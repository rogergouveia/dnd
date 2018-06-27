package br.com.naturalintelligence.dnd.communication.amqp.requisicao_acionamento;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.naturalintelligence.dnd.communication.amqp.FilaConfigurations;


@Component
@Qualifier("requisicaoAcionamento")
@ConfigurationProperties(prefix = "recuperacao.regua-cobranca.fila-requisicao-acionamento")
@Validated
public class FilaRequisicaoAcionamentoConfigurations implements FilaConfigurations{
    
    @NotBlank
    private String topicExchangeName;

    @NotBlank
    private String queueName;
    
    @NotBlank
    private String routingKey;

    @Override
    public String getTopicExchangeName() {
        return topicExchangeName;
    }

    @Override
    public void setTopicExchangeName(String topicExchangeName) {
        this.topicExchangeName = topicExchangeName;
    }

    @Override
    public String getQueueName() {
        return queueName;
    }

    @Override
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @Override
    public String getRoutingKey() {
        return routingKey;
    }

    @Override
    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

}
