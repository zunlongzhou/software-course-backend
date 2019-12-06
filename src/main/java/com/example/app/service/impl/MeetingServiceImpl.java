package com.example.app.service.impl;

import com.example.app.bean.Meeting;
import com.example.app.dao.MeetingRepository;
import com.example.app.service.MeetingService;
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
    Meeting nonExistent;

    {
        try {
            nonExistent = new Meeting("0","0","0",sdf.parse("0000-01-01 00:00:00"),"0","0","0","0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Meeting> findAll() {
        List<Meeting> res = meetingRepository.findAll();
        return res;
    }

    @Override
    public String save(Meeting meeting) {
        if (meeting == null || meeting.getMeetingName().equals("nonExistent") ){
            return "save failed";
        }else {
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
            return nonExistent;
        }
    }


    @Override
    public List<Meeting> findByMeetingPlace(String place) {
        List<Meeting> m = meetingRepository.findByMeetingPlace(place);
        if (m.size() == 0){
            m.add(nonExistent);
        }
        return m;
    }


    @Override
    public Meeting findByMeetingId(String meetingId) {
        Meeting m = meetingRepository.findByMeetingId(meetingId);
        if(m != null){
            return m;
        }
        else{
            return nonExistent;
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
    public String updateMeetingDate(Date meetingDate, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingDate(meetingDate,meetingId);
            return "updateMeetingDate success";
        }
        else {
            return "updateMeetingDate failed";
        }
    }

    @Override
    public String updateMeetingIntroduction(String meetingIntroduction, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingIntroduction(meetingIntroduction,meetingId);
            return "updateMeetingIntroduction success";
        }
        else {
            return "updateMeetingIntroduction failed";
        }
    }

    @Override
    public String updateMeetingName(String meetingName, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingName(meetingName, meetingId);
            return "updateMeetingName success";
        }
        else {
            return "updateMeetingName failed";
        }
    }

    @Override
    public String updateMeetingPhone(String meetingPhone, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingPhone(meetingPhone, meetingId);
            return "updateMeetingPhone success";
        }
        else {
            return "updateMeetingPhone failed";
        }
    }

    @Override
    public String updateMeetingPicture(String meetingPicture, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingPicture(meetingPicture, meetingId);
            return "updateMeetingPicture success";
        }
        else {
            return "updateMeetingPicture failed";
        }
    }

    @Override
    public String updateMeetingPlace(String meetingPlace, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingPlace(meetingPlace, meetingId);
            return "updateMeetingPlace success";
        }
        else {
            return "updateMeetingPlace failed";
        }
    }

    @Override
    public String updateMeetingTitle(String meetingTitle, String meetingInfo) {
        if(!getMeetingIdByMeetingName(meetingInfo).equals("nonExistent")){
            String meetingId=getMeetingIdByMeetingName(meetingInfo);
            meetingRepository.updateMeetingTitle(meetingTitle, meetingId);
            return "updateMeetingTitle success";
        }
        else {
            return "updateMeetingTitle failed";
        }
    }

    @Override
    public String getMeetingIdByMeetingName(String meetingName) {
        Meeting m = meetingRepository.findByMeetingName(meetingName);
        if(m == null){
            return "nonExistent";
        }
        else {
            return m.getMeetingId();
        }
    }
}