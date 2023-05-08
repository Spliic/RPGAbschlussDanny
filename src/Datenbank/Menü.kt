package Datenbank
import CYAN
import Kunde.Accountverwaltung
import LoginUndLogout.LoginUndLogout
import Produkte.Ersatzteile
import Produkte.Handydisplays
import RESET

class Menü {

    var zugriffZurDatenbank = Datenbank()
    var zugriffLogOut = LoginUndLogout()



    fun menueUser():Boolean {

        val produktUser = Menü()
        val reparaturAnleit = Menü()
        val reparaturShop = Menü()
        val accountFromUser = Accountverwaltung()
        val userLogOut = LoginUndLogout()

        println(
            """
            ${CYAN}Hier kommt das weitere Menü,
            Was möchten sie hier tun?$RESET
            [1] Produkte Anzeigen
            [2] Reparatur Anleitung Anzeigen
            [3] Dein Reparatur Shop in der Nähe
            [4] Accountverwaltung
            [5] Ausloggen
            Bitte Wählen sie eine Zahl von 1-5 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputNewMenue = readln().toInt()
        var loggedIn = true

        when (userInputNewMenue) {
            1 -> produktUser.productUser()
            2 -> reparaturAnleit.reparaturAnleitung()
            3 -> reparaturShop.reparaturShop()
            4 -> accountFromUser.accountUserVerwaltung()
            5 -> loggedIn = userLogOut.logOutUser()
        }
        return loggedIn
    }

    fun productUser():Boolean {
        var login = true
        println(
            """
            ${CYAN}Wir haben Folgende Produkte zur auswahl:$RESET
            [1] Handy Displays 
            [2] Handy Akkus 
            [3] Handy Werkzeug 
            [4] Ausloggen
            Bitte Wählen sie eine Zahl von 1-4 (Mit Enter bestätigen)
        """.trimIndent())
        var userInputNewMenue2 = readln().toInt()
        when (userInputNewMenue2) {
            1 -> zugriffZurDatenbank.displayAnzeigeLassen()
            2 -> zugriffZurDatenbank.akkuAnzeigenLassen()
            3 -> zugriffZurDatenbank.sonstigesWerkzeugAnzeigenLassen()
            4 -> login = zugriffLogOut.logOutUser()
        }
        return login


    }

    fun reparaturAnleitung() {

    }

    fun reparaturShop() {

    }




}

