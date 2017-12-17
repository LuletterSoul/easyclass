package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.QuestionOption;
import edu.vero.easyclass.repositories.OptionJpaDao;
import edu.vero.easyclass.repositories.QuestionJpaDao;
import edu.vero.easyclass.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService
{

    private QuestionJpaDao questionJpaDao;

    private OptionJpaDao optionJpaDao;

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
}
