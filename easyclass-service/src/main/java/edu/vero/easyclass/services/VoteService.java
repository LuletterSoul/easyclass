package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.domain.VoteOption;
import io.swagger.models.auth.In;

import java.util.List;


public interface VoteService
{
    Vote updateVote(Vote vote);

    Vote deleteVote(Integer voteId);

    Vote createVote(Vote vote);

    List<VoteOption> createVoteOptions(Integer voteId,List<VoteOption> voteOptions);
}
