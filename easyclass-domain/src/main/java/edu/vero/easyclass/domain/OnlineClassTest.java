package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="online_class_test")
public class OnlineClassTest {

    @GeneratedValue(generator = "testId",strategy = GenerationType.IDENTITY)
    private int testId;
    private Date establishTime;
    private Date deadline;
    private TestRecord testRecord;
    private Set<Question> questions;
    private TeacherArragement arragement;

    @Embedded
    public TestRecord getTestRecord() {
        return testRecord;
    }

    public void setTestRecord(TestRecord testRecord) {
        this.testRecord = testRecord;
    }


    @ManyToOne
    @JoinColumn(name="arrageId")
    public TeacherArragement getArragement() {
        return arragement;
    }

    public void setArragement(TeacherArragement arragement) {
        this.arragement = arragement;
    }

    @OneToMany(mappedBy = "classTest")
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }



    @Id
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
