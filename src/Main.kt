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
    while (true){
        println("${CYAN}Bitte geben sie ihr Aktuelles Alter ein:$RESET (Mit Enter Bestätigen)")
        var inputAlter = readln().toInt()
        // Überprüfen ob Kunde 12 oder älter ist.
        if (inputAlter >= 12) {
            menuFromStore()
        } else {
            println("${CYAN}Zugriff wurde zum OnlineShop verweigert. Sie müssen mindestens 12 Jahre alt sein.$RESET")
        }


    }

    /*var check = true
    while (check == true){
        check = menuFromStore()
    }

     */


}

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


