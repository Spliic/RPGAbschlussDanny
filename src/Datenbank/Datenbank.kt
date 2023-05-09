package Datenbank
import CYAN
import LoginUndLogout.LoginUndLogout
import Produkte.*
import RESET
var warenkorb = mutableListOf<Ersatzteile>()
var menu = Menü()


open class Datenbank {

    var haendler = mutableMapOf<String, String>()
    var kunde = mutableMapOf<String, String>()


    init {
        this.haendler = mutableMapOf(
            "Oliver" to "Oliver123",
            "Danny" to "Danny123",
            "Gordon" to "Gordon123"
        )
        this.kunde = mutableMapOf(
            "Angi" to "Angi123",
            "Emre" to "Emre123",
            "Kevin" to "Kevin123",
            "Dimi" to "Dimi123"
        )
    }

    var ersatzTeilSortimentDisplay = mutableListOf<Ersatzteile>(
        Handydisplays("iPhone 14 Pro Display", 139.99, 1, "8/10"),
        Handydisplays("iPhone 13 Pro Display", 119.99, 1, "7/10"),
        Handydisplays("iPhone 12 Pro Display", 99.99, 1, "9/10"),
        Handydisplays("iPhone 11 Pro Display", 79.99, 1, "6/10"),
        Handydisplays("iPhone X  Display", 69.99, 1, "4/10")
    )

    var anleitungHandys = mutableListOf<Ersatzteile>(
        Handyanleitung("iPhone 14 Pro Display + Akku Reparatur Anleitung ", 24.99, 1, "8/10"),
        Handyanleitung("iPhone 13 Pro Display + Akku Reparatur Anleitung ", 19.99, 1, "7/10"),
        Handyanleitung("iPhone 12 Pro Display + Akku Reparatur Anleitung ", 14.99, 1, "6/10"),
        Handyanleitung("iPhone 11 Pro Display + Akku Reparatur Anleitung ", 9.99, 1, "8/10"),
        Handyanleitung("iPhone X Display + Akku Reparatur Anleitung ", 4.99, 1, "10/10"),

        )

    var ersatzTeilSortimentAkku = mutableListOf<Ersatzteile>(
        Handyakkus("iPhone 14 Pro Akku", 69.99, 1, "9/10"),
        Handyakkus("iPhone 13 Pro Akku", 59.99, 1, "5/10"),
        Handyakkus("iPhone 12 Pro Akku", 49.99, 1, "7/10"),
        Handyakkus("iPhone 11 Pro Akku", 39.99, 1, "3/10"),
        Handyakkus("iPhone X  Akku", 29.99, 1, "1/10")
    )

    var ersatzteilWerkzeug = mutableListOf<Ersatzteile>(
        Handywerkzeug(
            "Pro Tech Toolkit",
            74.99,
            1,
            "In unserem hochwertigen Pro Tech Toolkit findest du alle Werkzeuge, die du für die Reparatur von Smartphone brauchst."
        ),
        Handywerkzeug("iOpener", 12.99, 1, "Tschüss, Klebebefestigung: Mit dem iOpener Kleber lösen"),
        Handywerkzeug(
            "Schraubendreher Set",
            54.99,
            1,
            "Dieses Set enthält unsere 15 nützlichsten Schraubendreher mit fester Klinge"
        )
    )

