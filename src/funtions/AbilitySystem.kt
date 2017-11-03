package funtions

import person
import java.util.*

class AbilitySystem constructor (var pow:Int, var spd:Int, var luk:Int, var AP:Int) // 能力系統，pow 力量 spd 速度 Int 幸運 AP 技能點。

fun get():String {
    println("您的力量為 ${person.pow}，速度為 ${person.spd}， 運氣為 ${person.luk}，可使用能力值為 ${person.AP}")
    return String()
} // 取得人物素質
fun addAP(){
    val input = Scanner(System.`in`)
    println("請輸入要增加的能力，力量為1，速度為2，運氣為3")
    var id = input.nextInt()
    when (id) {
        1 -> person.pow ++
        2 -> person.spd ++
        3 -> person.luk ++
    }
    person.AP --
    get() //呼叫get()傳回當前能力值
}
