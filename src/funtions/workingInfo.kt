package funtions

fun workinginfo(){
    println("您的工作內容簡略來說，分成推推車、換補水、收籃子、數車位、開手扶梯、送貨、收籃子")
    println("在規定上，推車一次以推 12 台為主。")
    println("若超過此數量，被管理者見到的話會收警告單，或告知課長。")
    println("請您務必注意一個人同一個時間只能做一件事情。")
    println("薪水部分，133/hr ，七休二，每天工時以7小時為基準。")
    println("在工作之餘，由於主角是位大學生，所以必須要到學校上課。")
    println("主要介紹大概到這邊，請享受 :)")
}
var doinginworking: Int = 0
fun gettheWork(){
    doinginworking = 1
}
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