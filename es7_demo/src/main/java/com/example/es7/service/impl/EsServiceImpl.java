package com.example.es7.service.impl;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EsServiceImpl {

    @Autowired
    @Qualifier("esClient")
    private RestHighLevelClient client;


}
