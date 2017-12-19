package edu.vero.easyclass.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 12:32 2017/12/19.
 * @since easyclass
 */
@Entity
@DiscriminatorValue(value = "Course")
public class CourseComment extends TeachingComment
{
    private TeacherArrangement arrangement;

    public void setArrangement(TeacherArrangement arrangement)
    {
        this.arrangement = arrangement;
    }

    @ManyToOne
    public TeacherArrangement getArrangement()
    {
        return arrangement;
    }
}
