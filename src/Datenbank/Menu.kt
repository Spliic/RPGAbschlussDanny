package Datenbank
import CYAN
import Kunde.Accountverwaltung
import LoginUndLogout.LoginUndLogout
import RESET

class Menu {

    var zugriffZurDatenbank = Datenbank()
    var zugriffLogOut = LoginUndLogout()
    var zugriffAccount = Accountverwaltung()



    /*
    Die Funktion "menueUser" zeigt dem Benutzer ein Menü mit verschiedenen Optionen, die er wählen kann.
    Die Funktion ruft dann je nach Auswahl des Benutzers andere Funktionen auf,
     */
    fun menueUser():Boolean {


        val accountFromUser = Accountverwaltung()
        val userLogOut = LoginUndLogout()



        println(
            """
            ${CYAN}Hier kommt das weitere Menü,
            Was möchten sie hier tun?$RESET
            [1] Produkte Anzeigen
            [2] Reparatur Anleitung Anzeigen
            [3] Accountverwaltung
            [4] Mein Warenkorb ansehen
            [5] Ausloggen
            Bitte Wählen sie eine Zahl von 1-5 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputNewMenue = readln().toInt()
        var loggedIn = true

        when (userInputNewMenue) {
            1 -> productUser()
            2 -> {
                zugriffZurDatenbank.reparaturAnleitung()
                menueUser()
            }
            3 -> accountFromUser.accountUserVerwaltung()
            4 -> zugriffZurDatenbank.warenkorbAnzeigen()
            5 -> loggedIn = userLogOut.logOutUser()

        }
        return loggedIn
    }


    /*
    Die Funktion productUser() zeigt dem Benutzer die verschiedenen Produktkategorien zur Auswahl
    und gibt je nach Eingabe des Benutzers die passende Produktkategorie aus.
     */
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
            1 -> {
                zugriffZurDatenbank.displayAnzeigeLassen()
                menueUser()
            }
            2 -> {
                zugriffZurDatenbank.akkuAnzeigenLassen()
                menueUser()
            }
            3 -> {
                zugriffZurDatenbank.sonstigesWerkzeugAnzeigenLassen()
                menueUser()
            }
            4 -> login = zugriffLogOut.logOutUser()
        }
        return login


    }


    /*
    Diese Funktion stellt dem Benutzer ein Menü zur Verfügung, um aus verschiedenen Zahlungsoptionen auszuwählen.
    Der Benutzer kann auswählen, ob er seine Produkte bezahlen oder seinen Warenkorb leeren möchte.
    Außerdem kann der Benutzer zum Hauptmenü zurückkehren oder sich ausloggen.
     */
    fun zahlungsMenu(){
        println(
            """
            ${CYAN}Was Wollen sie als Nächstes tun?$RESET
            [1] Produkte Bezahlen 
            [2] Warenkorb leeren
            [3] Zurück zum Menü
            [4] Logout
            Bitte Wählen sie eine Zahl von 1-4 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var inputZahlungsMenu = readln().toInt()
        when (inputZahlungsMenu) {
            1 -> {
                zugriffAccount.zahlungCheckout(zugriffZurDatenbank)
                menueUser()
            }
            2 -> {
                zugriffZurDatenbank.warenkorbLeeren()
                menueUser()
            }
            3 -> menueUser()
        }
    }


    /*
    In dieser Funktion wird das Menü für Händler angezeigt.
    Der Händler hat die Möglichkeit, zwischen vier Optionen zu wählen: Produkte bestellen, Produkte hinzufügen, Produkte löschen und ausloggen.
     */
    fun haendlerMenu(): Boolean{
        var haendlerLoggin = true

        println(
            """
            ${CYAN}Hier kommt das weitere Menü,
            Was möchten sie hier tun?$RESET
            [1] Produkte Bestellen
            [2] Produkte Hinzufügen
            [3] Produkte Löschen
            [4] Ausloggen
            Bitte Wählen sie eine Zahl von 1-4 (Mit Enter bestätigen)
        """.trimIndent())
        var haendlerInputMenu = readln().toInt()

        when (haendlerInputMenu){
            1 -> zugriffZurDatenbank.haendlerBestellung()
            2 -> zugriffZurDatenbank.haendlerHinzufugen()
            3 -> zugriffZurDatenbank.haendlerLoeschen()
            4 -> zugriffLogOut.logOutUser()
        }
        return haendlerLoggin


    }


}