package com.example.notify.Repository;

import com.example.notify.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepository extends MongoRepository<User, String> {
}
