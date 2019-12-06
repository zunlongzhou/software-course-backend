package com.example.app.service.impl;

import com.example.app.bean.User;
import com.example.app.dao.UserRepository;
import com.example.app.service.UserService;
import com.example.app.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    User nonExistent = null;

    @Override
    public List<User> findAll() {
        List<User> res = userRepository.findAll();
        return res;
    }

    @Override
    public PageUtil getAllUserByPageUtil(int pageNum, int pageSize) {
        PageUtil pageUtil = new PageUtil();

        int totalNumber = userRepository.findAll().size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<User> list = userRepository.findUser((pageNum-1)*pageSize,pageSize);
        pageUtil.setContent(list);

        return pageUtil;
    }

    @Override
    public String save(User user) {
         if (user == null || user.getUserName().equals("nonExistent") ){
             return "save failed";
         }else {
             userRepository.save(user);
             return "save success";
         }
    }

    @Override
    public List<User> findByUserName(String name) {
        List<User> m = userRepository.findByUserName(name);
        if (m.size() == 0){
            m.add(nonExistent);
        }
        return m;
    }

    @Override
    public User findByVipId(String vipId) {
        User u = userRepository.findByVipId(vipId);
        if(u != null){
            return u;
        }
        else{
            try {
                nonExistent = new User("0","nonExistent","0","0","0",sdf.parse("0000-01-01 00:00:00"),"0");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return nonExistent;
        }
    }

    @Override
    public User findByUserPhone(String userPhone) {
        User u = userRepository.findByUserPhone(userPhone);
        if(u != null){
            return u;
        }
        else{
            try {
                nonExistent = new User("0","nonExistent","0","0","0",sdf.parse("0000-01-01 00:00:00"),"0");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return nonExistent;
        }
    }

    @Override
    public User findByMail(String mail) {
        User u = userRepository.findByMail(mail);
        if(u != null){
            return u;
        }
        else{
            try {
                nonExistent = new User("0","nonExistent","0","0","0",sdf.parse("0000-01-01 00:00:00"),"0");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return nonExistent;
        }
    }

    @Override
    public String login(String loginName, String password) {
        if(userRepository.findByMailAndPassword(loginName,password)!=null){
            return "login success";
        }
        else if (userRepository.findByUserPhoneAndPassword(loginName,password)!=null){
            return "login success";
        }
        else if (userRepository.findByVipIdAndPassword(loginName,password)!=null){
            return "login success";
        }
        else {
            return "login failed";
        }
    }

    @Override
    public String deleteByVipId(String vipId) {
        User u = userRepository.findByVipId(vipId);
        if (u != null){
            userRepository.deleteByVipId(vipId);
            return "deleteByVipId success";
        }
        else {
            return "deleteByVipId failed";
        }
    }

    @Override
    public String deleteByUserPhone(String userPhone) {
        User u = userRepository.findByUserPhone(userPhone);
        if (u != null){
            userRepository.deleteByUserPhone(userPhone);
            return "deleteByUserPhone success";
        }
        else {
            return "deleteByUserPhone failed";
        }
    }

    @Override
    public String deleteByMail(String mail) {
        User u = userRepository.findByMail(mail);
        if (u != null){
            userRepository.deleteByMail(mail);
            return "deleteByMail success";
        }
        else {
            return "deleteByMail failed";
        }
    }

    @Override
    public String updateUserDeadline(Date deadline, String userInfo) {
        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
            String userId=getUserIdByVipId(userInfo);
            userRepository.updateUserDeadLine(deadline,userId);
            return "updateUserDeadline success";
        }
        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
            String userId=getUserIdByMail(userInfo);
            userRepository.updateUserDeadLine(deadline,userId);
            return "updateUserDeadline success";
        }
        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
            String userId=getUserIdByUserPhone(userInfo);
            userRepository.updateUserDeadLine(deadline,userId);
            return "updateUserDeadline success";
        }
        else {
            return "updateUserDeadline failed";
        }
    }

    @Override
    public String updateUserMail(String mail, String userInfo) {
        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
            String userId=getUserIdByVipId(userInfo);
            userRepository.updateUserMail(mail,userId);
            return "updateUserMail success";
        }
        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
            String userId=getUserIdByMail(userInfo);
            userRepository.updateUserMail(mail,userId);
            return "updateUserMail success";
        }
        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
            String userId=getUserIdByUserPhone(userInfo);
            userRepository.updateUserMail(mail,userId);
            return "updateUserMail success";
        }
        else {
            return "updateUserMail failed";
        }
    }

    @Override
    public String updateUserPassword(String password, String userInfo) {
        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
            String userId=getUserIdByVipId(userInfo);
            userRepository.updateUserPassword(password, userId);
            return "updateUserPassword success";
        }
        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
            String userId=getUserIdByMail(userInfo);
            userRepository.updateUserPassword(password, userId);
            return "updateUserPassword success";
        }
        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
            String userId=getUserIdByUserPhone(userInfo);
            userRepository.updateUserPassword(password, userId);
            return "updateUserPassword success";
        }
        else {
            return "updateUserPassword failed";
        }
    }

    @Override
    public String updateUserName(String userName, String userInfo) {
        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
            String userId=getUserIdByVipId(userInfo);
            userRepository.updateUserName(userName, userId);
            return "updateUserName success";
        }
        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
            String userId=getUserIdByMail(userInfo);
            userRepository.updateUserName(userName, userId);
            return "updateUserName success";
        }
        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
            String userId=getUserIdByUserPhone(userInfo);
            userRepository.updateUserName(userName, userId);
            return "updateUserName success";
        }
        else {
            return "updateUserName failed";
        }
    }

    @Override
    public String updateUserPhone(String userPhone, String userInfo) {
        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
            String userId=getUserIdByVipId(userInfo);
            userRepository.updateUserPhone(userPhone,userId);
            return "updateUserPhone success";
        }
        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
            String userId=getUserIdByMail(userInfo);
            userRepository.updateUserPhone(userPhone,userId);
            return "updateUserPhone success";
        }
        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
            String userId=getUserIdByUserPhone(userInfo);
            userRepository.updateUserPhone(userPhone,userId);
            return "updateUserPhone success";
        }
        else {
            return "updateUserPhone failed";
        }
    }

    @Override
    public String updateUserVipId(String vipId, String userInfo) {
        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
            String userId=getUserIdByVipId(userInfo);
            userRepository.updateUserVipId(vipId,userId);
            return "updateUserVipId success";
        }
        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
            String userId=getUserIdByMail(userInfo);
            userRepository.updateUserVipId(vipId,userId);
            return "updateUserVipId success";
        }
        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
            String userId=getUserIdByUserPhone(userInfo);
            userRepository.updateUserVipId(vipId,userId);
            return "updateUserVipId success";
        }
        else {
            return "updateUserVipId failed";
        }

    }

    @Override
    public String getUserIdByUserPhone(String userPhone) {
        User u = userRepository.findByUserPhone(userPhone);
        if(u == null){
            return "nonExistent";
        }
        else {
            return u.getUserId();
        }
    }

    @Override
    public String getUserIdByVipId(String vipId) {
        User u = userRepository.findByVipId(vipId);
        if(u == null){
            return "nonExistent";
        }
        else {
            return u.getUserId();
        }
    }

    @Override
    public String getUserIdByMail(String mail) {
        User u = userRepository.findByMail(mail);
        if(u == null){
            return "nonExistent";
        }
        else {
            return u.getUserId();
        }
    }


}
