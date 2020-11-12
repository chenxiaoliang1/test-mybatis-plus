package com.yiyuntian.test.testmybatisplus.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.yiyuntian.test.testmybatisplus.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Chen Xiaoliang
 * @since 2020-11-10 09:53:40
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController extends ApiController {

    private final UserService userService;

    @GetMapping({"/list", "/list/{id}"})
    public R list(@PathVariable(required = false) Long id){
        logger.info("查询用户列表");
        return success(userService.selectAllUsers(id));
    }

}