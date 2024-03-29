package com.xzy.read.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.xzy.read.VO.ResultVo;
import com.xzy.read.entity.Followers;
import com.xzy.read.entity.Follows;
import com.xzy.read.entity.enums.FollowType;
import com.xzy.read.service.FollowService;
import org.springframework.web.bind.annotation.*;

/**
 * @author XieZhongYi
 * 2020/03/28 21:00
 */
@RestController
@RequestMapping("/api")
public class FollowController {

    private FollowService followersService;

    public FollowController(FollowService followersService) {
        this.followersService = followersService;
    }


    @PutMapping("/follow")
    public ResultVo follow(@RequestBody Followers followers) {
        return followersService.follow(followers);
    }

//    @GetMapping("/follow/followers")
//    public Long followers(Long id) {
//        return followersService.countfollowers(id);
//    }
//
//    @GetMapping("/follow/fans")
//    public Long fans(Long id) {
//        return followersService.countFans(id);
//    }

    @PutMapping("/follow/topic")
    public ResultVo followTopic(@RequestBody Follows follows) {
        return followersService.follow(follows, FollowType.TOPIC);
    }

    @GetMapping("/follow/topic/followers")
    public ResultVo followers(Long typeId,@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "8") int size) {
        return followersService.followerByType(page, size,typeId,FollowType.TOPIC);
    }

    @PutMapping("/follow/notebook")
    public ResultVo followNb(@RequestBody Follows follows) {
        return followersService.follow(follows, FollowType.NOTEBOOK);
    }

    @GetMapping("/follow/timeline")
    public ResultVo timeline(Long userId,@RequestParam(defaultValue = "1") int page) {
        return followersService.findArticlesByTimeline(userId, page);
    }


    @GetMapping("/follow/users")
    public ResultVo users(Long userId) {
        return followersService.findAllFollowersByUserId(userId);
    }

    @GetMapping("/follow/all")
    public ResultVo all(Long userId,@RequestParam(defaultValue = "all") String type) {
        return followersService.findAllFollowsByUserId(userId, type);
    }

}
