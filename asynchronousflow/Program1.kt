// suspending function asynchronously return a single values, to return multiple 
// asynchronously computed values Flow is used 

// u can flow to receive live updates from database 
// fun simple():List<Int> = listOf(1,2,3)

// fun main(){
//     simple().forEach{
//         value -> println(value)
//     }
// }

// =====================================


fun simple():Sequence<Int> = sequence{
    for(i in 1..3){
        Thread.sleep(100) // pretend we are computing it
        yield(i *10)
    }
}

this computation code blcoks the main thread and 
// ========================================
// Suspending functions

// When these values are computed by
// asynchronous code we can mark the simple function with a suspend modifier, so that it can perform its work without
// blocking and return the result as a list:


suspend fun simple(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}
fun main() = runBlocking<Unit> {
    simple().forEach { value -> println(value) }
}



