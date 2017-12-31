CREATE TABLE easy_class.class_schedule
(
    scheduleId int(11) PRIMARY KEY NOT NULL,
    commentId int(11),
    userId int(11),
    arrangeId int(11),
    CONSTRAINT FKtcj13gj61l4po6xmxr7vj2n23 FOREIGN KEY (userId) REFERENCES user (userId),
    CONSTRAINT FKm1tk8b0cxgxdryam2hy9vybl8 FOREIGN KEY (arrangeId) REFERENCES teacher_arrangement (arrangementId)
);
CREATE INDEX FK4w4f90q4kfumoi96q312d8bhe ON easy_class.class_schedule (commentId);
CREATE INDEX FKtcj13gj61l4po6xmxr7vj2n23 ON easy_class.class_schedule (userId);
CREATE INDEX FKm1tk8b0cxgxdryam2hy9vybl8 ON easy_class.class_schedule (arrangeId);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (1, 1, 10, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (2, 2, 11, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (3, 26, 20, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (4, 4, 12, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (5, 5, 13, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (6, 6, 14, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (7, 7, 15, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (8, 8, 16, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (9, 9, 17, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (10, 10, 18, 1);
INSERT INTO easy_class.class_schedule (scheduleId, commentId, userId, arrangeId) VALUES (11, 11, 19, 1);