package funtions
import emotional
import warrning
import kotlin.system.exitProcess

fun getEmoWarr():String{
    println("目前警告單有 $warrning 張，心情值為 $emotional")
    if (emotional == 0){
        println("離職了")
        println("一共賺了 $TotalSalary 元。")
        exitProcess(1)
    }
    if(warrning == 10){
        println("被開除了，遊戲結束ㄌ")
        println("一共賺了 $TotalSalary 元。")
        exitProcess(1)
    }
    return String()
}
fun emotoGame(){
    TODO("實作心情對遊戲的影響")
}