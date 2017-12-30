package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.repositories.CoursewareJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.services.CoursewareService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


@Service
public class CoursewareServiceImpl implements CoursewareService
{

    private TeacherArrangementJpaDao arrangementJpaDao;
    private CoursewareJpaDao coursewareJpaDao;

    @Autowired
    public void setArrangementJpaDao(TeacherArrangementJpaDao arrangementJpaDao) {
        this.arrangementJpaDao = arrangementJpaDao;
    }

    @Autowired
    public void setCoursewareJpaDao(CoursewareJpaDao coursewareJpaDao)
    {
        this.coursewareJpaDao = coursewareJpaDao;
    }

    @Override
    public List<Courseware> findAllCourseWare()
    {
        return coursewareJpaDao.findAll();
    }

    @Override
    public Courseware findCourseWare(Integer coursewareId)
    {
        return coursewareJpaDao.findOne(coursewareId);
    }

    @Override
    public Courseware createCourseware(Integer arrangeId,MultipartFile multipartFile,HttpServletRequest request)
    {
        Courseware courseware = new Courseware();
        String fileName = multipartFile.getOriginalFilename();
        ServletContext context = request.getServletContext();
        // 获取应用部署到服务器之后的应用上下文，为文件保存的路径做基础规划；
        String relativePath = "\\arrangement\\" + arrangeId + "\\coursewares\\"+fileName;
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
        courseware.setArrangement(arrangementJpaDao.findOne(arrangeId));
        courseware.setFileName(fileName);
        courseware.setFilePath(realPath);
        courseware.setSize(multipartFile.getSize());
        coursewareJpaDao.saveAndFlush(courseware);
        return courseware;
    }

    @Override
    public Courseware downloadCourseware(Integer coursewareId, HttpServletRequest request, HttpServletResponse response) {
        Courseware courseware = coursewareJpaDao.findOne(coursewareId);
        String realPath = courseware.getFilePath();
        String fileName = courseware.getFileName();
        FileInputStream in = null;
        ServletOutputStream out = null;
        response.setHeader("Content-Type", "application/x-msdownload");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            in = new FileInputStream(realPath);
            out = response.getOutputStream();
            int len = 0;
            byte b[] = new byte[1024];
            while ((len = in.read(b)) != -1 && in != null) {
                out.write(b, 0, len);
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(realPath + "" + fileName + " " + "下载成功");
        return courseware;
    }

    @Override
    public Courseware deleteCourseware(Integer CoursewareId)
    {
        Courseware courseware = coursewareJpaDao.findOne(CoursewareId);
        coursewareJpaDao.delete(courseware);
        return courseware;
    }

    @Override
    public Courseware updateCourseware(Courseware courseware)
    {
        TeacherArrangement arrangement = arrangementJpaDao.findOne(courseware.getArrangement().getArrangementId());
        courseware.setArrangement(arrangement);
        return coursewareJpaDao.saveAndFlush(courseware);
    }
}
