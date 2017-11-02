import classes.workersname
import funtions.*
import java.util.*

class AbilitySystem constructor (var pow:Int, var spd:Int, var luk:Int, var AP:Int)


var stamina = 100
var emotional = 5
var warrning = 0
var person = AbilitySystem((1..10).random(), (1..10).random(), (1..10).random(), (1..10).random())
var days = 1
/* data class Job constructor(val id:Int,)
var test = Job((1..10).random()) */
fun get():String {
    println("您的力量為 ${person.pow}，速度為 ${person.spd}， 運氣為 ${person.luk}，可使用能力值為 ${person.AP}")
    return String()
}
fun addAP(){

}
/*val timer = Timer()
fun timer(){

    timer.schedule(timerTask {get()}, 13000)

}*/

fun main(args: Array<String>) {
    var personname = "Wtson"
    workersname(personname).greet()
    workinginfo()
    println("$personname 在 $ToworkTime 點上班了！ ")
    println("打好卡，穿好制服，往賣場移動。")
    println("進入休息區時，檢查了一下推車區，剩下 ${cartsB1f} 台。")
    for (days in 1..100){
        println()
        println("今天是第 $days 天")
        println()
        println(getEmoWarr())
        println()
        println(get())
        println()
        for (inworkingtime in 1..8) {
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


        }
    }
}
