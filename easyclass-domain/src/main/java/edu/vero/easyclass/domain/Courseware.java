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
    @GeneratedValue(generator = "coursewareId", strategy = GenerationType.IDENTITY)
    private int coursewareId;

    private String title;

    private String fileName;

    private String filePath;

    private int size;

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
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

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("coursewareId", coursewareId).add("title",
            title).add("fileName", fileName).add("filePath", filePath).add("size",
                size).toString();
    }
}
