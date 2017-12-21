package edu.vero.easyclass.controllers;

import edu.vero.easyclass.base.ControllerBaseTester;
import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.OnlineClassTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * TeacherArrangementController Tester.
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
public class TeacherArrangementControllerTest extends ControllerBaseTester
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
     * Method: setTeacherArrangementService(TeacherArrangementService teacherArrangementService)
     */
    @Test
    public void testSetTeacherArrangementService()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: createNotice(@PathVariable("arrangementId") Integer arrangementId, @RequestBody
     * Notice notice)
     */
    @Test
    public void testCreateNotice()
        throws Exception
    {
        Notice notice = new Notice();
        notice.setEstablishedTime(new Date());
        notice.setTitle("title!!!");

        String jsonString = objectMapper.writeValueAsString(notice);
        int arrangementId=1;
        MvcResult result =  mockMvc.perform(post("/arrangements/{arrangementId}/notices",arrangementId)
                .content(jsonString.getBytes())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print()).andReturn();
        String content = result.getResponse().getContentAsString();
        Notice created = objectMapper.readValue(content,Notice.class);
        Assert.assertNotNull(notice.getNoticeId());
        System.out.println("Created notice is "+created.getNoticeId());
    }

    /**
     * Method: createOnlineClassTest(@PathVariable("arrangementId") Integer
     * arrangementId, @RequestBody OnlineClassTest onlineClassTest)
     */
    @Test
    public void testCreateOnlineClassTest()
        throws Exception
    {
        OnlineClassTest onlineClassTest = new OnlineClassTest();
        onlineClassTest.setEstablishedTime(new Date());


        String jsonString = objectMapper.writeValueAsString(onlineClassTest);
        MvcResult result =  mockMvc.perform(post("/arrangements/{arrangementId}/tests")
                .content(jsonString.getBytes())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print()).andReturn();
        String content = result.getResponse().getContentAsString();
        OnlineClassTest created = objectMapper.readValue(content,OnlineClassTest.class);
        Assert.assertNotNull(onlineClassTest.getTestId());
        System.out.println("Created onlineClassTest is "+created.getTestId());
    }

    /**
     * Method: findAllArrangements()
     */
    @Test
    public void testFindAllArrangements()
        throws Exception
    {
       /* TeacherArrangement teacherArrangement = new TeacherArrangement();

        String jsonString = objectMapper.writeValueAsString(teacherArrangement);
        MvcResult result =  mockMvc.perform(get("/arrangements")
                .content(jsonString.getBytes())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print()).andReturn();
        String content = result.getResponse().getContentAsString();
*/
    }

    /**
     * Method: findAllCoursewares(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindAllCoursewares()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findNewestNotices(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindNewestNotices()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: createAttendance(@PathVariable("arrangementId") Integer arrangementId, @RequestBody
     * Attendance attendance)
     */
    @Test
    public void testCreateAttendance()
       throws Exception
    {
        Attendance attendance = new Attendance();
        attendance.setEstablishedTime(new Date());
        attendance.setClosed(false);

        String jsonString = objectMapper.writeValueAsString(attendance);
        MvcResult result =  mockMvc.perform(post("/arrangements/{arrangementId}/attendances")
                .content(jsonString.getBytes())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print()).andReturn();
        String content = result.getResponse().getContentAsString();
        Attendance created = objectMapper.readValue(content,Attendance.class);
        Assert.assertNotNull(attendance.getAttendanceId());
        System.out.println("Created attendance is "+created.getAttendanceId());
    }

    /**
     * Method: findArrangement(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindArrangement()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findAllOnlineClassTest(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindAllOnlineClassTest()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findAllClassTime(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindAllClassTime()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findAllCourseComment(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindAllCourseComment()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findCourse(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindCourse()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findAllNotice(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindAllNotice()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: findTeacher(@PathVariable("arrangementId") Integer arrangementId)
     */
    @Test
    public void testFindTeacher()
        throws Exception
    {
        // TODO: Test goes here...
    }

}
