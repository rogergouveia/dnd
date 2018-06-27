package br.com.naturalintelligence.dnd.communication.amqp.requisicao_acionamento;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.naturalintelligence.dnd.communication.amqp.Fila;
import br.com.naturalintelligence.dnd.communication.amqp.FilaConfigurations;


@Component
@Qualifier("requisicaoAcionamento")
public class FilaRequisicaoAcionamento implements Fila{
    
    @Qualifier("requisicaoAcionamento")
    @Autowired
    private FilaConfigurations filaConfigurations;

    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public Queue queue() {
        return new Queue(filaConfigurations.getQueueName(), false);
    }

    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public TopicExchange topicExchange() {
        return new TopicExchange(filaConfigurations.getTopicExchangeName());
    }

    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public Binding binding(@Qualifier("requisicaoAcionamento")Queue queue, 
                           @Qualifier("requisicaoAcionamento")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(filaConfigurations.getRoutingKey());
    }

}
