import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
       /* val numbers: Flow<Int> = flowOperatorV2()
        numbers.transform { it ->
            delay(500L)
            emit(it * it)
            emit("Square of $it is ${it * it}")
        }.collect { it ->
            println("Receiving $it")
        }*/

        flowOnOperator()
    }
}

suspend fun flowOnOperator() {
    (1..10).asFlow().flowOn(Dispatchers.IO).take(3).map { it ->
        delay(2000L)
        "mapping $it"

    }.take(3).collect { it ->
        println("Receiving $it")
    }
}

fun flowOperatorV2(): Flow<Int> = flow {
    val size = 10
    for (i in 1..size) {
        emit(i)
    }
}