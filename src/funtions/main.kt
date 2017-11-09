import java.util.*
import kotlin.system.exitProcess
fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start
// 隨機function
//-------  推車總數 -------


var carts5f = (1..10).random()
var carts4f = (1..20).random()
var carts3f = (10..30).random()
var carts2f = (10..50).random()
var carts1f = (20..80).random()
var cartsB1f = 0
var cartsB2f = (10..50).random()


//--------------


//-------  停車場空位總數 -------

var threefloor_parking = 108
var fourfloor = 109
var fivefloor = 108
var B2floor = 170

//--------------



//-------  體力、心情、警告單、天數  --------


var stamina = 100 // 體力值
var emotional = 5 // 心情值
var warrning = 0  // 警告單數量
var days = 1 // 天數


//--------------


//-------  能力值 -------


var person = AbilitySystem((1..10).random(), (1..10).random(), (1..10).random(), 4) // 人物素質初始化
open class AbilitySystem constructor (var pow:Int, var spd:Int, var luk:Int, var AP:Int) // 能力系統，pow 力量 spd 速度 Int 幸運 AP 技能點。
//data class Job constructor(val id:Int)
//TODO("補上職業")
//TODO("補上每天工作內容")


//--------------

//-------  工時、工資 -------


var doinginworking: Int = 0
var ToworkTime: Int = 0
var OffworkTime: Int = 0
var DailySalary: Int = (OffworkTime - ToworkTime) * 133
var TotalSalary: Int = DailySalary * 100
var Yasuminohi: Int = 0


//--------------


//取得工時、薪資、判斷休假日、工作內容、上班要做的事情

fun getWorkingTime(){
    ToworkTime = (7..10).random()
    OffworkTime = (15..17).random()
}
fun salary(){
    if(OffworkTime - ToworkTime > 8){
        println("Off work！")
        emotional -= 1
        DailySalary = ( ((OffworkTime - ToworkTime) - 8 ) * 2 * 133 ) + 8 * 133
        TotalSalary += DailySalary
        println("Today's earning: $DailySalary dollars")
    }
    else if(OffworkTime - ToworkTime <= 8){
        println("Off work on time!")
        emotional += 1
        DailySalary = (OffworkTime - ToworkTime) * 133
        TotalSalary += DailySalary
        println("Today's earning $DailySalary dollars")
    }
}
fun GetYasumi() {
    Yasuminohi = (0..10).random()
}
fun workinginfo(){
    println("Your job is:move barrows, change barrelled water, collect basket, count parking space, active escalator, deliver packages.")
    println("According to rule, you can only move 12 barrows once.")
    println("If supervisor see you against the rule, you'll get a ticket, or get report to Section Manager. ")
    println("Keep it in mind, you can only deal with one thing at a time.")
    println("The salary:133/hr, working seven days in a row and get two days off. Seven-hour work day")
    println("Since you study in night schoo, you have get to school on time.")
    println("That's all. Please enjoy.")
    println("")
}
fun gettheWork(){
    doinginworking = (1..10).random()
}

//--------------


//跟人物搭招呼
open class workersname(val name: String){
    fun greet() {
        println("$name, Time to work!")
    }
}
//--------------





//-------  工作內容  -------
fun CheckandPushB1FCarts() {
    //工作時間
    getRandomCartsB1fcount()
    if (cartsB1f > 26) {
        println("Find many barrows,time to rest")
        println("")
        emotional += 1
        getEmoWarr()
    } else if (cartsB1f < 25 && cartsB1f > 11) {
        println("The amount of barrows are a little bit small.")
        println("You was reproved by coustomer.")
        println("")
        emotional -= 1
        getEmoWarr()
    } else if (cartsB1f < 10) {
        println("Barrows were so small.")
        println("Argued by coustomer, and you've get one ticket.")
        println("")
        warrning += 1
        emotional -= 1
        getEmoWarr()
    }
}
fun CheckandPush1FCarts() {
    getRandomCarts1fcount()
    if (carts1f > 40){
        println("Find many barrows,time to rest.")
        println("")
    } else if (carts1f < 20 && carts1f > 10){
        println("Too little barrows,got blamed.")
        println("")
        emotional--
        getEmoWarr()
    }
}
//--------------
//-------  延時器 -------
fun timer(){
    TODO("加上每天延遲的功能")
    // funtions.timer.schedule(timerTask {get()}, 13000)
}
//--------------

