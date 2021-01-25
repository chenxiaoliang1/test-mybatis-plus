package com.yiyuntian.test.testmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyuntian.test.testmybatisplus.entity.User;
import com.yiyuntian.test.testmybatisplus.mapper.UserMapper;
import com.yiyuntian.test.testmybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
@MapperScan("com.yiyuntian.test.testmybatisplus.mapper")
class TestMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testSelect() {
        log.info("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            log.info(user.toString());
        }
    }

    @Test
    void testSelectByAge() {
        log.info("----- selectByAge method test ------");
        List<User> userList = userService.selectByAge(28);

        for (User user :
                userList) {
            log.info(user.toString());
        }
    }

    @Test
    public void testUpdate() {
        User user = new User();
        /*user.setName("xiaoming");
        user.setAge(16);
        user.setEmail("xiaoming@sina.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());*/

        user.setName("Kang");
        user.setAge(19);
        user.setEmail("Kang@sina.com");

        if (userService.save(user))
            userService.list().forEach(System.out::println);
        else
            log.info("添加数据失败！");
    }

    @Test
    public void testDelete() {
        if (userService.removeById(1325997504210329602L)){
            log.info("删除数据成功！");
            userService.list().forEach(System.out::println);
        } else {
            log.info("删除数据失败！");
        }
    }

    @Test
    public void testDeleteByAge() {
        userMapper.deleteByAge(21);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>();
        page.setCurrent(2);
        page.setSize(3);
        userService.page(page, null);
        log.info("获取当前页：{}",page.getCurrent());
        log.info("获取总记录数：{}",page.getTotal());
        log.info("获取每页的条数：{}",page.getSize());
        log.info("获取每页数据的集合：{}",page.getRecords());
        log.info("获取总页数：{}",page.getPages());
        log.info("是否存在下一页：{}",page.hasNext());
        log.info("是否存在上一页：{}",page.hasPrevious());


    }

    @Test
    public void testVersion() {
        User user = new User();
        user.setName("Wei");
        user.setAge(21);
        user.setEmail("Wei@163.com");
        userService.save(user);
        userService.list().forEach(System.out::println);
        user.setName("Wang");
        userService.update(user, null);
        userService.list().forEach(System.out::println);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("id", "name", "age")
                .eq("age", 21)
                .like("name", "W");
        userService
                .list(queryWrapper)
                .forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper() {
        userService
                .update(
                        new UpdateWrapper<User>()
                                .lambda()
                                .eq(User::getName, "Wang")
                                .set(User::getAge, 18)
                );
    }
}
