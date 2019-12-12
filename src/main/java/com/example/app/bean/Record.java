package com.example.app.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column
    private String recordId;

    @Column
    private String meetingId;

    @Column
    private Date recordDate;

    @Column
    private String userId;

    public Record(){}

    public Record(String recordId, String meetingId, Date recordDate, String userId) {
        this.recordId = recordId;
        this.meetingId = meetingId;
        this.recordDate = recordDate;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Record{" +
                "Id=" + Id +
                ", recordId='" + recordId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", recordDate=" + recordDate +
                ", userId='" + userId + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
