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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="schooling")
public class Schooling {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name = "entry_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;

    @Column(name = "release_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="classroom_entry_id")
    private Classroom entryClassroom;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="classroom_release_id")
    private Classroom releaseClassroom;

	private String note;

    @OneToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="promotion_id")
    private Promotion promotion;

    @ManyToOne(
        cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
        }
    )
    @JoinColumn(name="jardinier_id")
    private Teacher jardinier;

}
