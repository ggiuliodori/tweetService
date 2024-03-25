package com.uala.tweet.repository;

import com.uala.tweet.model.TweetModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TweetRepository extends MongoRepository<TweetModel, String> {
    Optional<TweetModel> findFirstByUserIdOrderByTimestampDesc(String userId);
}

