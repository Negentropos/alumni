package org.ecolemathiasgrunewald.ancienseleves.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="teacher")
public class Teacher {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

    private String mail;

    private String phone;

    @Column(name = "entry_date", columnDefinition = "DATE")
	private LocalDate entryDate;

    @Column(name = "release_date", columnDefinition = "DATE")
	private LocalDate releaseDate;

    @OneToMany(
        mappedBy = "teacher",
        cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
        }
    )
    private List<PromotionTeacher> promotionTeachers = new ArrayList<>();

    @OneToMany(
        mappedBy = "jardinier",
        cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
        }
    )
    private List<Schooling> jeSchoolings = new ArrayList<>();

}
