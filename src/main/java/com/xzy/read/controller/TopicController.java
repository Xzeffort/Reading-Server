package com.xzy.read.controller;

import com.xzy.read.VO.ResultVo;
import com.xzy.read.entity.Topic;
import com.xzy.read.entity.TopicArticle;
import com.xzy.read.service.TopicService;
import org.springframework.web.bind.annotation.*;

/**
 * @author XieZhongYi
 * 2020/04/01 16:24
 */
@RestController
@RequestMapping("/api")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    @GetMapping("/topic/{id}")
    public ResultVo topicInfo(@PathVariable Long id) {
        return topicService.getInfoById(id);
    }

    @PostMapping("/topic")
    public ResultVo createTopic(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

    @PutMapping("/topic")
    public ResultVo updateTopic(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

    @DeleteMapping("/topic")
    public ResultVo deleteTopic(@RequestBody Topic topic) {
        return topicService.delete(topic);
    }

    @GetMapping("/topic/search")
    public ResultVo searchTopics(Long articleId,String name) {
        return topicService.search(articleId, name);
    }

    @GetMapping("/topic/collect")
    public ResultVo getTopicCollections(Long topicId, @RequestParam(defaultValue = "1") int page) {
        return topicService.getAllArticles(topicId, page);
    }

    @PostMapping("/topic/collect")
    public ResultVo topicCollect(@RequestBody TopicArticle topicArticle) {
        return topicService.collect(topicArticle);
    }

    @DeleteMapping("/topic/collect")
    public ResultVo deleteTopicCollect(@RequestBody TopicArticle topicArticle) {
        return topicService.remove(topicArticle);
    }

}
