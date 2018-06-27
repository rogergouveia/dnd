package br.com.naturalintelligence.dnd.dto.mapping.dto_mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.naturalintelligence.dnd.data.entity.JPAEntity;

/**
 * Anotação utilizada em classes DTO para indicar para qual 
 * JPA Entity deve ser realizada a conversão.  
 * 
 * @author rngouveia
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoMap {
    Class<? extends JPAEntity> entity();
}
