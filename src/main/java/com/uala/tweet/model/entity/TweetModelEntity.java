package com.uala.tweet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tweets")
public class TweetModelEntity {
    private String id;
    private String userId;
    private String content;
    private LocalDateTime timestamp;
}

