package demo

import org.junit.Test

import org.junit.Assert.*

class GreetingJoinerTest {

    @Test
    fun getJoinedGreeting() {
        val joiner = GreetingJoiner(Greeter("Hello"))
        joiner.apply {
            addName("Foo")
            addName("Bar")
            addName("Baz")
        }

        assertEquals("Hello Foo and Bar and Baz", joiner.getJoinedGreeting())
    }
}