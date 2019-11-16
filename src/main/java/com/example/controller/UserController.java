package com.example.controller;

import com.example.po.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //查询数据，展示列表
    @RequestMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("list",userList);

        return "user/list";

    }


    //用户点击 add 按钮，跳转到新增用户页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    //保存新增用户数据
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);

        //跳转到列表页
        return "redirect:/";
    }

    //根据用户id查询用户数据
    @RequestMapping("/toEdit/{id}")
    public String findOne(@PathVariable("id") Long id, Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "user/userEdit";
    }

    //保存修改数据
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user.getId(),user);

        return "redirect:/";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);

        return "redirect:/";
    }
}
