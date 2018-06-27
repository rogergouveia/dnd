package br.com.naturalintelligence.dnd.dto.mapping.dozer;

import java.util.List;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MappingConfiguration {
    
    @Autowired(required = false)
    private List<BeanMappingBuilder> beanMappingBuilders;
    
    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:mappings/*.xml") Resource[] resources) throws Exception {
        final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        // Other configurations
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }
//    
//    
//    @Bean
//    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() throws Exception {
//        final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
//        // Other configurations
//        dozerBeanMapperFactoryBean.setMappingBuilders(beanMappingBuilders);
//        return dozerBeanMapperFactoryBean;
//    }
}
