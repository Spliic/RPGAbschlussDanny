package Datenbank
open class Datenbank {

    var haendler = mutableMapOf<String,String>()
    var kunde = mutableMapOf<String,String>()

    init {
        this.haendler = mutableMapOf(
            "Oliver" to "Oliver123",
            "Danny" to "Danny123",
            "Gordon" to "Gordon123")
        this.kunde = mutableMapOf(
            "Angi" to "Angi123",
            "Emre" to "Emre123",
            "Kevin" to "Kevin123",
            "Dimi" to "Dimi123")
    }

    var dispalys = mutableMapOf<String,Double>()

    init {
        this.dispalys = mutableMapOf(
            "iPhone 14 Display" to 129.99,
            "iPhone 13 Display" to 109.99,
            "iPhone 12 Display" to 89.99,
            "iPhone 12 Display" to 69.99
        )
    }
}