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

//    @ApiOperation(value = "更新投票（未测试）")
//    @PutMapping
//    public ResponseEntity<Vote> updateVote(@RequestBody Vote vote)
//    {
//        return new ResponseEntity<>(voteService.updateVote(vote), HttpStatus.OK);
//    }

    @ApiOperation(value = "删除一个投票（测试通过）")
    @DeleteMapping(value = "/{voteId}")
    public ResponseEntity<Vote> deleteVote(@PathVariable("voteId") Integer voteId)
    {
        return new ResponseEntity<>(voteService.deleteVote(voteId), HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "创建投票（测试通过）")
    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote)
    {
        return new ResponseEntity<>(voteService.createVote(vote), HttpStatus.CREATED);
    }

//    @ApiOperation(value = "创建投可投票项(未测试 没啥用)")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "voteId", value = "投票编号", dataType = "int", paramType = "path", required = true)})
//    @PostMapping(value = "/{voteId}/vote_options")
//    public ResponseEntity<List<VoteOption>> createVoteOptions(@RequestBody List<VoteOption> voteOptions,
//                                                              @PathVariable("voteId") Integer voteId)
//    {
//        return new ResponseEntity<>(voteService.createVoteOptions(voteId, voteOptions),
//            HttpStatus.CREATED);
//    }

    @ApiOperation(value="根据id查找一次投票信息（测试通过）")
    @GetMapping(value = "/{voteId}")
    public ResponseEntity<Vote> findVote(@PathVariable("voteId") Integer voteId)
    {
        return new ResponseEntity<>(voteService.findVote(voteId), HttpStatus.OK);
    }

}
