package com.regexp.parsetwins.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilString {

  public static String regexp = ": \"(\\.|[^\"\\\\])*\"";
  static Logger logger = LoggerFactory.getLogger(UtilString.class);

  public static String parseData(String request, String out) {
    try {
      Matcher matcher = Pattern
          .compile("\"" + request + "\"" + regexp, Pattern.UNICODE_CHARACTER_CLASS).matcher(out);
      StringBuilder s = new StringBuilder("");
      while (matcher.find())
      s.append(out.substring(matcher.start(), matcher.end()).substring(request.length() + 4));
      return s.toString().replaceAll("\\\\","").replaceAll("\"","");
    } catch (Exception e) {
      logger.info(Arrays.toString(e.getStackTrace()));
      return "not matches";
    }
  }

  public static String parseString(String data) {
    return null;
  }
}
