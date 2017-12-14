package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.Teacher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * TeacherArrangementController Tester.
 *
 * @author XiangDe Liu qq313700046@icloud.com
 * @version 1.0
 * @since <pre>ʮ���� 15, 2017</pre>
 */

public class TeacherArrangementControllerTest extends BaseControllerTest{

    private static String baseUrl="/teachers";

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: setTeacherArrangementService(TeacherArrangementService teacherArrangementService)
     */
    @Test
    public void testSetTeacherArrangementService() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: createNotice(@PathVariable("arrangementId") Integer arrangementId, @RequestBody Notice notice)
     */
    @Test
    public void testCreateNotice() throws Exception {
        Notice notice = new Notice();
        notice.setContent("下周三交作业");
        notice.setEstablishedTime(new Date());
        notice.setTitle("关于作业");

        Teacher teacher =new Teacher();
        teacher.setTeacherName("刘冬梅");
        teacher.setTeacherGender("女");
        teacher.setTeacherId("915106842222");

        String jsonString = objectMapper.writeValueAsString(teacher);
        //模拟客户端发请求
        MvcResult mvcResult = mockMvc.perform(post(baseUrl)
                .content(jsonString.getBytes())
                //指定json格式为UTF-8
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                //服务器返回状态码为201，表示实体被创建
                .andExpect(status().isCreated())
                .andDo(print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        Teacher createdTeacher = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),Teacher.class);
        Assert.assertNotNull(createdTeacher.getTeacherId());
    }


} 
