package com.example.dao;

import com.example.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    public User findByNameIs(String name);

    public User findByNameAndAge(String name,Integer age);

    //新增根据年龄查询
    public List<User> findByAge(Integer age);
}
