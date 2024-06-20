import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        filterOperator()
    }
}

suspend fun filterOperator() {
    (1..10).asFlow().filter {
        delay(500L)
        it % 2 == 0
    }.collect { it ->
        println("Receiving $it")
    }
}