package com.example.app.controller;

import com.example.app.bean.Application;
import com.example.app.service.ApplicationService;
import com.example.app.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/findAllApplication/{pageNum}/{pageSize}")
    public PageUtil findAllApplication(@PathVariable int pageNum, @PathVariable int pageSize){
        return applicationService.getAllApplicationByPageUtil(pageNum,pageSize);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Application application){
        if (application ==null){
            return "save failed";
        }else {
            return applicationService.save(application);
        }
    }

    @RequestMapping(value = "/findByApplicationId",method = RequestMethod.GET)
    public Application findByApplicationId(@RequestParam(value = "applicationId") String applicationId){
        return applicationService.findByApplicationId(applicationId);
    }

    @RequestMapping(value = "/findByUserIdAndMeetingId",method = RequestMethod.GET)
    public  Application findByUserIdAndMeetingId(@RequestParam(value = "userId")String userId,@RequestParam(value = "meetingId")String meetingId){
        return applicationService.findByUserIdAndMeetingId(userId,meetingId);
    }

    @RequestMapping(value = "/findByUserId",method = RequestMethod.GET)
    public List<Application> findByUserId(@RequestParam(value = "userId")String userId){
        return applicationService.findByUserId(userId);
    }

    @RequestMapping(value = "/findByMeetingId",method = RequestMethod.GET)
    public List<Application> findByMeetingId(@RequestParam(value = "meetingId")String meetingId){
        return applicationService.findByMeetingId(meetingId);
    }

    @RequestMapping(value = "/deleteApplication",method = RequestMethod.GET)
    public String deleteApplication(@RequestParam(value = "applicationId")String applicationId){
        return applicationService.deleteApplication(applicationId);
    }

    @RequestMapping(value = "/updateApplicationUserId",method = RequestMethod.GET)
    public String updateApplicationUserId(@RequestParam(value = "userId")String userId,@RequestParam(value = "applicationId")String applicationId){
        return applicationService.updateApplicationUserId(userId,applicationId);
    }

    @RequestMapping(value = "/updateApplicationMeetingId",method = RequestMethod.GET)
    public String updateApplicationMeetingId(@RequestParam(value = "meetingId")String meetingId,@RequestParam(value = "applicationId")String applicationId){
        return applicationService.updateApplicationMeetingId(meetingId,applicationId);
    }

}
