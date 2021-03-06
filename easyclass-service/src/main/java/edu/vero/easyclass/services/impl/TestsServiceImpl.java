package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.repositories.*;
import edu.vero.easyclass.services.TestRecordService;
import edu.vero.easyclass.services.TestsService;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class TestsServiceImpl implements TestsService
{
    private TestsJpaDao testsJpaDao;

    private QuestionJpaDao questionJpaDao;

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    private TestRecordJpaDao testRecordJpaDao;

    @Autowired
    public void setTestRecordJpaDao(TestRecordJpaDao testRecordJpaDao) {
        this.testRecordJpaDao = testRecordJpaDao;
    }

    @Autowired
    public void setTestsJpaDao(TestsJpaDao testsJpaDao)
    {
        this.testsJpaDao = testsJpaDao;
    }

    @Autowired
    public void setQuestionJpaDao(QuestionJpaDao questionJpaDao)
    {
        this.questionJpaDao = questionJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJpaDao(TeacherArrangementJpaDao teacherArrangementJpaDao)
    {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
    }

    public List<OnlineClassTest> findAllTests()
    {
        return testsJpaDao.findAll();
    }

    public OnlineClassTest createTest(OnlineClassTest onlineClassTest)
    {
        TeacherArrangement teacherArrangement=teacherArrangementJpaDao.findOne(onlineClassTest.getArrangement().getArrangementId());
        onlineClassTest.setArrangement(teacherArrangement);
        List<Question> questions = onlineClassTest.getQuestions();
        List<Question> questionList = new ArrayList<>();
        for(Question question:questions){
            questionList.add(questionJpaDao.findOne(question.getQuestionId()));
        }
        onlineClassTest.setQuestions(questionList);
        return testsJpaDao.saveAndFlush(onlineClassTest);
    }

    @Override
    public OnlineClassTest updateTest(OnlineClassTest onlineClassTest)
    {
        testsJpaDao.save(onlineClassTest);
        return onlineClassTest;
    }

    public OnlineClassTest findTest(Integer testId)
    {
        return testsJpaDao.findOne(testId);
    }

    public TeacherArrangement findTestArrangement(Integer testId)
    {
        OnlineClassTest onlineClassTest = testsJpaDao.findOne(testId);
        return onlineClassTest.getArrangement();
    }

    public List<Question> findTestQuestions(Integer testId)
    {
        OnlineClassTest onlineClassTest = testsJpaDao.findOne(testId);
        return onlineClassTest.getQuestions();
    }

    @Override
    public OnlineClassTest deleteTest(Integer testId) {
        OnlineClassTest test = testsJpaDao.findOne(testId);
        List<TestRecord> testRecords = testRecordJpaDao.findAllRecordByTestId(testId);
        testRecordJpaDao.delete(testRecords);
        testsJpaDao.delete(testId);
        return test;
    }


}
