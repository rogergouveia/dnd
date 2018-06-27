package br.com.naturalintelligence.dnd.business.bpm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import br.com.naturalintelligence.dnd.business.Camunda.Variaveis;

/**
 * Interface que define o comportamento padrão das Tasks bpm
 * do sistema. 
 * 
 * @author rngouveia
 */
public interface Task extends JavaDelegate{
    /**
     * 
     * @return {@link DelegateExecution} do Camunda
     */
    DelegateExecution getExecution();
    
    /**
     * Seta a {@link DelegateExecution} do Camunda
     */
    void setExecution(DelegateExecution execution);

    /**
     * Implementação da Task
     * 
     * @throws Exception
     */
    void executar() throws Exception;
    
    public default Object getVariable(Variaveis variavel) {
        return getExecution().getVariable(variavel.getNome());
    }
    
    public default void setVariable(Variaveis variavel, Object object) {
        getExecution().setVariable(variavel.getNome(), object);
    }
    
    
    /**
     * Guarda a {@link DelegateExecution} do Camunda, e define comportamento
     * após execução que garante que todas as variáveis de saída de
     * uma Task devem ser setadas.
     * 
     */
    @Override
    public default void execute(DelegateExecution execution) throws Exception {
        setExecution(execution);
        executar();
        List<Variaveis> outParamsNotSet = new ArrayList<>(getOutputParametersNotSet()); 
        if (!outParamsNotSet.isEmpty()) {
            throw new TaskOutputParameterNotSetException(outParamsNotSet.get(0).getNome());
        }
    }
    
    /**
     * 
     * @return Variáveis de saída da Task que não foram setados
     */
    default Collection<Variaveis> getOutputParametersNotSet() {
        List<Variaveis> retorno = new ArrayList<>();
        for (Variaveis v: getOutputVariables()) {
            if (!getExecution().getVariables().containsKey(v.getNome())) {
                retorno.add(v);
            }
        }
        return retorno;
    }
    
    /**
     * 
     * @return Variáveis de entrada da Task
     */
    public List<Variaveis> getInputVariables();
    
    /**
     * 
     * @return Variáveis de saída da Task
     */
    public List<Variaveis> getOutputVariables();
    


}
