package com.yaoyong.demo.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yaoyong.demo.base.constant.HttpEnumStatus;
import com.yaoyong.demo.base.exception.UnauthorizedException;
import com.yaoyong.demo.base.model.RestModel;
import com.yaoyong.demo.common.util.JWTUtil;
import com.yaoyong.demo.shiro.Encryption;
import com.yaoyong.demo.sys.entity.User;
import com.yaoyong.demo.sys.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @ClassName: UserController
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月4日 下午6:34:32
 *
 */

@Api(tags = "登录类", value = "会员登录管理")
@RestController
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	IUserService userService;

	// @Autowired
	// HashedCredentialsMatcher hashedCredentialsMatcher;

	/**
	 *
	 * @Title: userUpdate @Description: 用户登录入口 @param: loginName @param:
	 *         userPass @param: @return:RestModel<?> @throws
	 */
	@ApiOperation(value = "会员登录", notes = "会员登录接口")
	@PutMapping(value = "login")
	public RestModel<?> userUpdate(@RequestParam String loginName, @RequestParam String userPass) {

		// response.setHeader("Access-Control-Allow-Origin","*");//跨域

		// QueryWrapper<User> query = new QueryWrapper<User>();
		// query.eq("loginName", loginName);
		// User loginUser = userService.getOne(query);
		try {

			Subject subject = SecurityUtils.getSubject();
			// 已经认证过
			if (subject.isAuthenticated()) {
				return RestModel.status(HttpEnumStatus.LOGIN_SUCCESS);
			}

			logger.error("password:" + userPass + "----------------" + Encryption.md5("123456", "yaoyong"));
			UsernamePasswordToken token = new UsernamePasswordToken(loginName, userPass, false, null);
			token.setRememberMe(false);
			subject.login(token);

		} catch (AuthenticationException e) {
			// 登录失败则跳转到登录失败页面，可能是用户名或密码错误
			return RestModel.status(HttpEnumStatus.LOGIN_FAILURE);
		}
		return RestModel.status(HttpEnumStatus.LOGIN_SUCCESS);
	}

	@ApiOperation(value = "JWT登录", notes = "JWT登录页面")
	@PostMapping("jwtlogin")
	public RestModel<?> login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
		// 测试密码
		String encryptedPwd = null;
		QueryWrapper<User> query = new QueryWrapper<User>();
		query.eq("login_name", loginName);
		User loginUser = userService.getOne(query);
		if (null == loginUser) {
			throw new UnauthorizedException();
		}
		encryptedPwd = Encryption.md5(password, loginUser.getUserSalt());
		if (loginUser.getPassword().equals(encryptedPwd)) {
			return RestModel.data(JWTUtil.sign(loginName, encryptedPwd));
		} else {
			throw new UnauthorizedException();
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看User实体")
	@GetMapping(value = "")
	public RestModel<?> userView(@RequestParam Long id) {
		User user = userService.getById(id);
		if (null == user) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		} else {
			return RestModel.data(user);
		}
	}

	public static String toMD5(String source) {

		String algorithmName = "MD5";// 加密方式
		// 加密的字符串
		// String source="doubi";
		// 盐值，用于和密码混合起来用
		ByteSource salt = ByteSource.Util.bytes(source);
		// 加密的次数,可以进行多次的加密操作
		int hashIterations = 1;
		// 通过SimpleHash 来进行加密操作
		SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);
		return hash.toHex();
	}

}
