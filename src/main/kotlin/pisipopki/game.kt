package pisipopki

class Player(
    val name: String,
    var hp: Int = 100
) {
    val inventory = Inventory()

    // получить люлей
    fun takeDamage(amount: Int) {
        hp -= amount
        if (hp < 0) hp = 0
        println("Игрок словил $amount урона")
    }

    fun isAlive(): Boolean {
        return hp > 0
    }

    // экипируем шмот
    fun equip(item: Item) {
        if (item.type == "weapon" || item.type == "armor") {
            item.equipped = true
            println("Ты надел ${item.name}")
        } else {
            println("Это хрень не экипируется (${item.name})")
        }
    }

    // юзаем расходник
    fun useConsumable(item: Item) {
        if (item.type != "consumable") {
            println("Это не расходник: ${item.name}")
            return
        }

        println("Ты бахнул ${item.name} и отхилился на ${item.damage}")
        hp += item.damage
        if (hp > 100) hp = 100

        inventory.removeItem(item)
    }
}

fun main() {

    print("Имя игрока: ")
    val player = Player(readLine()!!)

    // базовые предметы (для теста и начала игры)
    val sword = Item(1, "Меч", "Ну просто меч", 20, 10, "weapon")
    val armor = Item(2, "Броня", "Пожившая но норм", 0, 15, "armor")
    val smallPotion = Item(3, "Малое зелье", "Хилит слегка", 25, 5, "consumable")

    player.inventory.addItem(sword)
    player.inventory.addItem(armor)
    player.inventory.addItem(smallPotion)

    val enemy = Enemy("Гоблин", 100, 12)

    println("\nБой начинается!\n")

    while (player.isAlive() && enemy.isAlive()) {

        println(
            "\n1) Атаковать\n" +
                    "2) Выпить зелье\n" +
                    "3) Мой статус\n"
        )
        print(">>> ")

        when (readLine()!!.toInt()) {

            1 -> {
                // удар игрока
                val weapon = player.inventory.findItemByName("Меч")
                val dmg = weapon?.damage ?: 5 // без меча кулачком
                println("Ты наносишь $dmg урона")
                enemy.takeDamage(dmg)
            }

            2 -> {
                val potion = player.inventory.findItemByName("Малое зелье")
                if (potion != null) player.useConsumable(potion)
                else println("ну нет у тебя зелья")
            }

            3 -> {
                println("HP игрока: ${player.hp}")
                println("HP врага: ${enemy.hp}")
            }
        }

        // враг ходит, если жив
        if (enemy.isAlive()) enemy.attack(player)
    }

    // конец матча
    if (player.isAlive())
        println("Ты победил, капитан!")
    else
        println("ГГ, тебя размотали...")
}
