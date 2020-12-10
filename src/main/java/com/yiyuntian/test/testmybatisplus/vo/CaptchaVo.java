package com.yiyuntian.test.testmybatisplus.vo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Chen Xiaoliang
 * @Date 2020/12/10 15:31
 */
@Data
@AllArgsConstructor
public class CaptchaVo {

    private String verKey;
    private String imgBase64;
}