    fun displayAnzeigeLassen() {
        var productmenu = Menü()
        var logOut = LoginUndLogout()

        println(
            """
                .___.__               .__                
              __| _/|__| ____________ |  | _____  ___.__.
             / __ | |  |/  ___/\____ \|  | \__  \<   |  |
            / /_/ | |  |\___ \ |  |_> >  |__/ __ \\___  |
            \____ | |__/____  >|   __/|____(____  / ____|
                 \/         \/ |__|             \/\/  
            $CYAN Diese Handydisplays sind auf Lager! $RESET  
        """.trimIndent()
        )
        for (display in 0 until ersatzTeilSortimentDisplay.size) {
            println(
                """
                Artikel ${display + 1}: Name: ${ersatzTeilSortimentDisplay[display].name}
                           Preis: ${ersatzTeilSortimentDisplay[display].preis}€
                           Anzahl: ${ersatzTeilSortimentDisplay[display].anzahl}
                           Bewertung: ${ersatzTeilSortimentDisplay[display].bewertung}
            """.trimIndent()
            )
        }


        println(
            """
            ${CYAN}Welches Produkt wollen sie in den Einkaufswagen legen?:$RESET
            [1] Artikel 1: ${ersatzTeilSortimentDisplay[0].name}
            [2] Artikel 2: ${ersatzTeilSortimentDisplay[1].name}
            [3] Artikel 3: ${ersatzTeilSortimentDisplay[2].name}
            [4] Artikel 4: ${ersatzTeilSortimentDisplay[3].name}
            [5] Artikel 5: ${ersatzTeilSortimentDisplay[4].name}
            [6] Logout
            Bitte Wählen sie eine Zahl von 1-6 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()
        when (userInputProductMenu) {
            1 -> println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[0].name} in den Warenkorb gelegt")
            2 -> println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[1].name} in den Warenkorb gelegt")
            3 -> println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[2].name} in den Warenkorb gelegt")
            4 -> println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[3].name} in den Warenkorb gelegt")
            5 -> println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[4].name} in den Warenkorb gelegt")
            6 -> logOut.logOutUser()
        }
        warenkorbbefuellen(ersatzTeilSortimentDisplay[userInputProductMenu - 1])


        println("Wollen sie noch weitere Produkte kaufen?")
        productmenu.menueUser()


    }

    fun akkuAnzeigenLassen() {
        var logOut = LoginUndLogout()
        var produktmenu = Menü()
        println(
            """
                    __    __          
            _____  |  | _|  | ____ __ 
            \__  \ |  |/ /  |/ /  |  \
             / __ \|    <|    <|  |  /
            (____  /__|_ \__|_ \____/ 
                 \/     \/    \/    
            $CYAN Diese Handyakkus sind auf Lager! $RESET
        """.trimIndent()
        )
        for (akku in 0 until ersatzTeilSortimentAkku.size) {
            println(
                """
                Artikel ${akku + 1}: Name: ${ersatzTeilSortimentAkku[akku].name}
                           Preis: ${ersatzTeilSortimentAkku[akku].preis}€
                           Anzahl: ${ersatzTeilSortimentAkku[akku].anzahl}
                           Bewertung: ${ersatzTeilSortimentAkku[akku].bewertung}
            """.trimIndent()
            )
        }
        println(
            """
            ${CYAN}Welches Produkt wollen sie in den Einkaufswagen legen?:$RESET
            [1] Artikel 1: ${ersatzTeilSortimentAkku[0].name}
            [2] Artikel 2: ${ersatzTeilSortimentAkku[1].name}
            [3] Artikel 3: ${ersatzTeilSortimentAkku[2].name}
            [4] Artikel 4: ${ersatzTeilSortimentAkku[3].name}
            [5] Artikel 5: ${ersatzTeilSortimentAkku[4].name}
            [6] Logout
            Bitte Wählen sie eine Zahl von 1-6 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()
        when (userInputProductMenu) {
            1 -> println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[0].name} in den Warenkorb gelegt")
            2 -> println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[1].name} in den Warenkorb gelegt")
            3 -> println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[2].name} in den Warenkorb gelegt")
            4 -> println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[3].name} in den Warenkorb gelegt")
            5 -> println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[4].name} in den Warenkorb gelegt")
            6 -> logOut.logOutUser()
        }
        warenkorbbefuellen(ersatzTeilSortimentAkku[userInputProductMenu - 1])
        println("Wollen sie noch weitere Produkte kaufen?")
        produktmenu.menueUser()
    }

    fun sonstigesWerkzeugAnzeigenLassen() {
        var logOut = LoginUndLogout()
        var produktmenu = Menü()
        println(
            """
                                  __                                
            __  _  __ ___________|  | __________ ____  __ __  ____  
            \ \/ \/ // __ \_  __ \  |/ /\___   // __ \|  |  \/ ___\ 
             \     /\  ___/|  | \/    <  /    /\  ___/|  |  / /_/  >
              \/\_/  \___  >__|  |__|_ \/_____ \\___  >____/\___  / 
                         \/           \/      \/    \/     /_____/   
             $CYAN Diese Werkzeug haben wir auf Lager!$RESET
        """.trimIndent()
        )
        for (werkzeug in 0 until ersatzteilWerkzeug.size) {
            println(
                """
                Artikel ${werkzeug + 1}: Name: ${ersatzteilWerkzeug[werkzeug].name}
                           Preis: ${ersatzteilWerkzeug[werkzeug].preis}€
                           Anzahl: ${ersatzteilWerkzeug[werkzeug].anzahl}
                           Beschreibung: ${ersatzteilWerkzeug[werkzeug].bewertung}
            """.trimIndent()
            )
        }
        println(
            """
            ${CYAN}Welches Produkt wollen sie in den Einkaufswagen legen?:$RESET
            [1] Artikel 1: ${ersatzteilWerkzeug[0].name}
            [2] Artikel 2: ${ersatzteilWerkzeug[1].name}
            [3] Artikel 3: ${ersatzteilWerkzeug[2].name}
            [4] Logout
            Bitte Wählen sie eine Zahl von 1-4 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()
        when (userInputProductMenu) {
            1 -> println("Sie haben den Artikel: ${ersatzteilWerkzeug[0].name} in den Warenkorb gelegt")
            2 -> println("Sie haben den Artikel: ${ersatzteilWerkzeug[1].name} in den Warenkorb gelegt")
            3 -> println("Sie haben den Artikel: ${ersatzteilWerkzeug[2].name} in den Warenkorb gelegt")
            4 -> logOut.logOutUser()
        }
        warenkorbbefuellen(ersatzteilWerkzeug[userInputProductMenu - 1])
        println("Wollen sie noch weitere Produkte kaufen?")
        produktmenu.menueUser()

    }

    fun reparaturAnleitung() {

        var logOut = LoginUndLogout()
        var produktmenu = Menü()
        println(
            """
                           _____         .__         .__  __                        
              /  _  \   ____ |  |   ____ |__|/  |_ __ __  ____    ____  
             /  /_\  \ /    \|  | _/ __ \|  \   __\  |  \/    \  / ___\ 
            /    |    \   |  \  |_\  ___/|  ||  | |  |  /   |  \/ /_/  >
            \____|__  /___|  /____/\___  >__||__| |____/|___|  /\___  / 
                    \/     \/          \/                    \//_____/
                    """.trimIndent()
        )
        for (anleitung in 0 until anleitungHandys.size) {
            println(
                """
                Artikel ${anleitung + 1}: Name: ${anleitungHandys[anleitung].name}
                           Preis: ${anleitungHandys[anleitung].preis}€
                           Anzahl: ${anleitungHandys[anleitung].anzahl}
                           Bewertung: ${anleitungHandys[anleitung].bewertung}
            """.trimIndent()
            )
        }
        println(
            """
            ${CYAN}Welches Produkt wollen sie in den Einkaufswagen legen?:$RESET
            [1] Artikel 1: ${anleitungHandys[0].name}
            [2] Artikel 2: ${anleitungHandys[1].name}
            [3] Artikel 3: ${anleitungHandys[2].name}
            [4] Artikel 4: ${anleitungHandys[3].name}
            [5] Artikel 5: ${anleitungHandys[4].name}
            [6] Logout
            Bitte Wählen sie eine Zahl von 1-6 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()


        when (userInputProductMenu) {
            1 -> println("Sie haben den Artikel: ${anleitungHandys[0].name} in den Warenkorb gelegt")
            2 -> println("Sie haben den Artikel: ${anleitungHandys[1].name} in den Warenkorb gelegt")
            3 -> println("Sie haben den Artikel: ${anleitungHandys[2].name} in den Warenkorb gelegt")
            4 -> println("Sie haben den Artikel: ${anleitungHandys[3].name} in den Warenkorb gelegt")
            5 -> println("Sie haben den Artikel: ${anleitungHandys[4].name} in den Warenkorb gelegt")
            6 -> logOut.logOutUser()
        }
        warenkorbbefuellen(anleitungHandys[userInputProductMenu - 1])
        println("Wollen sie noch weitere Produkte kaufen?")
        produktmenu.menueUser()
    }

    fun warenkorbbefuellen(produkt: Ersatzteile): MutableList<Ersatzteile> {

        warenkorb.add(produkt)
        return warenkorb
    }

    fun warenkorbAnzeigen() {

        if (warenkorb.isEmpty()) {
            println("Der Warenkorb ist aktuell leer.")


        } else {
            println("Ihr aktueller Warenkorbinhalt:")
            for (produkt in warenkorb) {
                println("- ${produkt.name}: ${produkt.preis}€")
            }
            val gesamtPreis = warenkorbPreis()
            println("Gesamtpreis: $gesamtPreis€")

        }
        menu.menueUser()

    }

    fun warenkorbPreis(): Double {
        var gesamtPreis = 0.0
        for (produkt in warenkorb) {
            gesamtPreis += produkt.preis
        }
        return gesamtPreis


    }

}









