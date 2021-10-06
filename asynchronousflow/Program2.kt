import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


/*
  using th List<Int> we returns all value at once 
To represent the stream of values that
are being asynchronously computed, we can use a Flow<Int> type just like we would use the Sequence<Int> type for
synchronously computed values:
*/


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow
    simple().collect { value -> println(value) } 
}


/*
 A builder function for Flow type is called flow 
 code inside flow {..} builder can sespend
 this simple() function no longer marked with suspend modifier 
 values are emited from the flow using emit function 
 values are collected from the flow using collect function 

*/


