package com.yiyuntian.test.testmybatisplus.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.yiyuntian.test.testmybatisplus.vo.CaptchaVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Chen Xiaoliang
 * @Date 2020/12/10 15:29
 */
@RestController
@Slf4j
@RequestMapping("/captcha")
public class CaptchaController extends ApiController {

    @GetMapping("/generator1")
    public R generatorCaptcha1() {
        // png类型
        SpecCaptcha captcha = new SpecCaptcha(130, 48);
//        captcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        String text = captcha.text().toLowerCase();
        log.info("验证码：{}", text);
        String verCode = UUID.randomUUID().toString();
        return success(new CaptchaVo(verCode, captcha.toBase64()));
    }

    @GetMapping("/generator2")
    public R generatorCaptcha2() {
        // gif类型
        GifCaptcha captcha = new GifCaptcha(130, 48);
        String text = captcha.text().toLowerCase();
        log.info("验证码：{}", text);
        String verCode = UUID.randomUUID().toString();
        return success(new CaptchaVo(verCode, captcha.toBase64()));
    }

    @GetMapping("/generator3")
    public R generatorCaptcha3() {
        // 中文类型
        ChineseCaptcha captcha = new ChineseCaptcha(130, 48);
        String text = captcha.text();
        log.info("验证码：{}", text);
        String verCode = UUID.randomUUID().toString();
        return success(new CaptchaVo(verCode, captcha.toBase64()));
    }

    @GetMapping("/generator4")
    public R generatorCaptcha4() {
        // 中文类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        // 几位数运算，默认是两位
        captcha.setLen(3);
        String arithmeticStr = captcha.getArithmeticString();
        log.info("算术表达式：{}", arithmeticStr);
        String text = captcha.text();
        log.info("验证码：{}", text);
        String verCode = UUID.randomUUID().toString();
        return success(new CaptchaVo(verCode, captcha.toBase64()));
    }
}
