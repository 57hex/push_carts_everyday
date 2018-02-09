import java.util.*

import kotlin.system.exitProcess


fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
// 隨機function
//-------  推車總數、來客數、時間 -------


class Carts constructor(var carts5f: Int, var carts4f: Int, var carts3f: Int, var carts2f: Int, var carts1f: Int, var cartsB1f: Int, var cartsB2f: Int)

var customer = 0
var clock = 0
var carts = Carts(0, 0, 0, 0, 0, 0, 0)


//--------------


//-------  停車場空位總數 -------
class Parking constructor(var threefloor_parking: Int, var fourfloor_parking: Int, var fivefloor_parking: Int, var B2floor_parking: Int)

var parking = Parking(108, 109, 108, 170)
//--------------


//-------  體力、心情、警告單、天數  --------


var stamina = 100 // 體力值
var emotional = 5 // 心情值
var warrning = 0  // 警告單數量


//--------------


//-------  能力值 -------

open class AbilitySystem constructor(var pow: Int, var spd: Int, var luk: Int, var AP: Int) // 能力系統，pow 力量 spd 速度 Int 幸運 AP 技能點。

var person = AbilitySystem((1..10).random(), (1..10).random(), (1..10).random(), 4) // 人物素質初始化
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


//取得工時、薪資、判斷休假日、工作內容、上班要做的事情、星期幾


fun getWorkingTime() {
    ToworkTime = (7..10).random()
    OffworkTime = (15..17).random()
}

fun salary() {
    if (OffworkTime - ToworkTime > 8) {
        println("下班囉！")
        emotional -= 1
        DailySalary = (((OffworkTime - ToworkTime) - 8) * 2 * 133) + 8 * 133
        TotalSalary += DailySalary
        println("今天總共賺了:$DailySalary 元")
    } else if (OffworkTime - ToworkTime <= 8) {
        println("準時下班,奇蹟!")
        emotional += 1
        DailySalary = (OffworkTime - ToworkTime) * 133
        TotalSalary += DailySalary
        println("今天總共賺了:$DailySalary 元")
    }
}

fun getyasumi() {
    Yasuminohi = (0..10).random()
}

fun workinginfo() {
    println(" 你的工作是：移動車車、換水、收籃子、數停車位(why?)、開手扶梯、送包裹 ")
    println(" 根據過勞法(?)規定,一次只能移動12輛車車 ")
    println(" 如果主管看到你違反規則,你就準備吃單子,不然就是被往上呈報 ")
    println(" 記住,一次一件事 ")
    println(" 薪水為133/時,做七休二,一天七小")
    println("而且你晚上還要上課")
    println("這就是全部了,玩得愉快\n")
}

fun gettheWork() {
    doinginworking = (1..10).random()
}

//--------------


//跟人物搭招呼
class Workersname(val name: String) {
    fun greet() {
        println("$name,該當社畜啦")
    }
}
//--------------


fun rest() {
    println("推車足夠了,休息吧\n")
    emotional += 1
}


fun ask() {
    val input = Scanner(System.`in`)
    println("要不要補車車?\n")
    val decide = input.nextInt()
    when (decide) {
        1 -> pushb1carts()
        2 -> println("勞資不推啦!\n")
    }
}


fun abilitydown() {
    person.pow--
    person.spd--
    person.luk--
}


fun hope() {
    println("你更有精神的面對每一天的工作,所有能力皆上升了")
    person.pow++
    person.spd++
    person.luk++
}


fun b1f1() {
    println("推車太少了,被抱怨了,還拿到了警告\n")
    emotional--
    warrning++
    ask()
}

fun b1f2() {
    println("推車有點少,被抱怨了\n")
    emotional--
    ask()
}


fun firstf1() {
    println("推車太少,被抱怨了\n")
    emotional--
    warrning++
    ask()
}


fun addpow() {
    person.pow++
    person.AP--
}


fun addspd() {
    person.spd++
    person.AP--
}


fun addluk() {
    person.luk++
    person.AP--
}

//-------  工作內容  -------
fun checkandpushb1fcarts() {
    //工作時間
    when (carts.cartsB1f) {
        in 0..11 -> b1f1()
        in 12..25 -> b1f2()
        else -> rest()
    }
}

fun checkandpush1fcarts() {

    when (carts.carts1f) {
        in 11..19 -> firstf1()
        else -> rest()
    }
}

//--------------
//-------  延時器 -------


//--------------

// ------- 隨機化推車數量、顧客 -------
fun getCustomerCount() {
    when (clock) {
        in 8..9 -> customer = (20..50).random()
        in 10..13 -> customer = (50..100).random()
        in 14..16 -> customer = (20..50).random()
        in 17..21 -> customer = (50..100).random()
        in 22..23 -> customer = (10..20).random()
    }
}

fun getSatSunCustomerCount() {
    when (clock) {
        in 8..9 -> customer = (40..70).random()
        in 10..13 -> customer = (70..120).random()
        in 14..16 -> customer = (40..70).random()
        in 17..21 -> customer = (70..120).random()
        in 22..23 -> customer = (30..50).random()
    }
}

