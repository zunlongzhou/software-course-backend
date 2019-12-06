package com.example.app.service;

import com.example.app.bean.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingService {

    List<Meeting> findAll();

    String save(Meeting meeting);

    Meeting findByMeetingName(String name);

    List<Meeting> findByMeetingPlace(String place);

    Meeting findByMeetingId(String meetingId);

    String deleteByMeetingId(String meetingId);

    String deleteByMeetingName(String meetingName);

    String updateMeetingDate(Date meetingDate, String meetingInfo);

    String updateMeetingIntroduction(String meetingIntroduction,String meetingInfo);

    String updateMeetingName(String meetingName,String meetingInfo);

    String updateMeetingPhone(String meetingPhone,String meetingInfo);

    String updateMeetingPicture(String meetingPicture,String meetingInfo);

    String updateMeetingPlace(String meetingPlace,String meetingInfo);

    String updateMeetingTitle(String meetingTitle,String meetingInfo);

    String getMeetingIdByMeetingName(String meetingName);

}
