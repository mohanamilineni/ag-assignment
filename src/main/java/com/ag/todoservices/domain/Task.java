/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Bracket Task model which contains text and isBalanced information
 * 
 * @author Mohan AMILINENI
 *
 */
@Component
@Entity
@JsonIgnoreProperties({"id"})
public class Task extends BaseEntity {

	//0 - Variables declaration	
	@Size(min=1, max=100, message="Must be between 1 and 50 chars long")
	private String  input;
	
	private boolean isBalanced;

	//1 - Getters and Setters
	public String getInput() {
		return input;
	}
	public boolean getIsBalanced() {
		return isBalanced;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public void setIsBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}
	
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().hashCode() : 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Task otherTodo = (Task) o;
		
		return this.getId() != null ? this.getId().equals(otherTodo.getId()) : otherTodo.getId() == null;		
	}
		
	@Override
	public String toString() {
		return "Task [input=" + input + ", isBalanced=" + isBalanced + ", getId()=" + getId() + "]";
	}
		
}
