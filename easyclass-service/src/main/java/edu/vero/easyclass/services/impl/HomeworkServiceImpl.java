package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.repositories.HomeworkJpaDao;
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
import java.util.List;


@Service
public class HomeworkServiceImpl implements HomeworkService
{

    private HomeworkJpaDao homeworkJpaDao;

    private ScheduleJpaDao scheduleJpaDao;

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
        ClassSchedule schedule = scheduleJpaDao.findOne(homework.getSchedule().getScheduleId());
        homework.setSchedule(schedule);
        return homeworkJpaDao.saveAndFlush(homework);
    }

    @Override
    public List<Homework> findAllHomeworks()
    {
        List<Homework> list = homeworkJpaDao.findAll();
        return list;
    }

    public Homework uploadHomework(Integer homeworkId, MultipartFile multipartFile, HttpServletRequest request)
    {
        Homework homework = homeworkJpaDao.findOne(homeworkId);
        String fileName = multipartFile.getOriginalFilename();
        if (homework == null)
        {
            throw new EntityNotFoundException();
        }
        Integer scheduleId = homework.getSchedule().getScheduleId();
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
        homework.setFileName(fileName);
        homework.setSubmitted(true);
        homework.setFilePath(realPath);
        homework.setSize(multipartFile.getSize());
        homeworkJpaDao.save(homework);
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
    public Homework downloadHomework(Integer homeworkId, HttpServletResponse response) {
        Homework homework  = homeworkJpaDao.findOne(homeworkId);
        String realPath = homework.getFilePath();
        String fileName = homework.getFileName();
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
        return homework;
    }

}
