package com.uala.tweet.controller;

import com.uala.tweet.model.TweetModel;
import com.uala.tweet.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TweetController {

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @PostMapping("/api/tweets")
    public ResponseEntity<String> createTweet(@RequestBody TweetModel tweet) {
        try {
            TweetModel savedTweet = tweetRepository.save(tweet);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTweet.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el tweet: " + e.getMessage());
        }
    }

    @PostMapping("/tweets/latest")
    public ResponseEntity<List<TweetModel>> getLatestTweetsByUserIds(@RequestBody List<String> userIds) {
        try {
            List<TweetModel> latestTweets = new ArrayList<>();
            for (String userId : userIds) {
                Optional<TweetModel> latestTweetOptional = tweetRepository.findFirstByUserIdOrderByTimestampDesc(userId);
                latestTweetOptional.ifPresent(latestTweets::add);
            }
            return ResponseEntity.ok(latestTweets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
