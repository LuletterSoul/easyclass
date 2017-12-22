package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.VoteOption;
import edu.vero.easyclass.services.VoteOptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 11:24 2017/12/19.
 * @since easyclass
 */
@Api(description = "投票更新业务")
@RestController
@RequestMapping(value = "/vote_options")
public class VoteOptionController
{

    private VoteOptionService voteOptionService;

    @Autowired
    public void setVoteOptionService(VoteOptionService voteOptionService)
    {
        this.voteOptionService = voteOptionService;
    }

    @ApiOperation(value = "可更新投票项的被选次数")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "voteOption", value = "投票项的模型数据", dataType = "VoteOption", paramType = "body", required = true)})
    @PutMapping
    public ResponseEntity<VoteOption> updateOption(@RequestBody VoteOption voteOption)
    {
        return new ResponseEntity<>(voteOptionService.updateOption(voteOption), HttpStatus.OK);
    }

    @ApiOperation(value = "删除投票")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "voteId", value = "投票项的编号", dataType = "int", paramType = "path", required = true)})
    @DeleteMapping(value = "/{voteId}")
    public ResponseEntity<VoteOption> deleteOption(@PathVariable("voteId") Integer voteId)
    {
        return null;
    }
}
