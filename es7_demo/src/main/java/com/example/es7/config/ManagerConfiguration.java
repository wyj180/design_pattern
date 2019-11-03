package com.example.es7.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class ManagerConfiguration {

    @Value("${sqm.manager.es.url}")
    private String[] esUrl;

    /**
     * ES Client
     */
    @Bean("esClient")
    public RestHighLevelClient restHighLevelClient() {
        HttpHost[] esHosts = Arrays.stream(esUrl).map(url -> {
            return new HttpHost(url, 9200);
        }).collect(Collectors.toList()).stream().toArray(HttpHost[]::new);

        RestClientBuilder restClientBuilder = RestClient.builder(esHosts);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);
        return restHighLevelClient;
    }

}