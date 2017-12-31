CREATE TABLE easy_class.question_option
(
    optionId int(11) PRIMARY KEY NOT NULL,
    content varchar(255),
    optionOrder int(11),
    questionId int(11),
    CONSTRAINT FK2jpltvrgtlud0919ftwdir85 FOREIGN KEY (questionId) REFERENCES question (questionId)
);
CREATE INDEX FK2jpltvrgtlud0919ftwdir85 ON easy_class.question_option (questionId);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (1, '绿轴', 1, 1);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (2, '青轴', 2, 1);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (6, '绿轴', 3, 4);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (7, '红轴', 2, 4);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (8, '黑轴', 1, 4);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (9, '425', 1, 5);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (10, '600', 2, 5);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (11, '白色的', 1, 6);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (12, '看情况', 2, 6);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (13, '教室', 1, 7);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (14, '图书馆', 2, 7);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (15, '周日', 1, 8);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (16, '周一', 2, 8);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (17, '四核八线程', 1, 9);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (18, '六核十二线程', 2, 9);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (19, '六核十二线程', 2, 10);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (20, '四核八线程', 1, 10);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (21, '四核八线程', 1, 11);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (22, '六核六线程', 2, 11);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (23, 'ddr4', 2, 12);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (24, 'ddr3', 1, 12);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (25, 'US', 2, 13);
INSERT INTO easy_class.question_option (optionId, content, optionOrder, questionId) VALUES (26, 'UK', 1, 13);