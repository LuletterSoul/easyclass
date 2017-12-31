CREATE TABLE easy_class.test_question
(
    testId int(11) NOT NULL,
    questionId int(11) NOT NULL,
    CONSTRAINT FK7o6i671bgwvpxnkjdjbd8mvs9 FOREIGN KEY (testId) REFERENCES online_class_test (testId),
    CONSTRAINT FKpg6xsbl52lp54y9vl23o0i65o FOREIGN KEY (questionId) REFERENCES question (questionId)
);
CREATE INDEX FK7o6i671bgwvpxnkjdjbd8mvs9 ON easy_class.test_question (testId);
CREATE INDEX FKpg6xsbl52lp54y9vl23o0i65o ON easy_class.test_question (questionId);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (1, 4);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (1, 1);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (1, 5);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (1, 6);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (1, 7);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (2, 6);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (2, 7);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (2, 8);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (2, 9);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (2, 10);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (3, 7);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (3, 8);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (3, 6);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (3, 11);
INSERT INTO easy_class.test_question (testId, questionId) VALUES (3, 10);