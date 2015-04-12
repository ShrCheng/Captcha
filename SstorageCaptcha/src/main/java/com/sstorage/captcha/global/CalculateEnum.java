package com.sstorage.captcha.global;

/**
 * 计算公式枚举 <br/>
 * 描述 : 计算公式枚举 <br/>
 * 作者 : 师成 <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2015年02月03日 下午09:51:47 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">师成</a>
 */
public enum CalculateEnum {
  
  ADD("+", "加"),
  SUBTRACT("-", "减"),
  MULTIPLY("*", "乘"),
  DIVIDE("÷", "除"),
  EQUAL("=", "等");

  private final String value_en;
  private final String value_zh;
  
  CalculateEnum(String value_en, String value_zh) {
    this.value_en = value_en;
    this.value_zh = value_zh;
  }
  
  public String getValueEn() {
    return value_en;
  }
  
  public String getValueZh() {
    return value_zh;
  }
  
}
