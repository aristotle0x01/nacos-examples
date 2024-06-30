package com.alibaba.nacos.example.spring.cloud;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

// service-provider
@FeignClient(name = "testController", configuration = FeignConfig.class, url = "http://localhost:8070/")
public interface MyClient {
    @RequestMapping(method = RequestMethod.GET, value = "/srv")
    String echo2(@RequestParam("param") String param);

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Headers("Content-Type: multipart/form-data")
    ResponseEntity<String> uploadFiles(@RequestPart("files") MultipartFile file);
}
