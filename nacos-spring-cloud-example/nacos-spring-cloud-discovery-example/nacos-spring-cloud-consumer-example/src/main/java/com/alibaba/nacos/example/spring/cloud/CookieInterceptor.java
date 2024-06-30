package com.alibaba.nacos.example.spring.cloud;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class CookieInterceptor implements RequestInterceptor {

    // https://blog.csdn.net/WYA1993/article/details/84304243
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Cookie cookie = WebUtils.getCookie(request, "token");
            if (cookie != null) {
                template.header(cookie.getName(), cookie.getValue());
            }
        }
    }
}