package helden
import spells.Attack

// Eine klasse der von der klasse Held erbt
class Krieger(name: String, hp: Int): Held(name, hp) {

    var spells = listOf<Attack>()
    init {
        var warriorAttackOne = Attack("Klingenschlag", 35)
        var warriorAttackTwo = Attack("Klinge der Urahnen",25)
        var warriorAttackThree = Attack("Wütender Ansturm",40)
        var warriorAttackFour = Attack("Angriff-Steigerrer",10)

        var spellList = listOf(warriorAttackOne,warriorAttackTwo,warriorAttackThree,warriorAttackFour)
        this.spells = spellList
    }
}