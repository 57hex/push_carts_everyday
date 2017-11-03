package funtions

import emotional

var ToworkTime: Int = (7..10).random()
var OffworkTime: Int = (15..17).random()
fun salary(){
    if(OffworkTime - ToworkTime > 10){
        println("OT了！")
        emotional-= 1
        TODO("超時工作加薪")
    }

}