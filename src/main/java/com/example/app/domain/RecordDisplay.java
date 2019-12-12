package com.example.app.domain;

import java.util.Date;

public class RecordDisplay {

    private String recordId;

    private String meetingId;

    private Date recordDate;

    private String userId;

    private String userName;

    private String userPhone;

    private String mail;

    private String vipId;

    private Date deadline;

    public RecordDisplay(){}

    public RecordDisplay(String recordId, String meetingId, Date recordDate, String userId, String userName, String userPhone, String mail, String vipId, Date deadline) {
        this.recordId = recordId;
        this.meetingId = meetingId;
        this.recordDate = recordDate;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.mail = mail;
        this.vipId = vipId;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "RecordDisplay{" +
                "recordId='" + recordId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", recordDate=" + recordDate +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", mail='" + mail + '\'' +
                ", vipId='" + vipId + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
