/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ag.todoservices.domain.Todo;

/**
 * Interface to manage data related operations for Todo functionalities using JPA 
 * 
 * @author Mohan AMILINENI
 *
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {}
