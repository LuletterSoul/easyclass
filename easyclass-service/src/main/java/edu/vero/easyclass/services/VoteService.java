package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Vote;
import io.swagger.models.auth.In;


public interface VoteService
{
    Vote closeVote(Integer voteId);

    Vote deleteVote(Integer voteId);

    Vote createVote(Vote vote, Integer attendanceId);

    Vote findVote(Integer voteId);
}
