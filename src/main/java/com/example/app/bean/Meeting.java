package com.example.app.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue
    private  Integer Id;

    @Column
    private String meetingId;

    @Column
    private String meetingName;

    @Column
    private String meetingPlace;

    @Column
    private Date meetingStartDate;

    @Column
    private Date meetingEndDate;

    @Column
    private String meetingPhone;

    @Column
    private String meetingIntroduction;

    @Column
    private String meetingTitle;

    @Column
    private String meetingPicture;

    public Meeting(){}

    public Meeting(String meetingId, String meetingName, String meetingPlace, Date meetingStartDate, Date meetingEndDate, String meetingPhone, String meetingIntroduction, String meetingTitle, String meetingPicture) {
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.meetingPlace = meetingPlace;
        this.meetingStartDate = meetingStartDate;
        this.meetingEndDate = meetingEndDate;
        this.meetingPhone = meetingPhone;
        this.meetingIntroduction = meetingIntroduction;
        this.meetingTitle = meetingTitle;
        this.meetingPicture = meetingPicture;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "Id=" + Id +
                ", meetingId='" + meetingId + '\'' +
                ", meetingName='" + meetingName + '\'' +
                ", meetingPlace='" + meetingPlace + '\'' +
                ", meetingStartDate=" + meetingStartDate +
                ", meetingEndDate=" + meetingEndDate +
                ", meetingPhone='" + meetingPhone + '\'' +
                ", meetingIntroduction='" + meetingIntroduction + '\'' +
                ", meetingTitle='" + meetingTitle + '\'' +
                ", meetingPicture='" + meetingPicture + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public Date getMeetingStartDate() {
        return meetingStartDate;
    }

    public void setMeetingStartDate(Date meetingStartDate) {
        this.meetingStartDate = meetingStartDate;
    }

    public Date getMeetingEndDate() {
        return meetingEndDate;
    }

    public void setMeetingEndDate(Date meetingEndDate) {
        this.meetingEndDate = meetingEndDate;
    }

    public String getMeetingPhone() {
        return meetingPhone;
    }

    public void setMeetingPhone(String meetingPhone) {
        this.meetingPhone = meetingPhone;
    }

    public String getMeetingIntroduction() {
        return meetingIntroduction;
    }

    public void setMeetingIntroduction(String meetingIntroduction) {
        this.meetingIntroduction = meetingIntroduction;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public String getMeetingPicture() {
        return meetingPicture;
    }

    public void setMeetingPicture(String meetingPicture) {
        this.meetingPicture = meetingPicture;
    }

}
