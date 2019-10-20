package jp.arithmath.task.logback

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply

class CustomFilter: Filter<ILoggingEvent>() {
    val regexp = ".*TARGET.*".toRegex()
    override fun decide(event: ILoggingEvent?): FilterReply {
        if (event == null) {
            return FilterReply.NEUTRAL
        }
//        println("[FILTER] formattedMessage: " + event.formattedMessage)
//        println("[FILTER] message         : " + event.message)
////        println("[FILTER] argumentArray   : " + event.argumentArray.toString())
//        println("[FILTER] callerData      : " + event.callerData.toString())
//        println("[FILTER] level           : " + event.level)
//        println("[FILTER] loggerContextV0 : " + event.loggerContextVO.toString())
//        println("[FILTER] loggerName      : " + event.loggerName.toString())

        if (!arrayOf(Level.WARN, Level.ERROR).contains(event.level)) {
//            println("level is mismatch")
            return FilterReply.NEUTRAL
        }
        if (regexp.containsMatchIn(event.message)) {
//            println("regexp match")
            return FilterReply.DENY
        } else {
//            println("regexp unmatch")
            return FilterReply.NEUTRAL
        }
    }
}