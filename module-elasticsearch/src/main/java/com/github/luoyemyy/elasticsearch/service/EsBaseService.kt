package com.github.luoyemyy.elasticsearch.service

import org.elasticsearch.client.IndicesClient
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EsBaseService {

    @Autowired
    private lateinit var restHighLevelClient: RestHighLevelClient

    fun index(name: String): IndicesClient {
        return restHighLevelClient.indices()
    }
}