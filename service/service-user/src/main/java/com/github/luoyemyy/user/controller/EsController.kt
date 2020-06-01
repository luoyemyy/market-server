package com.github.luoyemyy.user.controller

import com.github.luoyemyy.common.aspect.AppApi
import com.github.luoyemyy.common.swagger.ApiResponse
import com.github.luoyemyy.common.swagger.response
import com.github.luoyemyy.elasticsearch.service.ElasticsearchTestService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["es"])
@RestController
@RequestMapping("api/es")
class EsController {

    @Autowired
    private lateinit var elasticsearchTestService: ElasticsearchTestService

    @AppApi(auth = false)
    @ApiOperation("es添加测试数据")
    @GetMapping("test")
    fun byUsername(): ApiResponse {
        elasticsearchTestService.test()
        return response()
    }
}