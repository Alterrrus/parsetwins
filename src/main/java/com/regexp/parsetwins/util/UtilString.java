package com.regexp.parsetwins.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilString {

  public static String regexp = ": \"(\\\\.|[^\"\\\\])*\"";
  static Logger logger = LoggerFactory.getLogger(UtilString.class);

  public static String parseData(String request, String out) {
    try {
      Matcher matcher = Pattern
          .compile("\"" + request + "\"" + regexp, Pattern.UNICODE_CHARACTER_CLASS).matcher(out);
      matcher.find();
      String[] s = out.substring(matcher.start(), matcher.end()).split(":");
      if (s[1].length() == 2) {
        return " ,";
      } else {
        return s[1].substring(1, s[1].length() - 1) + ",";
      }
    } catch (Exception e) {
      logger.info(e.getMessage());
      return "not matches";
    }
  }

  public static String parseString(String data) {
    return null;
  }
}
