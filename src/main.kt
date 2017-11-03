import classes.workersname
import funtions.*

var stamina = 100 // 體力值
var emotional = 5 // 心情值
var warrning = 0  // 警告單數量
var person = AbilitySystem((1..10).random(), (1..10).random(), (1..10).random(), 4) // 人物素質初始化
var days = 1 // 天數
//data class Job constructor(val id:Int)
//TODO("補上職業")
//TODO("補上隨機休假功能")

fun timer(){
    TODO("加上每天延遲的功能")
   // timer.schedule(timerTask {get()}, 13000)

}

fun main(args: Array<String>) {
    var personname = "Wtson" // 人物名稱
    workersname(personname).greet() // 呼叫 workersname 傳入 personname 的值 實行 .greet 的方法
    workinginfo() // 呼叫 workinginfo 方法

    println("打好卡，穿好制服，往賣場移動。")
    println("進入休息區時，檢查了一下推車區，剩下 ${cartsB1f} 台。")
    for (days in 1..100){   // 遊戲總共有 100 天， 所以 for 100 次
        getWorkingTime()
        println()
        println("今天是第 $days 天")
        println()
        println(getEmoWarr())
        println()
        println("$personname 在 $ToworkTime 點上班了！ ")
        println()
        println(get())
        println()  //每一天開始都會提醒是第幾天，提醒警告單與心情值、還有顯示能力值
        var inworkingtime = OffworkTime - ToworkTime

        do  { //工作時間
            if (cartsB1f > 26){
                println("推車滿多的，休息一下吧")
                emotional += 1
                getEmoWarr()
            }
            else if(cartsB1f < 25 && cartsB1f >11){
                println("推車有點少，被客人罵了")
                emotional -= 1
                getEmoWarr()
            }
            else if (cartsB1f < 10){
                println("推車太少了，被客人罵然後收了一張警告單")
                warrning += 1
                emotional -= 1
                getEmoWarr()
            }
            inworkingtime --

        } while (inworkingtime != 0)
        println("$personname 在 $OffworkTime 下班了！")
        salary() //日節薪水
    }
    println("一共賺了 $TotalSalary 元")
}
