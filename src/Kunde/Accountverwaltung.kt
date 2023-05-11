package Kunde
import CYAN
import Datenbank.Datenbank
import Datenbank.Menu
import LoginUndLogout.LoginUndLogout
import RESET

class Accountverwaltung: Datenbank() {


    /*
    Diese Funktion implementiert die Account-Verwaltung.
    Sie fordert den Benutzer auf, entweder eine Zahlungsmethode hinzuzufügen oder sich auszuloggen.
     */
    open fun accountUserVerwaltung(){

        var logout = LoginUndLogout()


        println(
            """
            ${CYAN}Was möchten sie hier tun?$RESET
            [1] Zahlungsmethode Hinzufügen
            [2] Ausloggen
            Bitte Wählen sie eine Zahl von 1-2 (Mit Enter bestätigen)
        """.trimIndent())

        var userinputInAccount = readln().toInt()

        when (userinputInAccount){
            1 -> zahlungsmethodeHinzufügen()
            2 -> logout.logOutUser()
        }


    }


    /*
    Sobald der Benutzer seine IBAN eingegeben hat, wird eine Bestätigungsmeldung ausgegeben, dass seine Kontodaten erfolgreich hinzugefügt wurden.
     */
    fun zahlungsmethodeHinzufügen(){
        var menu = Menu()
        println("Bitte geben sie ihre IBAN ein:(Mit Enter bestätigen)")

        var eingabeMethode = readln()

        println("Ihr Konte mit dieser IBAN:$eingabeMethode wurde hinzugefügt")
        menu.menueUser()

    }


    /*
    Die Funktion zahlungCheckout() zeigt dem Benutzer eine Liste von verfügbaren Zahlungsmethoden an und fordert ihn auf, eine auszuwählen
     */
    fun zahlungCheckout(datenbank : Datenbank){
        var logOut = LoginUndLogout()

        println(
            """
            ${CYAN}Mit Welcher Zahlungsmethode wollen sie Bezahlen?:$RESET
            [1] Bankeinzug/Lastschrift
            [2] PayPal
            [3] Logout
            Bitte Wählen sie eine Zahl von 1-3 (Mit Enter bestätigen)
        """.trimIndent())

        var checkoutUserInput = readln().toInt()
        when(checkoutUserInput){
            1 -> zahlungBankeinzug(datenbank)
            2 -> zahlungPayPal(datenbank)
            3 -> logOut.logOutUser()

        }
    }


    /*
    Diese Funktion führt eine Zahlung durch, wenn der Benutzer Bankeinzug als Zahlungsmethode gewählt hat.
    Die Funktion verwendet eine einfache Schleife, um einen Fortschrittsbalken für die Zahlungsverarbeitung anzuzeigen.
    Anschließend wird der Bestand reduziert und der Warenkorb geleert.
     */
    fun zahlungBankeinzug(datenbank: Datenbank) {

        var total = 100
        var progress = 0

        while (progress <= total) {
            print("$CYAN\rZahlung wird bearbeitet...$progress%$RESET")    // Das \r steht dafür das der Cursor an den Anfang der Aktuellen zeile zurückkehrt, ohne eine neue zu beginnen
            progress++
            Thread.sleep(20)
            }
        println()
        println("Zahlung mit Bankeinzug/Lastschrift war erfolgreich. \nVielen Dank für ihren Einkauf.")
        datenbank.bestandReduzieren()
        warenkorbLeeren()

    }


    /*
    Diese Funktion führt eine Zahlung durch, wenn der Benutzer PayPal gewählt hat.
    Die Funktion verwendet eine einfache Schleife, um einen Fortschrittsbalken für die Zahlungsverarbeitung anzuzeigen.
    Anschließend wird der Bestand reduziert und der Warenkorb geleert.
     */
    fun zahlungPayPal(datenbank: Datenbank){

        var total = 100
        var progress = 0

        while (progress <= total) {
            print("$CYAN\rZahlung wird bearbeitet...$progress%$RESET")    // Das \r steht dafür das der Cursor an den Anfang der Aktuellen zeile zurückkehrt, ohne eine neue zu beginnen
            progress++
            Thread.sleep(20)
        }
        println()
        println("Zahlung mit PayPal war erfolgreich. \nVielen Dank für ihren Einkauf.")
        datenbank.bestandReduzieren()
        warenkorbLeeren()




    }



    }
