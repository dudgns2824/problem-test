package kr.co.hmcnetworks.backoffice.commons.core.util

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.*

class DateUtil {
    companion object {
        private val dateTimeFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        // val zoneId = ZoneId.systemDefault()
        // val zoneId = ZoneId.of("Asia/Seoul")
        private val zoneId = ZoneId.of("UTC")

        fun lastDayOfMonth(yy: Int, mm: Int): Int {
            val localDate = LocalDateTime.of(yy, mm, 1, 1, 1)
                .with(TemporalAdjusters.lastDayOfMonth())
            return localDate.dayOfMonth
        }

        fun lastDayOfMonth(yymm: String, delimiters: String = "-"): Int {
            val arrYymm = yymm.split(delimiters)
            return this.lastDayOfMonth(arrYymm[0].toInt(), arrYymm[1].toInt())
        }

        fun toDisplayName(yy: Int, mm: Int, dd: Int): String {
            val localDate = LocalDate.of(yy, mm, dd)
            return localDate.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN)
        }

        fun toYmdPattern(ymdStr: String, patternStr: String = "d일(E)"): String {
            return LocalDate.parse(ymdStr)
                .format(
                    DateTimeFormatter.ofPattern(patternStr)
                        .withLocale(Locale.forLanguageTag("ko"))
                )
        }

        /** instant to localDateTime */
        fun toLocalDateTime(req: Instant): LocalDateTime = LocalDateTime.ofInstant(req, zoneId)

        /** localDate to instant */
        fun toInstant(req: LocalDate): Instant = req.atStartOfDay(zoneId).toInstant()
        fun toInstant(req: LocalDateTime): Instant = req.atZone(zoneId).toInstant()

        /** add startTime : 00:00:00 */
        fun withStartTime(req: String): LocalDateTime {
            if (!"""^\d{4}-\d{2}-\d{2}$"""
                    .toRegex().matches(req.toString() as CharSequence)
            ) {
                return LocalDateTime.parse(
                    "${LocalDate.now()} 00:00:00",
                    dateTimeFormatter
                )
            } // error시 오늘 일자로 반환

            return LocalDateTime.parse("$req 00:00:00", dateTimeFormatter)
        }

        /** add startTime : 23:59:59 */
        fun withEndTime(req: String): LocalDateTime {
            if (!"""^\d{4}-\d{2}-\d{2}$"""
                    .toRegex().matches(req.toString() as CharSequence)
            ) {
                return LocalDateTime.parse(
                    "${LocalDate.now()} 23:59:59",
                    dateTimeFormatter
                )
            }

            return LocalDateTime.parse("$req 23:59:59", dateTimeFormatter)
        }

        /** ymd list 반환 */
        fun rangeYmdToList(startYmd: LocalDate, endYmd: LocalDate) = generateSequence(startYmd) {
            it.plusDays(1)
        }
            .takeWhile { it <= endYmd }
            .toList()
    }
}
