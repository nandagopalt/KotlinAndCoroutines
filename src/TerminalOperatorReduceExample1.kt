import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        reduceOperator()
    }
}

suspend fun reduceOperator() {
    val size = 10
    val factorial = (1..size).asFlow().reduce { accumulator, value ->
        accumulator * value
    }
    println("Factorial of $size is $factorial")
}