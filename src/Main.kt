import Kunde.Kundenaccount
import Datenbank.Menü
import LoginUndLogout.LoginUndLogout
import haendler.Haendleraccount

var CYAN = "\u001B[36m"
var RESET = "\u001B[0m"

fun main() {

    /*var check = true
    while (check == true){
        check = menuFromStore()
    }

     */
     menuFromStore()


}

fun menuFromStore(): Boolean{
    var userLoggedIn = false
    val kundenaccount = Kundenaccount()
    val haendleraccount = Haendleraccount()
    val loginUndLogoutUser = LoginUndLogout()
    val loginUndLogoutHaendler = LoginUndLogout()
    val menueUser = Menü()



    println("""
            ${CYAN}Was möchten sie hier tun?$RESET
            [1] Neues Kundenkonto erstellen
            [2] Neues Händlerkonto erstellen
            [3] Kunden-Anmeldung
            [4] Händler-Anmeldung
            Bitte Wählen sie eine Zahl von 1-4 (Mit Enter bestätigen)
        """.trimIndent())
    var userInputMenu = readln().toInt()
    when(userInputMenu){
        1 -> kundenaccount.newAccountForUser()
        2 -> haendleraccount.newAccountForHaendler()
        3 -> userLoggedIn = loginUndLogoutUser.logInMenueUser()
        4 -> loginUndLogoutHaendler.logInMenueHaendler()
    }
    println()

    // Wenn Kunde eingeloggt ist, wird Menü für den User geöffnet
    if (userLoggedIn){

        userLoggedIn = menueUser.menueUser()
    }
    return userLoggedIn
}


