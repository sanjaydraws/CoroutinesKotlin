// Flows are cold
// Flows are cold streams similar to sequences â€” the code inside a flow builder does not run until the flow is collected.
// This becomes clear in the following example:


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow { // flow builder
    println("Flow started")
    for (i in 1..3) {
        delay(1000) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = simple() 
    println("Calling Collect")
    flow.collect{ value -> println(value)}
    println("Calling collect again")
    flow.collect{ value -> println(value)}
}


/*
Calling simple function...
Calling Collect
Flow started
1
2
3
Calling collect again
Flow started
1
2
3

*/