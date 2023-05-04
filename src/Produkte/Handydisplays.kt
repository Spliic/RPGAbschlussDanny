package Produkte

class Handydisplays(
    name: String,
    preis: Double,
    var anzahl: Int,
    val bewertungen: List<Produktbewertung>
) : Ersatzteile(name, preis) {



    fun getAnleitungDisplay() {
        println("Ihre Anleitung")
        // TODO: Hier eine Anleitung aufrufen
    }

}