package Produkte
import CYAN
import Datenbank.Datenbank
import Kunde.Accountverwaltung
import LoginUndLogout
import RESET

class Menü : Datenbank() {


    fun menueUser() {

        val produktUser = Menü()
        val reparaturAnleit = Menü()
        val reparaturShop = Menü()
        val accountFromUser = Accountverwaltung()
        val userLogOut = LoginUndLogout()

        println(
            """
            Hier kommt das weitere Menü
            Was möchten sie hier tun?
            $CYAN[1] Produkte Anzeigen $RESET
            [2] Reparatur Anleitung Anzeigen
            [3] Dein Reparatur Shop in der Nähe
            [4] Accountverwaltung
            [5] Ausloggen
            Bitte Wählen sie eine Zahl von 1-5 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputNewMenue = readln().toInt()
        when (userInputNewMenue) {
            1 -> produktUser.productUser()
            2 -> reparaturAnleit.reparaturAnleitung()
            3 -> reparaturShop.reparaturShop()
            4 -> accountFromUser.accountUserVerwaltung()
            5 -> userLogOut.logOutUser()
        }
    }

    fun productUser() {


        println(
            """
            Wir haben Folgende Produkte zur auswahl:
            [1] Handy Displays
            [2] Handy Akkus
            [3] Handy Werkzeug
            [4] Sonstige Handyteile
            [5] Ausloggen
            Bitte Wählen sie eine Zahl von 1-5 (Mit Enter bestätigen)
        """.trimIndent())
        var userInputNewMenue = readln().toInt()
        when (userInputNewMenue) {
        }

    }

    fun reparaturAnleitung() {

    }

    fun reparaturShop() {

    }

}