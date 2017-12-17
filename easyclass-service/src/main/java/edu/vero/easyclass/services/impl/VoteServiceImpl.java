package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.repositories.VoteJpaDao;
import edu.vero.easyclass.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:43 2017/12/16.
 * @since easyclass
 */

@Service
public class VoteServiceImpl implements VoteService
{
    private VoteJpaDao voteJpaDao;

    @Autowired
    public void setVoteJpaDao(VoteJpaDao voteJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
    }

    @Override
    public Vote closeVote(Integer voteId)
    {
        Vote vote = voteJpaDao.findOne(voteId);
        vote.setClosed(true);
        voteJpaDao.save(vote);
        return vote;
    }
}
