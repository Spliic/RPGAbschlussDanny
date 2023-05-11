package LoginUndLogout

import CYAN
import Datenbank.Datenbank
import RESET
import menuFromStore

class LoginUndLogout: Datenbank() {


    /*
    Die Funktion "logInMenueUser" implementiert die Login-Funktionalität für Kunden.
    Der Benutzer wird aufgefordert, seinen Benutzernamen und sein Passwort einzugeben.
    Wenn der Benutzername korrekt eingegeben wird, wird das eingegebene Passwort überprüft.
    Wenn das Passwort korrekt eingegeben wird, wird der Benutzer eingeloggt und die Funktion gibt "true" zurück.
    Andernfalls wird der Benutzer aufgefordert, den Benutzernamen und/oder das Passwort erneut einzugeben.
    Wenn der Benutzer dreimal hintereinander ein falsches Passwort oder einen falschen Benutzernamen eingegeben hat, wird er ausgeloggt und die Funktion gibt "false" zurück.
     */
    fun logInMenueUser(datenbank:Datenbank): Boolean{
        var logInUser = false
        var countTry = 1
        var check = false


        while (!check){
            while (countTry < 4) {

                println("${CYAN}Bitte gebe dein Benutzernamen ein:$RESET")
                val userInputName = readln()

                if (datenbank.kunde.containsKey(userInputName)) {
                    println("${CYAN}Bitte gebe dein Passwort ein:$RESET")
                    val userInputPassword = readln()
                    if (datenbank.kunde[userInputName] == userInputPassword){
                        println("Sie wurden erfolgreich eingeloggt.")
                        logInUser = true
                        check = true
                        countTry = 5
                    } else {
                        println("Sie haben das Passwort falsch eingegeben.")
                        countTry++
                        if (countTry == 4) {
                            logInUser = false
                            check = true
                        }
                    }
                } else {
                    println("Sie haben den Benutzername falsch eingegeben.")
                    countTry++
                    if (countTry == 4) {
                        logInUser = false
                    }
                }
            }
        }
        if (countTry == 4) {
            println("Maximale Anzahl an versuchen verbraucht. Bitte Kundensupport anrufen.")
        }
        return logInUser
    }


    /*
    Die Funktion "logInMenueHaendler" implementiert die Login-Funktionalität für Kunden.
    Der Händler wird aufgefordert, seinen Benutzernamen und sein Passwort einzugeben.
    Wenn der Benutzername korrekt eingegeben wird, wird das eingegebene Passwort überprüft.
    Wenn das Passwort korrekt eingegeben wird, wird der Benutzer eingeloggt und die Funktion gibt "true" zurück.
    Andernfalls wird der Benutzer aufgefordert, den Benutzernamen und/oder das Passwort erneut einzugeben.
    Wenn der Benutzer dreimal hintereinander ein falsches Passwort oder einen falschen Benutzernamen eingegeben hat, wird er ausgeloggt und die Funktion gibt "false" zurück.
     */
    fun logInMenueHaendler(): Boolean{
        var logInHaendler = false
        var countTryHaendler = 1


        while (!logInHaendler){
            while (countTryHaendler < 4) {

                println("${CYAN}Bitte gebe dein Benutzernamen ein:$RESET")
                val haendlerInputName = readln()

                if (haendler.containsKey(haendlerInputName)) {
                    println("${CYAN}Bitte gebe dein Passwort ein:$RESET")
                    val haendlerInputPassword = readln()
                    if (haendler[haendlerInputName] == haendlerInputPassword){
                        println("Sie wurden erfolgreich eingeloggt.")
                        logInHaendler = true
                        countTryHaendler = 5
                        return true
                    } else {
                        println("Sie haben das Passwort falsch eingegeben.")
                        countTryHaendler++
                        if (countTryHaendler == 4) {
                            logInHaendler = true
                        }
                    }
                } else {
                    println("Sie haben den Benutzername falsch eingegeben.")
                    countTryHaendler++
                    if (countTryHaendler == 4) {
                        logInHaendler = true
                    }
                }
            }
        }
        if (countTryHaendler == 4) {
            println("Maximale Anzahl an versuchen verbraucht. Bitte Kundensupport anrufen.")
        }

       return false
    }


    /*
     Die Funktion logOutUser() hat die Aufgabe, den aktuellen Benutzer auszuloggen und das Hauptmenü der Anwendung aufzurufen.
     */
    fun logOutUser():Boolean{
        println("Du wurdest erfolgreich ausgeloggt")
        println()
        menuFromStore()
    return false
    }

}