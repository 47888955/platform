package com.yaoyong.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
//@EnableSwagger2
//@EnableWebMvc
public class Swagger2Config {

	private static final Logger log = LoggerFactory.getLogger(Swagger2Config.class);

	/**
	 * 添加摘要信息(Docket)
	 */
	//@Bean
	public Docket controllerApi() {

		log.error("-------------------------------------yaoyong swagger");
		System.out.println("-----------------------------yaoyong");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("标题：某公司_用户信息管理系统_接口文档").description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
						.contact(new Contact("一只袜子", null, null)).version("版本号:1.0").build())
				.select().apis(RequestHandlerSelectors.basePackage("com.yaoyong.demo.sys.controller")).paths(PathSelectors.any())
				.build();

	}

	private ApiInfo apiInfo() {
		System.out.println("--------------------------------------------------yaoyong");
		return new ApiInfoBuilder().license("Apache License Version 2.0")
				.title("blogspot").description("api docs").contact(new Contact("tangzedong",
						"https://www.cnblogs.com/HackerBlog/", "tangzedong.programmer@gmail.com"))
				.version("1.0").build();
	}

}
