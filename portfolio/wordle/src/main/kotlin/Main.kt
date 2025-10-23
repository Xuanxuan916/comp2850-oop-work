private const val MAX_ATTEMPTS = 6
private const val WORDS_FILE = "words.txt"

fun main() {
    println("=== Welcome to the Worlde Game ===")
    print(" Enter the filename containing 5-letter words (e.g., words.txt): ")
    val filename = readLine()?.trim() ?: return
    val words = readWorldList(filename)

    if(words.isEmpty()) {
        println("No vaild 5-letters words found in the file" )
        return
    }
    
    val target = pickRandomWord(words)

    for(i in 1..6) {
        val guess = getGuess(i)
        val result = checkGuess(guess, target)
        showGuess(guess, result)

        if (guess == target) {
            println(" You are correct! The answer is ${target.uppercase()}")
            return 
        }
    }else()
    println(" You ran out of tries. The correct answer is ${target.uppercase()}")

}

