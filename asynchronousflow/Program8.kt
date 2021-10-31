// size limiting operators  
// Size-limiting intermediate operators like take cancel the execution of the flow when the corresponding limit is reached.
// Cancellation in coroutines is always performed by throwing an exception, so that all the resource-management
// functions (like try { ... } finally { ... } blocks) operate normally in case of cancellation:


fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}
fun main()  = runBlocking<Unit>{
   numbers()
   .take(2) // take only first two 
   .collect{
       value -> println(value)
   }
}

/**
 * 1
2
Finally in numbers
 */