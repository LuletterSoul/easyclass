package edu.vero.easyclass.domain;

import javax.persistence.*;

@Entity
@Table(name = "teacher_comment")
public class TeacherComment {
    @GeneratedValue(generator = "commentId", strategy = GenerationType.IDENTITY)
    private int commentId;
    private int score;
    private String type;
    private TeacherArrangement arrangement;

    @Id
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    @OneToOne
    @JoinColumn(name = "arrangeId")
    public TeacherArrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(TeacherArrangement arrangement) {
        this.arrangement = arrangement;
    }
}
