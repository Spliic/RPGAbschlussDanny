package Kunde

import CYAN
import Datenbank.Datenbank
import Datenbank.Menu
import LoginUndLogout.LoginUndLogout
import RESET

class Accountverwaltung: Datenbank() {


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

    fun zahlungsmethodeHinzufügen(){
        var menu = Menu()
        println("Bitte geben sie ihre IBAN ein:(Mit Enter bestätigen)")

        var eingabeMethode = readln()

        println("Ihr Konte mit dieser IBAN:$eingabeMethode wurde hinzugefügt")
        menu.menueUser()

    }

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

    fun zahlungBankeinzug(datenbank: Datenbank) {

        var total = 100
        var progress = 0

        while (progress <= total) {
            print("$CYAN\rZahlung wird bearbeitet...$progress%$RESET")
            progress++
            Thread.sleep(20)
            }
        println()
        println("Zahlung mit Bankeinzug/Lastschrift war erfolgreich. \nVielen Dank für ihren Einkauf.")
        datenbank.bestandReduzieren()
        warenkorbLeeren()




    }

    fun zahlungPayPal(datenbank: Datenbank){

        var total = 100
        var progress = 0

        while (progress <= total) {
            print("$CYAN\rZahlung wird bearbeitet...$progress%$RESET")
            progress++
            Thread.sleep(20)
        }
        println()
        println("Zahlung mit PayPal war erfolgreich. \nVielen Dank für ihren Einkauf.")
        datenbank.bestandReduzieren()
        warenkorbLeeren()




    }



    }
