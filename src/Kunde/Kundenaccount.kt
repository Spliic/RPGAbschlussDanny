package Kunde
import Datenbank.Datenbank

class Kundenaccount: Datenbank() {


    open fun newAccountForUser(){
        println("Bitte gebe hier deinen Benutzername für dich ein")
        val addNewAcountName = readln()
        println("Bitte gebe für deinen Benutzernamen auch ein Passwort ein")
        val addNewAccountPassword = readln()
        kunde[addNewAcountName] = addNewAccountPassword
        println("Neues Kundenkonto mit $addNewAcountName wurde angelegt.")
    }






}