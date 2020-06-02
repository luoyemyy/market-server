@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.github.luoyemyy.common.util

import org.slf4j.LoggerFactory
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.util.*
import java.util.concurrent.*

fun Date?.formatDate(): String? {
    return format(DateUtil.FORMAT_YMD)
}

fun Date?.formatDateTime(): String? {
    return format(DateUtil.FORMAT_YMDHMS)
}

fun Date?.format(format: String?): String? {
    return this?.let { date ->
        date.toInstant().atZone(ZoneId.systemDefault()).let {
            DateUtil.format8(it, format)
        }
    }
}

fun String?.parseDate(): Date? {
    return parse(DateUtil.FORMAT_YMD)
}

fun String?.parseDateTime(): Date? {
    return parse(DateUtil.FORMAT_YMDHMS)
}

fun String?.parse(format: String?): Date? {
    return DateUtil.parse8(this, format)?.toInstant()?.let {
        Date.from(it)
    }
}

object DateUtil {
    private val logger = LoggerFactory.getLogger(Date::class.java)
    const val FORMAT_MD = "MM-dd"
    const val FORMAT_YMD = "yyyy-MM-dd"
    const val FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss"
    const val FORMAT_YMD_CN = "yyyy年MM月dd日"
    const val FORMAT_YMDHMS_CN = "yyyy年MM月dd日 HH:mm:ss"

    private val localMap: ConcurrentHashMap<String, DateTimeFormatter> by lazy {
        ConcurrentHashMap<String, DateTimeFormatter>().apply {
            put(FORMAT_MD, formatter(FORMAT_MD))
            put(FORMAT_YMD, formatter(FORMAT_YMD))
            put(FORMAT_YMDHMS, formatter(FORMAT_YMDHMS))
            put(FORMAT_YMD_CN, formatter(FORMAT_YMD_CN))
            put(FORMAT_YMDHMS_CN, formatter(FORMAT_YMDHMS_CN))
        }
    }

    private fun getSdf(format: String?): DateTimeFormatter? {
        return if (format.isNullOrEmpty()) {
            logger.error("format不能为空")
            return null
        } else localMap[format] ?: try {
            formatter(format).apply {
                localMap.putIfAbsent(format, this)
            }
        } catch (e: IllegalArgumentException) {
            logger.error("无效的format={}", format, e)
            null
        }
    }

    private fun formatter(format: String): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(format).withZone(ZoneId.systemDefault())
    }

    internal fun format8(date: ZonedDateTime?, format: String?): String? {
        return date?.let {
            getSdf(format)?.format(it)
        }
    }

    internal fun parse8(date: String?, format: String?): ZonedDateTime? {
        return date?.let {
            getSdf(format)?.let {
                try {
                    parse(it.parse(date))
                } catch (e: DateTimeParseException) {
                    logger.error("解析失败 date={}, format={}", date, format, e)
                    null
                } catch (e: DateTimeException) {
                    logger.error("解析失败 date={}, format={}", date, format, e)
                    null
                }
            }
        }
    }

    /**
     * 没有指定的字段，就用当前时间的字段代替
     */
    private fun parse(ta: TemporalAccessor): ZonedDateTime {
        val zone = ZoneId.from(ta)
        val hasYear = ta.isSupported(ChronoField.YEAR)
        val hasMonth = ta.isSupported(ChronoField.MONTH_OF_YEAR)
        val hasDay = ta.isSupported(ChronoField.DAY_OF_MONTH)
        val hasHour = ta.isSupported(ChronoField.HOUR_OF_DAY)
        val hasMinute = ta.isSupported(ChronoField.MINUTE_OF_HOUR)
        val hasSecond = ta.isSupported(ChronoField.SECOND_OF_MINUTE)
        val hasNano = ta.isSupported(ChronoField.NANO_OF_SECOND)

        var year = if (hasYear) ta.get(ChronoField.YEAR) else 0
        var month = if (hasMonth) ta.get(ChronoField.MONTH_OF_YEAR) else 0
        var day = if (hasDay) ta.get(ChronoField.DAY_OF_MONTH) else 0
        if (!hasYear || !hasMonth || !hasDay) {
            val localDate = LocalDate.now()
            if (!hasYear) {
                year = localDate.year
            }
            if (!hasMonth) {
                month = localDate.monthValue
            }
            if (!hasDay) {
                day = localDate.dayOfMonth
            }
        }
        var hour = if (hasHour) ta.get(ChronoField.HOUR_OF_DAY) else 0
        var minute = if (hasMinute) ta.get(ChronoField.MINUTE_OF_HOUR) else 0
        var second = if (hasSecond) ta.get(ChronoField.SECOND_OF_MINUTE) else 0
        var nano = if (hasNano) ta.get(ChronoField.NANO_OF_SECOND) else 0
        if (!hasHour || !hasMinute || !hasSecond || !hasNano) {
            val localTime = LocalTime.now()
            if (!hasHour) {
                hour = localTime.hour
            }
            if (!hasMonth) {
                minute = localTime.minute
            }
            if (!hasDay) {
                second = localTime.second
            }
            if (!hasDay) {
                nano = localTime.nano
            }
        }
        return ZonedDateTime.of(year, month, day, hour, minute, second, nano, zone)
    }
}

