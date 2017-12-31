CREATE TABLE easy_class.question
(
    questionId int(11) PRIMARY KEY NOT NULL,
    answerOrder int(11),
    content varchar(255),
    courseId int(11),
    CONSTRAINT FK9sui8laudydw48v5hbxyrpfkv FOREIGN KEY (courseId) REFERENCES course (courseId)
);
CREATE INDEX FK9sui8laudydw48v5hbxyrpfkv ON easy_class.question (courseId);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (1, 1, 'G轴中最轻的轴体是？', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (4, 3, '以下G轴中最重的轴体', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (5, 1, '英语四六级通过的分数', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (6, 2, '天空的颜色', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (7, 2, '大学期末的时候人口最密集的地方是哪？', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (8, 2, '准确来说每周的第一天应该是周几', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (9, 2, 'R5 1600x的规格', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (10, 1, 'i7 7700k的规格', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (11, 2, 'i5 8400的规格', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (12, 2, '现在最新版本的内存条是', 1);
INSERT INTO easy_class.question (questionId, answerOrder, content, courseId) VALUES (13, 1, '英国的英文缩写是', 1);