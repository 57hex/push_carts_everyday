package funtions

import classes.workersname
import funtions.*
import sun.jvmstat.monitor.LongMonitor
import java.util.*
var stamina = 100 // 體力值
var emotional = 5 // 心情值
var warrning = 0  // 警告單數量
var person = AbilitySystem((1..10).random(), (1..10).random(), (1..10).random(), 4) // 人物素質初始化
var days = 1 // 天數
//data class Job constructor(val id:Int)
//TODO("補上職業")
//TODO("補上每天工作內容")


fun main(args: Array<String>) {
    var personname = "Wtson" // 人物名稱
    workersname(personname).greet() // 呼叫 workersname 傳入 personname 的值 實行 .greet 的方法
    workinginfo() // 呼叫 workinginfo 方法
    println("打好卡，穿好制服，往賣場移動。")
    println("進入休息區時，檢查了一下推車區，剩下 ${cartsB1f} 台。")
    for (days in 1..100) {   // 遊戲總共有 100 天， 所以 for 100 次
        println("今天是第 $days 天")
        println()
        println(getEmoWarr())
        println()
        GetYasumi() // 判斷今天是否休假
        println(get())
        println()  //每一天開始都會提醒是第幾天，提醒警告單與心情值、還有顯示能力值
        if (Yasuminohi % 3 == 0) { // 暫時用機率代替隨機休假
            println("今天休假")
            continue
        } else //如果沒有休假就從得到上班下班時間開始
            getWorkingTime()
        var inworkingtime = OffworkTime - ToworkTime
            println()
            println("$personname 在 $ToworkTime 點上班了！ ")
            println()
            gettheWork()
        do {
            when (doinginworking) {
                1 -> CheckandPushB1FCarts()
                2 -> CheckandPush1FCarts()
            }
            inworkingtime --

        }while (inworkingtime != 0)



        println("$personname 在 $OffworkTime 下班了！")
        addAP()
        salary() //日節薪水
        println()
        person.AP ++
    }
}


