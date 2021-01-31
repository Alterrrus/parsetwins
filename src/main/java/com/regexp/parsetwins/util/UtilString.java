package com.regexp.parsetwins.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilString {
  public static String regexp = ": \"(\\\\.|[^\"\\\\])*\"";

  public static String parseData(String request,String out) {
    Matcher matcher = Pattern
        .compile("\"" + request + "\"" + regexp, Pattern.UNICODE_CHARACTER_CLASS).matcher(out);
    matcher.find();
    String[] s = out.substring(matcher.start(), matcher.end()).split(":");
    if (s[1].length() == 2) {
      return " ,";
    } else {
      return s[1].substring(1, s[1].length() - 1) + ",";
    }
  }

  public static String parseString(String data) {
    return null;
  }
}
