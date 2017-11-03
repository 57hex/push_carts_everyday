package funtions

import emotional
var ToworkTime: Int = 0
var OffworkTime: Int = 0
var DailySalary: Int = (OffworkTime - ToworkTime) * 133
var TotalSalary: Int = DailySalary * 100
fun getWorkingTime(){
    ToworkTime = (7..10).random()
    OffworkTime = (15..17).random()
}
fun salary(){
    if(OffworkTime - ToworkTime > 8){
        println("OT了！")
        emotional-= 1
        DailySalary = ( ((OffworkTime - ToworkTime) - 8 ) * 2 * 133 ) + 8 * 133
        TotalSalary += DailySalary
        println("今天一共賺了 $DailySalary 元。")
    }
    else if(OffworkTime - ToworkTime <= 8){
        println("準時下班")
        emotional+= 1
        DailySalary = (OffworkTime - ToworkTime) * 133
        TotalSalary += DailySalary
        println("今天一共賺了 $DailySalary 元。")
    }
}