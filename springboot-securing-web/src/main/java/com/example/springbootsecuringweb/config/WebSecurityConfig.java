package com.example.springbootsecuringweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * WebSecurityConfig类使用了@EnableWebSecurity注解 ，以启用Spring Security的Web安全支持，并提供Spring MVC集成。
 * 它还扩展了WebSecurityConfigurerAdapter，并覆盖了一些方法来设置Web安全配置的一些细节。
 * @author x_lilong
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * configure(HttpSecurity)方法定义了哪些URL路径应该被保护，哪些不应该。
	 * 具体来说，“/”和“/ home”路径被配置为不需要任何身份验证。所有其他路径必须经过身份验证。
	 * 当用户成功登录时，它们将被重定向到先前请求的需要身份认证的页面。有一个由 loginPage()指定的自定义“/登录”页面，每个人都可以查看它。
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();*/
		http
	      .authorizeRequests()
	        .antMatchers("/").permitAll()                      //请求路径"/"允许访问
	        .anyRequest().authenticated()                      //其它请求都需要校验才能访问
	      .and()
	        .formLogin()
	          .loginPage("/login")                             //定义登录的页面"/login"，允许访问
	          .permitAll()
	      .and()
	        .logout()                                           //默认的"/logout", 允许访问
	          .permitAll();
	}

	/**
	 * 对于configureGlobal(AuthenticationManagerBuilder) 方法，它将单个用户设置在内存中。该用户的用户名为“user”，密码为“password”，角色为“USER”。
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}
