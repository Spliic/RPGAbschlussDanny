package LoginUndLogout
import CYAN
import Datenbank.Datenbank
import RESET
import menuFromStore

class LoginUndLogout: Datenbank() {

    fun logInMenueUser(): Boolean{
        var logInUser = false
        var countTry = 1
        var check = false


        while (!check){
            while (countTry < 4) {

                println("${CYAN}Bitte gebe dein Benutzernamen ein:$RESET")
                val userInputName = readln()

                if (kunde.containsKey(userInputName)) {
                    println("${CYAN}Bitte gebe dein Passwort ein:$RESET")
                    val userInputPassword = readln()
                    if (kunde[userInputName] == userInputPassword){
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

    fun logInMenueHaendler(){
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
    }

    fun logOutUser():Boolean{
        println("Du wurdest erfolgreich ausgeloggt")
        println()
        menuFromStore()
    return false
    }

}