package com.ag.assignment.todo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import com.ag.assignment.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Created by AMK on 17/12/18.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Todo extends BaseEntity {
	
	@Size(min=1, max=50, message="Must be between 1 and 50 chars long")
	private String  text;
	private Boolean isCompleted;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false)
	@EqualsAndHashCode.Exclude
	private Date createdAt;
			
	public Todo setIsCompleted(Boolean isCompleted) {		
		this.isCompleted = isCompleted == null? Boolean.FALSE : isCompleted;
		return this;
	}	
}
