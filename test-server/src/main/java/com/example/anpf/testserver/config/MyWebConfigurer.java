/**
 * 
 */
package com.example.anpf.testserver.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.anpf.testserver.interceptor.LoginInterceptor;

/**
 * @author anpf
 * @date: 2020/08/10
 */
@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {
	
	@Bean
	public LoginInterceptor getLoginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
	}
 
}
