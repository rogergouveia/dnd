package br.com.naturalintelligence.dnd.data.entity.character;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Table;

import br.com.naturalintelligence.dnd.data.entity.JPAEntity;



@Entity
@Table(appliesTo="storage")
public abstract class Storage implements JPAEntity {
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="storage_seq")
	@SequenceGenerator(name="storage_seq", sequenceName="storage_seq", allocationSize=1)
	@Column(name="storage_id", updatable = false, nullable = false)
	private Long id;
	
	@OneToMany(mappedBy="storage", cascade = CascadeType.ALL)
	private Collection<Item> itens;
	
	private String name;
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Item> getItens() {
		return itens;
	}

	public void setItens(Collection<Item> itens) {
		this.itens = itens;
	}
	
	
	
}
