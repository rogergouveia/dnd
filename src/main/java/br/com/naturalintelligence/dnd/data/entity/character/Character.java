package br.com.naturalintelligence.dnd.data.entity.character;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.naturalintelligence.dnd.data.entity.JPAEntity;


 
@Entity
@Table(appliesTo="character")
@EntityListeners(AuditingEntityListener.class)
public class Character implements JPAEntity {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="character_seq")
	@SequenceGenerator(name="character_seq", sequenceName="character_seq", allocationSize=1)
	@Column(name="character_id", updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;
	
	
	private Race race;
	
	private Classes classes;
	
	private Storage storage;
	
	private Integer proficiencyBonus;
	
	
	@NotNull
	@OneToOne(mappedBy="character", cascade = CascadeType.ALL)
	private Abilities abilities;
	
	@NotNull
	@OneToOne(mappedBy="character", cascade = CascadeType.ALL)
	private Skills skills;
	
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
		
	
}
