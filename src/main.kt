import java.util.Scanner
import kotlin.system.exitProcess

fun workinginfo(){
    println("您的工作內容簡略來說，分成推推車、換補水、收籃子、數車位、開手扶梯、送貨、收籃子")
    println("在規定上，推車一次以推 12 台為主。")
    println("若超過此數量，被管理者見到的話會收警告單，或告知課長。")
    println("請您務必注意一個人同一個時間只能做一件事情。")
    println("薪水部分，133/hr ，七休二，每天工時以7小時為基準。")
    println("在工作之餘，由於主角是位大學生，所以必須要到學校上課。")
    println("主要介紹大概到這邊，請享受 :)")
}
class week(){}

fun main(args: Array<String>) {
    var warrning = 0
    var emotional = 5
    var ontime = (8..10).random()
    var personname = "Wtson"
    workersname(personname).greet()
    workinginfo()
    println("$personname 在 $ontime 點上班了！ ")
    println("打好卡，穿好制服，往賣場移動。")
    println("進入休息區時，檢查了一下推車區，剩下 $cartsB1f 台。")
    if(cartsB1f > 30){
        println("再休息一下吧")
        emotional += 1
        if (emotional > 6){
            println("現在心情很好")
        }
    }
    else if (cartsB1f < 29 && cartsB1f > 16){
        println("要準備出發去收車了")
    }
    else if (cartsB1f < 15){
        println("車子快沒囉，客人快要沒車用了，收一張警告單。")
        warrning += 1
        emotional -= 1
        if (emotional < 4){
            println("現在心情不太好")
        }
        else if (warrning > 10){
            println("被開除了")
            exitProcess(1)
        }
    }

}
