package org.ecolemathiasgrunewald.ancienseleves.model;

import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
@Table(name="schooling")
public class Schooling {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

    @Column(name = "entry_date")
	private Date entryDate;

    @Column(name = "release_date")
	private Date releaseDate;

    @ManyToOne(
        //cascade = CascadeType.ALL
    )
    @JoinColumn(name="classroom_entry_id")
    private Classroom entryClassroom;

    @ManyToOne(
    )
    @JoinColumn(name="classroom_release_id")
    private Classroom releaseClassroom;

	private String note;

    @OneToOne(
    )
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

    @ManyToOne(
    )
    @JoinColumn(name="promotion_id")
    private Promotion promotion;

    @ManyToOne(
    )
    @JoinColumn(name="jardinier_id")
    private Teacher jardinier;

    public boolean isInClass(int classCode){
        if (this.entryClassroom.getCode() >= classCode && this.releaseClassroom.getCode() <= classCode){
            return true;
        }
        return false;
    }

}
