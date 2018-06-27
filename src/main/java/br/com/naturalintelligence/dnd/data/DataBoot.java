package br.com.naturalintelligence.dnd.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.naturalintelligence.dnd.data.repository.CharacterRepository;

@Component
public class DataBoot {
	
	@Autowired
	private CharacterRepository devedorRepo;
	
	

	@PostConstruct
	public void init() {
	}
	

	
}
