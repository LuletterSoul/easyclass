CREATE TABLE easy_class.teacher_arrangement
(
    arrangementId int(11) PRIMARY KEY NOT NULL,
    place varchar(255),
    courseId int(11),
    userId int(11),
    CONSTRAINT FKf3fv8aqs68130jfxrdadjh91m FOREIGN KEY (courseId) REFERENCES course (courseId),
    CONSTRAINT FKta3aeyhh63f131irbi0csxcpi FOREIGN KEY (userId) REFERENCES user (userId)
);
CREATE INDEX FKf3fv8aqs68130jfxrdadjh91m ON easy_class.teacher_arrangement (courseId);
CREATE INDEX FKta3aeyhh63f131irbi0csxcpi ON easy_class.teacher_arrangement (userId);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (1, '一工101', 1, 1);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (2, '一工101', 2, 2);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (3, '一工102', 2, 3);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (4, '一工103', 3, 3);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (5, '一工104', 4, 4);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (6, '一工105', 5, 5);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (7, '一工106', 6, 6);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (8, '一工107', 6, 7);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (9, '四工A101', 1, 1);
INSERT INTO easy_class.teacher_arrangement (arrangementId, place, courseId, userId) VALUES (10, '四工A102', 2, 2);