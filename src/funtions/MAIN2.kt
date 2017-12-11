package functions

import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start
// 個人數值
data class player constructor(private var pow:Int,private var spd:Int,private var luk:Int,private var AP:Int){
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
    fun Addpow(pow: Int):Int{
        if (checkAPis0orNot()){
            if (this.AP - pow >= 0) {
                this.pow += pow
                return this.pow
            }
            else return 0
        }
        else
            return 0
    }
    fun Addspd(spd: Int):Int{
        if (checkAPis0orNot()) {
            if (this.AP - spd >= 0){
            this.spd += spd
            return this.spd
            }
            else return 0
        }
        else return 0
    }
    fun Addluk(luk: Int):Int{
        if (checkAPis0orNot()) {
            if (this.AP - luk >= 0) {
                this.luk -= luk
                return this.luk
            }
            else return 0
        }
        else return 0
    }
    fun checkAPis0orNot(): Boolean {
        if (this.AP < 5) {
            println("Your AP is less than 5, now your AP is ${this.AP} ")
            return true
        }
        if (this.AP <= 0){
            println("YOU DON'T HAVE ANY AP!")
            return false
        }
        else return true
    }
    fun randomnize(){
        this.pow = (0..10).random()
        this.spd = (0..10).random()
        this.luk = (0..10).random()
        this.AP = 10
    }
    fun AddWhat(x: Int, y: Int):String{
        when (x){
            0 -> Addpow(y)
            1 -> Addspd(y)
            2 -> Addluk(y)
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
    var Watson = player(0,0,0,0)
}