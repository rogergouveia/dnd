package br.com.naturalintelligence.dnd.communication.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

public interface Fila {
    
    public Queue queue();

    public TopicExchange topicExchange();

    public Binding binding(Queue queue, TopicExchange exchange);

}
