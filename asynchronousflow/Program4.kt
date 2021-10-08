// Flow cancellation basics
// how the flow gets
// cancelled on a timeout when running in a withTimeoutOrNull block
//  and stops executing its code:
fun simple():Flow<Int> = flow{
    for(i in 1..13){
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    withTimeoutOrNull(350){
        //timeout after 350 ms 
        simple().collect{
            value -> println(value)
        }
    }
    println("Done")
}

/*
Emitting 1
1
Emitting 2
2
Emitting 3
3
Done
*/