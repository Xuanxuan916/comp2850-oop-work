import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec{
    
    "check if isVaild() works correctly" {
        println("Testing isValid()")
        isValid("apple") shouldBe true 
        isValid("abc") shouldBe false
        isValid("apple1") shouldBe false 
        isValid("hello") shouldBe true 
    }

    println("Testing checkGuess()...")
    val target = "table"
    val guess = "tales"
    val result = checkGuess(guess, target)
    println("Guess: $guess | Target: $target")
    println("Result: $result (expected: [2, 2, 1, 1, 0])")
    println()
    }

     println("Testing displayGuess()...")
    val guess2 = "apple"
    val result2 = listOf(1, 0, 2, 0, 1)
    displayGuess(guess2, result2)

    println()
    println("=== Tests finished ===")
})

