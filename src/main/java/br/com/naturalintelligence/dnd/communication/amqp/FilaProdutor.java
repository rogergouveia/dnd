package br.com.naturalintelligence.dnd.communication.amqp;

public interface FilaProdutor {
    
    public void send(Object message);
}