// ------- 隨機化推車數量 -------
fun getRandomCartsB1fcount(){
    cartsB1f = (1..50).random()
}
fun getRandomCartsB2fcount(){
    cartsB2f = (1..50).random()
}
fun getRandomCarts1fcount(){
    carts1f = (1..50).random()
}
fun getRandomCarts2fcount(){
    carts2f = (1..50).random()
}
fun getRandomCarts3ffcount(){
    carts3f = (1..50).random()
}
//--------------

// -------- 檢查警告單、心情、獲取能力值、配點  -------

fun getEmoWarr():String{
    println("You've got ${warrning} tickets.Your emotion is: ${emotional}")
    println("")
    if (emotional == 0){
        var getsometingspecial = (1..100).random()
        if (getsometingspecial % 7 == 0){
            println("Your emotion were too bad,that makes you sucidie.")
        }else println("You quit your job.")
        println("Total earning: $TotalSalary dollars.")
        exitProcess(1)
    }
    if(warrning == 50){
        println("Get fired. GAME OVER")
        println("Total earning: $TotalSalary dollars.")
        exitProcess(1)
    }
    return String()
}
fun emotoGame(){
    TODO("實作心情對遊戲的影響")
}
fun get():String {
    println("Your power: ${person.pow}.Speed: ${person.spd}. Lucky: ${person.luk}. Avilable point: ${person.AP}")
    return String()
} // 取得人物素質
fun addAP(){
    val input = Scanner(System.`in`)
    if (person.AP > 0) {
        println("Please enter a ability that you want to imporve.")
        println("Power:[1]. Speed[2]. Lucky[3]")
        var id = input.nextInt()
        if(person.AP > 0) {
            when (id) {
                1 -> person.pow++
                2 -> person.spd++
                3 -> person.luk++
                else -> println("Re-enter number!")
            }
        } else println("You've got zero avilable point.")
        //TODO("還是沒辦法觸發else裡面的條件")

    }

    if (person.AP >= 1) person.AP --
    get() //呼叫get()傳回當前能力值
}
//--------------

fun main(args: Array<String>) {
    var personname = "Wtson" // 人物名稱
    workersname(personname).greet() // 呼叫 workersname 傳入 personname 的值 實行 .greet 的方法
    workinginfo() // 呼叫 workinginfo 方法

    println("Clock-in! Wear your uniform,move to mall.")
    println("Check barrows area, ${cartsB1f} left.")
    for (days in 1..100) {   // 遊戲總共有 100 天， 所以 for 100 次
        println("Today is day $days.")
        println()
        println(getEmoWarr())
        println()
        GetYasumi() // 判斷今天是否休假
        println(get())
        println()  //每一天開始都會提醒是第幾天，提醒警告單與心情值、還有顯示能力值
        if (Yasuminohi % 3 == 0) { // 暫時用機率代替隨機休假
            println("Days off.")
            continue
        } else //如果沒有休假就從得到上班下班時間開始
            getWorkingTime()
        var inworkingtime = OffworkTime - ToworkTime
        println()
        println("$personname clocked in at $ToworkTime! ")
        println()
        gettheWork()
        do {
            when (doinginworking) {
                1 -> CheckandPushB1FCarts()
                2 -> CheckandPush1FCarts()
            }
            inworkingtime --

        }while (inworkingtime != 0)



        println("$personname clocked out at $OffworkTime! ")
        addAP()
        salary() //日節薪水
        println()
        person.AP ++
    }
}