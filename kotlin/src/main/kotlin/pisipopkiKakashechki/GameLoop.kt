package pisipopkiKakashechki

fun main(){
    val gameTime = GameTime()
    val player = Player(
        "Oleg",
        0.0,
        2.0
    )

    val enemy = Enemy(
        1,
        10.0,
        -1.0
    )

    println("Начальное положение беремености персонажей: ")
    player.printPosition()
    enemy.printPosition()

    while(true){
        // каждая итерация цикла - будет для нас игровым кадром
        gameTime.update()
        // Подсчет времени игрового
        val dt = gameTime.deltaTimeSeconds

        //обновляем позиции объектов с учетом прошедшего времени
        player.update(dt)
        enemy.update(dt)

        //вывод иформации с формированием
        println("прошло времени: ${"%.3f".format(gameTime.deltaTimeSeconds)} сек")
        // "%.3f" - значит отобразить 3 символа после '.'
        // format(число которое надо отформатировать)



        player.printPosition()
        enemy.printPosition()


        if (gameTime.deltaTimeSeconds >= 5) {// если время игры >= 5 то игра завершится
            println("Игра завершена, прошло 5 сек бой окончен")
            break
        } else if (enemy.x - player.x <= 0.0){// Считаем оставшиеся расстояние между игроками и врагами и выполняем условие
            println("Игра завершена, цели достигли друг друга")
            break
        }
    }
}