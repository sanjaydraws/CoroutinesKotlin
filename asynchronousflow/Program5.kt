// The flow { ... } builder from the previous examples is the most basic one. There are other builders for easier declaration
// of flows:

// flowOf builder defines a flow emitting a fixed set of values 
// Various collections and sequences can be converted to flows using .asFlow() extension functions.

fun main() = runBlocking<Unit>{
    // convert an integer range to a flow 
    (1..3).asFlow().collect{
        value -> println(value)
    }
}


fun main() = runBlocking<Unit>{
    // convert an integer range to a flow 
   listOf(1,2,4).asFlow().collect{
        value -> println(value)
    }
}


