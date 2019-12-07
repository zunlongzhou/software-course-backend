package com.example.app.service.impl;


import com.example.app.bean.Application;
import com.example.app.dao.ApplicationRepository;
import com.example.app.service.ApplicationService;
import com.example.app.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {



    @Autowired
    private ApplicationRepository applicationRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Application nonExistent;
    {
        try {
            nonExistent = new Application("0","0","0",sdf.parse("0000-01-01 00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public String save(Application application) {
        if (application == null || application.getApplicationId().equals("nonExistent") ){
            return "save failed";
        }else {
            applicationRepository.save(application);
            return "save success";
        }
    }

    @Override
    public Application findByApplicationId(String applicationId) {
        Application a = applicationRepository.findByApplicationId(applicationId);
        if(a != null){
            return a;
        }
        else{
            return nonExistent;
        }
    }

    @Override
    public Application findByUserIdAndMeetingId(String userId, String meetingId) {
        Application a = applicationRepository.findByUserIdAndMeetingId(userId,meetingId);
        if(a != null){
            return a;
        }
        else{
            return nonExistent;
        }
    }

    @Override
    public PageUtil findApplicationByUserId(String userId,int pageNum, int pageSize) {
        PageUtil pageUtil = new PageUtil();

        int totalNumber = applicationRepository.findByUserId(userId).size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Application> list = applicationRepository.findApplicationByUserId(userId,(pageNum-1)*pageSize,pageSize);
        pageUtil.setContent(list);

        return pageUtil;
    }

    @Override
    public PageUtil findApplicationByMeetingId(String meetingId,int pageNum, int pageSize) {
        PageUtil pageUtil = new PageUtil();

        int totalNumber = applicationRepository.findByMeetingIdId(meetingId).size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Application> list = applicationRepository.findApplicationByMeetingId(meetingId,(pageNum-1)*pageSize,pageSize);
        pageUtil.setContent(list);

        return pageUtil;
    }

    @Override
    public String getApplicationId(Application application) {
        return application.getApplicationId();
    }

    @Override
    public String deleteApplication(String applicationId) {
        Application a =applicationRepository.findByApplicationId(applicationId);
        if (a != null){
            applicationRepository.deleteByApplicationId(applicationId);
            return "deleteApplication success";
        }
        else {
            return "deleteApplication failed";
        }
    }

    @Override
    public String updateApplicationUserId(String userId,String applicationId) {
       applicationRepository.updateApplicationUserId(userId,applicationId);
       return "updateApplicationUserId has done";
    }

    @Override
    public String updateApplicationMeetingId(String meetingId,String applicationId) {
        applicationRepository.updateApplicationMeetingId(meetingId,applicationId);
        return "updateApplicationMeetingId has done";
    }

    @Override
    public PageUtil getAllApplicationByPageUtil(int pageNum, int pageSize) {
        PageUtil pageUtil = new PageUtil();

        int totalNumber = applicationRepository.findAll().size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Application> list = applicationRepository.findApplication((pageNum-1)*pageSize,pageSize);
        pageUtil.setContent(list);

        return pageUtil;
    }
}
