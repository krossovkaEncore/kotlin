package pisipopki

class Inventory(val maxWeight: Int = 50) {
    private var items: MutableList<Item> = mutableListOf()
    // private - модификатор доступа, чтобы наш список предметов был доступен только через инвентарь
    // <Item> - указывает, что положить в список, можно исключительно объекты класса Item
    fun addItem(item: Item) {
        // item - это параметр, который принимает метод и обрабатывает внутри себя
        // :Item - указывает на то, что в роли параметра можно положить только объекты класса Item
        items.add(item)
        // Добавлен переданный в параметре придмет в список (инвентарь)
        // add - добавить в конец списка
        println("предмет '${item.name}' добавлен в инвентарь")
    }
    //функция удаляющая предмет окак
    fun removeItem(item: Item): Boolean {
        // boolean - жто то что будет возращать метод после выполнения
        val removed = items.remove(item)
        //remove удаляет 1 элемент из списка по предмету который мы ищем (item)
        if (removed) {
            println("предмет '${item.name}' успешно удален")
        } else {
            println("такого предмета не существует")
        }

        return removed
    }
    // Сделать функцию inventoryPrint
    fun inventoryPrint() {
        println("=== my inventory ===")
        if (items.isEmpty()) {
            println("инвентарь пуст")
            return
        }
        // Которая через цикл for (item in items) выводит все элементы списка
        // Отобразим инвентарь после подбора предметов в инвентарь
        for (item in items) {
            // item - временная переменная которая будет каждую интерации цикла хранить в себе 1 элемент списка
            // пока не переберутся все элементы этого списка
            println("- ${item.name}")
        }
    }

    fun findItemByName(name: String): Item? {
        //Проходит по items в цикле for
        for (item in items) {
            //Если находит предмет с таким именем
            if (item.name == name) {
                //возвращаем item
                return item
            }
        }
        return null
    }

    fun findItemById(id: Int): Item? {
        //Проходит по items в цикле for
        for (item in items) {
            //Если находит предмет с таким id
            if (item.id == id) {
                //возвращаем item
                return item
            }
        }
        return null
    }
}
