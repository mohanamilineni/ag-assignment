package com.ag.assignment.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AMK on 17/12/18.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
