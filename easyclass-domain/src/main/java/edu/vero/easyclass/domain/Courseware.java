package edu.vero.easyclass.domain;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;


@Entity
@Table(name = "courseware")
public class Courseware
{
    private int coursewareId;

    private String title;

    private String fileName;

    private String filePath;

    private long size;

    private TeacherArrangement arrangement;

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getCoursewareId()
    {
        return coursewareId;
    }

    public void setCoursewareId(int coursewareId)
    {
        this.coursewareId = coursewareId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("coursewareId", coursewareId).add("title",
            title).add("fileName", fileName).add("filePath", filePath).add("size",
                size).toString();
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrangementId")
    public TeacherArrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(TeacherArrangement arrangement) {
        this.arrangement = arrangement;
    }
}
