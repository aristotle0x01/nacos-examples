package com.alibaba.nacos.example.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @Autowired
    private MyClient myClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
    }

    @RequestMapping(value = "/echo2", method = RequestMethod.GET)
    public String srv(@RequestParam("param") String param) {
        return myClient.echo2(param);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<String> services() {
        return discoveryClient.getServices();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestPart("files") MultipartFile files) {
        int i = 0;
        System.out.println("uploadFiles client");
        return myClient.uploadFiles(files);
    }
}