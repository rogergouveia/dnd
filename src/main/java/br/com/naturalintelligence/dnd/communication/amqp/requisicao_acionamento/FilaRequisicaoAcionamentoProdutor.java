package br.com.naturalintelligence.dnd.communication.amqp.requisicao_acionamento;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.naturalintelligence.dnd.communication.amqp.FilaConfigurations;
import br.com.naturalintelligence.dnd.communication.amqp.FilaProdutor;

@Qualifier("requisicaoAcionamento")
@Component
public class FilaRequisicaoAcionamentoProdutor implements FilaProdutor{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Qualifier("requisicaoAcionamento")
    @Autowired
    private FilaConfigurations filaConfigurations;
    
    @Override
    public void send(Object message) {
        rabbitTemplate.convertAndSend(filaConfigurations.getTopicExchangeName(), 
                                      filaConfigurations.getRoutingKey(), 
                                      message );
    }
    

}
