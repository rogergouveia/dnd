package br.com.naturalintelligence.dnd.data;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class DatasourcesConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "regua.datasource")
    public DataSourceProperties reguaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "regua.datasource")
    public DataSource reguaDataSource() {
        return reguaDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "camunda.datasource")
    public DataSourceProperties camundaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "camundaBpmDataSource")
    @ConfigurationProperties(prefix = "camunda.datasource")
    public DataSource camundaDataSource() {
        return camundaDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
