class Ability(var pow: Int,var spd: Int,var luk: Int, var AbilityPoint: Int){
    fun firsttimerandom() {
        pow = (4..15).random()
        spd = (4..15).random()
        luk = (4..15).random()
        AbilityPoint = 4
    }
    fun get() {
        println("您的力量為$pow 速度為$spd 運氣為$luk 可使用能力值為$AbilityPoint")
    }
    fun getAbilityPoint() {
        AbilityPoint += (1..3).random()
        println("您現在可使用的能力值為$AbilityPoint")
    }

}