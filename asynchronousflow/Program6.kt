// flow can be transformed with operators , just as you would with collection and sequences 
// Intermediate operators are applied to an upstream flow and return a downstream flow. These operators are cold, just like flows are. A

fun main() = runBlocking<Unit>{
    (1..3).asFlow()// a flow of request
    .map{request -> performRequest(request)}
    .collect{response -> println(response)}
    
}

suspend fun performRequest(request:Int):String{
    delay(100) // imitate long-running asynchronous task 
    return "response $request"
}