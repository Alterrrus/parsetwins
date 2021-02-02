package com.regexp.parsetwins.model;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Data
public class AccessToResource {
  private String url;

  Logger log= LoggerFactory.getLogger(AccessToResource.class);


  public AccessToResource() {
  }

  public String getResource() {
    try{
    return new Scanner(new URL(url).openStream(),
        String.valueOf(StandardCharsets.UTF_8)).useDelimiter("\\A").next();}catch (IOException e){
      log.info(Arrays.toString(e.getStackTrace()));
      return "file not found";
    }
  }
}
