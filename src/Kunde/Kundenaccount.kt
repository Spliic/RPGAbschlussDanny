package Kunde
import Datenbank.Datenbank
import menuFromStore

class Kundenaccount: Datenbank() {


    open fun newAccountForUser(){
        println("Bitte gebe hier deinen Benutzername für dich ein")
        val addNewAcountName = readln()
        println("Bitte gebe für deinen Benutzernamen auch ein Passwort ein")
        val addNewAccountPassword = readln()
        kunde[addNewAcountName] = addNewAccountPassword
        println("Neues Kundenkonto mit Benutzername:$addNewAcountName wurde angelegt.")


    }



}