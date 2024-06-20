import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        takeOperator()
    }
}

suspend fun takeOperator() {
    (1..10).asFlow().take(3).collect { it ->
        println(it)
    }
}