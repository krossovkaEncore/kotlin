package pisipopki

class Enemy(
    val name: String,
    var hp: Int,
    val damage: Int
) {

    // получает люлей
    fun takeDamage(amount: Int) {
        hp -= amount
        if (hp < 0) hp = 0
        println("$name получил $amount урона")
    }

    // живой ли чел
    fun isAlive(): Boolean {
        return hp > 0
    }

    // наносит удар игроку
    fun attack(player: Player) {
        // 20% шанс на промах
        val missChance = (1..100).random()
        if (missChance <= 20) {
            println("$name промахнулся как лох")
            return
        }

        println("$name атакует игрока и наносит ${damage} урона")
        player.takeDamage(damage)
    }
}
