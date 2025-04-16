package io.cdap.wrangler.api.parser;

public class ByteSize {
  private final long bytes;

  public ByteSize(String value) {
    this.bytes = parseBytes(value);
  }

  private long parseBytes(String value) {
    String s = value.trim().toUpperCase();
    long multiplier = 1;

    if (s.endsWith("KB")) {
      multiplier = 1024L;
      s = s.substring(0, s.length() - 2);
    } else if (s.endsWith("MB")) {
      multiplier = 1024L * 1024;
      s = s.substring(0, s.length() - 2);
    } else if (s.endsWith("GB")) {
      multiplier = 1024L * 1024 * 1024;
      s = s.substring(0, s.length() - 2);
    } else if (s.endsWith("TB")) {
      multiplier = 1024L * 1024 * 1024 * 1024;
      s = s.substring(0, s.length() - 2);
    } else if (s.endsWith("B")) {
      multiplier = 1;
      s = s.substring(0, s.length() - 1);
    }

    return Long.parseLong(s.trim()) * multiplier;
  }

  public long getBytes() {
    return bytes;
  }
}
