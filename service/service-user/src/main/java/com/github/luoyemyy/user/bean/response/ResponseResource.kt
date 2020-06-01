package com.github.luoyemyy.user.bean.response

import com.github.luoyemyy.resource.entity.ResourceRecord
import io.swagger.annotations.ApiModel

@ApiModel
class ResponseResource {
    var resourceId: Long = 0
    var parentId: Long = 0
    var name: String? = null
    var type: Int = 0
    var pathId: Int = 0
    var path: String? = null
    var level: Int = 0

    companion object {

        fun map(resources: List<ResourceRecord>?): List<ResponseResource> {
            return resources?.map { map(it) } ?: listOf()
        }

        private fun map(resource: ResourceRecord): ResponseResource {
            return ResponseResource().apply {
                resourceId = resource.id ?: 0
                parentId = resource.parentId ?: 0
                name = resource.name
                type = resource.type ?: 0
                pathId = resource.pathId ?: 0
                path = resource.path
                level = resource.level ?: 0
            }
        }
    }
}