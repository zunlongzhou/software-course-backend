package com.example.app.controller;

import com.example.app.bean.User;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody User user){
        if (user ==null){
            return "save failed";
        }else {
            return userService.save(user);
        }
    }

    @RequestMapping(value = "/findByUserName",method = RequestMethod.GET)
    public List<User> findByUserName(@RequestParam(value = "userName") String userName){
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/findByVipId",method = RequestMethod.GET)
    public User findByVipId(@RequestParam(value = "vipId") String vipId){
        return userService.findByVipId(vipId);
    }

    @RequestMapping(value = "/findByUserPhone",method = RequestMethod.GET)
    public User findByUserPhone(@RequestParam(value = "userPhone") String userPhone){
        return userService.findByUserPhone(userPhone);
    }

    @RequestMapping(value = "/findByMail",method = RequestMethod.GET)
    public User findByMail(@RequestParam(value = "mail") String mail){
        return userService.findByMail(mail);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "loginName") String loginName,@RequestParam(value = "password") String password){
        return userService.login(loginName,password);
    }

    @RequestMapping(value = "/deleteByVipId",method = RequestMethod.GET)
    public String deleteByVipId(@RequestParam(value = "vipId") String vipId){
        return userService.deleteByVipId(vipId);
    }


    @RequestMapping(value = "/deleteByUserPhone",method = RequestMethod.GET)
    public String deleteByUserPhone(@RequestParam(value = "userPhone") String userPhone){
        return userService.deleteByUserPhone(userPhone);
    }


    @RequestMapping(value = "/deleteByMail",method = RequestMethod.GET)
    public String deleteByMail(@RequestParam(value = "mail") String mail){
        return userService.deleteByMail(mail);
    }

    @RequestMapping(value = "/updateUserDeadLine",method = RequestMethod.GET)
    public String updateUserDeadline(@RequestParam(value = "deadline") Date deadline,@RequestParam(value = "userInfo") String userInfo){
        return userService.updateUserDeadline(deadline,userInfo);
    }

    @RequestMapping(value = "/updateUserPassword",method = RequestMethod.POST)
    public String updateUserPassword(@RequestParam(value = "password")String password,@RequestParam(value = "userInfo") String userInfo){
        return userService.updateUserPassword(password,userInfo);
    }

    @RequestMapping(value = "/updateUserName",method = RequestMethod.GET)
    public String updateUserName(@RequestParam(value = "userName")String userName,@RequestParam(value = "userInfo") String userInfo){
        return userService.updateUserName(userName,userInfo);
    }

    @RequestMapping(value = "/updateUserPhone",method = RequestMethod.GET)
    public String updateUserPhone(@RequestParam(value = "userPhone")String userPhone,@RequestParam(value = "userInfo") String userInfo){
        return userService.updateUserPhone(userPhone,userInfo);
    }

    @RequestMapping(value = "/updateUserVipId",method = RequestMethod.GET)
    public String updateUserVipId(@RequestParam(value = "vipId")String vipId,@RequestParam(value = "userInfo") String userInfo){
        return userService.updateUserVipId(vipId,userInfo);
    }

    @RequestMapping(value = "/updateUserMail",method = RequestMethod.GET)
    public String updateUserMail(@RequestParam(value = "mail")String userMail,@RequestParam(value = "userInfo") String userInfo){
        return userService.updateUserMail(userMail,userInfo);
    }

}
