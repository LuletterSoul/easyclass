package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.QuestionOption;
import edu.vero.easyclass.domain.Question;

import java.util.List;

public interface QuestionService{

    public List<Question> findAllQuestions();
    public Question createQuestion(Question question);
    public Question findQuestion(Integer questionId);
    public List<QuestionOption> findQuestionOptions(Integer questionId);
}