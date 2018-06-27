package br.com.naturalintelligence.dnd.business.bpm;

/**
 * Exceção disparada quando todos os parâmetros de saída
 * de uma {@link Task} não foram setados
 * 
 * @author rngouveia
 *
 */
public class TaskOutputParameterNotSetException extends Exception{
    private static final long serialVersionUID = 1L;

    public TaskOutputParameterNotSetException(String message) {
        super(message);
    }

}
