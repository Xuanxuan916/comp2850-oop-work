// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isVaild(world: String): Boolean {
    val trimmed = word.trim()
    return world.length == 5 && trimmed.all {it.isLetter()}
}

fun readWorldList (filename: String): MutableList<String> {
    val words = mutableList<String>()
    File(filename).forEachLine { line ->
        val word = line.trim().lowercase().
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