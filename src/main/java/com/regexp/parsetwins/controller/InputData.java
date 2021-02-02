package com.regexp.parsetwins.controller;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.regexp.parsetwins.service.ParseResource;
import java.io.File;
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
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping(value = "/enter", produces = MediaType.APPLICATION_JSON_VALUE)
public class InputData {

  private final ParseResource resource;

  public InputData(ParseResource resource) {
    this.resource = resource;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Map<String, String>> getData(@RequestParam String inputUrl, @RequestParam int start,
      @RequestParam int end,
      @RequestParam int timeout, @RequestParam String... request)
      throws InterruptedException, IOException {

    //String parseUrl = UtilString.parseString(inputUrl);//обработать поступившую строку
    List<Map<String, String>> list = new ArrayList<>();

    for (int i = start; i <= end; i++) {
      String url = inputUrl + i;
      list.add(resource.parse(url, request));
      Thread.sleep(timeout);
    }
    File file = new File("/home/andrey/Desktop/new.JSON");
    JsonMapper mapper=new JsonMapper();
    mapper.writeValue(file,list);
    return list;
  }
}
