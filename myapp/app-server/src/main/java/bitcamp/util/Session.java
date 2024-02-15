package bitcamp.util;

import java.util.HashMap;
import java.util.Map;

public class Session {

  private Map<String, Object> attrMap = new HashMap<>();

  public void setAttribute(String name, Object value) {
    attrMap.put(name, value);
  }

  public Object getAttribute(String name) {
    return attrMap.get(name);
  }

  public void invalidate() { // 무효화하라
    attrMap.clear();

  }
}
