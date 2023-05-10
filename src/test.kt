import Datenbank.Datenbank
import Produkte.Handydisplays

fun main() {

    var test = Datenbank()

    test.ersatzTeilSortimentDisplay.add(Handydisplays("iPhone 14 Display",139.99,10,""))

    warenkorb.add(Handydisplays("iPhone 14 Display",139.99,10,""))
    test.bestandReduzieren()
}