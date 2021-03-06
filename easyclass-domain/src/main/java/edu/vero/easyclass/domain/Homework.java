package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "homework")
public class Homework {

    private int homeworkId;

    private String title;

    private String content;

    private Date establishedTime;

    private Date deadline;

    private TeacherArrangement arrangement;

    private Set<HomeworkRecord> homeworkRecords;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrangementId")
    public TeacherArrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(TeacherArrangement arrangement) {
        this.arrangement = arrangement;
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "homework")
    public Set<HomeworkRecord> getHomeworkRecords() {
        return homeworkRecords;
    }

    public void setHomeworkRecords(Set<HomeworkRecord> homeworkRecords) {
        this.homeworkRecords = homeworkRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return homeworkId == homework.homeworkId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(homeworkId);
    }
}
