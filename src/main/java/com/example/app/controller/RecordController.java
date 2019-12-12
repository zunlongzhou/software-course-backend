package com.example.app.controller;

import com.example.app.bean.Record;
import com.example.app.domain.MeetingTransfer;
import com.example.app.domain.RecordDisplay;
import com.example.app.domain.RecordTransfer;
import com.example.app.service.RecordService;
import com.example.app.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/findAllRecord/{pageNum}/{pageSize}")
    public PageUtil findAllRecord(@PathVariable int pageNum, @PathVariable int pageSize){
        return recordService.getAllRecordByPageUtil(pageNum,pageSize);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody RecordTransfer recordTransfer){
        if (recordTransfer ==null){
            return "save failed";
        }else {
            return recordService.save(recordTransfer);
        }
    }

    @RequestMapping(value = "/findByRecordId",method = RequestMethod.GET)
    public RecordDisplay findByRecordId(@RequestParam(value = "recordId") String recordId){
        return recordService.findRecordByRecordId(recordId);
    }

    @RequestMapping(value = "/getRecordByMeetingId/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public PageUtil getRecordByMeetingId(@RequestParam(value = "meetingId") String meetingId,@PathVariable int pageNum, @PathVariable int pageSize){
        return recordService.getRecordByMeetingId(meetingId, pageNum, pageSize);
    }

    @RequestMapping(value = "/deleteByRecordId",method = RequestMethod.GET)
    public String deleteByRecordId(@RequestParam(value = "recordId") String recordId){
        return recordService.deleteRecord(recordId);
    }

    @RequestMapping(value = "/updateRecord",method = RequestMethod.POST)
    public String updateRecord(@RequestBody Record record){
        return recordService.updateRecord(record);
    }
}
