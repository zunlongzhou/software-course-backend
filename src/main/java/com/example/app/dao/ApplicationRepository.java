package com.example.app.dao;


import com.example.app.bean.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {

    @Query(nativeQuery = true,value = "select * from application a order by a.application_date ASC limit ?1,?2")
    public List<Application> findApplication(int pageNum, int pageSize);

//    Page<Application> findAllByApplicationDate(Integer id, Pageable pageable);

    Application findByApplicationId(String applicationId);

    Application findByUserIdAndMeetingId(String userId,String meetingId);

    @Query("select a from Application a where a.userId = ?1")
    List<Application> findByUserId(String userId);

    @Query("select a from Application a where a.meetingId = ?1")
    List<Application> findByMeetingIdId(String meetingId);

    @Transactional
    String deleteByApplicationId(String applicationId);

    @Transactional
    @Modifying
    @Query("update Application a set a.meetingId=?1 where a.applicationId=?2")
    Integer updateApplicationMeetingId(String meeetingId, String applicationId);

    @Transactional
    @Modifying
    @Query("update Application a set a.userId=?1 where a.applicationId=?2")
    Integer updateApplicationUserId(String userId, String applicationId);

}
