package funtions

import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start
// 個人數值
data class Player constructor(private var pow:Int,private var spd:Int,private var luk:Int,private var AP:Int){
    fun getall(): String{
        return "Your power: ${this.pow}.Speed: ${this.spd}. Lucky: ${this.luk}. Ability Point: ${this.AP}"
    }
    fun getpow():Int{
        return this.pow
    }
    fun getspd():Int{
        return this.spd
    }
    fun getluk():Int{
        return this.luk
    }
    fun getnowAP():Int{
        return this.AP
    }
    private fun AddPow(pow: Int):Int{
        if (checkAPis0orNot() && pow > 0){ //避免增加AP被輸入負數
            if (this.AP - pow >= 0) {
                this.pow += pow
                this.AP -= pow
                return this.pow
            }
            else return 0
        }
        else
            return 0
    }
    private fun AddSpd(spd: Int):Int{
        if (checkAPis0orNot() && pow > 0) {
            if (this.AP - spd >= 0){
            this.spd += spd
            this.AP -= spd
            return this.spd
            }
            else return 0
        }
        else return 0
    }
    fun AddLuk(luk: Int):Int{
        if (checkAPis0orNot() && pow > 0) {
            if (this.AP - luk >= 0) {
                this.luk += luk
                this.AP -= luk
                return this.luk
            }
            else return 0
        } else return 0
    }
    fun checkAPis0orNot(): Boolean {
        if (this.AP < 5) {
            println("Your AP is less than 5, now your AP is ${this.AP} ")
            return true
        }
        if (this.AP <= 0){
            println("YOU DON'T HAVE ANY AP!")
            this.AP = 0 // 清空AP，避免有AP為負的情況發生
            return false
        }
        else return true
    }
    fun Randomnize(){
        this.pow = (0..10).random()
        this.spd = (0..10).random()
        this.luk = (0..10).random()
        this.AP = 10
    }
    fun AddWhat(x: Int, y: Int):String{
        when (x){
            0 -> AddPow(y)
            1 -> AddSpd(y)
            2 -> AddLuk(y)
            else -> println("you have to input a number which between 0~2")
        }
        if (y < 0){
            println("the input number should be a positive integer")
        }
        return this.getall()
    }

}
// 個人素質結束

//天數、警告、體力、心情系統
class daily constructor(private var days:Int, private var emotional:Int, private var warrning:Int, private var stamina: Int){
    
}

//天數、警告、體力、心情系統結束

fun main(args: Array<String>) {
    var Watson = Player(0,0,0,0).Randomnize()
}