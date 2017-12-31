CREATE TABLE easy_class.course
(
    courseId int(11) PRIMARY KEY NOT NULL,
    courseName varchar(255),
    credit double NOT NULL,
    type varchar(255)
);
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (1, '常识', 6, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (2, '大学物理', 3, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (3, '高等数学', 6, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (4, '诗词鉴赏', 2, '选修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (5, '社交礼仪', 1.5, '选修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (6, '定向越野', 1.5, '选修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (7, '多彩的生物世界', 1.5, '选修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (8, '工程制图', 2, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (9, '模拟电子线路', 3, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (10, '马克思主义基本原理', 3, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (11, '程序设计基础1', 4, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (12, '程序设计基础2', 2, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (13, 'flash', 2, '通识选修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (14, 'C++程序设计', 2, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (15, 'java程序设计', 2, '必修课');
INSERT INTO easy_class.course (courseId, courseName, credit, type) VALUES (16, 'j2ee程序设计', 2, '必修课');