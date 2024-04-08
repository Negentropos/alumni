package org.ecolemathiasgrunewald.ancienseleves.model;

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
@Table(name="contact")
public class Contact {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

    private String type;

    private String content;

    @ManyToOne()
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

    @Column(name = "usable", columnDefinition = "TINYINT(1)")
	private boolean usable;




}
