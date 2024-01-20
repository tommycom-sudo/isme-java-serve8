package cn.dhbin.isme.pms.controller;

import cn.dhbin.isme.pms.service.CaptchaService;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.lang.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final CaptchaService captchaService;
    private static final String CAPTCHA_KEY = "captchaKey";


    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        Pair<String, ICaptcha> captchaPair = captchaService.create();
        HttpSession session = request.getSession();
        session.setAttribute(CAPTCHA_KEY, captchaPair.getKey());
        captchaPair.getValue().write(response.getOutputStream());


    }
}
