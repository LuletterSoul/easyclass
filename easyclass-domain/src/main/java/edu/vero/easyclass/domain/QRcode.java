package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "q_rcode")
public class QRcode
{

    @GeneratedValue(generator = "codeId", strategy = GenerationType.IDENTITY)
    private int codeId;

    private String filePath;

    private String fileName;

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getCodeId()
    {
        return codeId;
    }

    public void setCodeId(int codeId)
    {
        this.codeId = codeId;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}
