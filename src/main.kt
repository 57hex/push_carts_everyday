import java.util.Scanner
fun workinginfo(){
    println("您的工作內容簡略來說，分成推推車、換補水、收籃子、數車位、開手扶梯、送貨、收籃子")
    println("在規定上，推車一次以推 12 台為主。")
    println("若超過此數量，被管理者見到的話會收警告單，或告知課長。")
    println("請您多多注意您的角色的能力值、心情，也請您務必注意一個人同一個時間只能做一件事情。")
    println("薪水部分，133/hr ，七休二，每天工時以7小時為基準。")
    println("在工作之餘，由於主角是位大學生，所以必須要到學校上課。")
    println("主要介紹大概到這邊，請享受 :)")
}

class loucengshu(){
    var sankai = 108
    var yonkai = 109
    var gokai = 108
    var chikanikai = 170

}
class week(){}

fun main(args: Array<String>) {
    println("請輸入角色名稱")
    val nameinput = Scanner(System.`in`)
    workersname(nameinput.next()).greet()
    workinginfo()
    println()
}