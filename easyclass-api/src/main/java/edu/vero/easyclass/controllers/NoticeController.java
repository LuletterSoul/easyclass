package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/notices")
public class NoticeController
{
    private NoticeService noticeService;

    @Autowired
    public void setNoticeService(NoticeService noticeService)
    {
        this.noticeService = noticeService;
    }

    @PutMapping
    public ResponseEntity<Notice> updateNotice(@RequestBody Notice notice)
    {
        return null;
    }

    @GetMapping(value = "/{noticeId}")
    public ResponseEntity<Notice> getNotice(@PathVariable("id") String id)
    {
        return null;
    }

    @DeleteMapping(value = "/{noticeId}")
    public ResponseEntity<Notice> deleteNotice(@PathVariable("id") String id)
    {
        return null;
    }

}
