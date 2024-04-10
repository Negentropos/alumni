package org.ecolemathiasgrunewald.ancienseleves.model;

import java.sql.Date;

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
@Table(name="promotion_has_teacher")
public class PromotionTeacher {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

    private String role;

    @Column(name = "entry_date")
	private Date startDate;

    @Column(name = "release_date")
	private Date endDate;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name="promotion_id")
    private Promotion promotion;

}
