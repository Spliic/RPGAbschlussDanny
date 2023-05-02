package helden
import spells.Attack


// Eine klasse der von der klasse Held erbt
class Bogenschütze(name: String, hp: Int): Held(name, hp) {


    var spells = listOf<Attack>()
    init {
        var arrowAttackOne = Attack("Pfeil-Stoß", 30)
        var arrowAttackTwo = Attack("Mehrfachschuss",25)
        var arrowAttackThree = Attack("Ausweichschuss",40)
        var spellList = listOf(arrowAttackOne,arrowAttackTwo,arrowAttackThree)
        this.spells = spellList
    }
}