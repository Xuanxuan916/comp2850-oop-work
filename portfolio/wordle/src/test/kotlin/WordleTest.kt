import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    
    "check if isVaild() works correctly" {
        println("Testing isVaild()")
        isVaild("apple") shouldBe true 
        isVaild("abc") shouldBe false
        isVaild("apple1") shouldBe false 
        isVaild("hello") shouldBe true 
    }

    "check if checkGuess() works" {
        println("Testing checkGuess()")
        val target = "table"
        val guess = "tales"
        val result = checkGuess(guess, target)
        val expected = listOf(2, 2, 1, 1, 0)
        result shouldBe expected
    }

    "check if displayGuess() runs fine" {
        println("Testing displayGuess()...")
        val guess = "apple"
        val result = listOf(1, 0, 2, 0, 1)
        displayGuess(guess, result)
    }
})
})
