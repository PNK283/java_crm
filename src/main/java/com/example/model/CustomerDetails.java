package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "CRM_PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Firstname should not be null")
	private String firstName;

	@NotNull(message = "Lastname should not be null")
	private String lastName;

	@javax.validation.constraints.Email(message = "invalid email address")
	private String Email;

}
