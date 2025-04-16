package io.cdap.wrangler.api.parser;

public class TimeDuration {
  private final long millis;

  public TimeDuration(String value) {
    this.millis = parseDuration(value);
  }

  private long parseDuration(String value) {
    String s = value.trim().toLowerCase();
    long multiplier = 1;

    if (s.endsWith("ms")) {
      multiplier = 1;
      s = s.substring(0, s.length() - 2);
    } else if (s.endsWith("s")) {
      multiplier = 1000L;
      s = s.substring(0, s.length() - 1);
    } else if (s.endsWith("m")) {
      multiplier = 60L * 1000;
      s = s.substring(0, s.length() - 1);
    } else if (s.endsWith("h")) {
      multiplier = 60L * 60 * 1000;
      s = s.substring(0, s.length() - 1);
    } else if (s.endsWith("d")) {
      multiplier = 24L * 60 * 60 * 1000;
      s = s.substring(0, s.length() - 1);
    }

    return Long.parseLong(s.trim()) * multiplier;
  }

  public long getMillis() {
    return millis;
  }
}
