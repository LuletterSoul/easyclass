CREATE TABLE easy_class.teaching_comment
(
    commentLevel varchar(31) NOT NULL,
    commentId int(11) PRIMARY KEY NOT NULL,
    score float NOT NULL,
    arrangementId int(11),
    scheduleId int(11),
    timeId int(11),
    CONSTRAINT FKgg3yio106ka3go9tdgx0mmxrx FOREIGN KEY (arrangementId) REFERENCES teacher_arrangement (arrangementId),
    CONSTRAINT FK4donkkbnsxflccqpfxiatipd3 FOREIGN KEY (scheduleId) REFERENCES class_schedule (scheduleId),
    CONSTRAINT FKkmol10c2qxxlkomhy6yrkgcdh FOREIGN KEY (timeId) REFERENCES class_time (timeId)
);
CREATE INDEX FKgg3yio106ka3go9tdgx0mmxrx ON easy_class.teaching_comment (arrangementId);
CREATE INDEX FK4donkkbnsxflccqpfxiatipd3 ON easy_class.teaching_comment (scheduleId);
CREATE INDEX FKkmol10c2qxxlkomhy6yrkgcdh ON easy_class.teaching_comment (timeId);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 1, 100, 1, 1, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 2, 99, 1, 2, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 4, 98, 1, 4, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 5, 100, 1, 6, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 6, 95, 1, 6, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 7, 95, 1, 7, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 8, 95, 1, 8, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 9, 95, 1, 9, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 10, 95, 1, 10, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 11, 95, 1, 11, null);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 12, 100, null, 1, 1);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 13, 100, null, 1, 2);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 14, 100, null, 1, 3);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 15, 100, null, 1, 4);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 16, 100, null, 1, 5);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 17, 100, null, 1, 6);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 18, 100, null, 1, 7);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 19, 100, null, 1, 8);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 20, 100, null, 1, 9);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 21, 100, null, 1, 10);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 22, 100, null, 1, 11);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 23, 100, null, 1, 12);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 24, 90, null, 1, 13);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Class', 25, 99, null, 1, 14);
INSERT INTO easy_class.teaching_comment (commentLevel, commentId, score, arrangementId, scheduleId, timeId) VALUES ('Course', 26, 95, 1, 3, null);