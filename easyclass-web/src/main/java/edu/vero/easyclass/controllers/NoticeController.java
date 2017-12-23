package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.services.NoticeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(description = "公告业务")
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
        return new ResponseEntity<Notice>(noticeService.updateNotice(notice), HttpStatus.OK);
    }

    @GetMapping(value = "/{noticeId}")
    public ResponseEntity<Notice> getNotice(@PathVariable("noticeId") Integer noticeId)
    {
        return new ResponseEntity<>(noticeService.findNotice(noticeId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{noticeId}")
    public ResponseEntity<Notice> deleteNotice(@PathVariable("noticeId") Integer noticeId)
    {
        return new ResponseEntity<>(noticeService.deleteNotice(noticeId),
                HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/create")

    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice)
    {
        return new ResponseEntity<>(noticeService.createNotice(notice), HttpStatus.CREATED);
    }

}
