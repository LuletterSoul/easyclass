package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "vote_option")
public class VoteOption
{
    private int voteOptionId;

    private String optionContent;

    private Integer optionCount;

    @JsonIgnore
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
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
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
