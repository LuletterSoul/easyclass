package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="notice")
public class Notice {
    @GeneratedValue(generator = "noticeId",strategy = GenerationType.IDENTITY)
    private int noticeId;
    private String title;
    private String content;
    private Date establishTime;
    private TeacherArragement arragement;

    @ManyToOne
    @JoinColumn(name="arrageId")
    public TeacherArragement getArragement() {
        return arragement;
    }

    public void setArragement(TeacherArragement arragement) {
        this.arragement = arragement;
    }

    @Id
    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }
}
