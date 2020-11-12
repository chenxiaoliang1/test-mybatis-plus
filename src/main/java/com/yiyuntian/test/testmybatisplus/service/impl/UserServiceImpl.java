package com.yiyuntian.test.testmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiyuntian.test.testmybatisplus.entity.User;
import com.yiyuntian.test.testmybatisplus.mapper.UserMapper;
import com.yiyuntian.test.testmybatisplus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author Chen Xiaoliang
 * @since 2020-11-09 17:06:04
 */
@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;


    @Override
    public List<User> selectAllUsers(Long id) {
        if (id == null)
            return userMapper.selectList(null);
        else
            return userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getId, id));
    }

    @Override
    public List<User> selectByAge(Integer age) {
        return userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getAge,age));
    }
}