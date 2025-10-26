// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean {
    var noSpaces = ""
    for (letter in word) {
        if (letter != ' ') {
            noSpaces = noSpaces + letter
        }
    }

    if (noSpaces.length != 5) {
        return false
    }

    for (letter in noSpaces) {
        if (!letter.isLetter()) {
            return false
        }
    }

    return true
}


fun readWordList(filename: String): MutableList<String> {
    val words = mutableListOf<String>()
    val file = File(filename)

    if (!file.exists()) {
        println("File not found: $filename")
        return words
    }

    val lines = file.readLines()
    for (line in lines) {
        var word = ""
        for (letter in line) {
            if (letter == ' ') {
            } else if (letter == '\n') {
            } else if (letter == '\r') {
            } else if (letter == '\t') {
            } else {
                word = word + letter
            }
        }

        word = word.lowercase()

        if (isValid(word)) {
            words.add(word)
        }
    }

    return words
}

fun pickRandomWord(words: MutableList<String>): String {
    if (words.isEmpty()) {
        println("The word list is empty.")
        return ""
    }

    val index = Random.nextInt(words.size)
    val word = words[index]
    println("There are ${words.size} words in total. A random one is chosen.")
    return word
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: Please enter a 5-letter word: ")
        val inputLine = readLine()
        var guess = ""

        if (inputLine != null) {
            for (letter in inputLine) {
                if (letter == ' ') {
                } else if (letter == '\n') {
                } else if (letter == '\r') {
                } else if (letter == '\t') {
                } else {
                    guess = guess + letter
                }
            }
            guess = guess.lowercase()
        }

        if (isValid(guess)) {
            return guess
        } else {
            println("Invalid input! Please enter exactly 5 English letters.")
        }
    }
}


fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>()

    for (i in 0 until 5) {
        if (guess[i] == target[i]) {
            result.add(1)  
        } else {
            result.add(0) 
    }

    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    print("Result: ")
    for (i in 0 until guess.length) {
        if (matches[i] == 1) {
            print(guess[i] + " ")  
        } else {
            print("? ")          
        }
    }
    println()
}
