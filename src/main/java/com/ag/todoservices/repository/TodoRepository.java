package com.ag.todoservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ag.todoservices.domain.Todo;

/**
 * Created by AMK on 17/12/18.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {}
