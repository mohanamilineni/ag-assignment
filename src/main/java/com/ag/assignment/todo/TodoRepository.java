package com.ag.assignment.todo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AMK on 17/12/18.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {}
