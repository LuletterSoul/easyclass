CREATE TABLE easy_class.notice
(
    noticeId int(11) PRIMARY KEY NOT NULL,
    content varchar(255),
    establishedTime datetime,
    title varchar(255),
    arrangeId int(11),
    CONSTRAINT FKq07fj1wri2w96bjhovpd76kyp FOREIGN KEY (arrangeId) REFERENCES teacher_arrangement (arrangementId)
);
CREATE INDEX FKq07fj1wri2w96bjhovpd76kyp ON easy_class.notice (arrangeId);
INSERT INTO easy_class.notice (noticeId, content, establishedTime, title, arrangeId) VALUES (1, '第21周考试', '2017-12-30 16:24:49', '考试安排', 1);
INSERT INTO easy_class.notice (noticeId, content, establishedTime, title, arrangeId) VALUES (2, '第3周交第一次实验报告', '2017-12-30 16:28:18', '第1次实验通知', 1);
INSERT INTO easy_class.notice (noticeId, content, establishedTime, title, arrangeId) VALUES (3, '第5周交第2次实验报告', '2017-12-30 16:28:37', '第2次实验通知', 1);
INSERT INTO easy_class.notice (noticeId, content, establishedTime, title, arrangeId) VALUES (4, '第7周交第3次实验报告', '2017-12-30 16:28:46', '第3次实验通知', 1);
INSERT INTO easy_class.notice (noticeId, content, establishedTime, title, arrangeId) VALUES (5, '第9周交第4次实验报告', '2017-12-30 16:28:56', '第4次实验通知', 1);
INSERT INTO easy_class.notice (noticeId, content, establishedTime, title, arrangeId) VALUES (6, '第10周交第5次实验报告', '2017-12-30 16:29:05', '第5次实验通知', 1);