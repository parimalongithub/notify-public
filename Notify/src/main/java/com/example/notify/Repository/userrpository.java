package com.example.notify.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.notify.Entity.User;

@Repository
public interface userrpository extends CrudRepository<User,Long> {

}
