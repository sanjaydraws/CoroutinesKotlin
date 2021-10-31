Terminal flow operators
/* 
Terminal operators on flows are suspending functions that start a collection of the flow. The collect operator is the most
basic one, but there are other terminal operators, which can make it easier:
Conversion to various collections like toList and toSet.
Operators to get the first value and to ensure that a flow emits a single value.
Reducing a flow to a value with reduce and fold.

 */

fun main()  = runBlocking<Unit>{
    val sum = (1..5).asFlow()
    .map{it * it} // square of numbers 
    .reduce{a,b -> a+b} // sum  them terminal opearator
    println(sum) // 55 
 }
 