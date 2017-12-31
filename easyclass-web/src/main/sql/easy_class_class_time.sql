CREATE TABLE easy_class.class_time
(
    timeId int(11) PRIMARY KEY NOT NULL,
    classOrder varchar(255),
    term varchar(255),
    week varchar(255),
    weekday varchar(255),
    arrangementId int(11),
    CONSTRAINT FK9cepgyf9000o43oep01h1qqxk FOREIGN KEY (arrangementId) REFERENCES teacher_arrangement (arrangementId)
);
CREATE INDEX FK9cepgyf9000o43oep01h1qqxk ON easy_class.class_time (arrangementId);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (1, '1', '2018', '1', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (2, '1', '2018', '2', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (3, '1', '2018', '3', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (4, '1', '2018', '4', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (5, '1', '2018', '5', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (6, '1', '2018', '6', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (7, '1', '2018', '7', '1', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (8, '3', '2018', '1', '3', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (9, '3', '2018', '2', '3', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (10, '3', '2018', '3', '3', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (11, '3', '2018', '4', '3', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (12, '3', '2018', '6', '3', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (13, '3', '2018', '7', '3', 1);
INSERT INTO easy_class.class_time (timeId, classOrder, term, week, weekday, arrangementId) VALUES (14, '3', '2018', '5', '3', 1);