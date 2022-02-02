package com.demo.springelasticdemo.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.demo.springelasticdemo.data.es.repository")
//@ComponentScan(basePackages = { "com.baeldung.spring.data.es.service" })
public class ElasticSearchConfiguration {

    @Value("${elastic.config.hostAndPort}")
    private String hostAndPort;

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration
            = ClientConfiguration.builder()
                .connectedTo(hostAndPort)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}