package com.uala.tweet.repository;

import com.uala.tweet.model.entity.TweetModelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TweetRepository extends MongoRepository<TweetModelEntity, String> {
    Optional<TweetModelEntity> findFirstByUserIdOrderByTimestampDesc(String userId);
}

