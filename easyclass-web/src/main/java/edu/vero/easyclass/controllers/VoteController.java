package edu.vero.easyclass.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.domain.VoteOption;
import edu.vero.easyclass.services.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


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

    @PutMapping
    public ResponseEntity<Vote> updateVote(@RequestBody Vote vote)
    {
        return new ResponseEntity<>(voteService.updateVote(vote), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{voteId}")
    public ResponseEntity<Vote> deleteVote(@PathVariable("voteId") Integer voteId)
    {
        return new ResponseEntity<>(voteService.deleteVote(voteId), HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote)
    {
        return new ResponseEntity<>(voteService.createVote(vote), HttpStatus.CREATED);
    }

    @ApiOperation(value = "创建投可投票项")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "voteId", value = "投票编号", dataType = "int", paramType = "path", required = true)})
    @PostMapping(value = "/{voteId}/vote_options")
    public ResponseEntity<List<VoteOption>> createVoteOptions(@RequestBody List<VoteOption> voteOptions,
                                                              @PathVariable("voteId") Integer voteId)
    {
        return new ResponseEntity<>(voteService.createVoteOptions(voteId, voteOptions),
            HttpStatus.CREATED);
    }

    @GetMapping(value = "/{voteId}")
    public ResponseEntity<Vote> findVote(@PathVariable("voteId") Integer voteId)
    {
        return new ResponseEntity<>(voteService.findVote(voteId), HttpStatus.OK);
    }

}
