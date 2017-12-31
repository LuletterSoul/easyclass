CREATE TABLE easy_class.sign_record
(
    signId int(11) PRIMARY KEY NOT NULL,
    signTime datetime,
    attendanceId int(11),
    scheduleId int(11),
    CONSTRAINT FKscbqdm82x1s6a8u9ksrpqk49g FOREIGN KEY (attendanceId) REFERENCES attendance (attendanceId),
    CONSTRAINT FKf81ucmw0w5acwmb7g5lgi9ulm FOREIGN KEY (scheduleId) REFERENCES class_schedule (scheduleId)
);
CREATE INDEX FKscbqdm82x1s6a8u9ksrpqk49g ON easy_class.sign_record (attendanceId);
CREATE INDEX FKf81ucmw0w5acwmb7g5lgi9ulm ON easy_class.sign_record (scheduleId);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (1, '2017-12-30 07:54:00', 1, 1);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (2, '2017-12-30 07:54:00', 1, 2);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (4, '2017-12-30 07:54:00', 1, 4);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (5, '2017-12-30 07:54:00', 1, 5);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (6, '2017-12-30 07:54:00', 1, 6);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (7, '2017-12-30 07:54:00', 1, 7);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (8, '2017-12-30 07:54:00', 1, 8);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (9, '2017-12-30 07:54:00', 1, 9);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (10, '2017-12-30 07:54:00', 1, 10);
INSERT INTO easy_class.sign_record (signId, signTime, attendanceId, scheduleId) VALUES (11, '2017-12-30 07:54:00', 1, 11);