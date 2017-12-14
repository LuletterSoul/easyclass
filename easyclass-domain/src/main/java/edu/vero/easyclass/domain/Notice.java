package edu.vero.easyclass.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notice")
public class Notice {
    @GeneratedValue(generator = "noticeId", strategy = GenerationType.IDENTITY)
    private int noticeId;
    private String title;
    private String content;
    private Date establishedTime;
    private TeacherArrangement arrangement;

    @ManyToOne
    @JoinColumn(name = "arrangeId")
    public TeacherArrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(TeacherArrangement arrangement) {
        this.arrangement = arrangement;
    }

    @Id
    @GenericGenerator(name = "identityGenerator",strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
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

    public Date getEstablishedTime() {
        return establishedTime;
    }

    public void setEstablishedTime(Date establishedTime) {
        this.establishedTime = establishedTime;
    }
}
