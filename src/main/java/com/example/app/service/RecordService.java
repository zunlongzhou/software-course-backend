package com.example.app.service;

import com.example.app.bean.Record;
import com.example.app.domain.RecordDisplay;
import com.example.app.domain.RecordTransfer;
import com.example.app.utils.PageUtil;

public interface RecordService {

    PageUtil getAllRecordByPageUtil(int pageNum, int pageSize);

    PageUtil getRecordByMeetingId(String meetingId,int pageNum, int pageSize);

    String save(RecordTransfer recordTransfer);

    RecordDisplay findRecordByRecordId(String recordId);

    String updateRecord(Record record);

    String deleteRecord(String recordId);
}
