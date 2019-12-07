package com.example.app.service;

import com.example.app.bean.Application;
import com.example.app.utils.PageUtil;
import java.util.List;

public interface ApplicationService {


    PageUtil getAllApplicationByPageUtil(int pageNum, int pageSize);

    List<Application> findAll();

    String save(Application application);

    Application findByApplicationId(String applicationId);

    Application findByUserIdAndMeetingId(String userId,String meetingId);

    PageUtil findApplicationByUserId(String userId,int pageNum, int pageSize);

    PageUtil findApplicationByMeetingId(String meetingId,int pageNum, int pageSize);

    String getApplicationId(Application application);

    String deleteApplication(String applicationId);

    String updateApplicationUserId(String meetingId,String applicationId);

    String updateApplicationMeetingId(String userId,String applicationId);



}
