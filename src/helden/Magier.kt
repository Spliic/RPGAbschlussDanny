package helden
import spells.Attack


// Eine klasse der von der klasse Held erbt
class Magier(name: String, hp: Int) : Held(name, hp) {

    var spells = listOf<Attack>()
    init {
        var mageAttackOne = Attack("Feuerball", 25)
        var mageAttackTwo = Attack("TeamHeal",35)
        var mageAttackThree = Attack("Meteor",45)
        var spellList = listOf(mageAttackOne,mageAttackTwo,mageAttackThree)
        this.spells = spellList
    }

}