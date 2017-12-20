package edu.vero.easyclass.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.vero.easyclass.domain.User;
import org.junit.Assert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import edu.vero.easyclass.base.ControllerBaseTester;
import edu.vero.easyclass.domain.Teacher;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


/**
 * TeacherController Tester.
 * 
 * @author XiangDe Liu qq313700046@icloud.com
 * @since
 * 
 *        <pre>
 * ʮ���� 20, 2017
 *        </pre>
 * 
 * @version 1.0
 */
public class TeacherControllerTest extends ControllerBaseTester
{

    @Before
    public void before()
        throws Exception
    {}

    @After
    public void after()
        throws Exception
    {}

    /**
     * Method: setTeacherService(TeacherService teacherService)
     */
    @Test
    public void testSetTeacherService()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findAllTeacher()
     */
    @Test
    public void testFindAllTeacher()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findTeacher(@PathVariable("userId") Integer id)
     */
    @Test
    public void testFindTeacher()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findTeacherArrangement(@PathVariable("userId") Integer userId)
     */
    @Test
    public void testFindTeacherArrangement()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: createTeacherArrangement(@PathVariable("userId") Integer userId, @RequestBody
     * List<TeacherArrangement> list)
     */
    @Test
    public void testCreateTeacherArrangement()
        throws Exception
    {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("刘冬梅");
        teacher.setTeacherGender("女");
        teacher.setUsername("冬梅冬梅马冬梅");
        String jsonString = objectMapper.writeValueAsString(teacher);
        MvcResult result =  mockMvc.perform(post("/teachers").content(jsonString.getBytes())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print()).andReturn();
        String content = result.getResponse().getContentAsString();
        Teacher createdTeacher = objectMapper.readValue(content,Teacher.class);
        Assert.assertNotNull(teacher.getUserId());
        System.out.println("Created teacher's user is "+createdTeacher.getUserId());
        // TODO: Test goes here...
    }
}
