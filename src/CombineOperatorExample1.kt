import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        combineOperator()
    }
}

suspend fun combineOperator() {
    val numbers: Flow<Int> = flow {
        (1..10).forEach {
            delay(300L)
            emit(it)
        }
    }
    val words =
        listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten").asFlow().onEach {
            delay(400L)
        }

    numbers.combine(words) { a, b ->
        "$a -> $b"

    }.collect { it ->
        println(it)

    }

}