package org.ecolemathiasgrunewald.ancienseleves.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="promotion")
public class Promotion {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="number")
    private int name;

    @OneToMany(
        mappedBy = "promotion",
        cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
        }
    )
    private List<PromotionTeacher> promotionTeachers = new ArrayList<>();

}
