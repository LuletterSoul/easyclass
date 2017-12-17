package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/votes")
public class VoteController {

    private VoteService voteService;

    @Autowired
    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }

    @PutMapping(value = "/{voteId}")
    public ResponseEntity<Vote> closeVote(@PathVariable("voteId") String id){
        return null;
    }

}
