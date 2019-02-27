package com.yaoyong.demo.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yaoyong.demo.common.util.JWTUtil;
import com.yaoyong.demo.sys.entity.User;
import com.yaoyong.demo.sys.mapper.PermissionMapper;
import com.yaoyong.demo.sys.mapper.UserMapper;
import com.yaoyong.demo.sys.mapper.UserRoleMapper;
import com.yaoyong.demo.sys.service.impl.UserService;

/**
 *
 * @ClassName:  ShiroRealm
 * @Description:
 * @author: yaoyong
 * @date:   2019年1月1日 下午3:20:49
 * @RequiresAuthentication 登录后可访问
 * @RequiresRoles("admin") 管理员角色可
 * @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"}) 编辑权利
 * 不加注解 不需要验证。
 */
public class ShiroRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

	// 一般这里都写的是servic，这里省略直接调用dao
	@Autowired
	private UserMapper uUserDao;
	@Autowired
	private UserRoleMapper userRoleDao;
	@Autowired
	private PermissionMapper uPermissionDao;
	@Autowired
	private UserService userService;

	/**
	 * 大坑！，必须重写此方法，不然Shiro会报错
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}

	/**
	 * 登录认证
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {

		// UsernamePasswordToken token = (UsernamePasswordToken)
		// authenticationToken;
		String token = (String) authenticationToken.getCredentials(); // 用户
		logger.info("验证当前Subject时获取到token为：" + token.toString());
		// 查出是否有此用户
		// String username = token.getUsername();
		// String pwd = token.getPassword().toString();
		String loginName = JWTUtil.getUsername(token);
		if (null == loginName) {
			throw new AuthenticationException("token无效!"+authenticationToken.toString());
		}

		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		queryWrapper.eq("login_name", loginName);
		User user = uUserDao.selectOne(queryWrapper);
		if (null == user) {
			throw new AuthenticationException("用户不存在!");
		}

		if (!JWTUtil.verify(token, loginName, user.getPassword())) {
			throw new AuthenticationException("用户名或密码错误!");
		}

		 return new SimpleAuthenticationInfo(token, token, "my_realm");

		/*
		 * 若存在，将此用户存放到登录认证info中， 无需自己做密码对比，Shiro会为我们进行密码对比校验
		 */

//		if (user != null) {
//			Session session = SecurityUtils.getSubject().getSession();
//			session.setAttribute("user", user);
//			// 若存在，将此用户存放到登录认证info中，Shiro会为我们进行密码对比校验
//			// 盐值
//			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getLoginName());
//			return new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, getName());
//		}

	}

	/**
	 * 权限认证
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		logger.info("##################执行Shiro权限认证##################");
//		User user = (User) principals.getPrimaryPrincipal();
		String loginName = JWTUtil.getUsername(principals.toString());

// 把principals放session中 key=userId value=principals
//		SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getUserId()),
//				SecurityUtils.getSubject().getPrincipals());

		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		queryWrapper.eq("login_name", loginName);
		User user = uUserDao.selectOne(queryWrapper);
		if (user != null) {

			/**
			 * 获取用户角色\权限列表
			 */
			List<String> roleList = userService.getRolesByUserId(user.getUserId());
			List<String> permList = userService.getPermissionByUserId(user.getUserId());
			// user.setRoleList(roleList);
			// user.setPermList(permList);

			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			info.addRoles(roleList);
			// 用户的权限集合
			info.addStringPermissions(permList);

			return info;
		}

		// 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
		return null;
	}
}