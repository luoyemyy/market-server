package com.github.luoyemyy.elasticsearch.service

import com.github.luoyemyy.common.util.toJsonString
import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentType
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ElasticsearchTestService {

    companion object {
        private val logger = LoggerFactory.getLogger(ElasticsearchTestService::class.java)
    }

    @Autowired
    private lateinit var restHighLevelClient: RestHighLevelClient

    fun test() {
        BulkRequest().apply {
            (1..10).forEachIndexed { _, actId ->
                var curr = System.currentTimeMillis()
                (1..200).forEachIndexed { _, userId ->
                    if (Math.random() > 0.1) {
                        Sign(userId, actId, curr).toJsonString()?.also { json ->
                            logger.info(json)
                            IndexRequest("act_sign", "_doc").source(json, XContentType.JSON).also { index ->
                                this.add(index)
                            }
                        }
                    }
                    curr -= 86400000
                }
            }
            restHighLevelClient.bulk(this, RequestOptions.DEFAULT)
        }
    }

    class Sign(
            var userId: Int,
            var actId: Int,
            var signTime: Long
    )
}