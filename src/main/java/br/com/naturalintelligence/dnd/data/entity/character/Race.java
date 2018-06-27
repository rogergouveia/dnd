package br.com.naturalintelligence.dnd.data.entity.character;

import java.util.Collection;

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
@Table(appliesTo="race")
public class Race implements JPAEntity {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="race_seq")
	@SequenceGenerator(name="race_seq", sequenceName="race_seq", allocationSize=1)
	@Column(name="race_id", updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="character_id")
	private Character character;
	
	private Collection<RaceTrait> raceTraits;
	
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

}
