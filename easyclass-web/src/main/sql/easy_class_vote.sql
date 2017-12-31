CREATE TABLE easy_class.vote
(
    voteId int(11) PRIMARY KEY NOT NULL,
    closed bit(1) NOT NULL,
    deadline datetime,
    establishedTime datetime,
    voteContent varchar(255),
    attendanceId int(11),
    CONSTRAINT FKgmrafi0wpj25jqxphpfu3aku1 FOREIGN KEY (attendanceId) REFERENCES attendance (attendanceId)
);
CREATE INDEX FKgmrafi0wpj25jqxphpfu3aku1 ON easy_class.vote (attendanceId);
INSERT INTO easy_class.vote (voteId, closed, deadline, establishedTime, voteContent, attendanceId) VALUES (1, false, null, '2017-12-30 17:38:52', '这里懂了吗', 1);
INSERT INTO easy_class.vote (voteId, closed, deadline, establishedTime, voteContent, attendanceId) VALUES (2, false, null, '2017-12-30 17:39:46', '需要再讲一遍这部分吗？', 1);
INSERT INTO easy_class.vote (voteId, closed, deadline, establishedTime, voteContent, attendanceId) VALUES (3, false, null, '2017-12-30 17:49:26', '希望本门课程考试还是考察？', 1);