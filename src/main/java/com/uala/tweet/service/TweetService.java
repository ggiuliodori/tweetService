package com.uala.tweet.service;

import com.uala.tweet.parser.TweetParser;
import com.uala.tweet.model.api.TweetModelResponse;
import com.uala.tweet.model.entity.TweetModelEntity;
import com.uala.tweet.repository.TweetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;
    private final TweetParser tweetParser;

    public TweetService(TweetRepository tweetRepository, TweetParser tweetParser) {
        this.tweetRepository = tweetRepository;
        this.tweetParser = tweetParser;
    }

    public TweetModelResponse saveTweet(TweetModelEntity tweet) {
        return tweetParser.tweetEntityToTweetApiModel(tweetRepository.save(tweet));
    }

    public ResponseEntity<List<TweetModelResponse>> getListTweetResponse(List<String> userIds) {
        List<TweetModelEntity> latestTweets = new ArrayList<>();
        for (String userId : userIds) {
            Optional<TweetModelEntity> latestTweetOptional = tweetRepository.findFirstByUserIdOrderByTimestampDesc(userId);
            latestTweetOptional.ifPresent(latestTweets::add);
        }
        List<TweetModelResponse> latestTweetsResponse = latestTweets.stream().map(tweetParser::tweetEntityToTweetApiModel).collect(Collectors.toList());
        return ResponseEntity.ok(latestTweetsResponse);
    }
}
