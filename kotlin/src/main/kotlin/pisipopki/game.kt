package pisipopki

class Player(
    val name: String
){
    val inventory = Inventory()
}

fun main(){
    print("Как корабыль назовешь, так на нем и поплывешь: ")
    val player = Player(readLine()!!)
    while(true){
        println(
            "1) Добавить предмет в инвентарь\n" +
                    "2) Посмотреть содержимое инвенторя\n" +
                    " === DANGER ZONE ===\n" +
                    "3) удалить предмет из инвенторя\n" +
                    "4) Выход из игры"
        )
        print("выберете действие: ")
        val action: Byte = readLine()!!.toByte()

        if(action == 1.toByte()){
            print("введите айди нового предмета: ")
            val idItm: Int = readLine()!!.toInt()
            print("введите имя нового предмета: ")
            val nameItm: String = readLine()!!
            print("введите описание нового предмета: ")
            val descriptionItm: String = readLine()!!
            print("введите урон нового предмета: ")
            val damageItm: Int = readLine()!!.toInt()
            print("введите цену на предмет: ")
            val priceItm: Int = readLine()!!.toInt()
            val item = Item(idItm, nameItm, descriptionItm, damageItm, priceItm)

            player.inventory.addItem(item)
        }else if(action == 2.toByte()){
            player.inventory.inventoryPrint()
        }else if(action == 3.toByte()){
            print(
                "Как хотите указать предмет?\n" +
                        "1) айдишником\n" +
                        "2) именем\n" +
                        ">>> "
            )
            val act: Byte = readLine()!!.toByte()
            if(act == 1.toByte()){
                print("Укажите айди предмета: ")
                val id: Int = readLine()!!.toInt()
                val item: Item? = player.inventory.findItemById(id)
                if(item != null) {
                    player.inventory.removeItem(item)
                }
            } else if(act == 2.toByte()){
                print("Укажите имя предмета: ")
                val name: String = readLine()!!
                val item: Item? = player.inventory.findItemByName(name)
                if(item != null) {
                    player.inventory.removeItem(item)
                }
            } else {
                println("Олег негодяй не делай так")
            }
        }else if(action == 4.toByte()){
            break
        }else {
            println("Олег тестировщик не страдай фигней")
        }
    }
}
