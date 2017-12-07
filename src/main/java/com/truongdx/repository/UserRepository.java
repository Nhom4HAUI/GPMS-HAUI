package com.truongdx.repository;

import com.truongdx.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    List<User> findByUsernameContaining(String q);


}
