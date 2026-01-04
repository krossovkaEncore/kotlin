package pisipopkiKakashechki

open class GameObject(
    // open - открыть класс что бы можно было его наследовать
    // теперь можно делать дачерний классы от GameObject

    var x: Double, // x - позиция по кординатм X (горизантально)
    var speed: Double // скорость перемешения объекта (соколько по xy пройдет за сек.)
) {
    open fun update(deltaTimeSeconds: Double) {
        x += speed * deltaTimeSeconds
        //считаем сколько едениц по x мы должны пройти за delta времени
    }
}

class Player(
    val name: String,
    x: Double,
    speed: Double
): GameObject(x, speed) {
    // : GameObject - наследование род класса {x и speed} это свойство которые наследуются
    fun printPosition(){
        println("$name находится в положении x = $x")
    }
}

class Enemy(
    val id: Int,
    x: Double,
    speed: Double
): GameObject(x, speed) {
    fun printPosition(){
        println("враг с id = $id находится в положении по x = $x")
    }
}