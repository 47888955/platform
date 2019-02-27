package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * mybatis-plus Spring Boot 测试 Demo<br>
 * 文档：http://mp.baomidou.com<br>
 */

@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.yaoyong.demo",
		"com.yaoyong.demo.shiro",
		"com.yaoyong.demo.sys",
        "com.baomidou.springboot.config",
        "com.baomidou.springboot.controller",
        "com.baomidou.springboot.service"})
public class Application {

    protected final static Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        logger.info("PortalApplication is success!");
        //System.err.println("sample started. http://localhost:8080/user/test");
    }


	@Bean
	public Docket controllerApi() {

		logger.error("-------------------------------------yaoyong swagger");
		System.out.println("-----------------------------yaoyong");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("云配电平台接口文档").description("托维盛通云平台解决方案")
						.contact(new Contact("yaoyong", null, null)).version("版本号:1.0").build())
				.select().apis(RequestHandlerSelectors.basePackage("com.yaoyong")).paths(PathSelectors.any())
				.build();

	}

	private ApiInfo apiInfo() {
		System.out.println("--------------------------------------------------yaoyong");
		return new ApiInfoBuilder().license("Apache License Version 2.0")
				.title("blogspot").description("api docs").contact(new Contact("yaoyong",
						"https://www.baidu.com/", "47888955@qq.com"))
				.version("1.0").build();
	}



//	   @Bean
//	    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
//
//	        List<HttpMessageConverter<?>> converters = requestMappingHandlerAdapter.getMessageConverters();
//
//	        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//	        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
//	        MediaType textMedia = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//	        supportedMediaTypes.add(textMedia);
//	        MediaType jsonMedia = new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8"));
//	        supportedMediaTypes.add(jsonMedia);jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
//
//	        converters.add(jsonConverter);
//
//	        requestMappingHandlerAdapter.setMessageConverters(converters);
//
//	       return requestMappingHandlerAdapter;
//	    }


}
