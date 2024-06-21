import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            generateFlow().buffer().collect { it ->
                delay(300L)
                println(it)
            }
        }
        println("Collected in time: $time ms")
    }
}

suspend fun generateFlow(): Flow<Int> = flow {
    val size = 10
    for (i in 1..size) {
        delay(100L)
        emit(i)
    }
}