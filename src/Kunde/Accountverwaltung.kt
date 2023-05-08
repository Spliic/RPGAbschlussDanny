package Kunde

import CYAN
import Datenbank.Datenbank
import Datenbank.Menü
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
        var menu = Menü()
        println("Bitte geben sie ihre IBAN ein:(Mit Enter bestätigen)")

        var eingabeMethode = readln()

        println("Ihr Konte mit dieser IBAN:$eingabeMethode wurde hinzugefügt")
        menu.menueUser()


    }


}