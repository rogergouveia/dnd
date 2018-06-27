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
@Table(appliesTo="class_level")
public class ClassLevel implements JPAEntity {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="class_level_seq")
	@SequenceGenerator(name="class_level_seq", sequenceName="class_level_seq", allocationSize=1)
	@Column(name="class_level_id", updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="classes_id")
	private Classes classes;
	
	@NotNull
	private Integer level;
	
	@NotNull
	private ClassEnum classe;
	
	
	
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public enum ClassEnum {
		A,B,C;
	}


}
