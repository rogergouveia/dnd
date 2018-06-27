package br.com.naturalintelligence.dnd.dto.mapping.dto_mapping;

/**
 * Bean responsável pelo mapeamento de DTO para JPA Entity
 * 
 * @author rngouveia
 *
 */
public class DtoModelMapper //extends ModelMapper 
{
//    private BiMap<Class<? extends Dto>, Class<? extends JPAEntity>> mapping = HashBiMap.create();
//    
//    public DtoModelMapper(Map<Class<? extends Dto>, Class<? extends JPAEntity>> mapping) {
//        this.mapping.putAll(mapping);
//    }
//
//    /**
//     * Converte Dto para JPA Entity conforme anotação DtoMap
//     * e configurações do DtoModelMapper
//     * 
//     * @param dto
//     * @return JPAEntity
//     */
//    public <D extends Dto, E extends JPAEntity> E map(D dto) {
//        Class<? extends JPAEntity> eClass = mapping.get(dto.getClass());
//        E retorno = (E) super.map(dto, eClass);
//        return retorno;
//    }
//    
//    public <D extends Dto, J extends JPAEntity> Collection<J> map(Collection<D> dtos) {
//        Collection<J> retorno = new ArrayList<>();
//        for (D d: dtos) {
//            retorno.add(map(d));
//        }
//        return retorno;
//    }
//    
//
//    /**
//     * Converte JPA Entity para Dto conforme anotação DtoMap
//     * e configurações do DtoModelMapper
//     * 
//     * @param dto
//     * @return JPAEntity
//     */
//    public <D extends Dto, J extends JPAEntity> Dto map(J entity, Class<D> dtoClass) {
//        if (!mapping.containsKey(dtoClass)) {
//            throw new DtoMappingException("Conversão indevida. Classe DTO ("+dtoClass.getName()+") não está mapeada para JPA Entity ("+entity.getClass().getName()+")");
//        }
//        Class<? extends Dto> classe = isAbstract(dtoClass)?
//                                      getMappedConcreteDtoClass(entity.getClass()):
//                                      dtoClass;
//        return super.map(entity, classe);
//    }
//    
//    public <D extends Dto, J extends JPAEntity> Collection<Dto> map(Collection<J> entities, Class<D> dtoClass) {
//        Collection<Dto> retorno = new ArrayList<>();
//        for (J entity: entities) {
//            retorno.add(this.map(entity,dtoClass));
//        }
//        return retorno;
//    }
//    
////    private Class<? extends JPAEntity> getMappedConcreteEntityClass(Class<? extends Dto> concreteDtoClass){
////        Class<? extends JPAEntity> retorno = mapping.get(concreteDtoClass);
////        return retorno;
////    }
//    
//    private Class<? extends Dto> getMappedConcreteDtoClass(Class<? extends JPAEntity> concreteJPAClass){
//        Class<? extends Dto> retorno = mapping.inverse().get(concreteJPAClass);
//        return retorno;
//    }
//    
//    private boolean isAbstract(Class<?> classe) {
//        return Modifier.isAbstract(classe.getModifiers());
//    }
}
