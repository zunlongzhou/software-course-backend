package com.example.app.dao;


import com.example.app.bean.Meeting;
import com.example.app.bean.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Integer> {

    Record findByRecordId(String recordId);

    Record findByMeetingIdAndUserId(String meetingId,String userId);

    @Transactional
    String deleteByRecordId(String recordId);

    @Query(nativeQuery = true,value = "select * from record r order by r.record_date ASC limit ?1,?2")
    List<Record> findRecord(int pageNum, int pageSize);

    @Query("select r from Record r where r.meetingId = ?1")
    List<Record> findByMeetingId(String meetingId);

    @Query(nativeQuery = true,value = "select * from record r where r.meeting_id = ?1 order by r.record_date ASC limit ?2,?3")
    List<Record> findRecordByMeetingId(String meetingId,int pageNum, int pageSize);


}
