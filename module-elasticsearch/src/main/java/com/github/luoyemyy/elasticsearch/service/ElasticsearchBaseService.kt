package com.github.luoyemyy.elasticsearch.service

import com.github.luoyemyy.elasticsearch.bean.IndexParam
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.client.indices.CreateIndexRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ElasticsearchBaseService {

    @Autowired
    private lateinit var restHighLevelClient: RestHighLevelClient

    fun indexCreate(name: String, param: IndexParam): Boolean {
        val request = CreateIndexRequest(name).apply {
            param.getAliases()?.also {
                aliases(it)
            }
            param.getSettings()?.also {
                settings(it, param.getSourceType())
            }
            param.getMapping()?.also {
                mapping(it, param.getSourceType())
            }
        }
        val options = RequestOptions.DEFAULT
        return restHighLevelClient.indices().create(request, options).isAcknowledged
    }
}