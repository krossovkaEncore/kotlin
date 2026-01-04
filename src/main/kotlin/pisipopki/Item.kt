package pisipopki

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val damage: Int,
    val price: Int,
    val type: String, // weapon / armor / consumable
    var equipped: Boolean = false // потужно
)
