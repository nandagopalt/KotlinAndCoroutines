import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        mapOperator()
    }
}

suspend fun mapOperator() {
    (1..10).asFlow().map { it ->
        delay(500L)
        "mapping $it"
    }.collect { it ->
        println("Receiving $it")
    }
}
