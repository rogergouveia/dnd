package br.com.naturalintelligence.dnd.business.load_char;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.naturalintelligence.dnd.business.bpm.TaskImpl;
import br.com.naturalintelligence.dnd.data.repository.CharacterRepository;
import br.com.naturalintelligence.dnd.dto.divida.CharacterDto;

//@Component
public class LoadCharTask extends TaskImpl implements LoadCharTaskVarMapping {

    @Autowired
    private CharacterRepository charRepo;
    
    @Autowired
    private Mapper modelMapper;
    
    @Override
    public void executar() throws Exception{
        System.out.println("----->LoadChar");
        Set<CharacterDto> chars = getChars();
        setOutputChars(chars);
    }
    
    private Collection<Character> findChars(){
    	return charRepo.findAll();
    }
    
    private Set<CharacterDto> getChars(){
    	Collection<CharacterDto> chars = new ArrayList<CharacterDto>();
    	for (Character c: findChars()) {
    		chars.add(modelMapper.map(c, CharacterDto.class));
    	}
    	return new HashSet<CharacterDto>(chars);
    }

}
