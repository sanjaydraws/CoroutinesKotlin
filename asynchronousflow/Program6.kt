// flow can be transformed with operators , just as you would with collection and sequences 
// Intermediate operators are applied to an upstream flow and return a downstream flow. These operators are cold, just like flows are. A


// The basic operators have familiar names like map and filter. The important difference to sequences is that blocks of
// code inside these operators can call suspending functions.

// For example, a flow of incoming requests can be mapped to the results with the map operator, even when performing
// a request is a long-running operation that is implemented by a suspending function:
fun main() = runBlocking<Unit>{
    (1..3).asFlow()// a flow of request
    .map{request -> performRequest(request)}
    .collect{response -> println(response)}
    
}

suspend fun performRequest(request:Int):String{
    delay(100) // imitate long-running asynchronous task 
    return "response $request"
}


==========================================
fun main() = runBlocking<Unit>{
    (1..3).asFlow()// a flow of request
    .map{request -> performRequest(request)}
    .collect{response -> println(response)}
    
}

suspend fun performRequest(request:Int):String{
    if(request == 2)
        delay(200) // imitate long-running asynchronous task 
    else
        delay(100)
    return "response $request"
}

