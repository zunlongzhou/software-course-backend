package com.example.app.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column
    private String applicationId;

    @Column
    private String userId;

    @Column
    private String meetingId;

    @Column
    private Date applicationDate;

    @Column
    private String userName;

    @Column
    private String userPhone;

    @Column
    private String mail;

    @Column
    private String vipId;

    @Override
    public String toString() {
        return "Application{" +
                "Id=" + Id +
                ", applicationId='" + applicationId + '\'' +
                ", userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", applicationDate=" + applicationDate +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", mail='" + mail + '\'' +
                ", vipId='" + vipId + '\'' +
                '}';
    }

    public Application(String applicationId, String userId, String meetingId, Date applicationDate, String userName, String userPhone, String mail, String vipId) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.meetingId = meetingId;
        this.applicationDate = applicationDate;
        this.userName = userName;
        this.userPhone = userPhone;
        this.mail = mail;
        this.vipId = vipId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public Application(){}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

}
