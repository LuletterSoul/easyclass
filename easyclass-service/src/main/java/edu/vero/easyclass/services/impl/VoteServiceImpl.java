package edu.vero.easyclass.services.impl;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.domain.VoteOption;
import edu.vero.easyclass.repositories.VoteJpaDao;
import edu.vero.easyclass.repositories.VoteOptionJpaDao;
import edu.vero.easyclass.services.VoteService;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:43 2017/12/16.
 * @since easyclass
 */

@Service
public class VoteServiceImpl implements VoteService
{
    private VoteJpaDao voteJpaDao;

    private VoteOptionJpaDao voteOptionJpaDao;

    @Autowired
    public void setVoteOptionJpaDao(VoteOptionJpaDao voteOptionJpaDao)
    {
        this.voteOptionJpaDao = voteOptionJpaDao;
    }

    // @Autowired
    // public void setAttendanceJpaDao(AttendanceJpaDao attendanceJpaDao)
    // {
    // this.attendanceJpaDao = attendanceJpaDao;
    // }

    @Autowired
    public void setVoteJpaDao(VoteJpaDao voteJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
    }

    // @Override
    // public Vote updateVote(Integer voteId)
    // {
    // Vote vote = voteJpaDao.findOne(voteId);
    // vote.setClosed(true);
    // voteJpaDao.save(vote);
    // return vote;
    // }

    @Override
    public Vote updateVote(Vote vote)
    {
        return voteJpaDao.save(vote);
    }

    @Override
    public Vote deleteVote(Integer voteId)
    {
        Vote vote = voteJpaDao.findOne(voteId);
        Set<VoteOption> options = vote.getOptions();
        for(VoteOption option:options){
            voteOptionJpaDao.delete(option);
        }
        voteJpaDao.delete(vote);
        return vote;
    }

    @Override
    public Vote createVote(Vote vote)
    {
        voteJpaDao.save(vote);
        Set<VoteOption> voteOptions = vote.getOptions();
        for (VoteOption option :
                voteOptions) {
            option.setVote(vote);
        }

        voteOptionJpaDao.save(vote.getOptions());
        return vote;
    }

    @Override
    public Vote findVote(Integer voteId)
    {
        return voteJpaDao.findOne(voteId);
    }

    @Override
    public List<VoteOption> createVoteOptions(Integer voteId, List<VoteOption> voteOptions)
    {
        Vote vote = voteJpaDao.findOne(voteId);

        for (VoteOption voteOption : voteOptions)
        {
            voteOption.setVote(vote);

        }
        voteOptionJpaDao.save(voteOptions);
        return voteOptions;
    }

    //
    // @Override
    // public Vote createVote(Vote vote, Integer attendanceId) {
    // vote.setAttendance(attendanceJpaDao.findOne(attendanceId));
    // return voteJpaDao.saveAndFlush(vote);
    // }
}
