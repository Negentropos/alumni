package org.ecolemathiasgrunewald.ancienseleves.model;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="study")
public class Study {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    private String diploma;

    private String school;

    private String note;

    @Column(name="diploma_level")
    private int diplomaLevel;

    @Column(name = "entry_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;

    @Column(name = "release_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;


    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

}