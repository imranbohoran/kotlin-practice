package com.tib.sandbox.kotlin

fun main(args: Array<String>) {
    // Strings
    greetings("Imran")
    greetingsDefault()
    greetingsDefault("Bohoran")

    // varargs
    kotlinVarargs("foo", "bar", "baz")

    // functions
    val value1 = 3
    val value2 = 4
    println("Is the value $value1 odd: "+ odd(value1))
    println("Is the value $value2 odd: "+ odd(value2))
    println("Is the value $value1 even: "+ even(value1))
    println("Is the value $value2 even: "+ even(value2))

    // functions taking functions
    val notOdd = not(::odd)
    val notEven = not(::even)
    println("Is the value $value1 not odd: "+ notOdd(value1))
    println("Is the value $value2 not odd: "+ notOdd(value2))
    println("Is the value $value1 not even: "+ notEven(value1))
    println("Is the value $value2 not even: "+ notEven(value2))

    // fibonachi
    println("Fibonachi of 2 is "+ fib(2))
    println("Fibonachi of 4 is "+ fib(4))
    println("Fibonachi of 5 is "+ fib(5))
    println("Fibonachi of 6 is "+ fib(6))

    println(fibSequence().take(4).toList())
    println(fibSequence().take(5).toList())
    println(fibSequence().take(8).toList())
}

fun greetings(name: String) {
    println("Greetings $name")
}

fun greetingsDefault(name: String = "Newbee") {
    greetings(name)
}

fun kotlinVarargs(vararg names: String) {
    println("We are passed in ${names.size} elements")
}

fun odd(number: Int): Boolean = number % 2 == 1

fun even(number: Int): Boolean = number % 2 == 0

fun not(f: (Int) -> Boolean): (Int) -> Boolean {
    return {number -> !f.invoke(number)}
}

fun fib(number: Int) : Int {
    if(number <= 2) return 1
    else
        return fib(number - 1) + fib(number - 2)
}

fun fibSequence() : Sequence<Long> {
    var current = 0L
    var next = 1L

    fun next(): Long {
        val result = current + next
        current = next
        next = result
        return current
    }

    return generateSequence(::next)
}
