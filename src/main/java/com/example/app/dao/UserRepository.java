package com.example.app.dao;

import com.example.app.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAll();

    @Query(nativeQuery = true,value = "select * from user u order by u.id ASC limit ?1,?2")
    List<User> findUser(int pageNum, int pageSize);

    List<User> findByUserName(String name);

    User findByUserPhone(String userPhone);

    User findByVipId(String vipId);

    User findByMail(String mail);

    User findByUserPhoneAndPassword(String userPhone,String password);

    User findByMailAndPassword(String mail,String password);

    User findByVipIdAndPassword(String vipId,String password);

    @Transactional
    void deleteByVipId(String vipId);

    @Transactional
    void deleteByUserPhone(String userPhone);

    @Transactional
    void deleteByMail(String mail);

    @Transactional
    @Modifying
    @Query("update User u set u.deadline=?1 where u.userId=?2")
    void updateUserDeadLine(Date deadline,String userId);

    @Transactional
    @Modifying
    @Query("update User u set u.mail=?1 where u.userId=?2")
    void updateUserMail(String mail,String userId);

    @Transactional
    @Modifying
    @Query("update User u set u.password=?1 where u.userId=?2")
    void updateUserPassword(String password,String userId);

    @Transactional
    @Modifying
    @Query("update User u set u.userName=?1 where u.userId=?2")
    void updateUserName(String userName,String userId);

    @Transactional
    @Modifying
    @Query("update User u set u.userPhone=?1 where u.userId=?2")
    void updateUserPhone(String userPhone,String userId);

    @Transactional
    @Modifying
    @Query("update User u set u.vipId=?1 where u.userId=?2")
    void updateUserVipId(String vipId,String userId);

}
