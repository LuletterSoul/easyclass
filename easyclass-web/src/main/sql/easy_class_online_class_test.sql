CREATE TABLE easy_class.online_class_test
(
    testId int(11) PRIMARY KEY NOT NULL,
    deadline datetime,
    establishedTime datetime,
    arrangeId int(11),
    CONSTRAINT FK4707qj9xc6gxdgusnn715odup FOREIGN KEY (arrangeId) REFERENCES teacher_arrangement (arrangementId)
);
CREATE INDEX FK4707qj9xc6gxdgusnn715odup ON easy_class.online_class_test (arrangeId);
INSERT INTO easy_class.online_class_test (testId, deadline, establishedTime, arrangeId) VALUES (1, '2018-01-01 15:47:09', '2017-12-30 15:47:22', 1);
INSERT INTO easy_class.online_class_test (testId, deadline, establishedTime, arrangeId) VALUES (2, '2017-12-31 20:09:22', '2017-12-31 18:08:45', 1);
INSERT INTO easy_class.online_class_test (testId, deadline, establishedTime, arrangeId) VALUES (3, '2018-01-02 21:09:30', '2018-01-02 18:08:55', 1);