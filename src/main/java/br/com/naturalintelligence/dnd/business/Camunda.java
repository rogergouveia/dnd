package br.com.naturalintelligence.dnd.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Bean que permite interações programáticas com o Camunda.
 * 
 * @author rngouveia
 *
 */
@Component
public class Camunda {
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		System.out.println("Start Executar Regua");
		runtimeService.startProcessInstanceByKey(Processos.LOAD_CHAR.getDefinitionKey());
	}
	
	
	public Map<String,Object> executarProcesso(Processos process) {
	    return executarProcesso(process, new HashMap<>());
	}
	
	public Map<String,Object> executarProcesso(Processos process, Map<String,Object> variablesIn) {
	    String processInstanceId = runtimeService.startProcessInstanceByKey(process.getDefinitionKey(), variablesIn)
	                                             .getProcessInstanceId();
	    List<HistoricVariableInstance> variaveis = historyService.createHistoricVariableInstanceQuery()
	                                                             .processInstanceIdIn(processInstanceId)
	                                                             .list();
	    return extractVariables(variaveis);
	}
	
	private Map<String,Object> extractVariables(List<HistoricVariableInstance> variaveis){
	    Map<String,Object> retorno = new HashMap<>();
        for (HistoricVariableInstance h: variaveis) {
            retorno.put(h.getName(), h.getValue());
        }
        return retorno;
	}
	
	
	
	public enum Processos{
	    LOAD_CHAR("load_char_process")
	    ;
	    
	    private String definitionKey;

        private Processos(String definitionKey) {
            this.definitionKey = definitionKey;
        }

        public String getDefinitionKey() {
            return definitionKey;
        }

        public void setDefinitionKey(String definitionKey) {
            this.definitionKey = definitionKey;
        }
	    
	}
	
	
	public enum Variaveis{
	    CHARS("chars", "")
	    ;
	    
	    private String nome;
	    private String descricao;
	    
	    private Variaveis(String nome, String descricao) {
	        this.nome = nome;
	        this.descricao = descricao;
	    }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
	}
}
