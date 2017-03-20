package br.com.ruavarejo.backend.interceptor;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.ruavarejo.backend.annotation.WebComponent;
import br.com.ruavarejo.backend.security.UserInfo;

@WebComponent
public class Interceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserInfo userInfo;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		userInfo.setIpAddress(request.getHeader("X-FORWARDED-FOR"));
		prepareResponseHeader(response);
		return true;
	}

	private void prepareResponseHeader(HttpServletResponse response) {
		if (response.getHeader(ACCESS_CONTROL_ALLOW_METHODS) == null) {
			response.addHeader(ACCESS_CONTROL_ALLOW_METHODS , "GET, POST, PUT, PATCH, OPTIONS, DELETE");
		}
		
		if (response.getHeader(ACCESS_CONTROL_ALLOW_ORIGIN) == null) {
			response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		}
		
		if (response.getHeader(ACCESS_CONTROL_ALLOW_HEADERS) == null) {
			response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, AUTHORIZATION);
			response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, CONTENT_TYPE);
		}
	}
}
