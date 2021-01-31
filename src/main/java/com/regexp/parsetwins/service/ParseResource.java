package com.regexp.parsetwins.service;
import com.regexp.parsetwins.model.AccessToResource;
import com.regexp.parsetwins.util.UtilString;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ParseResource {

  private final AccessToResource accessToResource;

  public ParseResource(AccessToResource accessToResource) {
    this.accessToResource = accessToResource;
  }


  public Map<String,String> parse(String url, String ...request) throws IOException {
    accessToResource.setUrl(url);
    String resource=accessToResource.getResource();
    Map<String,String> map=new HashMap<>();
    Arrays.stream(request).forEach(item->map.compute(item,(a,b)->b+" "
        + UtilString.parseData(item,resource)));
    return map;
    }

}
