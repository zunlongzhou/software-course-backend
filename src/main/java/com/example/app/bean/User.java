package com.example.app.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column
    private String userId;

    @Column
    private String userName;

    @Column
    private String userPhone;

    @Column
    private String mail;

    @Column
    private String vipId;

    @Column
    private Date deadline;

    @Column
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", mail='" + mail + '\'' +
                ", vipId='" + vipId + '\'' +
                ", deadline=" + deadline +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String userId, String userName, String userPhone, String mail, String vipId, Date deadline, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.mail = mail;
        this.vipId = vipId;
        this.deadline = deadline;
        this.password = password;
    }

    public User(){}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

}
