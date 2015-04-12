package com.shrcheng.captcha.global;

/**
 * 计算数据枚举 <br/>
 * 描述 : 计算数据枚举  <br/>
 * 作者 : 师成 <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2015年02月03日 下午09:52:26 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">师成</a>
 */
public enum NumberEnum {

  ONE("1", "壹"),
  TWO("2", "贰"),
  THREE("3", "叁"),
  FOUR("4", "肆"),
  FIVE("5", "伍"),
  SIX("6", "陆"),
  SEVEN("7", "柒"),
  EIGHT("8", "捌"),
  NINE("9", "玖"),
  ZERO("0", "零");
  
  private final String value_en;
  private final String value_zh;

  private NumberEnum(String value_en, String value_zh) {
    this.value_en = value_en;
    this.value_zh = value_zh;
  }

  public String getValueEn() {
    return value_en;
  }

  public String getValueZh() {
    return value_zh;
  }
  
  public static void main(String[] args) {
    System.out.println(NumberEnum.values().length);
  }
  
}
