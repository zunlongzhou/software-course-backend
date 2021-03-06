package com.example.app.service;

import com.example.app.bean.User;
import com.example.app.domain.UserTransfer;
import com.example.app.utils.PageUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface UserService {

    PageUtil getAllUserByPageUtil(int pageNum, int pageSize);

    String save(UserTransfer userTransfer);

    List<User> findByUserName(String name);

    User findByVipId(String vipId);

    User findByUserPhone(String userPhone);

    User findByMail(String mail);

    String login(String loginName,String password);

    String deleteByVipId(String vipId);

    String deleteByUserPhone(String userPhone);

    String deleteByMail(String mail);

    String updateUser(User user);

//    String updateUserDeadLine(Date deadline, String userId);
//
//    String updateUserMail(String mail,String userId);
//
//    String updateUserPassword(String password,String userId);
//
//    String updateUserName(String userName,String userId);
//
//    String updateUserPhone(String userPhone,String userId);
//
//    String updateUserVipId(String vipId,String userId);
//
//    String getUserIdByUserPhone(String userPhone);
//
//    String getUserIdByVipId(String vipId);
//
//    String getUserIdByMail(String mail);

}
