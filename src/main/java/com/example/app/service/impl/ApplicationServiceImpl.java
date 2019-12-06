package com.example.app.service.impl;


import com.example.app.bean.Application;
import com.example.app.dao.ApplicationRepository;
import com.example.app.service.ApplicationService;
import com.example.app.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<Application> findByUserId(String userId) {
        List<Application> a =  applicationRepository.findByUserId(userId);
        if (a.size()==0){
            a.add(nonExistent);
        }
        return a;
    }

    @Override
    public List<Application> findByMeetingId(String meetingId) {
        List<Application> a =  applicationRepository.findByMeetingIdId(meetingId);
        if (a.size()==0){
            a.add(nonExistent);
        }
        return a;
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
