import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        transformOperator()
    }
}

suspend fun transformOperator() {
    (1..10).asFlow().transform { it ->
        delay(it * 1000L)
        emit("Emitting String value $it")
        emit(it)
    }.collect { it ->
        println(it)
    }
}