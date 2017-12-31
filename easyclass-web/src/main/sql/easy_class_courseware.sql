CREATE TABLE easy_class.courseware
(
    coursewareId int(11) PRIMARY KEY NOT NULL,
    fileName varchar(255),
    filePath varchar(255),
    size int(11) NOT NULL,
    title varchar(255),
    arrangementId int(11),
    CONSTRAINT FKklw2gj1kkigxtqwwqxv3wipsb FOREIGN KEY (arrangementId) REFERENCES teacher_arrangement (arrangementId)
);
CREATE INDEX FKklw2gj1kkigxtqwwqxv3wipsb ON easy_class.courseware (arrangementId);