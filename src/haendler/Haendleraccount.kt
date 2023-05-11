package haendler
import Datenbank.Datenbank
import menuFromStore

class Haendleraccount: Datenbank() {


    /*
    Diese Funktion erstellt ein neues Händlerkonto.
    Zunächst fordert sie den Benutzer auf, einen Benutzernamen und ein Passwort für das neue Konto einzugeben.
    Dann wird das Konto in eine liste namens haendler gespeichert
     */
    fun newAccountForHaendler() {
        println("Bitte gebe hier deinen Benutzername für dich ein")
        val addNewAcountNameHaendler = readln()
        println("Bitte gebe für deinen Benutzernamen auch ein Passwort ein")
        val addNewAccountPasswordHaendler = readln()
        haendler[addNewAcountNameHaendler] = addNewAccountPasswordHaendler
        println("Neues Händlerkonto mit Benutzername: $addNewAcountNameHaendler wurde angelegt.")

    }


}