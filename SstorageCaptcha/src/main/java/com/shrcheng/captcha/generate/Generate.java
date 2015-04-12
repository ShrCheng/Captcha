package com.shrcheng.captcha.generate;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.shrcheng.captcha.entity.CaptchaResultEntity;
import com.shrcheng.captcha.util.CaptchaUtil;

/**
 * 生成验证码 <br/>
 * 描述 : 生成验证码 <br/>
 * 作者 : 师成 <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2015年02月04日 上午01:30:08 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">师成</a>
 */
public class Generate {

  private static int DEFAULT_WIDTH = 200;//图片宽度
  private static int DEFAULT_HEIGHT = 40;//图片高度

  /**
   * 生成验证码
   * 描述 : 生成验证码 <br/>
   * @return 生成验证码返回实体类
   */
  public static CaptchaResultEntity generate(){
    CaptchaUtil captchaUtil = new CaptchaUtil();
    BufferedImage image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics(); // 创建一个图形类
    graphics.setColor(CaptchaUtil.getBackgroundColor());// 背景颜色要偏淡
    graphics.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);// 画背景
    graphics.setColor(CaptchaUtil.getBackgroundColor());// 边框颜色
//    graphics.drawRect(0, 0, DEFAULT_WIDTH - 1, DEFAULT_HEIGHT - 1);// 画边框
    CaptchaResultEntity captchaResultEntity = captchaUtil.generateCalculateImage();
    String[] result = captchaResultEntity.getExpression();
    int length = result.length;//生成验证码的数量
    Font font = new Font("YaHei", Font.ITALIC,20);// 创建字体，字体的大小应该根据图片的高度来定。 
    graphics.setFont(font);//设置字体 
    for (int i = 0; i < length; i++) {
      String string = String.valueOf(result[i]);
      graphics.drawString(string, 30 * i + 30, 25);
    }
    graphics.dispose();// 图像生效
    captchaResultEntity.setImage(image);
    return captchaResultEntity;
  }

}
