package edu.vero.easyclass.domain;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class TestRecord {
    private float score;
    private String answer;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
