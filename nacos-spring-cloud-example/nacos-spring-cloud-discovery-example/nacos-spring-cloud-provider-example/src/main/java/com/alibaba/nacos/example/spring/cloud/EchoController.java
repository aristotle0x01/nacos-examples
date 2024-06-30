package com.alibaba.nacos.example.spring.cloud;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class EchoController {
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @RequestMapping(value = "/srv", method = RequestMethod.GET)
    public String echo2(@RequestParam("param") String param) {
        return "Hello Nacos Discovery from provider: " + param;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestPart("files") MultipartFile files) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();

            Stream.of(files).forEach(file -> {
                // Get the file and save it somewhere
                byte[] bytes = new byte[0];
                try {
                    bytes = file.getBytes();
                    Path path = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                fileNames.add(file.getOriginalFilename());
            });

            message = "Uploaded the files successfully: " + fileNames;
            System.out.println(message);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}