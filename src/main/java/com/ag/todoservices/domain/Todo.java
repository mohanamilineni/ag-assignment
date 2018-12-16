/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;


/**
 * This class acts as a model for ToDo object with the properties id, text, isCompleted
 * @author Mohan AMILINENI
 *
 */
@Entity
public class Todo extends BaseEntity {

	//0 - Variables Declaration
	@Size(min=1, max=50, message="Must be between 1 and 50 chars long")
	public String  text;
	
	public boolean isCompleted = false;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false)
	public Date createdAt;
	
	//1 - Getters and Setters
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + getId() + ", text=" + text + ", isCompleted=" + isCompleted + ", createdAt=" + createdAt + "]";
	}	
		
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().hashCode() : 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Todo otherTodo = (Todo) o;
		
		return this.getId() != null ? this.getId().equals(otherTodo.getId()) : otherTodo.getId() == null;		
	}
	
}
