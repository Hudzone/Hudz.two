const val HERO_NAME: String = "Madrigal"
var playerLevel: Int = 5

fun main() {
    println("Hero was born")

    println("Hero's name: $HERO_NAME")
    println("Level: $playerLevel")

    readBountyBoard()
    println("Time passes... $HERO_NAME returns from his jorney...")

    playerLevel += 1
    println("$HERO_NAME level is $playerLevel")
    readBountyBoard()
}

private fun readBountyBoard() {
    println("$HERO_NAME approaches the bounty board. New task: ")
    println(obtainQuest(playerLevel, false, true, "paladin"))
}

private fun obtainQuest(
    // заголовок функции
    playerLevel: Int,
    hasAngeredBarbarians: Boolean,
    hasBeFriendedBarbarians: Boolean,
    playerClass: String
): String {
    // тело функции
    val quest: String = when (playerLevel) {
        1 -> "Meet Mr. Bubbles in the land of soft things"
        in 2..5 -> {
            // Проверить возможность дипломатического решения
            val canTalkToBarbarians = !hasAngeredBarbarians &&
                    (hasBeFriendedBarbarians || playerClass == "barbarian")
            // Добавляем условное выражение
            if (canTalkToBarbarians) {
                "Convince the barbarians to call off their invasion."
            } else {
                "Save the town from the barbarian invasions."
            }
        }
        6 -> "Locate the enchanted sword."
        7 -> "Recover the long-lost artifact of creation."
        8 -> "Defeat Nogartse, bringer of death and eater of worlds."
        else -> "There is no quest right now"
    }
    return quest
}