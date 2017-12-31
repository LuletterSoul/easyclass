CREATE TABLE easy_class.vote_option
(
    voteOptionId int(11) PRIMARY KEY NOT NULL,
    optionContent varchar(255),
    optionCount int(11),
    voteId int(11),
    CONSTRAINT FKt0t23mnf3nrha702k98q8bahr FOREIGN KEY (voteId) REFERENCES vote (voteId)
);
CREATE INDEX FKt0t23mnf3nrha702k98q8bahr ON easy_class.vote_option (voteId);
INSERT INTO easy_class.vote_option (voteOptionId, optionContent, optionCount, voteId) VALUES (1, '不懂', 0, 1);
INSERT INTO easy_class.vote_option (voteOptionId, optionContent, optionCount, voteId) VALUES (2, '懂', 0, 1);
INSERT INTO easy_class.vote_option (voteOptionId, optionContent, optionCount, voteId) VALUES (3, '不需要', 0, 2);
INSERT INTO easy_class.vote_option (voteOptionId, optionContent, optionCount, voteId) VALUES (4, '需要', 0, 2);
INSERT INTO easy_class.vote_option (voteOptionId, optionContent, optionCount, voteId) VALUES (5, '考察', 0, 3);
INSERT INTO easy_class.vote_option (voteOptionId, optionContent, optionCount, voteId) VALUES (6, '考试', 0, 3);