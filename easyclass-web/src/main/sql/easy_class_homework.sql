CREATE TABLE easy_class.homework
(
    homeworkId int(11) PRIMARY KEY NOT NULL,
    content varchar(255),
    deadline datetime,
    establishedTime datetime,
    fileName varchar(255),
    filePath varchar(255),
    size bigint(20),
    submitted bit(1) NOT NULL,
    title varchar(255),
    scheduleId int(11),
    CONSTRAINT FK9hnhh559r5sx4klsnswg7avio FOREIGN KEY (scheduleId) REFERENCES class_schedule (scheduleId)
);
CREATE INDEX FK9hnhh559r5sx4klsnswg7avio ON easy_class.homework (scheduleId);