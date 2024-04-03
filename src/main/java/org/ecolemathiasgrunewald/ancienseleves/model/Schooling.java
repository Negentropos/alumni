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

    @Column(name = "entry_date", columnDefinition = "DATE")
	private LocalDate entryDate;

    @Column(name = "release_date", columnDefinition = "DATE")
	private LocalDate releaseDate;

    @Column(name = "class_of_release")
	private String classOfRelease;

    @Column(name = "class_of_entry")
	private String classOfEntry;

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
