import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        zipOperator()
    }
}

suspend fun zipOperator() {
    val numbers: Flow<Int> = flowOf(1, 2, 3, 4, 5)
    val words: Flow<String> = flowOf("One", "Two", "Three", "Four", "Five")
    numbers.zip(words) { numberEntry, wordEntry ->
        "$numberEntry -> $wordEntry"
    }.collect {
        println(it)
    }
}