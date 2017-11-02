import java.util.Random
class workersname(val name: String){
    fun greet() {
        println("$name, 開始上班囉！")
    }
}
fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start
fun workinginfo(){
    println("您的工作內容簡略來說，分成推推車、換補水、收籃子、數車位、開手扶梯、送貨、收籃子")
    println("在規定上，推車一次以推 12 台為主。")
}
fun nenglisystem(){
    var pow = (3..15).random()
    var speed = (3..15).random()
    var luk = (3..15).random()
    println("以下是您的初始能力值")
    print("力量：$pow")
    print("速度: $speed")
    print("運氣: $luk")
}
class loucengshu(){
    var sankai = 108
    var yonkai = 109
    var gokai = 108
    var chikanikai = 170
    
}
fun main(args: Array<String>) {
    workersname("json").greet()
    workinginfo()
}