CREATE TABLE easy_class.user
(
    serviceLevel varchar(31) NOT NULL,
    userId int(11) PRIMARY KEY NOT NULL,
    password varchar(255),
    username varchar(255),
    teacherGender varchar(255),
    teacherId varchar(255),
    teacherName varchar(255),
    grade varchar(255),
    majorIn varchar(255),
    studentGender varchar(255),
    studentId varchar(255),
    studentName varchar(255),
    depId int(11),
    CONSTRAINT FK740kgr69n4541atao2lwbah4g FOREIGN KEY (depId) REFERENCES department (depId)
);
CREATE UNIQUE INDEX UK_sb8bbouer5wak8vyiiy4pf2bx ON easy_class.user (username);
CREATE UNIQUE INDEX UK_cmubifvnahuydie5hkyft79fp ON easy_class.user (teacherId);
CREATE UNIQUE INDEX UK_5m7f6sv2emosxheqxkcadascf ON easy_class.user (studentId);
CREATE INDEX FK740kgr69n4541atao2lwbah4g ON easy_class.user (depId);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 1, '123', '123456老师', '男', '123456', '赵刚', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 2, '123', '123457老师', '女', '123457', '李艳', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 3, '123', '123455老师', '女', '123455', '王晓玲', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 4, '123', '123454老师', '男', '123454', '刘少君', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 5, '123', '123453老师', '男', '123453', '孙振', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 6, '123', '123452老师', '男', '123452', '张罗森', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 7, '123', '123451老师', '男', '123451', '张嘟嘟', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 8, '123', '123458老师', '女', '123458', '罗森', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Teacher', 9, '123', '123459老师', '女', '123459', '丁丹', null, null, null, null, null, null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 10, '123', '0000', null, null, null, '2015', '软件工程', '男', '935100000000', '小明', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 11, '123', '0001', null, null, null, '2015', '软件工程', '男', '935100000001', '小卡', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 12, '123', '0002', null, null, null, '2015', '软件工程', '男', '935100000002', '小芳', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 13, '123', '0003', null, null, null, '2015', '软件工程', '男', '935100000003', '小刘', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 14, '123', '0004', null, null, null, '2015', '软件工程', '男', '935100000004', '小张', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 15, '123', '0005', null, null, null, '2015', '软件工程', '男', '935100000005', '萌萌', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 16, '123', '0006', null, null, null, '2015', '软件工程', '男', '935100000006', '小祥', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 17, '123', '0007', null, null, null, '2015', '软件工程', '男', '935100000007', '小远', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 18, '123', '0008', null, null, null, '2015', '软件工程', '男', '935100000008', '小欧', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 19, '123', '0009', null, null, null, '2015', '软件工程', '男', '935100000009', '小光', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 20, '123', '0010', null, null, null, '2015', '软件工程', '男', '935100000010', '小帆', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 21, '123', '0011', null, null, null, '2015', '软件工程', '男', '935100000011', '小德', null);
INSERT INTO easy_class.user (serviceLevel, userId, password, username, teacherGender, teacherId, teacherName, grade, majorIn, studentGender, studentId, studentName, depId) VALUES ('Student', 22, '123', '0012', null, null, null, '2015', '软件工程', '男', '935100000012', '小王', null);