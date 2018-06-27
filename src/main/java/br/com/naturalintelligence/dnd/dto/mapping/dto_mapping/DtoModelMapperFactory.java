package br.com.naturalintelligence.dnd.dto.mapping.dto_mapping;

public class DtoModelMapperFactory // implements FactoryBean<DtoModelMapper>
{
//
//    @Autowired(required = false)
//    private List<Configurer> configurers;
//
//    
//    @Override
//    public DtoModelMapper getObject() throws Exception {
//        Set<BeanDefinition> dtoAnotated = findClassesWithDTOAnnotation();
//        Map<Class<? extends Dto>, Class<? extends JPAEntity>> mapping = new HashMap<>(initializeMapping(dtoAnotated));
//        final DtoModelMapper modelMapper = new DtoModelMapper(mapping);
//        configure(modelMapper);
//        return modelMapper;
//    }
//
//    @Override
//    public Class<?> getObjectType() {
//        return DtoModelMapper.class;
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return true;
//    }
//    
//    private void configure(DtoModelMapper modelMapper) {
//        if (configurers != null) {
//            configurers.forEach(c -> c.configureImpl(modelMapper));
//        }
//    }
//    
//    /**
//     * Busca todas as classes da aplicação anotadas com DtoMap
//     * 
//     * @return
//     */
//    private Set<BeanDefinition> findClassesWithDTOAnnotation() {
//        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
//
//        scanner.addIncludeFilter(new AnnotationTypeFilter(DtoMap.class));
//        String applicationPackage = ReguacobrancaserviceApplication.class.getPackage().getName();
//
//        return scanner.findCandidateComponents(applicationPackage);
//    }
//    
//    /**
//     * Adiciona no map as classes anotadas com DtoMap passadas por parâmetro
//     * e as classes JPA Entity para as quais as anotações apontam.
//     * 
//     * @param dtoAnotated
//     * @return Map de para quais JPA Entity cada Dto aponta
//     */
//    private Map<Class<? extends Dto>, Class<? extends JPAEntity>> initializeMapping(Set<BeanDefinition> dtoAnotated) {
//        Map<Class<? extends Dto>, Class<? extends JPAEntity>> retorno = new HashMap<>();
//        for (BeanDefinition bd : dtoAnotated) {
//            Class<? extends Dto> dtoClass;
//            try {
//                dtoClass = (Class<? extends Dto>) Class.forName(bd.getBeanClassName());
//                Class<? extends JPAEntity> entityClass = dtoClass.getAnnotation(DtoMap.class).entity();
//                retorno.put(dtoClass, entityClass);
//            } catch (ClassNotFoundException e) {
//                throw instanciarFalhaMapeamentoDto(e);
//            } catch (Exception e) {
//                throw instanciarFalhaMapeamentoDto(e);
//            }
//        }
//        return retorno;
//    }
//    
//    private DtoMappingException instanciarFalhaMapeamentoDto(Throwable e) {
//        return new DtoMappingException(
//                "Anotação @DTOMap apenas deve ser utilizada em classes que implementam interface DTO", e);
//    }

}
