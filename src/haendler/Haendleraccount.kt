package haendler
import Datenbank.Datenbank

class Haendleraccount: Datenbank() {

    fun newAccountForHaendler(){
        println("Bitte gebe hier deinen Benutzername für dich ein")
        val addNewAcountNameHaendler = readln()
        println("Bitte gebe für deinen Benutzernamen auch ein Passwort ein")
        val addNewAccountPasswordHaendler = readln()
        haendler[addNewAcountNameHaendler] = addNewAccountPasswordHaendler
        println("Neues Händlerkonto mit $addNewAcountNameHaendler wurde angelegt.")
    }

}