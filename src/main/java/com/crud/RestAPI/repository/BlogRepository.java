package com.crud.RestAPI.repository;

import com.crud.RestAPI.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
}
