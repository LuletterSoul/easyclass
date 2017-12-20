package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "vote_option")
public class VoteOption
{
    private int voteOptionId;

    private String optionContent;

    private Integer optionCount;

    private Vote vote;

    @ManyToOne
    @JoinColumn(name = "voteId")
    public Vote getVote()
    {
        return vote;
    }

    public void setVote(Vote vote)
    {
        this.vote = vote;
    }

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getVoteOptionId()
    {
        return voteOptionId;
    }

    public void setVoteOptionId(int voteOptionId)
    {
        this.voteOptionId = voteOptionId;
    }

    public String getOptionContent()
    {
        return optionContent;
    }

    public void setOptionContent(String optionContent)
    {
        this.optionContent = optionContent;
    }

    public Integer getOptionCount()
    {
        return optionCount;
    }

    public void setOptionCount(Integer optionCount)
    {
        this.optionCount = optionCount;
    }
}
