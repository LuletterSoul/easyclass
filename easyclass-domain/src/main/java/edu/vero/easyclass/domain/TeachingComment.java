package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "teaching_comment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "commentLevel", discriminatorType = DiscriminatorType.STRING)
public class TeachingComment
{
    private int commentId;

    private float score;

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getCommentId()
    {
        return commentId;
    }

    public void setCommentId(int commentId)
    {
        this.commentId = commentId;
    }

    public float getScore()
    {
        return score;
    }

    public void setScore(float score)
    {
        this.score = score;
    }

}
