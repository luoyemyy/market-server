@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.github.luoyemyy.common.bean

import java.lang.Integer.max
import java.lang.Integer.min

class PageInfo {

    var hasPage = false
    var prevPage = 1
    var nextPage = 1
    var totalPage = 1
    var pageSize: Int = 10
    var pageIndex = 1
    var totalRec = 0

    companion object {
        fun create(pageIndex: Int = 1, totalRec: Int = 0, pageSize: Int = 10): PageInfo {
            return PageInfo().apply {
                calc(pageIndex, totalRec, pageSize)
            }
        }
    }

    fun pageStart(): Int {
        return (pageIndex - 1) * pageSize
    }

    fun updateRecord(totalRec: Int = 0) {
        calc(pageIndex, totalRec, pageSize)
    }

    fun updateSize(pageSize: Int = 10) {
        calc(pageIndex, totalRec, pageSize)
    }

    private fun calc(pageIndex: Int, totalRec: Int, pageSize: Int) {
        if (totalRec == 0) {
            this.hasPage = false
            this.pageSize = pageSize
            this.pageIndex = pageIndex
        } else {
            this.hasPage = true
            this.pageSize = pageSize
            this.totalPage = (totalRec / pageSize).let { if (totalRec % pageSize == 0) it else it + 1 }
            this.pageIndex = if (pageIndex < 1) 1 else min(pageIndex, totalPage)
            this.prevPage = max(pageIndex - 1, 1)
            this.nextPage = min(pageIndex + 1, totalPage)
            this.totalRec = totalRec
        }
    }
}