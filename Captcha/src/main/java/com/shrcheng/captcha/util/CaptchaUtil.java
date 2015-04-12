package com.shrcheng.captcha.util;

import java.awt.Color;

import com.shrcheng.captcha.entity.CaptchaEntity;
import com.shrcheng.captcha.entity.CaptchaResultEntity;
import com.shrcheng.captcha.global.CalculateEnum;
import com.shrcheng.captcha.global.NumberEnum;

/**
 * 图像生成公用工具类 <br/>
 * 描述 : 图像生成公用工具类 <br/>
 * 作者 : 师成 <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2015年02月03日 下午09:52:56 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">师成</a>
 */
public class CaptchaUtil {

  /**
   * 生成背景颜色 <br/>
   * 描述 : 描述该文件的作用<br/>
   * @return 背景颜色
   */
  public static Color getBackgroundColor() {
    int color = (int) (Math.random() * 255);
    int _color = (int) (Math.random() * 255);
    int color_ = (int) (Math.random() * 255);
    return new Color(color, _color, color_);
  }
  
  /**
   * 生成计算的数据 <br/>
   * 描述 : 生成计算的数据(计算的数和计算公式) <br/>
   * @return 计算的数据
   */
  private CaptchaEntity generateCalcNumber(){
    int firstNumber = 0;//第一个计算数:输出的数据
    int lastNumber = 0;//第二个计算数:输出的数据
    int calc = 0;//计算方式: 0 加法, 1 减法, 2 乘法, 3 除法, 4 等于
    int number = 0;
    number = (int) (Math.random() * 2);//取数据的类型,0 阿拉伯数字 | 1 中文大写汉字
    firstNumber = (int) (Math.random() * 10);
    lastNumber = (int) (Math.random() * 10);
    calc = (int) (Math.random() * 4);
    /**
     * 当计算方式为 1 减法时
     *  被减数不能为小于减数,小于时,重新生成计算数据  1 - 9
     */
    while (calc == 1 && firstNumber - lastNumber < 0) {
      lastNumber = (int) (Math.random() * 10);
    }
    /**
     * 当计算方式为 3 除法时
     *  > 被除数不能为0,为0时, 重新生成计算数据
     */
    while (calc == 3 && lastNumber == 0) {
      lastNumber = (int) (Math.random() * 10);
    }
    /**
     * 当计算方式为 3 除法时且被除数大于0
     *  > 被除数不能被除数整除时, 重新生成计算数据
     *  > 除数等于0时, 除数加1
     */
    while (calc == 3 && (firstNumber % lastNumber) > 0) {
      lastNumber = (int) (Math.random() * 10);
      if (lastNumber == 0) {
        lastNumber = 1;
      }
    }
    CaptchaEntity entity = new CaptchaEntity();
    entity.setFirstNumber(firstNumber);
    entity.setLastNumber(lastNumber);
    entity.setCalc(calc);
    entity.setNumber(number);
    return entity;
  }

  /**
   * 生成图片数据 <br/>
   * 描述 : 生成图片数据<br/>
   * @return 生成图片数据
   */
  public CaptchaResultEntity generateCalculateImage(){
    CaptchaEntity entity = generateCalcNumber();
    int calc = entity.getCalc();//计算方式
    int number = entity.getNumber();//数据类型
    int firstNumber = entity.getFirstNumber();
    int lastNumber = entity.getLastNumber();
    String _calc = null;//计算方式
    String _firstNumber = null;
    String _lastNumber = null;
    String equals = null;
    // 显示 0 阿拉伯数字 
    if (number == 0) {
      _firstNumber = String.valueOf(firstNumber);
      _lastNumber = String.valueOf(lastNumber);
      _calc = getCalculateEn(calc, calc);
      equals = CalculateEnum.EQUAL.getValueEn();
    }
    // 显示 1 中文大写汉字
    if (number == 1) {
      for (NumberEnum numberEnum : NumberEnum.values()) {
        if (numberEnum.getValueEn().equals(String.valueOf(firstNumber))) {
          _firstNumber = numberEnum.getValueZh();
        }
        if (numberEnum.getValueEn().equals(String.valueOf(lastNumber))) {
          _lastNumber = numberEnum.getValueZh();
        }
      }
      _calc = getCalculateZh(calc, number);
      equals = CalculateEnum.EQUAL.getValueZh();
    }
    String[] result = new String[]{_firstNumber, _calc, _lastNumber, equals, "?"};
    CaptchaResultEntity captchaResultEntity = new CaptchaResultEntity();
    captchaResultEntity.setExpression(result);
    captchaResultEntity.setResult(generateCalculateResult(entity));
    return captchaResultEntity;
  }
  
  /**
   * 生成数据结果 <br/>
   * 描述 : 生成数据结果<br/>
   * @return 生成数据结果
   */
  private Integer generateCalculateResult(CaptchaEntity entity){
    int calc = entity.getCalc();//计算方式: 0 加法, 1 减法, 2 乘法, 3 除法, 4 等于
    int firstNumber = entity.getFirstNumber();
    int lastNumber = entity.getLastNumber();
    int result = 0;
    switch (calc) {
      case 0:
        result = firstNumber + lastNumber;
        break;
      case 1:
        result = firstNumber - lastNumber;
        break;
      case 2:
        result = firstNumber * lastNumber;
        break;
      case 3:
        result = firstNumber / lastNumber;
        break;
    }
    return result;
  }
  
  /**
   * 计算方式 <br/>
   * 描述 : 计算方式 <br/>
   * @param calc 计算方式
   * @param number 取数据的类型,0 阿拉伯数字 | 1 中文大写汉字
   * @return 计算方式
   */
  private String getCalculateEn(int calc, int number) {
    String result = null;// 计算方式: 0 加法, 1 减法, 2 乘法, 3 除法, 4 等于
    switch (calc) {
      case 0:
        result = CalculateEnum.ADD.getValueEn();
      break;
      case 1:
        result = CalculateEnum.SUBTRACT.getValueEn();
      break;
      case 2:
        result = CalculateEnum.MULTIPLY.getValueEn();
      break;
      case 3:
        result = CalculateEnum.DIVIDE.getValueEn();
      break;
      case 4:
        result = CalculateEnum.EQUAL.getValueEn();
      break;
    }
    return result;
  }
  
  /**
   * 计算方式 <br/>
   * 描述 : 计算方式 <br/>
   * @param calc 计算方式
   * @param number 取数据的类型,0 阿拉伯数字 | 1 中文大写汉字
   * @return 计算方式
   */
  private String getCalculateZh(int calc, int number) {
    String result = null;
    switch (calc) {
      case 0:
        result = CalculateEnum.ADD.getValueZh();
      break;
      case 1:
        result = CalculateEnum.SUBTRACT.getValueZh();
      break;
      case 2:
        result = CalculateEnum.MULTIPLY.getValueZh();
      break;
      case 3:
        result = CalculateEnum.DIVIDE.getValueZh();
      break;
      case 4:
        result = CalculateEnum.EQUAL.getValueZh();
      break;
    }
    return result;
  }
  
}
