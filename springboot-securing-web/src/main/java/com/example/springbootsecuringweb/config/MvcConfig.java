package com.example.springbootsecuringweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * Web应用程序基于Spring MVC。 因此，你需要配置Spring MVC并设置视图控制器来暴露这些模板。 如下是一个典型的Spring MVC配置类。
 * @author x_lilong
 *
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	/**
	 * addViewControllers()方法（覆盖WebMvcConfigurerAdapter中同名的方法）添加了四个视图控制器。
	 *  两个视图控制器引用名称为“home”的视图（在home.html中定义），另一个引用名为“hello”的视图（在hello.html中定义）。
	 *   第四个视图控制器引用另一个名为“login”的视图。 您将在下一部分中创建该视图。
	 */
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
	
	

}
