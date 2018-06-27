package br.com.naturalintelligence.dnd.communication.amqp.requisicao_acionamento;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.naturalintelligence.dnd.communication.amqp.FilaConfigurations;
import br.com.naturalintelligence.dnd.communication.amqp.FilaConsumidor;

@Qualifier("requisicaoAcionamento")
@Component
public class FilaRequisicaoAcionamentoConsumidor implements FilaConsumidor{

//    private RequisicaoAcionamento requisicao;
    
    private SimpleMessageListenerContainer container;
    
    @Qualifier("requisicaoAcionamento")
    @Autowired
    private FilaConfigurations filaConfigurations;
    
    @PostConstruct
    public void init() {
        container = new SimpleMessageListenerContainer();
        container.setMessageListener(new MessageListenerAdapter(this, "consumir"));
    }

    @Override
    public void consumir(Object message) {
//        System.out.println("mensagem recebida...");
//        if (message instanceof RequisicaoAcionamentoDto) {
//            System.out.println("...conversao com sucesso");
//            requisicao = (RequisicaoAcionamento)requisicao;
//            
//        }
//        else {
//            System.out.println("...conversao falhou");
//        }
    }
    
    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(filaConfigurations.getQueueName());
        return container;
    }

}
