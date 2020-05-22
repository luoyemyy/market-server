package com.github.luoyemyy.elasticsearch.bean

import org.elasticsearch.action.admin.indices.alias.Alias
import org.elasticsearch.common.xcontent.XContentType

class IndexParam {


    fun getSettings(): String? {
        return null
    }

    fun getMapping(): String? {
        return null
    }

    fun getAliases(): List<Alias>? {
        return null
    }

    fun getSourceType(): XContentType {
        return XContentType.JSON
    }

    class IndexSettings {

    }

    class IndexMapping {

    }

    class IndexAlias {

    }
}