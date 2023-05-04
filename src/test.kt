import Kunde.Kundenaccount
import Produkte.Handydisplays
import Produkte.Produktbewertung
import haendler.Haendleraccount

fun main() {

    var bewertung1 = Produktbewertung("User1",7,"War gut")
    var bewertung2 = Produktbewertung("User2",2,"Scheiße")
    var bewertung3 = Produktbewertung("User3",8,"War gdadawdut")

    var handyDisplay = Handydisplays("I Phone 14",139.99,100, listOf(bewertung1,bewertung2,bewertung3))
    var handyDisplay2 = Handydisplays("I Phone 13", 89.99 ,100, listOf(bewertung1,bewertung2,bewertung3))

    var produktListe = mutableListOf(handyDisplay,handyDisplay2)

    println("""
        Diese Handydisplays sind auf Lager!
        Artikel 1:${produktListe[0].name},${produktListe[0].preis},${produktListe[0].anzahl}
        Artikel 2:${produktListe[1].name},${produktListe[1].preis},${produktListe[1].anzahl}
    """.trimIndent())
    produktListe[0].anzahl -= 1
    println("""
        Diese Handydisplays sind auf Lager!
        Artikel 1:${produktListe[0].name},${produktListe[0].preis},${produktListe[0].anzahl}
        Artikel 2:${produktListe[1].name},${produktListe[1].preis},${produktListe[1].anzahl}
    """.trimIndent())

    println("""
        Welche Anleitung wollen sie sich anzeigen lassen?
        Anleitung1: ${produktListe[0].name}
        Anleitung2: ${produktListe[1].name}
        Geben sie 1 oder 2 ein:
    """.trimIndent())
    var inputAnleitung = readln()
    produktListe[inputAnleitung.toInt() - 1].getAnleitungDisplay()









}