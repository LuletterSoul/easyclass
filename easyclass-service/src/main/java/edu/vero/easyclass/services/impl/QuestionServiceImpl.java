package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.QuestionOption;
import edu.vero.easyclass.repositories.CourseJpaDao;
import edu.vero.easyclass.repositories.OptionJpaDao;
import edu.vero.easyclass.repositories.QuestionJpaDao;
import edu.vero.easyclass.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class QuestionServiceImpl implements QuestionService
{

    private QuestionJpaDao questionJpaDao;

    private OptionJpaDao optionJpaDao;

    private CourseJpaDao courseJpaDao;

    @Autowired
    public void setCourseJpaDao(CourseJpaDao courseJpaDao)
    {
        this.courseJpaDao = courseJpaDao;
    }

    @Autowired
    public void setQuestionJpaDao(QuestionJpaDao questionJpaDao)
    {
        this.questionJpaDao = questionJpaDao;
    }

    @Autowired
    public void setOptionJpaDao(OptionJpaDao optionJpaDao)
    {
        this.optionJpaDao = optionJpaDao;
    }

    @Override
    public List<Question> findAllQuestions()
    {
        return questionJpaDao.findAll();
    }

    @Override
    public Question createQuestion(Question question)
    {
        Course course = courseJpaDao.findOne(question.getCourse().getCourseId());
        Set<QuestionOption> questionOptions = question.getOptions();
        question.setCourse(course);
        questionJpaDao.saveAndFlush(question);
        for (QuestionOption option : questionOptions)
        {
            option.setQuestion(question);
        }
        optionJpaDao.save(questionOptions);
        questionJpaDao.saveAndFlush(question);
        return question;
    }

    @Override
    public Question findQuestion(Integer questionId)
    {
        Question question = questionJpaDao.findOne(questionId);
        return question;
    }

    @Override
    public List<QuestionOption> findQuestionOptions(Integer questionId)
    {
        Question question = questionJpaDao.findOne(questionId);
        List<QuestionOption> list = new ArrayList(question.getOptions());
        return list;
    }

    @Override
    public Question deleteQuestion(Integer questionId)
    {
        Question question = questionJpaDao.findOne(questionId);
        Set<QuestionOption> options = question.getOptions();
        for(QuestionOption option:options){
            optionJpaDao.delete(option);
        }
        questionJpaDao.delete(question);
        return question;
    }

    @Override
    public Question updateQuestion(Question question)
    {
        Set<QuestionOption> options = question.getOptions();
        for (QuestionOption option : options)
        {
            option.setQuestion(question);
        }
        optionJpaDao.save(options);
        question =questionJpaDao.saveAndFlush(question);
        return question;
    }
}
