package com.truongdx.repository;

import com.truongdx.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository  extends CrudRepository<Team, Integer> {
}
