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
        println("OT了！")
        emotional -= 1
        DailySalary = ( ((OffworkTime - ToworkTime) - 8 ) * 2 * 133 ) + 8 * 133
        TotalSalary += DailySalary
        println("今天一共賺了 $DailySalary 元。")
    }
    else if(OffworkTime - ToworkTime <= 8){
        println("準時下班")
        emotional += 1
        DailySalary = (OffworkTime - ToworkTime) * 133
        TotalSalary += DailySalary
        println("今天一共賺了 $DailySalary 元。")
    }
}
fun GetYasumi() {
    Yasuminohi = (0..10).random()
}
fun workinginfo(){
    println("您的工作內容簡略來說，分成推推車、換補水、收籃子、數車位、開手扶梯、送貨、收籃子")
    println("在規定上，推車一次以推 12 台為主。")
    println("若超過此數量，被管理者見到的話會收警告單，或告知課長。")
    println("請您務必注意一個人同一個時間只能做一件事情。")
    println("薪水部分，133/hr ，七休二，每天工時以7小時為基準。")
    println("在工作之餘，由於主角是位大學生，所以必須要到學校上課。")
    println("主要介紹大概到這邊，請享受 :)")
}
fun gettheWork(){
    doinginworking = (1..10).random()
}

//--------------


//跟人物搭招呼
open class workersname(val name: String){
    fun greet() {
        println("$name, 開始上班囉！")
    }
}
//--------------





//-------  工作內容  -------
fun CheckandPushB1FCarts() {
    //工作時間
        getRandomCartsB1fcount()
        if (cartsB1f > 26) {
            println("推車滿多的，休息一下吧")
            emotional += 1
            getEmoWarr()
        } else if (cartsB1f < 25 && cartsB1f > 11) {
            println("推車有點少，被客人罵了")
            emotional -= 1
            getEmoWarr()
        } else if (cartsB1f < 10) {
            println("推車太少了，被客人罵然後收了一張警告單")
            warrning += 1
            emotional -= 1
            getEmoWarr()
        }
}
fun CheckandPush1FCarts() {
        getRandomCarts1fcount()
    if (carts1f > 40){
        println("推車滿多的，休息一下吧")
    } else if (carts1f < 20 && carts1f > 10){
        println("推車太少囉，被罵了。")
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
    println("目前警告單有 ${warrning} 張，心情值為 ${emotional}")
    if (emotional == 0){
        var getsometingspecial = (1..100).random()
        if (getsometingspecial % 7 == 0){
            println("心情太不好人生好難跑去自殺了")
        }else println("離職了")
        println("一共賺了 $TotalSalary 元。")
        exitProcess(1)
    }
    if(warrning == 50){
        println("被開除了，遊戲結束ㄌ")
        println("一共賺了 $TotalSalary 元。")
        exitProcess(1)
    }
    return String()
}
fun emotoGame(){
    TODO("實作心情對遊戲的影響")
}
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
//--------------

fun main(args: Array<String>) {
    var personname = "Wtson" // 人物名稱
    workersname(personname).greet() // 呼叫 workersname 傳入 personname 的值 實行 .greet 的方法
    workinginfo() // 呼叫 workinginfo 方法

    println("打好卡，穿好制服，往賣場移動。")
    println("進入休息區時，檢查了一下推車區，剩下 ${cartsB1f} 台。")
    for (days in 1..100) {   // 遊戲總共有 100 天， 所以 for 100 次
        println("今天是第 $days 天")
        println()
        println(getEmoWarr())
        println()
        GetYasumi() // 判斷今天是否休假
        println(get())
        println()  //每一天開始都會提醒是第幾天，提醒警告單與心情值、還有顯示能力值
        if (Yasuminohi % 3 == 0) { // 暫時用機率代替隨機休假
            println("今天休假")
            continue
        } else //如果沒有休假就從得到上班下班時間開始
            getWorkingTime()
        var inworkingtime = OffworkTime - ToworkTime
            println()
            println("$personname 在 $ToworkTime 點上班了！ ")
            println()
            gettheWork()
        do {
            when (doinginworking) {
                1 -> CheckandPushB1FCarts()
                2 -> CheckandPush1FCarts()
            }
            inworkingtime --

        }while (inworkingtime != 0)



        println("$personname 在 $OffworkTime 下班了！")
        addAP()
        salary() //日節薪水
        println()
        person.AP ++
    }
}
