package com.example.app.domain;


public class MeetingTransfer {

    private String meetingName;

    private String meetingPlace;

    private String meetingStartDate;

    private String meetingEndDate;

    private String meetingPhone;

    private String meetingIntroduction;

    private String meetingTitle;

    private String meetingPicture;

    public  MeetingTransfer(){}

    public MeetingTransfer(String meetingName, String meetingPlace, String meetingStartDate, String meetingEndDate, String meetingPhone, String meetingIntroduction, String meetingTitle, String meetingPicture) {
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
        return "MeetingTransfer{" +
                "meetingName='" + meetingName + '\'' +
                ", meetingPlace='" + meetingPlace + '\'' +
                ", meetingStartDate='" + meetingStartDate + '\'' +
                ", meetingEndDate='" + meetingEndDate + '\'' +
                ", meetingPhone='" + meetingPhone + '\'' +
                ", meetingIntroduction='" + meetingIntroduction + '\'' +
                ", meetingTitle='" + meetingTitle + '\'' +
                ", meetingPicture='" + meetingPicture + '\'' +
                '}';
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

    public String getMeetingStartDate() {
        return meetingStartDate;
    }

    public void setMeetingStartDate(String meetingStartDate) {
        this.meetingStartDate = meetingStartDate;
    }

    public String getMeetingEndDate() {
        return meetingEndDate;
    }

    public void setMeetingEndDate(String meetingEndDate) {
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
