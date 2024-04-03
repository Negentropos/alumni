package org.ecolemathiasgrunewald.ancienseleves.model;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="job")
public class Job {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    private String name;

    private String company;

    @Column(name = "entry_date", columnDefinition = "DATE")
	private LocalDate entryDate;

    @Column(name = "release_date", columnDefinition = "DATE")
	private LocalDate releaseDate;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

}
