package pisipopki

class Inventory(val maxItems: Int = 50) {

    private var items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) {
        if (items.size == maxItems) {
            println("инвентарь полный, братан")
        } else {
            items.add(item)
            println("предмет '${item.name}' добавлен")
        }
    }

    fun removeItem(item: Item): Boolean {
        val removed = items.remove(item)
        if (removed) println("предмет '${item.name}' удалён")
        return removed
    }

    fun inventoryPrint() {
        println("=== inventory ===")
        if (items.isEmpty()) {
            println("пусто как в душе после пар")
            return
        }
        for (item in items) {
            println("- ${item.name} | тип: ${item.type} | надет: ${item.equipped}")
        }
    }

    fun findItemById(id: Int): Item? {
        for (item in items)
            if (item.id == id) return item
        return null
    }

    fun findItemByName(name: String): Item? {
        for (item in items)
            if (item.name == name) return item
        return null
    }
}
