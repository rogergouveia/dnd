package br.com.naturalintelligence.dnd.dto.mapping.dto_mapping;

public class DtoMappingException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DtoMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DtoMappingException(String message) {
        super(message);
    }
    
    
    
}
