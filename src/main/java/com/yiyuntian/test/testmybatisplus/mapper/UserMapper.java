package com.yiyuntian.test.testmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yiyuntian.test.testmybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * (User)表数据库访问层
 *
 * @author Chen Xiaoliang
 * @since 2020-11-09 15:11:52
 */
public interface UserMapper extends BaseMapper<User> {

    int deleteByAge(@Param("age") Integer age);

}