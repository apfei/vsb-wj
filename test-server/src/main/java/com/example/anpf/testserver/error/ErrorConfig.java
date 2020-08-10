/**
 * 
 */
package com.example.anpf.testserver.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author anpf
 * @date: 2020/08/10
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
		registry.addErrorPages(error404);
		
	}
}
