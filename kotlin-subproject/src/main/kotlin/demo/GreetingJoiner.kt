package demo

class GreetingJoiner(private val greeter: Greeter) {

    private val names = ArrayList<String?>()

    fun addName(name: String?) {
        names.add(name)
    }

    fun getJoinedGreeting(): String {
        return "${greeter.greeting} ${names.filterNotNull().joinToString(separator = " and ")}"
    }
}
