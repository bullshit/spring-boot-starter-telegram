package com.github.drednote.telegram.updatehandler.mvc;

import com.github.drednote.telegram.core.RequestType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Getter
@EqualsAndHashCode
public class BotRequestMappingInfo {

  private final String pattern;
  private final RequestType type;

  @EqualsAndHashCode.Exclude
  private final PathMatcher pathMatcher = new AntPathMatcher();

  public BotRequestMappingInfo(String pattern, RequestType type) {
    this.pattern = pattern;
    this.type = type;
  }

  public BotRequestMappingInfo getMatchingCondition(String requestText) {
    if (requestText == null) {
      requestText = "";
    }
    String matches = getMatchingPattern(pattern, requestText);

    return matches == null ? null : this;
  }

  private String getMatchingPattern(String pattern, String lookupPath) {
    if (pattern.equals(lookupPath)) {
      return pattern;
    }
    if (this.pathMatcher.match(pattern, lookupPath)) {
      return pattern;
    }
    return null;
  }

  public String toString() {
    return "{%s %s}".formatted(type, pattern);
  }
}