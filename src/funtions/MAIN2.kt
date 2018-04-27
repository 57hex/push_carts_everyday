package funtions

import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start

//天數、警告、體力、心情系統
class daily constructor(private var days:Int, private var emotional:Int, private var warrning:Int, private var stamina: Int){
    
}

//天數、警告、體力、心情系統結束

fun main(args: Array<String>) {
    var Watson = Player(0,0,0,0).Randomnize()

}