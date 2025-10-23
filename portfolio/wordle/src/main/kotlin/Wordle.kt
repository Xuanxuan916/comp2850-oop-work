// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isVaild(word: String): Boolean {
    val trimmed = word.trim()
    return word.length == 5 && trimmed.all {it.isLetter()}
}

fun readWorldList (filename: String): MutableList<String> {
    val words = mutableListOf<String>()
    File(filename).forEachLine { line ->
        val word = line.trim().lowercase()
        if (isVaild(word)){
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
