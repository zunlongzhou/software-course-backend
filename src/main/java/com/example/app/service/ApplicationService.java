package com.example.app.service;

import com.example.app.bean.Application;
import com.example.app.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ApplicationService {


    PageUtil getAllApplicationByPageUtil(int pageNum, int pageSize);

    List<Application> findAll();

    String save(Application application);

    Application findByApplicationId(String applicationId);

    Application findByUserIdAndMeetingId(String userId,String meetingId);

    List<Application> findByUserId(String userId);

    List<Application> findByMeetingId(String meetingId);

    String getApplicationId(Application application);

    String deleteApplication(String applicationId);

    String updateApplicationUserId(String meetingId,String applicationId);

    String updateApplicationMeetingId(String userId,String applicationId);



}
