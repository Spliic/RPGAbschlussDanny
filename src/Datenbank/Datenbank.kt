package Datenbank
import CYAN
import LoginUndLogout.LoginUndLogout
import Produkte.*
import RESET
import menu
import warenkorb
import java.math.BigDecimal
import java.math.RoundingMode


open class Datenbank{

    // Hier werden 2 Maps erstellt die jeweils den Benutzernamen und Passwort erhalten
    var haendler = mutableMapOf<String, String>()
    var kunde = mutableMapOf<String, String>()



    // Die Init funktion initialisiert die Listen mit den Benutzernamen und Passwörtern
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


    /*
    Hier wird eine Liste von Handydisplays erstellt, die später im Code verwendet wird, um
    das Sortiment an verfügbaren Ersatzteilen anzuzeigen und auszuwählen
     */

    var ersatzTeilSortimentDisplay = mutableListOf<Ersatzteile>(
        Handydisplays("iPhone 14 Pro Display", 139.99, 0, "8/10"),
        Handydisplays("iPhone 13 Pro Display", 119.99, 8, "7/10"),
        Handydisplays("iPhone 12 Pro Display", 99.99, 5, "9/10"),
        Handydisplays("iPhone 11 Pro Display", 79.99, 2, "6/10"),
        Handydisplays("iPhone X  Display", 69.99, 15, "4/10")
    )


    /*
    Hier wird eine Liste von anleitungHandys erstellt, die später im Code verwendet wird, um
    das Sortiment an verfügbaren Anleitungen anzuzeigen und auszuwählen
     */

    var anleitungHandys = mutableListOf<Ersatzteile>(
        Handyanleitung("iPhone 14 Pro Display + Akku Reparatur Anleitung ", 24.99, 1, "8/10"),
        Handyanleitung("iPhone 13 Pro Display + Akku Reparatur Anleitung ", 19.99, 0, "7/10"),
        Handyanleitung("iPhone 12 Pro Display + Akku Reparatur Anleitung ", 14.99, 1, "6/10"),
        Handyanleitung("iPhone 11 Pro Display + Akku Reparatur Anleitung ", 9.99, 1, "8/10"),
        Handyanleitung("iPhone X Display + Akku Reparatur Anleitung ", 4.99, 1, "10/10"),

        )


    /*
    Hier wird eine Liste von ersatzAkkus erstellt, die später im Code verwendet wird, um
    das Sortiment an verfügbaren ersatzAkkus anzuzeigen und auszuwählen
     */

    var ersatzTeilSortimentAkku = mutableListOf<Ersatzteile>(
        Handyakkus("iPhone 14 Pro Akku", 69.99, 1, "9/10"),
        Handyakkus("iPhone 13 Pro Akku", 59.99, 0, "5/10"),
        Handyakkus("iPhone 12 Pro Akku", 49.99, 1, "7/10"),
        Handyakkus("iPhone 11 Pro Akku", 39.99, 1, "3/10"),
        Handyakkus("iPhone X  Akku", 29.99, 1, "1/10")
    )

