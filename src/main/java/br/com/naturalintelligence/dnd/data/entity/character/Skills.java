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
@Table(appliesTo="skills")
public class Skills implements JPAEntity {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skills_seq")
	@SequenceGenerator(name="skills_seq", sequenceName="skills_seq", allocationSize=1)
	@Column(name="skills_id", updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="character_id")
	private Character character;
	
	@NotNull
	private Boolean acrobatics;
	
	
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	
}
