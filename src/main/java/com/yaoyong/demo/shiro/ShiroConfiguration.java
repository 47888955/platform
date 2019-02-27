package com.yaoyong.demo.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfiguration {
	/**
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
	 *
	 * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
	 * 3、部分过滤器可指定参数，如perms，roles
	 *
	 */

	@Bean("securityManager")
	public DefaultWebSecurityManager getManager(ShiroRealm realm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(realm);

		/*
		 * 关闭shiro自带的session，详情见文档
		 * http://shiro.apache.org/session-management.html#SessionManagement-
		 * StatelessApplications%28Sessionless%29
		 */
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		manager.setSubjectDAO(subjectDAO);

		return manager;
	}

	@Bean("shiroFilter")
	public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

		// 添加自己的过滤器并且取名为jwt
		Map<String, Filter> filterMap = new HashMap<>();
		filterMap.put("jwt", new JWTFilter());
		factoryBean.setFilters(filterMap);

		factoryBean.setSecurityManager(securityManager);
		factoryBean.setUnauthorizedUrl("/401");

		/*
		 * 自定义url规则 http://shiro.apache.org/web.html#urls-
		 */
		Map<String, String> filterRuleMap = new HashMap<>();
		// 所有请求通过我们自己的JWT Filter
		filterRuleMap.put("/**", "jwt");
		// 访问401和404页面不通过我们的Filter
		filterRuleMap.put("/401", "anon");

		filterRuleMap.put("/static/**", "anon");
		filterRuleMap.put("/login", "anon");
		 // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterRuleMap.put("/logout", "logout");
		filterRuleMap.put("/swagger**", "anon");
		filterRuleMap.put("/webjars/**", "anon");

		factoryBean.setFilterChainDefinitionMap(filterRuleMap);
		return factoryBean;
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		// 强制使用cglib，防止重复代理和可能引起代理出错的问题
		// https://zhuanlan.zhihu.com/p/29161098
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		return defaultAdvisorAutoProxyCreator;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	// @Bean
	// @ConditionalOnMissingBean
	// public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	// DefaultAdvisorAutoProxyCreator defaultAAP = new
	// DefaultAdvisorAutoProxyCreator();
	// defaultAAP.setProxyTargetClass(true);
	// return defaultAAP;
	// }

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

	@Bean("hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		// 指定加密方式为MD5
		credentialsMatcher.setHashAlgorithmName("MD5");
		// 加密次数
		credentialsMatcher.setHashIterations(1);
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}

	@Bean(name = "shiroRealm")
	@DependsOn("lifecycleBeanPostProcessor")
	public ShiroRealm shiroRealm() {
		ShiroRealm realm = new ShiroRealm();
		//realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

	// @Bean(name = "ehCacheManager")
	// @DependsOn("lifecycleBeanPostProcessor")
	// public EhCacheManager ehCacheManager(){
	// EhCacheManager ehCacheManager = new EhCacheManager();
	// return ehCacheManager;
	// }

	// @Bean(name = "securityManager")
	// public DefaultWebSecurityManager securityManager() {
	// DefaultWebSecurityManager securityManager = new
	// DefaultWebSecurityManager();
	// securityManager.setRealm(shiroRealm());
	// // securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache,
	// // 采用EhCache 缓存
	// return securityManager;
	// }

	// Filter工厂，设置对应的过滤条件和跳转条件
	// @Bean
	// public ShiroFilterFactoryBean
	// shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager
	// securityManager) {
	//
	// ShiroFilterFactoryBean shiroFilterFactoryBean = new
	// ShiroFilterFactoryBean();
	// shiroFilterFactoryBean.setSecurityManager(securityManager);
	// // 拦截器.
	// Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String,
	// String>();
	// // 配置不会被拦截的链接 顺序判断
	// filterChainDefinitionMap.put("/static/**", "anon");
	// filterChainDefinitionMap.put("/login", "anon");
	// // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
	// filterChainDefinitionMap.put("/logout", "logout");
	// filterChainDefinitionMap.put("/swagger**", "anon");
	// filterChainDefinitionMap.put("/webjars/**", "anon");
	//
	// // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
	// // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
	// filterChainDefinitionMap.put("/**", "anon");
	// // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
	// shiroFilterFactoryBean.setLoginUrl("/login.html");
	// // 登录成功后要跳转的链接
	// shiroFilterFactoryBean.setSuccessUrl("/index.html");
	// // 未授权界面;
	// shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");
	// shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	// return shiroFilterFactoryBean;
	//
	// }

	// @Bean(name = "shiroFilter")
	// public ShiroFilterFactoryBean
	// shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
	// ShiroFilterFactoryBean shiroFilterFactoryBean = new
	// ShiroFilterFactoryBean();
	// shiroFilterFactoryBean.setSecurityManager(securityManager);
	//
	// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	//
	// // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
	// Map<String, String> filterChainDefinitionManager = new
	// LinkedHashMap<String, String>();
	// // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
	// filterChainDefinitionManager.put("/logout", "logout");
	// // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
	//// filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
	//// filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");
	// filterChainDefinitionManager.put("/login", "anon");
	// filterChainDefinitionManager.put("/swagger-ui.html", "anon");
	// filterChainDefinitionManager.put("/index", "anon");
	// filterChainDefinitionManager.put("/ajaxLogin", "anon");
	// filterChainDefinitionManager.put("/statistic/**", "anon");
	// filterChainDefinitionManager.put("/**", "authc,roles[user]");//其他资源全部拦截
	// shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
	//
	// // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
	// shiroFilterFactoryBean.setLoginUrl("/login");
	// // 登录成功后要跳转的链接
	// shiroFilterFactoryBean.setSuccessUrl("/success");
	// // 未授权界面
	// shiroFilterFactoryBean.setUnauthorizedUrl("/403");
	//
	// return shiroFilterFactoryBean;
	// }

}