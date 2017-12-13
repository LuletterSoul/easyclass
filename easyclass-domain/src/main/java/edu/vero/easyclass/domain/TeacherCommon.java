package edu.vero.easyclass.domain;

import javax.persistence.*;

@Entity
@Table(name="teacher_common")
public class TeacherCommon {

    @GeneratedValue(generator = "commondId",strategy = GenerationType.IDENTITY)
    private int commondId;
    private int score;
    private String type;
    private TeacherArragement arragement;

    @Id
    public int getCommondId() {
        return commondId;
    }

    public void setCommondId(int commondId) {
        this.commondId = commondId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
