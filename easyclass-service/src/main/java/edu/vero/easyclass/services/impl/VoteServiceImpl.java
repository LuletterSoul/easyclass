package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.domain.VoteOption;
import edu.vero.easyclass.repositories.AttendanceJpaDao;
import edu.vero.easyclass.repositories.VoteJpaDao;
import edu.vero.easyclass.repositories.VoteOptionJpaDao;
import edu.vero.easyclass.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

//    @Autowired
//    public void setAttendanceJpaDao(AttendanceJpaDao attendanceJpaDao)
//    {
//        this.attendanceJpaDao = attendanceJpaDao;
//    }

    @Autowired
    public void setVoteJpaDao(VoteJpaDao voteJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
    }

//    @Override
//    public Vote updateVote(Integer voteId)
//    {
//        Vote vote = voteJpaDao.findOne(voteId);
//        vote.setClosed(true);
//        voteJpaDao.save(vote);
//        return vote;
//    }

    @Override
    public Vote updateVote(Vote vote) {
        return voteJpaDao.save(vote);
    }

    @Override
    public Vote deleteVote(Integer voteId)
    {
        Vote vote = voteJpaDao.findOne(voteId);
        voteJpaDao.delete(vote);
        return vote;
    }

    @Override
    public Vote createVote(Vote vote)
    {
        return voteJpaDao.save(vote);
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
