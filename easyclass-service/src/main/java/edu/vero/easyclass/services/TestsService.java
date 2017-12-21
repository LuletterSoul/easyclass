package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;

import java.util.List;


public interface TestsService
{
    List<OnlineClassTest> findAllTests();

    OnlineClassTest createTest(OnlineClassTest onlineClassTest);

    OnlineClassTest updateTest(OnlineClassTest onlineClassTest);

    OnlineClassTest findTest(Integer testId);

    TeacherArrangement findTestArrangement(Integer testId);

    List<Question> findTestQuestions(Integer testId);

    OnlineClassTest deleteTest(Integer testId);
}