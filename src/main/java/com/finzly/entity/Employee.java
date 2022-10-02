package com.finzly.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String mobileNo;
	private String status;
	@CreationTimestamp
	@Column(updatable = false,nullable = true)
	private Date createdDate;
	private String createdBy;
	@UpdateTimestamp
	private Date updateDate;
	private String updateBy;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id_FK")
	private Country country;

}
