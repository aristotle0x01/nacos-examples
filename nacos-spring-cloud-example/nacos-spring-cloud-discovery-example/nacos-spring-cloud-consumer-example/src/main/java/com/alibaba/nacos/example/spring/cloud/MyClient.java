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


//    feign form
//    https://stackoverflow.com/questions/55624656/java-lang-noclassdeffounderror-feign-requestbody-in-feign-while-adding-support
//    https://stackoverflow.com/questions/31752779/file-upload-using-feign-multipart-form-data
//    https://stackoverflow.com/questions/35803093/how-to-post-form-url-encoded-data-with-spring-cloud-feign
//    https://howtoprogram.xyz/2016/12/29/file-uploading-open-feign/
//    https://mkyong.com/spring-boot/spring-boot-file-upload-example/


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Headers("Content-Type: multipart/form-data")
    ResponseEntity<String> uploadFiles(@RequestPart("files") MultipartFile file);
}
