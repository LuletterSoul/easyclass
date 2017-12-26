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
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
        String realPath = context.getRealPath(relativePath);
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

}
