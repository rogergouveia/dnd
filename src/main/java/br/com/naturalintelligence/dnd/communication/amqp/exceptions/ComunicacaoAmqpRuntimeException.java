package br.com.naturalintelligence.dnd.communication.amqp.exceptions;

import org.springframework.amqp.AmqpException;

/**
 * Exceção disparada quando houve falha em comunicação AMQP.
 * 
 * @author rngouveia
 *
 */
public class ComunicacaoAmqpRuntimeException extends AmqpException{
    private static final long serialVersionUID = 1L;

    public ComunicacaoAmqpRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    

}
