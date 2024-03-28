package com.uala.tweet.parser;

import com.uala.tweet.model.api.TweetModelResponse;
import com.uala.tweet.model.entity.TweetModelEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TweetParser {

    public TweetModelResponse tweetEntityToTweetApiModel(TweetModelEntity tweetModelEntity) {
        return Optional.ofNullable(TweetModelResponse.builder()
                .id(tweetModelEntity.getId())
                .userId(tweetModelEntity.getUserId())
                .content(tweetModelEntity.getContent())
                .timestamp(tweetModelEntity.getTimestamp())
                .build()).orElse(null);
    }
}
