CREATE TABLE easy_class.attendance
(
    attendanceId int(11) PRIMARY KEY NOT NULL,
    attend bit(1) NOT NULL,
    closed bit(1) NOT NULL,
    closedTime datetime,
    deadline datetime,
    establishedTime datetime,
    arrangeId int(11),
    codeId int(11),
    CONSTRAINT FKrb4j77uyobby5ujoohjvst45l FOREIGN KEY (arrangeId) REFERENCES teacher_arrangement (arrangementId),
    CONSTRAINT FKh8c82ntbfw10n8xv332frlmkx FOREIGN KEY (codeId) REFERENCES q_rcode (codeId)
);
CREATE INDEX FKrb4j77uyobby5ujoohjvst45l ON easy_class.attendance (arrangeId);
CREATE INDEX FKh8c82ntbfw10n8xv332frlmkx ON easy_class.attendance (codeId);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (1, true, false, null, '2018-01-01 15:20:36', '2017-12-30 16:20:15', 1, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (2, true, false, null, '2018-01-01 16:20:52', '2017-12-30 16:20:18', 2, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (3, true, false, null, '2018-01-01 16:21:01', '2017-12-30 16:20:20', 3, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (4, true, false, null, '2018-01-01 16:21:05', '2017-12-30 16:20:24', 4, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (5, true, false, null, '2018-01-01 16:21:10', '2017-12-30 16:20:26', 5, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (6, true, false, null, '2018-01-01 16:21:15', '2017-12-30 16:20:29', 6, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (7, true, false, '2017-12-30 16:23:32', '2018-01-01 16:21:21', '2017-12-30 16:20:32', 7, null);
INSERT INTO easy_class.attendance (attendanceId, attend, closed, closedTime, deadline, establishedTime, arrangeId, codeId) VALUES (8, true, false, '2017-12-30 16:23:27', '2017-12-31 16:23:01', '2017-12-30 16:22:55', 8, null);