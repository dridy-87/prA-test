package com.miris.test.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHeaders;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.resilience4j.core.lang.NonNullApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationHandler implements HandlerInterceptor {

	private final RedisTemplate<String, Object> redisTemplate;
	
	 private static final String SESSION_PREFIX = "spring:session:sessions:expires:";

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler
    ) throws IOException {
        String sessionID = request.getHeader(HttpHeaders.AUTHORIZATION);
        
        //session 확
        log.info("sesssionID:::" + sessionID);
        
        
       
        if(redisTemplate.opsForValue().get(SESSION_PREFIX + sessionID) == null) {
        	new ObjectMapper().writeValue(
                    response.getOutputStream(), "EMPTY TOKEN");
        	return false;
        } else {
        	return true;
        }
      
    }
}
