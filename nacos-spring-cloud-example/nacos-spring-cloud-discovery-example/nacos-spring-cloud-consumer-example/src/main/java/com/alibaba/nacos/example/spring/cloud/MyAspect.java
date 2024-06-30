package com.alibaba.nacos.example.spring.cloud;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class MyAspect {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, Object> feignClients = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        String[] names = applicationContext.getBeanNamesForAnnotation(FeignClient.class);
        for (String n : names) {
            Object bean = applicationContext.getBean(n);
            Class<?> clazz = bean.getClass();
            FeignClient client = AnnotationUtils.findAnnotation(clazz, FeignClient.class);
            if (client != null && client.name() != null) {
                String annotationName = client.name();
                feignClients.put(annotationName, bean);
            }
        }
    }

    @Around("execution(* com.alibaba.nacos.example.spring.cloud.TestController.*(..))")
    public Object route(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String methodName = ms.getMethod().getName();
        if (methodName.equals("uploadFiles")) {
            Object callingBean = applicationContext.getBean(ms.getMethod().getDeclaringClass());
            String[] callingBeanNames = applicationContext.getBeanNamesForType(ms.getMethod().getDeclaringClass());
            Object feignClient = feignClients.get(callingBeanNames[0]);
            Parameter[] parameters = ms.getMethod().getParameters();
            Method method = feignClient.getClass().getDeclaredMethod(methodName, ms.getMethod().getParameterTypes());
            return method.invoke(feignClient, joinPoint.getArgs());
        } else {
            return joinPoint.proceed();
        }
    }
}
