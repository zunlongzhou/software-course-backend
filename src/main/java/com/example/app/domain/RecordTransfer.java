package com.example.app.domain;

public class RecordTransfer {

    private String recordId;

    private String meetingId;

    private String userId;

    public RecordTransfer(){}

    public RecordTransfer(String recordId, String meetingId, String userId) {
        this.recordId = recordId;
        this.meetingId = meetingId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RecordTransfer{" +
                "recordId='" + recordId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
