package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;

import java.util.List;


public interface TestsService
{
    public List<OnlineClassTest> findAllTests();

    public OnlineClassTest createTest(OnlineClassTest onlineClassTest);

    public OnlineClassTest updateTest(OnlineClassTest onlineClassTest);

    public OnlineClassTest findTest(Integer testId);

    public TeacherArrangement findTestArrangement(Integer testId);

    public List<Question> findTestQuestions(Integer testId);
}