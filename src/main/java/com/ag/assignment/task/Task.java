package com.ag.assignment.task;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.ag.assignment.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by AMK on 17/12/18.
 */
@SuppressWarnings("serial")
@Component
@Entity
@JsonIgnoreProperties({"id"})
@Data()
@EqualsAndHashCode(callSuper=true)
public class Task extends BaseEntity {

	@Size(min=1, max=100, message="Must be between 1 and 50 chars long")
	private String  input;
	
	private boolean isBalanced;	
	
	public boolean getIsBalanced() {
		return isBalanced;
	}
}
