package com.example.app.service;

import com.example.app.bean.Meeting;
import com.example.app.domain.MeetingTransfer;
import com.example.app.utils.PageUtil;

import java.util.Date;
import java.util.List;

public interface MeetingService {

    List<Meeting> findAll();

    PageUtil getAllMeetingByPageUtil(int pageNum, int pageSize);

    String save(MeetingTransfer meetingTransfer);

    Meeting findByMeetingName(String name);

    PageUtil findMeetingByMeetingPlace(String place,int pageNum, int pageSize);

    Meeting findByMeetingId(String meetingId);

    String deleteByMeetingId(String meetingId);

    String deleteByMeetingName(String meetingName);

    String updateMeeting(Meeting meeting);

//    String updateMeetingDate(Date meetingDate, String meetingInfo);
//
//    String updateMeetingIntroduction(String meetingIntroduction,String meetingInfo);
//
//    String updateMeetingName(String meetingName,String meetingInfo);
//
//    String updateMeetingPhone(String meetingPhone,String meetingInfo);
//
//    String updateMeetingPicture(String meetingPicture,String meetingInfo);
//
//    String updateMeetingPlace(String meetingPlace,String meetingInfo);
//
//    String updateMeetingTitle(String meetingTitle,String meetingInfo);


}
