import helden.Bogenschütze
import helden.Krieger
import helden.Magier


fun main() {


    var magier = Magier("Kael",100)
    var krieger = Krieger("Barbar",100)
    var bogenschuetze = Bogenschütze("Pikantenuss",100)

    for (spell in magier.spells){
        println(spell.name)
    }
    println()
    for (spell in krieger.spells){
        println(spell.name)
    }
    println()

    val attack = bogenschuetze.spells.random()
    println("Der Bogenschütze greift mit ${attack.name} an und macht ${attack.strengh} schaden")


}