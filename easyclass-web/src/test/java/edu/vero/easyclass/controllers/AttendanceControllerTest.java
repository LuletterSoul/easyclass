package edu.vero.easyclass.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.vero.easyclass.base.ControllerBaseTester;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * AttendanceController Tester.
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
public class AttendanceControllerTest extends ControllerBaseTester
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
     * Method: setAttendanceService(AttendanceService attendanceService)
     */
    @Test
    public void testSetAttendanceService()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: createVote(@PathVariable("attendanceId") Integer attendanceId, @RequestBody Vote
     * vote)
     */
    @Test
    public void testCreateVote()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: deleteQRcode(@PathVariable("attendanceId") Integer attendanceId)
     */
    @Test
    public void testDeleteQRcode()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: getQRcode(@PathVariable("attendanceId") Integer attendanceId)
     */
    @Test
    public void testGetQRcode()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: updateAttendance(@RequestBody Attendance attendance)
     */
    @Test
    public void testUpdateAttendance()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: getAttendance(@PathVariable("attendanceId") Integer attendanceId)
     */
    @Test
    public void testGetAttendance()
        throws Exception
    {
        // TODO: Test goes here...
    }

}
