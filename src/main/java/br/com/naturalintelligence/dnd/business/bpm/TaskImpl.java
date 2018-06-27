package br.com.naturalintelligence.dnd.business.bpm;

import org.camunda.bpm.engine.delegate.DelegateExecution;

/**
 * Classe abstrata que contém a {@link DelegateExecution} do Camunda
 * 
 * @author rngouveia
 *
 */
public abstract class TaskImpl implements Task {
    private DelegateExecution execution;

    public DelegateExecution getExecution() {
        return execution;
    }

    public void setExecution(DelegateExecution execution) {
        this.execution = execution;
    }
    
}
