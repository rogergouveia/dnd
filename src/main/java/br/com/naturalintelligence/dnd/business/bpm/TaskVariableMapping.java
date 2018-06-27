package br.com.naturalintelligence.dnd.business.bpm;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;

import br.com.naturalintelligence.dnd.business.Camunda.Variaveis;

/**
 * Implementa comportamento padrão de {@link DelegateVariableMapping}
 * que coloca na subExecucao os mesmos parâmetros da superExecucao antes
 * de executar a Task, e faz o contrário após a execução.
 * 
 * @author rngouveia
 *
 */
public interface TaskVariableMapping extends DelegateVariableMapping,Task{

    /**
     * Antes da execução da {@link Task}, coloca todos os parâmetros de entrada
     * da superExecução na subExecução.
     * 
     */
    @Override
    default void mapInputVariables(DelegateExecution superExecution, VariableMap subVariables) {
        for (Variaveis v: getInputVariables()) {
            subVariables.putValue(v.getNome(), superExecution.getVariable(v.getNome()));
        }
    }

    /**
     * Após a execução da {@link Task}, coloca todos os parâmetros de saída
     * da subExecução na superExecução.
     * 
     */
    @Override
    default void mapOutputVariables(DelegateExecution superExecution, VariableScope subInstance) {
        for (Variaveis v: getOutputVariables()) {
            superExecution.setVariable(v.getNome(), subInstance.getVariable(v.getNome()));
        }
    }
    
}
