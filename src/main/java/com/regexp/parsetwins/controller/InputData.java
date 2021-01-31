package com.regexp.parsetwins.controller;

import com.regexp.parsetwins.service.ParseResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enter", produces = MediaType.APPLICATION_JSON_VALUE)
public class InputData {

  private final ParseResource resource;

  public InputData(ParseResource resource) {
    this.resource = resource;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Map<String, String>> getData(@RequestParam String inputUrl, @RequestParam int start, @RequestParam int end,
      @RequestParam int timeout, @RequestParam String... request)
      throws IOException, InterruptedException {

    Arrays.stream(request).forEach(System.out::println);// времянка

    //String parseUrl = UtilString.parseString(inputUrl);//обработать поступившую строку
    List<Map<String,String>>list=new ArrayList<>();

    for (int i = start; i <=end ; i++) {
      String url=inputUrl+i;
      list.add(resource.parse(url,request));
      Thread.sleep(timeout);
    }

    return list;
  }
}
