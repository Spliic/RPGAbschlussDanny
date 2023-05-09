import Kunde.Kundenaccount
import Datenbank.Menü
import LoginUndLogout.LoginUndLogout
import haendler.Haendleraccount

var CYAN = "\u001B[36m"
var RESET = "\u001B[0m"

fun main() {

    // Benutzer nach Alter fragen
    println(
        """$CYAN    
          ___ ___                      .__  .__       .__     
         /   |   \   __________________|  | |__| ____ |  |__  
        /    ~    \_/ __ \_  __ \___   /  | |  |/ ___\|  |  \ 
        \    Y    /\  ___/|  | \//    /|  |_|  \  \___|   Y  \
         \___|_  /  \___  >__|  /_____ \____/__|\___  >___|  /
               \/       \/            \/            \/     \/ 
         __      __.__.__  .__   __                                        
        /  \    /  \__|  | |  | |  | ______   _____   _____   ____   ____  
        \   \/\/   /  |  | |  | |  |/ /  _ \ /     \ /     \_/ __ \ /    \ 
         \        /|  |  |_|  |_|    <  <_> )  Y Y  \  Y Y  \  ___/|   |  \
          \__/\  / |__|____/____/__|_ \____/|__|_|  /__|_|  /\___  >___|  /
               \/                    \/           \/      \/     \/     \/ 
                         ___.          .__ 
                         \_ |__   ____ |__|
                          | __ \_/ __ \|  |
                          | \_\ \  ___/|  |
                          |___  /\___  >__|
                              \/     \/       
           ___________          __________                    .__        
           \_   _____/_ __  ____\______   \ ____ ___________  |__|______ 
            |    __)|  |  \/    \|       _// __ \\____ \__  \ |  \_  __ \
            |     \ |  |  /   |  \    |   \  ___/|  |_> > __ \|  ||  | \/
            \___  / |____/|___|  /____|_  /\___  >   __(____  /__||__|   
                \/             \/       \/     \/|__|       \/           
    $RESET""".trimIndent()
    )
    /*Dieser Code prüft das Alter des Benutzers, bevor er den Zugriff zum Shop gewährt. Der Benutzer wird aufgefordert, sein Alter einzugeben.
    Wenn das eingegebene Alter größer oder gleich 12 ist, wird das Menü des Online-Shops aufgerufen und die while-Schleife beendet.
    Wenn das Alter kleiner als 12 ist, wird eine Fehlermeldung ausgegeben.

     */

    var counterForContinue = true
    while (counterForContinue) {
        try {
            println("${CYAN}Bitte geben Sie Ihr aktuelles Alter ein:$RESET (Mit Enter bestätigen)")
            var inputAlter = readln().toInt()
            if (inputAlter >= 12) {
                menuFromStore()
                counterForContinue = false
            } else {
                println("${CYAN}Zugriff wurde zum Online-Shop verweigert. Sie müssen mindestens 12 Jahre alt sein.$RESET")
            }
        } catch (e: NumberFormatException) {
            println("${CYAN}Bitte geben Sie eine gültige Zahl ein.$RESET")
        }
    }





    /*var check = true
    while (check == true){
        check = menuFromStore()
    }

     */

}



/*
 Die Funktion menuFromStore öffnet ein Menü, in dem der Benutzer zwischen vier Optionen wählen kann.
 Je nachdem, welche Option ausgewählt wird, ruft die Funktion eine entsprechende Methode auf, um das Konto zu erstellen oder den Benutzer einzuloggen.
 Wenn der Benutzer erfolgreich eingeloggt ist, wird das Menü für den Benutzer geöffnet.
 Die Funktion gibt true zurück, wenn der Benutzer eingeloggt ist, und false, wenn er nicht eingeloggt ist.
 */
fun menuFromStore(): Boolean {
    var userLoggedIn = false
    val kundenaccount = Kundenaccount()
    val haendleraccount = Haendleraccount()
    val loginUndLogoutUser = LoginUndLogout()
    val loginUndLogoutHaendler = LoginUndLogout()
    val menueUser = Menü()



    println(
        """
            ${CYAN}Was möchten sie hier tun?$RESET
            [1] Neues Kundenkonto erstellen
            [2] Neues Händlerkonto erstellen
            [3] Kunden-Anmeldung
            [4] Händler-Anmeldung
            Bitte Wählen sie eine Zahl von 1-4 (Mit Enter bestätigen)
        """.trimIndent()
    )
    var userInputMenu = readln().toInt()
    when (userInputMenu) {
        1 -> kundenaccount.newAccountForUser()
        2 -> haendleraccount.newAccountForHaendler()
        3 -> userLoggedIn = loginUndLogoutUser.logInMenueUser()
        4 -> loginUndLogoutHaendler.logInMenueHaendler()
    }
    println()

    // Wenn Kunde eingeloggt ist, wird Menü für den User geöffnet
    if (userLoggedIn) {

        userLoggedIn = menueUser.menueUser()
    }
    return userLoggedIn
}


