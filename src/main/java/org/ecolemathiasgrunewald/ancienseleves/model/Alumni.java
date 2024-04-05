package org.ecolemathiasgrunewald.ancienseleves.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
@Table(name="alumni")
public class Alumni {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name = "gender", columnDefinition = "TINYINT(1)")
	private boolean gender;

	@Column(name = "birthdate")
	private Date birthDate;

    @Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@OneToOne(
		mappedBy = "alumni"
	)
	private Schooling schooling;

	@OneToMany(
		mappedBy = "alumni"
	)
	private List<Job> jobs = new ArrayList<>();

	@OneToMany(
		mappedBy = "alumni"
	)
	private List<Study> studies = new ArrayList<>();

	@OneToMany(
		mappedBy = "alumni"
	)
	private List<Contact> contacts = new ArrayList<>();
	

}
