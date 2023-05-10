package Produkte

class Handyakkus(name: String, preis: Double, anzahl: Int, bewertung: String) :Ersatzteile(name, preis, anzahl,
    bewertung
) {


    fun preisAendern(neuerpreis: Double){
        this.preis = neuerpreis

    }

    fun anzahlAendern(anzahlVerkaufte: Int){

        this.preis = this.preis - anzahlVerkaufte
    }


}