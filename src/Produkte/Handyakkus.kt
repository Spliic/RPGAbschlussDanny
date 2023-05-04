package Produkte

class Handyakkus(
    name: String,
    preis: Double,
    var anzahl : Int,):Ersatzteile(name,preis) {


    fun getAnleitungDisplay() {
        println("Ihre Anleitung")
        // TODO: Hier eine AnleitungAkkus aufrufen
    }


}