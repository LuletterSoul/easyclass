package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.domain.HomeworkRecord;
import edu.vero.easyclass.repositories.HomeworkJpaDao;
import edu.vero.easyclass.repositories.HomeworkRecordJpaDao;
import edu.vero.easyclass.repositories.ScheduleJpaDao;
import edu.vero.easyclass.services.HomeworkService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;


@Service
public class HomeworkServiceImpl implements HomeworkService
{

    private HomeworkJpaDao homeworkJpaDao;

    private ScheduleJpaDao scheduleJpaDao;

    private HomeworkRecordJpaDao homeworkRecordJpaDao;

    @Autowired
    public void setScheduleJpaDao(ScheduleJpaDao scheduleJpaDao)
    {
        this.scheduleJpaDao = scheduleJpaDao;
    }

    @Autowired
    public void setHomeworkJpaDao(HomeworkJpaDao homeworkJpaDao)
    {
        this.homeworkJpaDao = homeworkJpaDao;
    }

    @Autowired
    public void setHomeworkRecordJpaDao(HomeworkRecordJpaDao homeworkRecordJpaDao) {
        this.homeworkRecordJpaDao = homeworkRecordJpaDao;
    }

    @Override
    public Homework deleteHomework(Integer homeworkId)
    {
        Homework homework = homeworkJpaDao.findOne(homeworkId);
        homeworkJpaDao.delete(homework);
        return homework;
    }

    @Override
    public Homework updateHomework(Homework homework)
    {

        homeworkJpaDao.saveAndFlush(homework);
        return homework;
    }

    @Override
    public Homework createHomework(Homework homework)
    {
//        ClassSchedule schedule = scheduleJpaDao.findOne(homework.getSchedule().getScheduleId());
//        homework.setSchedule(schedule);
        return homeworkJpaDao.saveAndFlush(homework);
    }

    @Override
    public List<Homework> findAllHomeworks()
    {
        List<Homework> list = homeworkJpaDao.findAll();
        return list;
    }

    public Homework uploadHomework(Integer scheduleId, Integer homeworkId, MultipartFile multipartFile, HttpServletRequest request)
    {
        Homework homework = homeworkJpaDao.findOne(homeworkId);
        ClassSchedule schedule = scheduleJpaDao.findOne(scheduleId);
        String fileName = multipartFile.getOriginalFilename();
        if (homework == null)
        {
            throw new EntityNotFoundException();
        }
        ServletContext context = request.getServletContext();
        // 获取应用部署到服务器之后的应用上下文，为文件保存的路径做基础规划；
        String relativePath = "\\schedules\\" + scheduleId + "\\homeworks\\"+fileName;
        System.out.println(relativePath);
        String realPath = context.getRealPath(relativePath);
        System.out.println(realPath);
        try
        {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(realPath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //新建一条作业记录
        HomeworkRecord homeworkRecord = new HomeworkRecord();
        homeworkRecord.setSubmittedTime(new Date());
        homeworkRecord.setSchedule(schedule);
        homeworkRecord.setHomework(homework);
        homeworkRecord.setFileName(fileName);
        homeworkRecord.setFilePath(realPath);
        homeworkRecord.setSize(multipartFile.getSize());
        homeworkRecordJpaDao.save(homeworkRecord);
        return homework;
    }

//    public String toUTF8String(String str){
//        StringBuffer sb = new StringBuffer();
//        int len = str.length();
//        for(int i = 0;i<len;i++){
//            char c = str.charAt(i);
//            if(c>0&&c<=255){
//                sb.append(c);
//            }else{
//                byte b[];
//                try{
//                    b = Character.toString(c).getBytes("UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                    b=null;
//                }
//                for(int j=0;j<b.length;j++){
//                    int k=b[j];
//                    if(k<0){
//                        k &=255;
//                    }
//                    sb.append("%"+Integer.toHexString(k).toUpperCase());
//                }
//            }
//        }
//        return sb.toString();
//    }
    @Override
    public HomeworkRecord downloadHomework(Integer recordId, HttpServletResponse response) {
        HomeworkRecord homeworkRecord  = homeworkRecordJpaDao.findOne(recordId);
        String realPath = homeworkRecord.getFilePath();
        String fileName = homeworkRecord.getFileName();
        FileInputStream in = null;
        ServletOutputStream out = null;
        response.setHeader("Content-Type","application/x-msdownload");
        try {
            response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            in = new FileInputStream(realPath);
            out = response.getOutputStream();
            int len = 0;
            byte b[] = new byte[1024];
            while((len = in.read(b))!=-1 && in!=null){
                out.write(b,0,len);
            }
            in.close();
            out.close();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println(realPath+""+fileName+" "+"下载成功");
        return homeworkRecord;
    }

}
