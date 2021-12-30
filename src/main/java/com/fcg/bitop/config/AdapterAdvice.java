/*
package com.fcg.bitop.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice("com.main.abc.package")
public class AdapterAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter< ? >> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class<? extends HttpMessageConverter< ? >> aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        // just some wrapper logic, you can just omit the below and return the body Object you got as a param
        Map<String, Object> data = new HashMap<>();
        data.put("serverTime", new Date(System.currentTimeMillis()));
        if(body instanceof Map && ((Map)body).get("error") != null ){
            data.put("isSuccess", false);
            if(((Map)body).get("trace") != null){
                ((Map)body).remove("trace");
            }
        } else if (body instanceof ApiError && ((ApiError)body).getResponseStatusCode().equalsIgnoreCase("0")){
            data.put("isSuccess", false);
        } else {
            data.put("isSuccess", true);
        }
        data.put("mainResponse",body);

        return data;
    }
}
*/
