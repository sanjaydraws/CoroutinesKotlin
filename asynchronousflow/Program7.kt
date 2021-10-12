// Using the transform operator,
// we can emit arbitrary values an arbitrary number of times.
// For example, using transform we can emit a string before performing a long-running asynchronous request and follow
// it with a response:
suspend fun performRequest(request: Int): String {
    if (request==2)delay(5000) // imitate long-running asynchronous work
    return "response $request"
}

fun main() = runBlocking<Unit> {
(1..3).asFlow() // a flow of requests
        .transform { request ->
            emit("Making request $request")
            emit(performRequest(request))
        }
        .collect { response -> println(response) }
}

/*
Making request 1
response 1
Making request 2
response 2
Making request 3
response 3

*/