fun getRandomCartsB1fCount() {
    carts.cartsB1f = (1..50).random()
}

fun getRandomCartsB2fCount() {
    carts.cartsB2f = (1..50).random()
}

fun getRandomCarts1fCount() {
    carts.carts1f = (50..200).random()
}

fun getRandomCarts2fCount() {
    carts.carts2f = (1..50).random()
}

fun getRandomCarts3ffCount() {
    carts.carts3f = (1..75).random()
}

fun getTotallyCartsCount() {
    carts.carts2f -= customer / (3..4).random()
    carts.carts1f -= customer / (3..4).random()
    carts.cartsB1f -= customer / (1..2).random()
}
//--------------

// -------- 推車功能  -------

fun pushb1carts() {
    carts.cartsB1f++
    stamina--
}

// -------- 檢查警告單、心情、獲取能力值、配點  -------

fun getEmoWarr(): String {
    println("你總共有:$warrning 張警告.你的心情為:$emotional")
    println("")
    if (emotional == 0) {
        val getsometingspecial = (1..100).random()
        if (getsometingspecial % 7 == 0) {
            println("你自殺了,幫你QQ")
        } else println("你離職了")
        println("總共賺了:$TotalSalary 元")
        exitProcess(1)
    }
    if (warrning == 50) {
        println("被炒魷魚了,GG")
        println("總共賺了:$TotalSalary 元")
        exitProcess(1)
    }
    return String()
}

fun emotoGame() {
    when (emotional) {
        in 1..5 -> println("你對這個世界不抱希望,你的能力下降了")
        in 1..5 -> abilitydown()
        in 6..10 -> println("你覺得有什麼事情不對勁,但是沒有甚麼事情發生")
        in 11..20 -> println("你覺得未來充滿希望,你的辛運上升了")
        in 11..20 -> person.luk++
        else -> hope()
    }
}

fun get(): String {
    println("---------------能力---------------")
    println("力量:${person.pow}. 速度:${person.spd}. 辛運:${person.luk}. 剩餘點數:${person.AP}")
    println("---------------------------------")
    return String()
} // 取得人物素質

fun addAP() {
    val input = Scanner(System.`in`)
    if (person.AP > 0) {
        println("輸入想升級的能力.")
        println("力量:[1]. 速度[2]. 辛運[3]")

        if (person.AP > 0) {
            while (true) {
                val id = input.nextInt()
                when (id) {
                    1 -> addpow()
                    2 -> addspd()
                    3 -> addluk()
                    else -> println("請重新輸入!")
                }
                if (id == 1 || id == 2 || id == 3) break
            }
        } else if (person.AP == 0) println("你沒有點數了!")
        //TODO("還是沒辦法觸發else裡面的條件")

    }

    if (person.AP >= 1) person.AP--
    get() //呼叫get()傳回當前能力值
}
//--------------
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    print("請告訴我你的名子:")
    val personname = input.nextLine()
    Workersname(personname).greet() // 呼叫 Workersname 傳入 personname 的值 實行 .greet 的方法
    workinginfo() // 呼叫 workinginfo 方法

    println("打卡了,穿上制服,進賣場面對奧客吧")
    println("檢查了推車區,剩下${carts.carts1f} 台")
    for (days in 1..100) {   // 遊戲總共有 100 天， 所以 for 100 次
        emotoGame()
        println("今天是第$days 天")
        when (days % 7) {
            1 -> println("星期一")
            2 -> println("星期二")
            3 -> println("星期三")
            4 -> println("星期四")
            5 -> println("星期五")
            6 -> println("星期六")
            0 -> println("星期日")
        }
        println()
        println(getEmoWarr())
        println()
        getyasumi() // 判斷今天是否休假
        println(get())
        println()  //每一天開始都會提醒是第幾天，提醒警告單與心情值、還有顯示能力值
        if (Yasuminohi % 3 == 0) { // 暫時用機率代替隨機休假
            println("放假休息啦")
            continue
        } else { //如果沒有休假就從得到上班下班時間開始
            getWorkingTime()
            var inworkingtime = OffworkTime - ToworkTime
            println()
            println("$personname 在$ToworkTime 點開始上班了 ")
            clock = ToworkTime
            println()
            if (Yasuminohi % 3 != 0 && (days % 7 != 6 || days % 7 != 7)) {
                do {
                    clock++
                    gettheWork()
                    getCustomerCount()
                    println("現在賣場裡有$customer 位客人")
                    when (doinginworking) {
                        1 -> {
                            checkandpushb1fcarts()
                        }
                        2 -> {
                            checkandpush1fcarts()
                        }
                        else -> println("迷路了")

                    }

                    println("剩餘時間:$inworkingtime 小時")
                    println()

                    inworkingtime--

                } while (inworkingtime != 0)
            }
        }
        println("$personname 在$OffworkTime 點下班了")
        addAP()
        salary() //日節薪水
        println()
        if (emotional > 10) {
            person.AP++
        }
    }
}