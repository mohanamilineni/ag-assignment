package com.ag.assignment.todo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import com.ag.assignment.model.BaseEntity;


/**
 * Created by AMK on 17/12/18.
 */
@SuppressWarnings("serial")
@Entity
public class Todo extends BaseEntity {

	//0 - Variables Declaration
	@Size(min=1, max=50, message="Must be between 1 and 50 chars long")
	private String  text;

	private Boolean isCompleted;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false)
	private Date createdAt;
	
	//1 - Getters and Setters
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Boolean getIsCompleted() {
		return this.isCompleted;
	}
	
	public Todo setIsCompleted(Boolean isCompleted) {		
		this.isCompleted = isCompleted == null? Boolean.FALSE : isCompleted;
		return this;
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
