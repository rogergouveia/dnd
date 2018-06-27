package br.com.naturalintelligence.dnd.data.entity.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Table;

import br.com.naturalintelligence.dnd.data.entity.JPAEntity;



@Entity
@Table(appliesTo="abilities")
public class Abilities implements JPAEntity {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="abilities_seq")
	@SequenceGenerator(name="abilities_seq", sequenceName="abilities_seq", allocationSize=1)
	@Column(name="abilities_id", updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="character_id")
	private Character character;
	
	@NotNull
	private Integer strength;
	@NotNull
	private Integer dexterity;
	@NotNull
	private Integer constitution;
	@NotNull
	private Integer intelligence;
	@NotNull
	private Integer wisdom;
	@NotNull
	private Integer charisma;
	
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}
	
	

}
