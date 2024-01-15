package cn.dhbin.isme.pms.service;

import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.lang.Pair;


public interface CaptchaService {

    //创建验证码
    Pair<String, ICaptcha> create();
}
