package br.com.naturalintelligence.dnd.business.load_char;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import br.com.naturalintelligence.dnd.business.Camunda.Variaveis;
import br.com.naturalintelligence.dnd.business.bpm.TaskVariableMapping;
import br.com.naturalintelligence.dnd.dto.divida.CharacterDto;

public interface LoadCharTaskVarMapping extends TaskVariableMapping {
    public default void setOutputChars(Set<CharacterDto> chars) {
        setVariable(Variaveis.CHARS, chars);
    }
    
    @Override
    public default List<Variaveis> getInputVariables(){
        return Arrays.asList();
    }
    
    @Override
    public default List<Variaveis> getOutputVariables(){
        return Arrays.asList(Variaveis.CHARS);
    }
}
