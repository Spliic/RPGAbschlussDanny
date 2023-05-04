import Kunde.Kundenaccount
import Produkte.Menü
import haendler.Haendleraccount

var CYAN = "\u001B[36m"
var RESET = "\u001B[0m"

fun main() {

    menuFromStore()


}

fun menuFromStore(){
    var userLoggedIn = false
    val kundenaccount = Kundenaccount()
    val haendleraccount = Haendleraccount()
    val loginUndLogoutUser = LoginUndLogout()
    val loginUndLogoutHaendler = LoginUndLogout()
    val menueUser = Menü()


    println("""
            Was möchten sie hier tun?
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
        menueUser.menueUser()
    }

}


