package funtions

import java.util.*

class AbilitySystem constructor (var pow:Int, var spd:Int, var luk:Int, var AP:Int) // 能力系統，pow 力量 spd 速度 Int 幸運 AP 技能點。

fun get():String {
    println("您的力量為 ${person.pow}，速度為 ${person.spd}， 運氣為 ${person.luk}，可使用能力值為 ${person.AP}")
    return String()
} // 取得人物素質
fun addAP(){
    val input = Scanner(System.`in`)
    if (person.AP > 0) {
        println("請輸入要增加的能力，力量為1，速度為2，運氣為3。")
        var id = input.nextInt()
        if(person.AP > 0) {
            when (id) {
                1 -> person.pow++
                2 -> person.spd++
                3 -> person.luk++
                else -> println("請重新輸入")
            }
        } else println("沒有技能點了！")
        //TODO("還是沒辦法觸發else裡面的條件")

    }

    if (person.AP >= 1) person.AP --
    get() //呼叫get()傳回當前能力值
}
