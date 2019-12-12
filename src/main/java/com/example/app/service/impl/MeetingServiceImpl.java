package com.example.app.service.impl;

import com.example.app.bean.Meeting;
import com.example.app.dao.MeetingRepository;
import com.example.app.domain.MeetingTransfer;
import com.example.app.service.MeetingService;
import com.example.app.utils.PageUtil;
import com.example.app.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public List<Meeting> findAll() {
        List<Meeting> res = meetingRepository.findAll();
        return res;
    }

    @Override
    public PageUtil getAllMeetingByPageUtil(int pageNum, int pageSize) {
        PageUtil pageUtil = new PageUtil();

        int totalNumber = meetingRepository.findAll().size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Meeting> list = meetingRepository.findMeeting((pageNum-1)*pageSize,pageSize);
        pageUtil.setContent(list);

        return pageUtil;
    }

    @Override
    public String save(MeetingTransfer meetingTransfer) {


        if (isExistByMeetingName(meetingTransfer.getMeetingName())){
            return "save failed";
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = null;
            try {
                startDate = sdf.parse(meetingTransfer.getMeetingStartDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date endDate = null;
            try {
                endDate = sdf.parse(meetingTransfer.getMeetingEndDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Meeting meeting = new Meeting();
            meeting.setMeetingName(meetingTransfer.getMeetingName());
            meeting.setMeetingStartDate(startDate);
            meeting.setMeetingEndDate(endDate);
            meeting.setMeetingIntroduction(meetingTransfer.getMeetingIntroduction());
            meeting.setMeetingPhone(meetingTransfer.getMeetingPhone());
            meeting.setMeetingPicture(meetingTransfer.getMeetingPicture());
            meeting.setMeetingPlace(meetingTransfer.getMeetingPlace());
            meeting.setMeetingTitle(meetingTransfer.getMeetingTitle());

            String time = TimeUtil.getTimeInMillis();
            String meetId = "meeting" + time;
            meeting.setMeetingId(meetId);
            meetingRepository.save(meeting);
            return "save success";
        }
    }

    @Override
    public Meeting findByMeetingName(String meetingName) {
        Meeting m = meetingRepository.findByMeetingName(meetingName);
        if(m != null){
            return m;
        }
        else{
            return null;
        }
    }


    @Override
    public PageUtil findMeetingByMeetingPlace(String place,int pageNum, int pageSize) {
        PageUtil pageUtil = new PageUtil();

        int totalNumber = meetingRepository.findByMeetingPlace(place).size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Meeting> list = meetingRepository.findMeetingByMeetingPlace(place,(pageNum-1)*pageSize,pageSize);
        pageUtil.setContent(list);

        return pageUtil;
    }


    @Override
    public Meeting findByMeetingId(String meetingId) {
        Meeting m = meetingRepository.findByMeetingId(meetingId);
        if(m != null){
            return m;
        }
        else{
            return null;
        }
    }

    @Override
    public String deleteByMeetingId(String meetingId) {
        Meeting m = meetingRepository.findByMeetingId(meetingId);
        if(m != null){
            meetingRepository.deleteByMeetingId(meetingId);
            return "deleteByMeetingId success";
        }
        else {
            return "deleteByMeetingId failed";
        }
    }

    @Override
    public String deleteByMeetingName(String meetingName) {
        Meeting m = meetingRepository.findByMeetingId(meetingName);
        if(m != null){
            meetingRepository.deleteByMeetingName(meetingName);
            return "deleteByMeetingName success";
        }
        else {
            return "deleteByMeetingName failed";
        }
    }

    @Override
    public String updateMeeting(Meeting meeting) {
        if (isExistByMeetingName(meeting.getMeetingName())){
            return "update failed";
        }
        else {
            meetingRepository.save(meeting);
            return "update success";
        }
    }

    public boolean isExistByMeetingName(String meetingName) {
        Meeting m = meetingRepository.findByMeetingName(meetingName);
        if(m == null){
            return false;
        }
        else {
            return true;
        }
    }

//    @Override
//    public String updateMeetingDate(Date meetingDate, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingDate(meetingDate,meetingId);
//            return "updateMeetingDate success";
//        }
//        else {
//            return "updateMeetingDate failed";
//        }
//    }
//
//    @Override
//    public String updateMeetingIntroduction(String meetingIntroduction, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingIntroduction(meetingIntroduction,meetingId);
//            return "updateMeetingIntroduction success";
//        }
//        else {
//            return "updateMeetingIntroduction failed";
//        }
//    }
//
//    @Override
//    public String updateMeetingName(String meetingName, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingName(meetingName, meetingId);
//            return "updateMeetingName success";
//        }
//        else {
//            return "updateMeetingName failed";
//        }
//    }
//
//    @Override
//    public String updateMeetingPhone(String meetingPhone, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingPhone(meetingPhone, meetingId);
//            return "updateMeetingPhone success";
//        }
//        else {
//            return "updateMeetingPhone failed";
//        }
//    }
//
//    @Override
//    public String updateMeetingPicture(String meetingPicture, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingPicture(meetingPicture, meetingId);
//            return "updateMeetingPicture success";
//        }
//        else {
//            return "updateMeetingPicture failed";
//        }
//    }
//
//    @Override
//    public String updateMeetingPlace(String meetingPlace, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingPlace(meetingPlace, meetingId);
//            return "updateMeetingPlace success";
//        }
//        else {
//            return "updateMeetingPlace failed";
//        }
//    }
//
//    @Override
//    public String updateMeetingTitle(String meetingTitle, String meetingInfo) {
//        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
//            String meetingId=getMeetingIdByMeetingName(meetingInfo);
//            meetingRepository.updateMeetingTitle(meetingTitle, meetingId);
//            return "updateMeetingTitle success";
//        }
//        else {
//            return "updateMeetingTitle failed";
//        }
//    }

}
