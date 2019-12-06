package com.example.app.controller;

import com.example.app.service.MeetingService;
import com.example.app.bean.Meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/findAllMeeting")
    public List<Meeting> findAllMeeting(){
        return meetingService.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Meeting meeting){
        if (meeting ==null){
            return "save failed";
        }else {
            return meetingService.save(meeting);
        }
    }


    @RequestMapping(value = "/findByMeetingName",method = RequestMethod.GET)
    public Meeting findByMeetingName(@RequestParam(value = "meetingName") String meetingName){
        return meetingService.findByMeetingName(meetingName);
    }


    @RequestMapping(value = "/findByMeetingId",method = RequestMethod.GET)
    public Meeting findByMeetingId(@RequestParam(value = "meetingId") String meetingId){
        return meetingService.findByMeetingId(meetingId);
    }


    @RequestMapping(value = "/findByMeetingPlace",method = RequestMethod.GET)
    public List<Meeting> findByMeetingPlace(@RequestParam(value = "meetingPlace") String meetingPlace){
        return meetingService.findByMeetingPlace(meetingPlace);
    }


    @RequestMapping(value = "/deleteByMeetingId",method = RequestMethod.GET)
    public String deleteByMeetingId(@RequestParam(value = "meetingId") String meetingId){
        return meetingService.deleteByMeetingId(meetingId);
    }

    @RequestMapping(value = "/deleteByMeetingName",method = RequestMethod.GET)
    public String deleteByMeetingName(@RequestParam(value = "meetingName") String meetingName){
        return meetingService.deleteByMeetingName(meetingName);
    }

    @RequestMapping(value = "/updateMeetingDate",method = RequestMethod.GET)
    public String updateMeetingDate(@RequestParam(value = "meetingDate") Date meetingDate,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingDate(meetingDate,meetingInfo);
    }

    @RequestMapping(value = "/updateMeetingIntroduction",method = RequestMethod.GET)
    public String updateMeetingIntroduction(@RequestParam(value = "meetingIntroduction") String meetingIntroduction,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingIntroduction(meetingIntroduction,meetingInfo);
    }

    @RequestMapping(value = "/updateMeetingName",method = RequestMethod.GET)
    public String updateMeetingName(@RequestParam(value = "meetingName") String meetingName,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingName(meetingName,meetingInfo);
    }

    @RequestMapping(value = "/updateMeetingPhone",method = RequestMethod.GET)
    public String updateMeetingPhone(@RequestParam(value = "meetingPhone") String meetingPhone,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingPhone(meetingPhone,meetingInfo);
    }

    @RequestMapping(value = "/updateMeetingPicture",method = RequestMethod.GET)
    public String updateMeetingPicture(@RequestParam(value = "meetingPicture") String meetingPicture,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingPicture(meetingPicture,meetingInfo);
    }

    @RequestMapping(value = "/updateMeetingPlace",method = RequestMethod.GET)
    public String updateMeetingPlace(@RequestParam(value = "meetingPlace") String meetingPlace,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingPlace(meetingPlace,meetingInfo);
    }

    @RequestMapping(value = "/updateMeetingTitle",method = RequestMethod.GET)
    public String updateMeetingTitle(@RequestParam(value = "meetingTitle") String meetingTitle,@RequestParam(value = "meetingInfo") String meetingInfo){
        return meetingService.updateMeetingTitle(meetingTitle,meetingInfo);
    }

}