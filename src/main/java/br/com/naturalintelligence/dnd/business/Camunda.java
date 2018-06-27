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
		runtimeService.startProcessInstanceByKey(Processos.EXECUTAR_REGUA.getDefinitionKey());
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
	    CONSULTAR_REGUA("consultar_regua_process"),
	    CONFIGURAR_REGUA("configurar_regua_process_key"),
	    CONSULTAR_DIVIDAS("consultar_dividas_process"),
	    EXECUTAR_REGUA("executar_regua_process_key");
	    
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
	    DEVEDORES_DTOS("devedoresDtos", ""),
	    VENCIMENTOS_REGUA("vencimentosRegua", ""),
	    METAREGUA_DTO("metaReguaDto", ""),
	    REQUISICAO("requisicao", ""),
	    REQUISICOES_ACIONAMENTOS_DTOS("requisicoesAcionamentosDtos", ""),
	    LOOPCOUNTER("loopCounter", ""),
	    CONFIGURACAO("configuracao", ""),
	    CONFIGURACAO_OK("configuracaoOk", ""),
	    CONFIGURACAO_MSG_FALHA("configuracaoMsgFalha", "");
	    
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
