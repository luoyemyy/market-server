@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.github.luoyemyy.market.common.utils

import org.slf4j.LoggerFactory
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private val logger = LoggerFactory.getLogger(DateUtils::class.java)
    const val FORMAT_MD = "MMdd"
    const val FORMAT_YMD = "yyyy-MM-dd"
    const val FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss"
    const val FORMAT_YMD_CN = "yyyy年MM月dd日"
    const val FORMAT_YMDHMS_CN = "yyyy年MM月dd日 HH:mm:ss"

    private val localMap: Map<String, ThreadLocal<SimpleDateFormat>> by lazy {
        mapOf(
                FORMAT_MD to ThreadLocal.withInitial { SimpleDateFormat(FORMAT_MD) },
                FORMAT_YMD to ThreadLocal.withInitial { SimpleDateFormat(FORMAT_YMD) },
                FORMAT_YMDHMS to ThreadLocal.withInitial { SimpleDateFormat(FORMAT_YMDHMS) },
                FORMAT_YMD_CN to ThreadLocal.withInitial { SimpleDateFormat(FORMAT_YMD_CN) },
                FORMAT_YMDHMS_CN to ThreadLocal.withInitial { SimpleDateFormat(FORMAT_YMDHMS_CN) }
        )
    }

    fun formatDate(date: Date?): String? {
        return format(date, FORMAT_YMD)
    }

    fun formatDateTime(date: Date?): String? {
        return format(date, FORMAT_YMDHMS)
    }

    fun format(date: Date?, format: String?): String? {
        return date?.let { sdf(format)?.format(it) }
    }

    private fun sdf(format: String?): SimpleDateFormat? {
        return if (format.isNullOrEmpty()) {
            logger.error("format不能为空")
            return null
        } else localMap[format]?.get() ?: try {
            SimpleDateFormat(format)
        } catch (e: IllegalArgumentException) {
            logger.error("无效的format={}", format)
            null
        }
    }

    fun parseDate(date: String?): Date? {
        return parse(date, FORMAT_YMD)
    }

    fun parseDateTime(date: String?): Date? {
        return parse(date, FORMAT_YMDHMS)
    }

    fun parse(date: String?, format: String?): Date? {
        return date?.let {
            sdf(format)?.let {
                try {
                    it.parse(date)
                } catch (e: ParseException) {
                    logger.error("解析失败 date={}, format={}", date, format)
                    null
                }
            }
        }
    }
}