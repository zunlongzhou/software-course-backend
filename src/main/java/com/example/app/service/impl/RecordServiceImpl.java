package com.example.app.service.impl;

import com.example.app.bean.Meeting;
import com.example.app.bean.Record;
import com.example.app.bean.User;
import com.example.app.dao.RecordRepository;
import com.example.app.dao.UserRepository;
import com.example.app.domain.RecordDisplay;
import com.example.app.domain.RecordTransfer;
import com.example.app.service.RecordService;
import com.example.app.utils.PageUtil;
import com.example.app.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PageUtil getAllRecordByPageUtil(int pageNum, int pageSize) {

        PageUtil pageUtil = new PageUtil();

        int totalNumber = recordRepository.findAll().size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Record> listRecord = recordRepository.findRecord((pageNum-1)*pageSize,pageSize);
        List<RecordDisplay> listRecordDisplay = new ArrayList<RecordDisplay>();
        Iterator<Record> iterator = listRecord.iterator();
        while (iterator.hasNext()) {
            Record record = iterator.next();
            RecordDisplay recordDisplay = new RecordDisplay();
            User user = userRepository.findByUserId(record.getUserId());

            recordDisplay.setMeetingId(record.getMeetingId());
            recordDisplay.setRecordDate(record.getRecordDate());
            recordDisplay.setUserId(record.getUserId());
            recordDisplay.setRecordId(record.getRecordId());

            recordDisplay.setDeadline(user.getDeadline());
            recordDisplay.setMail(user.getMail());
            recordDisplay.setUserName(user.getUserName());
            recordDisplay.setUserPhone(user.getUserPhone());
            recordDisplay.setVipId(user.getUserPhone());
            listRecordDisplay.add(recordDisplay);
        }

        pageUtil.setContent(listRecordDisplay);

        return pageUtil;

    }

    @Override
    public PageUtil getRecordByMeetingId(String meetingId,int pageNum, int pageSize) {

        PageUtil pageUtil = new PageUtil();

        int totalNumber = recordRepository.findByMeetingId(meetingId).size();

        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalElements(totalNumber);
        pageUtil.setNumber(pageNum);
        List<Record> listRecord = recordRepository.findRecordByMeetingId(meetingId,pageNum,pageSize);
        List<RecordDisplay> listRecordDisplay = new ArrayList<RecordDisplay>();
        Iterator<Record> iterator = listRecord.iterator();
        while (iterator.hasNext()) {
            Record record = iterator.next();
            RecordDisplay recordDisplay = new RecordDisplay();
            User user = userRepository.findByUserId(record.getUserId());

            recordDisplay.setMeetingId(record.getMeetingId());
            recordDisplay.setRecordDate(record.getRecordDate());
            recordDisplay.setUserId(record.getUserId());
            recordDisplay.setRecordId(record.getRecordId());

            recordDisplay.setDeadline(user.getDeadline());
            recordDisplay.setMail(user.getMail());
            recordDisplay.setUserName(user.getUserName());
            recordDisplay.setUserPhone(user.getUserPhone());
            recordDisplay.setVipId(user.getUserPhone());
            listRecordDisplay.add(recordDisplay);
        }

        pageUtil.setContent(listRecordDisplay);

        return pageUtil;

    }

    @Override
    public String save(RecordTransfer recordTransfer) {

        if (isExistByMeetingIdAndUserId(recordTransfer.getMeetingId(),recordTransfer.getUserId())){
            return "save failed";
        }
        else {
            Record record = new Record();
            record.setMeetingId(recordTransfer.getMeetingId());
            record.setUserId(recordTransfer.getUserId());

            String time = TimeUtil.getTimeInMillis();
            String recordId = "record" + time;
            record.setRecordId(recordId);

            record.setRecordDate(TimeUtil.getNow());
            recordRepository.save(record);
            return "save success";
        }

    }

    @Override
    public RecordDisplay findRecordByRecordId(String recordId) {
        if (isExistByRecordId(recordId)){
            RecordDisplay recordDisplay = new RecordDisplay();
            Record record = recordRepository.findByRecordId(recordId);
            User user = userRepository.findByUserId(record.getUserId());

            recordDisplay.setMeetingId(record.getMeetingId());
            recordDisplay.setRecordDate(record.getRecordDate());
            recordDisplay.setUserId(record.getUserId());
            recordDisplay.setRecordId(record.getRecordId());

            recordDisplay.setDeadline(user.getDeadline());
            recordDisplay.setMail(user.getMail());
            recordDisplay.setUserName(user.getUserName());
            recordDisplay.setUserPhone(user.getUserPhone());
            recordDisplay.setVipId(user.getUserPhone());
            return recordDisplay;
        }
        else {
            return null;
        }
    }

    @Override
    public String updateRecord(Record record) {
        if (isExistByMeetingIdAndUserId(record.getMeetingId(),record.getUserId())){
            recordRepository.save(record);
            return "update success";
        }
        else {
            return "update failed";
        }
    }

    @Override
    public String deleteRecord(String recordId) {
        if (isExistByRecordId(recordId)){
            recordRepository.deleteByRecordId(recordId);
            return "delete success";
        }
        else {
            return "delete failed";
        }
    }

    public boolean isExistByMeetingIdAndUserId(String meetingId,String userId) {
        Record r = recordRepository.findByMeetingIdAndUserId(meetingId,userId);
        if(r == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isExistByRecordId(String recordId){
        Record r = recordRepository.findByRecordId(recordId);
        if(r == null){
            return false;
        }
        else {
            return true;
        }
    }
}
