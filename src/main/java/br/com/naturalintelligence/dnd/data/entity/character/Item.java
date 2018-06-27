package br.com.naturalintelligence.dnd.data.entity.character;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Table;

import br.com.naturalintelligence.dnd.data.entity.JPAEntity;

 

@Entity
@Table(appliesTo="item")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Item implements JPAEntity {
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1)
	@Column(name="item_id", updatable = false, nullable = false)
	private Long id;
	
	private Integer weight;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="storage_id")
	private Storage storage;
	
	
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	
	
}
