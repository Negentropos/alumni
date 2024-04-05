package org.ecolemathiasgrunewald.ancienseleves.model;
import java.util.ArrayList;
import java.util.List;

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
@Table(name="classroom")
public class Classroom {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

    private String name;

    private String cycle;

    private int code;

    @OneToMany(
        mappedBy = "entryClassroom"
    )
    private List<Schooling> entrySchoolings = new ArrayList<>();

    @OneToMany(
        mappedBy = "releaseClassroom"
    )
    private List<Schooling> releaseSchoolings = new ArrayList<>();


}
