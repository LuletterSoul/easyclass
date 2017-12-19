package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.VoteOption;
import edu.vero.easyclass.services.VoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 11:24 2017/12/19.
 * @since easyclass
 */

@RestController(value = "/vote_options")
public class VoteOptionController
{

    private VoteOptionService voteOptionService;

    @Autowired
    public void setVoteOptionService(VoteOptionService voteOptionService)
    {
        this.voteOptionService = voteOptionService;
    }

    @PutMapping
    public ResponseEntity<VoteOption> updateOption(@RequestBody VoteOption voteOption)
    {
        return new ResponseEntity<>(voteOptionService.updateOption(voteOption), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<VoteOption> deleteOption()
    {
        return null;
    }
}
