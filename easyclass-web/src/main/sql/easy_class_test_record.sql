CREATE TABLE easy_class.test_record
(
    recordId int(11) PRIMARY KEY NOT NULL,
    answer varchar(255),
    score float NOT NULL,
    scheduleId int(11),
    testId int(11),
    CONSTRAINT FKn6mjtcr9kikm5m7q0a98dm2ok FOREIGN KEY (scheduleId) REFERENCES class_schedule (scheduleId),
    CONSTRAINT FK3qe737598d75efnto8a7s5eqf FOREIGN KEY (testId) REFERENCES online_class_test (testId)
);
CREATE INDEX FKn6mjtcr9kikm5m7q0a98dm2ok ON easy_class.test_record (scheduleId);
CREATE INDEX FK3qe737598d75efnto8a7s5eqf ON easy_class.test_record (testId);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (1, '1,1,2,1,2', 80, 1, 1);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (2, '1,1,2,1,2', 80, 2, 1);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (3, '1,1,2,2,2', 100, 4, 1);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (4, '2,2,1,2,2', 100, 6, 1);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (5, '2,2,1,1,2', 100, 5, 1);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (6, '2,2,1,1,2', 100, 3, 1);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (7, '2,2,1,1,2', 100, 1, 2);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (8, '2,2,1,1,2', 100, 2, 2);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (9, '2,2,1,1,2', 100, 3, 2);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (10, '2,2,1,1,2', 100, 4, 2);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (11, '2,2,1,1,2', 100, 5, 2);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (12, '2,2,1,1,2', 100, 1, 3);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (13, '2,2,1,1,2', 100, 2, 3);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (14, '2,2,1,1,2', 100, 3, 3);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (15, '2,2,1,1,2', 100, 4, 3);
INSERT INTO easy_class.test_record (recordId, answer, score, scheduleId, testId) VALUES (16, '2,2,1,1,2', 100, 5, 3);