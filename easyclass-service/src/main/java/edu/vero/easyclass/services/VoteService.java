package edu.vero.easyclass.services;


import java.util.List;

import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.domain.VoteOption;


public interface VoteService
{
    Vote updateVote(Vote vote);

    Vote deleteVote(Integer voteId);

    Vote findVote(Integer voteId);

    Vote createVote(Vote vote);

    List<VoteOption> createVoteOptions(Integer voteId, List<VoteOption> voteOptions);
}
