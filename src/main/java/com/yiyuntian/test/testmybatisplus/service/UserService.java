package com.yiyuntian.test.testmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yiyuntian.test.testmybatisplus.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Chen Xiaoliang
 * @since 2020-11-09 17:06:02
 */
public interface UserService extends IService<User> {

    List<User> selectAllUsers(Long id);

    List<User> selectByAge(Integer age);
}