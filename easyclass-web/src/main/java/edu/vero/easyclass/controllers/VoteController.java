package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.services.VoteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(description = "在线投票业务")
@RestController
@RequestMapping(value = "/votes")
public class VoteController
{

    private VoteService voteService;

    @Autowired
    public void setVoteService(VoteService voteService)
    {
        this.voteService = voteService;
    }

    @PutMapping(value = "/{voteId}")
    public ResponseEntity<Vote> closeVote(@PathVariable("voteId") Integer id)
    {
        return null;
    }

}
