class Ability constructor(var pow: Int,var spd: Int,var luk: Int, var AbilityPoint: Int){
    fun randomize() {
        pow = (4..15).random()
        spd = (4..15).random()
        luk = (4..15).random()
        AbilityPoint = (4..15).random()
    }
}
