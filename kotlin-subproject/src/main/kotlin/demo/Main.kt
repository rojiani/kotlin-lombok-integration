package demo

fun main(args: Array<String>) {
    val example = GreetingJoiner(Greeter("Hi"))

    example.addName("Harry")
    example.addName("Ron")
    example.addName(null)
    example.addName("Hermione")

    println(example.getJoinedGreeting())
}