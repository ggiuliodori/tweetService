package com.uala.tweet.controller;

import com.uala.tweet.model.api.TweetModelResponse;
import com.uala.tweet.model.entity.TweetModelEntity;
import com.uala.tweet.repository.TweetRepository;
import com.uala.tweet.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweet-service")
public class TweetController {

    private final TweetRepository tweetRepository;
    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetRepository tweetRepository, TweetService tweetService) {
        this.tweetRepository = tweetRepository;
        this.tweetService = tweetService;
    }

    @PostMapping("/tweet")
    public ResponseEntity<TweetModelResponse> createTweet(@RequestBody TweetModelEntity tweet) {
        try {
            TweetModelResponse savedTweet = tweetService.saveTweet(tweet);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTweet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/tweets/latest")
    public ResponseEntity<List<TweetModelResponse>> getLatestTweetsByUserIds(@RequestBody List<String> userIds) {
        try {
            return tweetService.getListTweetResponse(userIds);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
