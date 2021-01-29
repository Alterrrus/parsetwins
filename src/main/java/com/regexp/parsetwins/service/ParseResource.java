package com.regexp.parsetwins.service;

import com.regexp.parsetwins.model.AccessToResource;
import com.regexp.parsetwins.util.UtilString;
import java.io.IOException;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ParseResource {

  private final AccessToResource accessToResource;

  public ParseResource(AccessToResource accessToResource) {
    this.accessToResource = accessToResource;
  }

  public String parse() throws IOException {
    String temp=accessToResource.getResource();
    return UtilString.parseData(temp);// парсинг данных из страницы
  }
}
