package com.example.app.dao;

import com.example.app.bean.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Integer> {

    List<Meeting> findAll();

    @Query(nativeQuery = true,value = "select * from meeting m order by m.id ASC limit ?1,?2")
    public List<Meeting> findMeeting(int pageNum, int pageSize);

    @Query("select m from Meeting m where m.meetingPlace = ?1")
    List<Meeting> findByMeetingPlace(String meetingPlace);

    Meeting findByMeetingName(String meetingName);

    Meeting findByMeetingId(String meetingId);

    @Transactional
    String deleteByMeetingId(String meetingId);

    @Transactional
    String deleteByMeetingName(String meetingName);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingDate=?1 where m.meetingId=?2")
    Integer updateMeetingDate(Date meetingDate, String meetingId);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingIntroduction=?1 where m.meetingId=?2")
    Integer updateMeetingIntroduction(String meetingIntroduction, String meetingId);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingName=?1 where m.meetingId=?2")
    Integer updateMeetingName(String meetingName, String meetingId);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingPhone=?1 where m.meetingId=?2")
    Integer updateMeetingPhone(String meetingPhone, String meetingId);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingPicture=?1 where m.meetingId=?2")
    Integer updateMeetingPicture(String meetingPicture, String meetingId);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingPlace=?1 where m.meetingId=?2")
    Integer updateMeetingPlace(String meetingPlace, String meetingId);

    @Transactional
    @Modifying
    @Query("update Meeting m set m.meetingTitle=?1 where m.meetingId=?2")
    Integer updateMeetingTitle(String meetingTitle, String meetingId);

}
