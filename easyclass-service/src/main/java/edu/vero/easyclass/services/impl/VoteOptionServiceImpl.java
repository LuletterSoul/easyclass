package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.VoteOption;
import edu.vero.easyclass.repositories.VoteJpaDao;
import edu.vero.easyclass.repositories.VoteOptionJpaDao;
import edu.vero.easyclass.services.VoteOptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 11:25 2017/12/19.
 * @since easyclass
 */

@Service
public class VoteOptionServiceImpl implements VoteOptionService
{

    private VoteOptionJpaDao voteOptionJpaDao;

    @Autowired
    public void setVoteOptionJpaDao(VoteOptionJpaDao voteOptionJpaDao)
    {
        this.voteOptionJpaDao = voteOptionJpaDao;
    }

    public VoteOption updateOption(VoteOption voteOption)
    {
        VoteOption currentOption = voteOptionJpaDao.findOne(voteOption.getVoteOptionId());
        Integer count = currentOption.getOptionCount();
        currentOption.setOptionCount(count + 1);
        return voteOptionJpaDao.saveAndFlush(currentOption);
    }
}
