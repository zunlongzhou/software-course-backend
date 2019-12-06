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

    public Application(String applicationId, String userId, String meetingId, Date applicationDate) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.meetingId = meetingId;
        this.applicationDate = applicationDate;
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

    @Override
    public String toString() {
        return "Application{" +
                "Id=" + Id +
                ", applicationId=" + applicationId +
                ", userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", applicationDate=" + applicationDate +
                '}';
    }
}
