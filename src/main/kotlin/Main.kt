const val HERO_NAME: String = "Madrigal"
var playerLevel: Int = 0

fun main() {
    println("Hero was born")
    println("Hero's name: $HERO_NAME")
    println("What level is $HERO_NAME:  ")
    val playerLevelInput = readLine()!!
    playerLevel = if (playerLevelInput.matches("""\d+""".toRegex())) {
        playerLevelInput.toInt()
    } else {
        1
    }
    println("$HERO_NAME's level is $playerLevel.")

    readBountyBoard()
    println("Time passes... $HERO_NAME returns from his jorney...")

    playerLevel += 1
    println("$HERO_NAME level is $playerLevel")
    readBountyBoard()
}

private fun readBountyBoard() {
    println(
        """
        |$HERO_NAME approaches the bounty board. New task:
        |   "${obtainQuest(playerLevel).replace("[Nn]ogartse".toRegex(), "xxxxxx")}"
        """.trimMargin()
    )
}

private fun obtainQuest(
    // заголовок функции
    playerLevel: Int,
    playerClass: String = "paladin",
    hasBeFriendedBarbarians: Boolean = true,
    hasAngeredBarbarians: Boolean = false
): String = when (playerLevel) {
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