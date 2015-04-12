package com.sstorage.captcha.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Test;

import com.sstorage.captcha.entity.CaptchaResultEntity;
import com.sstorage.captcha.generate.Generate;
import com.sstorage.captcha.util.CaptchaUtil;

/**
 * 项目测试类 <br/>
 * 描述 : 测试项目中各个数据模块 <br/>
 * 作者 : 师成 <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2015年02月03日 下午09:54:17 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">师成</a>
 */
public class TestCalculate {

  @Test
  public void testCalculateEnum(){
    CaptchaResultEntity captchaResultEntity = Generate.generate();
    System.out.println(captchaResultEntity.getExpression());
    System.out.println(captchaResultEntity.getResult());
  }
  
  @Test
  public void testDivide(){
    for (int i = 0; i < 1000; i ++) {
      CaptchaUtil captchaUtil = new CaptchaUtil();
      captchaUtil.generateCalculateImage();
    }
  }
  
  @Test
  public void testGenerateImage(){
    JFrame jFrame = new JFrame();
    CaptchaResultEntity  captchaResultEntity = Generate.generate();
    jFrame.setBounds(400, 400, 250, 250);
    ImageIcon img = new ImageIcon(captchaResultEntity.getImage());
    System.out.println(captchaResultEntity.getResult());
    System.out.println(captchaResultEntity.getExpression());
    JLabel background = new JLabel(img);
    jFrame.add(background);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