    /*
    Hier wird eine Liste von ersatzWerkzeug erstellt, die später im Code verwendet wird, um
    das Sortiment an verfügbaren ersatzWerkzeug anzuzeigen und auszuwählen
     */

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
            0,
            "Dieses Set enthält unsere 15 nützlichsten Schraubendreher mit fester Klinge"
        )
    )






    /*
    Die Funktion DisplayAnzeigenLassen zeigt eine Liste von Handydisplays an die auf Lager sind.
    Die Funktion fordert den benutzer auf, ein produkt auszuwählen in dem er zahle von 1 bis 6 eingibt,
    wenn das ausgewählte produkt auf lager ist, wird es in den Warenkorb gelegt und auch bestätigt.
    Schließlich wird der benutzer aufgefordert zu entscheiden, ob er weitere Produkte kaufen möchte
    */
    fun displayAnzeigeLassen() {

        var logOut = LoginUndLogout()

        println(
            """$CYAN
                .___.__               .__                
              __| _/|__| ____________ |  | _____  ___.__.
             / __ | |  |/  ___/\____ \|  | \__  \<   |  |
            / /_/ | |  |\___ \ |  |_> >  |__/ __ \\___  |
            \____ | |__/____  >|   __/|____(____  / ____|
                 \/         \/ |__|             \/\/  
             Diese Handydisplays sind auf Lager! $RESET  
        """.trimIndent()
        )
        for (display in 0 until ersatzTeilSortimentDisplay.size) {
            println(
                """
                Artikel ${display + 1}: Name: ${ersatzTeilSortimentDisplay[display].name}
                           Preis: ${ersatzTeilSortimentDisplay[display].preis}€
                           ${
                               if (ersatzTeilSortimentDisplay[display].anzahl != 0){
                                   "Verfügbar: ${ersatzTeilSortimentDisplay[display].anzahl}"
                               } else {
                                   "Artikel nicht mehr Verfügbar."
                               }
                           }
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
            [6] Zurück zum Menü
            [7] Logout
            Bitte Wählen sie eine Zahl von 1-7 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()
        when (userInputProductMenu) {
            1 -> {
                if (ersatzTeilSortimentDisplay[0].anzahl == 0){
                    println("Artikel ist nicht verfügbar.")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[0].name} in den Warenkorb gelegt")
                }
            }
            2 -> {
                if (ersatzTeilSortimentDisplay[1].anzahl == 0){
                    println("Artikel ist nicht verfügbar.")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[1].name} in den Warenkorb gelegt")
                }
            }
            3 -> {
                if (ersatzTeilSortimentDisplay[2].anzahl == 0){
                    println("Artikel ist nicht verfügbar.")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[2].name} in den Warenkorb gelegt")
                }
            }
            4 -> {
                if (ersatzTeilSortimentDisplay[3].anzahl == 0){
                    println("Artikel ist nicht verfügbar.")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[3].name} in den Warenkorb gelegt")
                }
            }
            5 -> {
                if (ersatzTeilSortimentDisplay[4].anzahl == 0){
                    println("Artikel ist nicht verfügbar.")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentDisplay[4].name} in den Warenkorb gelegt")
                }
            }
            6 -> menu.menueUser()
            7 -> logOut.logOutUser()
        }
        warenkorbbefuellen(ersatzTeilSortimentDisplay[userInputProductMenu - 1])


        println("Wollen sie noch weitere Produkte kaufen?")

    }


    /*
    Die gegebene Funktion akkuAnzeigenLassen() gibt eine Liste von Handyakkus aus, die auf Lager sind, und bittet den Benutzer, einen Akku auszuwählen, den er in den Einkaufswagen legen möchte.
    Der Benutzer kann zwischen verschiedenen Optionen wählen, indem er eine Zahl von 1 bis 6 eingibt und die Eingabetaste drückt.
    Wenn der Benutzer eine gültige Option auswählt, wird der entsprechende Akku in den Warenkorb gelegt.
    Wenn der ausgewählte Artikel nicht mehr auf Lager ist, wird eine Meldung ausgegeben, die den Benutzer darüber informiert. Am Ende wird der Warenkorb des Benutzers aktualisiert,
    und er wird gefragt, ob er weitere Produkte kaufen möchte.
    Wenn der Benutzer die Option "Logout" auswählt, wird er ausgeloggt.
     */
    fun akkuAnzeigenLassen() {
        var logOut = LoginUndLogout()

        println(
            """$CYAN
                    __    __          
            _____  |  | _|  | ____ __ 
            \__  \ |  |/ /  |/ /  |  \
             / __ \|    <|    <|  |  /
            (____  /__|_ \__|_ \____/ 
                 \/     \/    \/    
             Diese Handyakkus sind auf Lager! $RESET
        """.trimIndent()
        )
        for (akku in 0 until ersatzTeilSortimentAkku.size) {
            println(
                """
                Artikel ${akku + 1}: Name: ${ersatzTeilSortimentAkku[akku].name}
                           Preis: ${ersatzTeilSortimentAkku[akku].preis}€
                           ${
                               if (ersatzTeilSortimentAkku[akku].anzahl != 0){
                                "Verfügbar: ${ersatzTeilSortimentAkku[akku].anzahl}"
                                } else {
                                    "Artikel nicht mehr Verfügbar."
                                }
                           }
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
            [6] Zurück zum Menü
            [7] Logout
            Bitte Wählen sie eine Zahl von 1-7 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()
        when (userInputProductMenu) {
            1 -> {
                if (ersatzTeilSortimentAkku[0].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[0].name} in den Warenkorb gelegt")
                }
            }
            2 -> {
                if (ersatzTeilSortimentAkku[1].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[1].name} in den Warenkorb gelegt")
                }
            }
            3 -> {
                if (ersatzTeilSortimentAkku[2].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[2].name} in den Warenkorb gelegt")
                }
            }
            4 -> {
                if (ersatzTeilSortimentAkku[3].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[3].name} in den Warenkorb gelegt")
                }
            }
            5 -> {
                if (ersatzTeilSortimentAkku[4].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzTeilSortimentAkku[4].name} in den Warenkorb gelegt")
                }
            }
            6 -> menu.menueUser()
            7 -> logOut.logOutUser()
        }
        warenkorbbefuellen(ersatzTeilSortimentAkku[userInputProductMenu - 1])
        println("Wollen sie noch weitere Produkte kaufen?")

    }


    /*
    Diese Funktion namens "sonstigesWerkzeugAnzeigenLassen" zeigt eine Liste von Werkzeugen an, die auf Lager sind, und gibt dem Benutzer die Möglichkeit,
    ein Werkzeug in den Einkaufswagen zu legen.
    Dann wird eine Schleife durchlaufen, um jedes Werkzeug in der Liste auszugeben, einschließlich seines Namens, Preises, Verfügbarkeit und Beschreibung.
    Die Funktion ruft auch die Funktion "warenkorbBefuellen" auf, um das ausgewählte Werkzeug zum Warenkorb des Benutzers hinzuzufügen.
    Schließlich wird der Benutzer gefragt, ob er weitere Produkte kaufen möchte.
    */
    fun sonstigesWerkzeugAnzeigenLassen() {
        var logOut = LoginUndLogout()

        println(
            """$CYAN
                                  __                                
            __  _  __ ___________|  | __________ ____  __ __  ____  
            \ \/ \/ // __ \_  __ \  |/ /\___   // __ \|  |  \/ ___\ 
             \     /\  ___/|  | \/    <  /    /\  ___/|  |  / /_/  >
              \/\_/  \___  >__|  |__|_ \/_____ \\___  >____/\___  / 
                         \/           \/      \/    \/     /_____/   
             Diese Werkzeug haben wir auf Lager!$RESET
        """.trimIndent()
        )
        for (werkzeug in 0 until ersatzteilWerkzeug.size) {
            println(
                """
                Artikel ${werkzeug + 1}: Name: ${ersatzteilWerkzeug[werkzeug].name}
                           Preis: ${ersatzteilWerkzeug[werkzeug].preis}€
                           ${
                                if (ersatzteilWerkzeug[werkzeug].anzahl != 0){
                                "Verfügbar: ${ersatzteilWerkzeug[werkzeug].anzahl}"
                                } else {
                                    "Artikel nicht mehr Verfügbar."
                                }
                           }
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
            [4] Zurück zum Menü
            [5] Logout
            Bitte Wählen sie eine Zahl von 1-5 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()
        when (userInputProductMenu) {
            1 -> {
                if (ersatzteilWerkzeug[0].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzteilWerkzeug[0].name} in den Warenkorb gelegt")
                }
            }
            2 -> {
                if (ersatzteilWerkzeug[1].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzteilWerkzeug[1].name} in den Warenkorb gelegt")
                }
            }
            3 -> {
                if (ersatzteilWerkzeug[2].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${ersatzteilWerkzeug[2].name} in den Warenkorb gelegt")
                }
            }
            4 -> menu.menueUser()
            5 -> logOut.logOutUser()
        }
        warenkorbbefuellen(ersatzteilWerkzeug[userInputProductMenu - 1])
        println("Wollen sie noch weitere Produkte kaufen?")


    }


    /*
    Es wird eine Schleife durchlaufen, die alle Artikel in einer Liste von Handys ausgibt, einschließlich ihrer Namen, Preise, Verfügbarkeit und Bewertungen.
    Danach wird der Benutzer aufgefordert, eine Zahl zwischen 1 und 6 auszuwählen, um einen Artikel zum Warenkorb hinzuzufügen oder sich auszuloggen.
    Je nach Eingabe wird der ausgewählte Artikel zum Warenkorb hinzugefügt, und der Benutzer wird aufgefordert, weitere Artikel hinzuzufügen oder nicht.
    */
    fun reparaturAnleitung() {

        var logOut = LoginUndLogout()

        println(
            """$CYAN
                           _____         .__         .__  __                        
              /  _  \   ____ |  |   ____ |__|/  |_ __ __  ____    ____  
             /  /_\  \ /    \|  | _/ __ \|  \   __\  |  \/    \  / ___\ 
            /    |    \   |  \  |_\  ___/|  ||  | |  |  /   |  \/ /_/  >
            \____|__  /___|  /____/\___  >__||__| |____/|___|  /\___  / 
                    \/     \/          \/                    \//_____/
                    $RESET""".trimIndent()
        )
        for (anleitung in 0 until anleitungHandys.size) {
            println(
                """
                Artikel ${anleitung + 1}: Name: ${anleitungHandys[anleitung].name}
                           Preis: ${anleitungHandys[anleitung].preis}€
                           ${
                                if (anleitungHandys[anleitung].anzahl != 0){
                                 "Verfügbar: ${anleitungHandys[anleitung].anzahl}"
                                } else {
                                     "Artikel nicht mehr Verfügbar."
                                }
                           }
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
            [6] Zurück zum Menü
            [7] Logout
            Bitte Wählen sie eine Zahl von 1-7 (Mit Enter bestätigen)
        """.trimIndent()
        )
        var userInputProductMenu = readln().toInt()


        when (userInputProductMenu) {
            1 -> {
                if (anleitungHandys[0].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${anleitungHandys[0].name} in den Warenkorb gelegt")
                }
            }
            2 -> {
                if (anleitungHandys[1].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${anleitungHandys[1].name} in den Warenkorb gelegt")
                }
            }
            3 -> {
                if (anleitungHandys[2].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${anleitungHandys[2].name} in den Warenkorb gelegt")
                }
            }
            4 -> {
                if (anleitungHandys[3].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${anleitungHandys[3].name} in den Warenkorb gelegt")
                }
            }
            5 -> {
                if (anleitungHandys[4].anzahl == 0){
                    println("Artikel ist nicht verfügbar")
                } else {
                    println("Sie haben den Artikel: ${anleitungHandys[4].name} in den Warenkorb gelegt")
                }
            }
            6 -> menu.menueUser()
            7 -> logOut.logOutUser()
        }
        warenkorbbefuellen(anleitungHandys[userInputProductMenu - 1])
        println("Wollen sie noch weitere Produkte kaufen?")

    }


    /*
    Eie Funktion warenkorbBefuellen fügt ein übergebenes Ersatzteile-Objekt dem warenkorb hinzu und gibt den aktualisierten warenkorb zurück.
     */
    fun warenkorbbefuellen(produkt: Ersatzteile): MutableList<Ersatzteile> {

        warenkorb.add(produkt)
        return warenkorb
    }


    /*
    Die Funktion warenkorbAnzeigen() zeigt den Inhalt des Warenkorbs an, falls er nicht leer ist.
    Am Ende berechnet er den Gesamtpreis aller Produkte im Warenkorb mit der Funktion warenkorbPreis() und gibt ihn zusammen mit dem Zahlungsmenü aus.
    Falls der Warenkorb leer ist, gibt er eine entsprechende Nachricht aus.
     */
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
        menu.zahlungsMenu()

    }


    /*
    Die Funktion warenkorbPreis berechnet den Gesamtpreis aller Produkte im Warenkorb.
    Jetzt wird das Ergebnis als BigDecimal mit zwei Nachkommastellen und Rundung auf den nächsten geraden Wert zurückgegeben.
     */
    fun warenkorbPreis(): BigDecimal {
        var gesamtPreis = 0.0
        for (produkt in warenkorb) {
            gesamtPreis += produkt.preis
        }
        val dezimal = BigDecimal(gesamtPreis).setScale(2,RoundingMode.HALF_EVEN)
        return dezimal
    }


    /*
    Die Funktion "warenkorbLeeren" dient dazu, den aktuellen Warenkorb zu leeren, indem alle Produkte aus der Liste entfernt werden.
     */
    fun warenkorbLeeren(){
        warenkorb.clear()
        println("Ihr Warenkorb wurde erfolgreich geleert")
    }


    /*
    Die Funktion überprüft zuerst, um welchen Produkttyp es sich handelt und sucht dann im entsprechenden Ersatzteilsortiment nach dem passenden Ersatzteil.
    Wenn das Ersatzteil gefunden wird, wird die Anzahl reduziert.
    Dabei wird für jedes Produkt im Warenkorb überprüft, ob es ein Handydisplay, ein Handyakku, ein Handywerkzeug oder eine Handyanleitung ist.
     */
    fun bestandReduzieren() {

        for (produkt in warenkorb){

            if (produkt is Handydisplays){
                for (teil in ersatzTeilSortimentDisplay){
                    if (teil.name == produkt.name){
                        var index = ersatzTeilSortimentDisplay.indexOf(teil)
                        ersatzTeilSortimentDisplay[index].anzahl -= 1
                    }
                }

            } else if (produkt is Handyakkus){
                for (teilAkku in ersatzTeilSortimentAkku){
                    if (teilAkku.name == produkt.name){
                        var indexFromAkku = ersatzTeilSortimentAkku.indexOf(teilAkku)
                        ersatzTeilSortimentAkku[indexFromAkku].anzahl -= 1
                    }
                }

            } else if (produkt is Handywerkzeug){
                for (teilWerkzeug in ersatzteilWerkzeug){
                    if (teilWerkzeug.name == produkt.name){
                        var indexFromWerkzeug = ersatzteilWerkzeug.indexOf(teilWerkzeug)
                        ersatzteilWerkzeug[indexFromWerkzeug].anzahl -= 1
                    }
                }

            } else if (produkt is Handyanleitung){
                for (teilAnleitung in anleitungHandys){
                    if (teilAnleitung.name == produkt.name){
                        var indexFromAnleitung = anleitungHandys.indexOf(teilAnleitung)
                        anleitungHandys[indexFromAnleitung].anzahl -= 1
                    }
                }
            }

        }
    }






    // Leider nicht mehr zeitlich geschafft den Händler bereich zu beenden.
    // Ziel ist es aber Privat diesen noch zu vervollständigen
    fun haendlerBestellung(){

    }

    fun haendlerHinzufugen(){

    }

    fun haendlerLoeschen(){


    }


}
