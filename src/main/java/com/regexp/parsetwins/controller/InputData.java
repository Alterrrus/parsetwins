package com.regexp.parsetwins.controller;

import com.regexp.parsetwins.service.ParseResource;
import com.regexp.parsetwins.util.UtilString;
import java.io.IOException;
import java.util.Arrays;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enter",produces = MediaType.APPLICATION_JSON_VALUE)
public class InputData {
  private final ParseResource resource;

  public InputData(ParseResource resource) {
    this.resource = resource;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

  String postData(@RequestParam String inputUrl,@RequestBody String ...request ) throws IOException {
    Arrays.stream(request).forEach(System.out::println);// времянка

    String parseUrl= UtilString.parseString(inputUrl);//обработать поступившую строку
    resource.getAccessToResource().setUrl(parseUrl);// задать url модели
    return resource.parse();
  }
}
