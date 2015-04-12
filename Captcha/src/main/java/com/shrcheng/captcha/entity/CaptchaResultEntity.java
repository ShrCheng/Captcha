package com.shrcheng.captcha.entity;

import java.awt.image.BufferedImage;

/**
 * 验证码结果 <br/>
 * 描述 : 验证码结果(计算的验证码的公式,计算的结果) <br/>
 * 作者 : 师成 <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2015年02月04日 上午01:02:29 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">师成</a>
 */
public class CaptchaResultEntity {

  private String[] expression;//计算的公式
  private int result;//计算的结果
  private BufferedImage image;//图片对象

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public String[] getExpression() {
    return expression;
  }

  public void setExpression(String[] expression) {
    this.expression = expression;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
  
}
