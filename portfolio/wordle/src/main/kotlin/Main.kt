import java.io.File
import kotlin.random.Random

private const val MAX_ATTEMPTS = 6
private const val WORDS_FILE = "words.txt"


fun isValid(word: String): Boolean {
    val trimmed = word.trim()
    return word.length == 5 && trimmed.all {it.isLetter()}
}

fun readWordList (filename: String): MutableList<String> {
    val words = mutableListOf<String>()
    File(filename).forEachLine { line ->
        val word = line.trim().lowercase()
        if (isValid(word)){
            words.add(word)
        }
    }
    return words
}

fun pickRandomWord (words: MutableList<String>) : String {
    require(words.isNotEmpty()) {" The list is empty, no operation performed." }
    println( "The list contains ${words.size} words ")
    val index = Random.nextInt(words.size)
    val word = words[index]
    words.removeAt(index)
    return word
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val input = readLine()?.trim()?.lowercase() ?: ""
        if (isValid(input)) {
            return input
        }else {
            println("Invalid input! Please enter a 5-letter word. ")
        }
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    require(guess.length == 5 && target.length == 5) 
    val result = mutableListOf<Int>()
    for(i in guess.indices) {
        if (guess[i] == target[i]) {
            result.add(1)
        }else {
            result.add(0)
        }
    }
    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    require(guess.length == matches.size) { "Guess and matches must have the same length." }
    val display = guess.mapIndexed { index, char ->
        if (matches[index] == 1){
            char
        } else{
            '?'
        }
    }.joinToString(" ")
    println(display)
}

fun main() {
    println("=== Welcome to the Worlde Game ===")
    print(" Enter the filename containing 5-letter words (e.g., words.txt): ")
    val filename = readLine()?.trim() ?: return
    val words = readWordList(filename)

    if(words.isEmpty()) {
        println("No valid 5-letters words found in the file" )
        return
    }
    
    val target = pickRandomWord(words)

    for(i in 1..6) {
        val guess = obtainGuess(i)
        val result = evaluateGuess(guess, target)
        displayGuess(guess, result)

        if (guess == target) {
            println(" You are correct! The answer is ${target.uppercase()}")
            return 
        }
    }
    println(" You ran out of tries. The correct answer is ${target.uppercase()}")

}

