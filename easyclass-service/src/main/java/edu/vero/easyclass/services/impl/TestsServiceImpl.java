package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.repositories.QuestionJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.repositories.TestsJpaDao;
import edu.vero.easyclass.services.TestRecordService;
import edu.vero.easyclass.services.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestsServiceImpl implements TestsService
{
    private TestsJpaDao testsJpaDao;

    private QuestionJpaDao questionJpaDao;

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

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
        testsJpaDao.save(onlineClassTest);
        return onlineClassTest;
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
}
