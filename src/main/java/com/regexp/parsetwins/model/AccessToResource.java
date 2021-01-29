package com.regexp.parsetwins.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AccessToResource {

  private String url;


  public AccessToResource() {
  }

  public String getResource() throws IOException {
    return new Scanner(new URL(url).openStream(),
        String.valueOf(StandardCharsets.UTF_8)).useDelimiter("\\A").next();
  }
}
