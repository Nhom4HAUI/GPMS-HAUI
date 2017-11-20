package com.truongdx.repository;

import com.truongdx.domain.Leader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeaderRepository extends CrudRepository<Leader, Integer>{

    Leader findByUsername(String username);

    List<Leader> findByUsernameContaining(String q);
}
