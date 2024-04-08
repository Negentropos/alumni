package org.ecolemathiasgrunewald.ancienseleves.model;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Integer id;

    private String name;

    private String company;

    @Column(name = "entry_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;

    @Column(name = "release_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;

    @ManyToOne()
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

}
