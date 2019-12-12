package com.example.app.service.impl;

import com.example.app.bean.User;
import com.example.app.dao.UserRepository;
import com.example.app.domain.UserTransfer;
import com.example.app.service.UserService;
import com.example.app.utils.PageUtil;
import com.example.app.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
    public String save(UserTransfer userTransfer) {

        if (!isExistByUserPhone(userTransfer.getUserPhone()) && !isExistByMail(userTransfer.getMail())){
            User user = new User();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = sdf.parse(userTransfer.getDeadline());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            user.setDeadline(date);
            user.setMail(userTransfer.getMail());
            user.setPassword(userTransfer.getPassword());
            user.setUserName(userTransfer.getUserName());
            user.setUserPhone(userTransfer.getUserPhone());

            String time = TimeUtil.getTimeInMillis();
            String userId = "user" + time;
            String vipId = "vip" +time;
            user.setUserId(userId);
            user.setVipId(vipId);
            userRepository.save(user);

            return "save success";
        }
        else {
            return "save failed";
        }

    }

    @Override
    public List<User> findByUserName(String name) {
        List<User> m = userRepository.findByUserName(name);
        if (m.size() == 0){
            return null;
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
            return null;
        }
    }

    @Override
    public User findByUserPhone(String userPhone) {
        User u = userRepository.findByUserPhone(userPhone);
        if(u != null){
            return u;
        }
        else{
            return null;
        }
    }

    @Override
    public User findByMail(String mail) {
        User u = userRepository.findByMail(mail);
        if(u != null){
            return u;
        }
        else{
            return null;
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
    public String updateUser(User user) {
        if (isExistByUserPhone(user.getUserPhone())){
            return "update failed";
        }
        else {
            userRepository.save(user);
            return "update success";
        }
    }


    public boolean isExistByUserPhone(String userPhone) {
        User u = userRepository.findByUserPhone(userPhone);
        if(u == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isExistByMail(String mail) {
        User u = userRepository.findByMail(mail);
        if(u == null){
            return false;
        }
        else {
            return true;
        }
    }







//    @Override
//    public String updateUserDeadLine(Date deadline, String userInfo) {
//        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
//            String userId=getUserIdByVipId(userInfo);
//            userRepository.updateUserDeadLine(deadline,userId);
//            return "updateUserDeadline success";
//        }
//        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
//            String userId=getUserIdByMail(userInfo);
//            userRepository.updateUserDeadLine(deadline,userId);
//            return "updateUserDeadline success";
//        }
//        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
//            String userId=getUserIdByUserPhone(userInfo);
//            userRepository.updateUserDeadLine(deadline,userId);
//            return "updateUserDeadline success";
//        }
//        else {
//            return "updateUserDeadline failed";
//        }
//    }
//
//    @Override
//    public String updateUserMail(String mail, String userInfo) {
//        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
//            String userId=getUserIdByVipId(userInfo);
//            userRepository.updateUserMail(mail,userId);
//            return "updateUserMail success";
//        }
//        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
//            String userId=getUserIdByMail(userInfo);
//            userRepository.updateUserMail(mail,userId);
//            return "updateUserMail success";
//        }
//        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
//            String userId=getUserIdByUserPhone(userInfo);
//            userRepository.updateUserMail(mail,userId);
//            return "updateUserMail success";
//        }
//        else {
//            return "updateUserMail failed";
//        }
//    }
//
//    @Override
//    public String updateUserPassword(String password, String userInfo) {
//        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
//            String userId=getUserIdByVipId(userInfo);
//            userRepository.updateUserPassword(password, userId);
//            return "updateUserPassword success";
//        }
//        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
//            String userId=getUserIdByMail(userInfo);
//            userRepository.updateUserPassword(password, userId);
//            return "updateUserPassword success";
//        }
//        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
//            String userId=getUserIdByUserPhone(userInfo);
//            userRepository.updateUserPassword(password, userId);
//            return "updateUserPassword success";
//        }
//        else {
//            return "updateUserPassword failed";
//        }
//    }
//
//    @Override
//    public String updateUserName(String userName, String userInfo) {
//        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
//            String userId=getUserIdByVipId(userInfo);
//            userRepository.updateUserName(userName, userId);
//            return "updateUserName success";
//        }
//        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
//            String userId=getUserIdByMail(userInfo);
//            userRepository.updateUserName(userName, userId);
//            return "updateUserName success";
//        }
//        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
//            String userId=getUserIdByUserPhone(userInfo);
//            userRepository.updateUserName(userName, userId);
//            return "updateUserName success";
//        }
//        else {
//            return "updateUserName failed";
//        }
//    }
//
//    @Override
//    public String updateUserPhone(String userPhone, String userInfo) {
//        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
//            String userId=getUserIdByVipId(userInfo);
//            userRepository.updateUserPhone(userPhone,userId);
//            return "updateUserPhone success";
//        }
//        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
//            String userId=getUserIdByMail(userInfo);
//            userRepository.updateUserPhone(userPhone,userId);
//            return "updateUserPhone success";
//        }
//        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
//            String userId=getUserIdByUserPhone(userInfo);
//            userRepository.updateUserPhone(userPhone,userId);
//            return "updateUserPhone success";
//        }
//        else {
//            return "updateUserPhone failed";
//        }
//    }
//
//    @Override
//    public String updateUserVipId(String vipId, String userInfo) {
//        if(!getUserIdByVipId(userInfo).equals("nonExistent")){
//            String userId=getUserIdByVipId(userInfo);
//            userRepository.updateUserVipId(vipId,userId);
//            return "updateUserVipId success";
//        }
//        else if (!getUserIdByMail(userInfo).equals("nonExistent")){
//            String userId=getUserIdByMail(userInfo);
//            userRepository.updateUserVipId(vipId,userId);
//            return "updateUserVipId success";
//        }
//        else if (!getUserIdByUserPhone(userInfo).equals("nonExistent")){
//            String userId=getUserIdByUserPhone(userInfo);
//            userRepository.updateUserVipId(vipId,userId);
//            return "updateUserVipId success";
//        }
//        else {
//            return "updateUserVipId failed";
//        }
//
//    }
}
