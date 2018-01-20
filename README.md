Kotlin + Java/Lombok Build Demo
===============================

Using Kotlin in an existing Java project that uses Kotlin has caused a lot of problems for people, with several questions on StackOverflow & elsewhere (see [1](https://stackoverflow.com/questions/35517325/kotlin-doesnt-see-java-lombok-accessors),
[2](https://stackoverflow.com/questions/46027391/is-it-possible-to-use-lombok-with-kotlin), [3](https://stackoverflow.com/questions/44180267/configuring-kapt-to-process-lombok-annotations), [4](https://stackoverflow.com/questions/46950837/how-to-use-lombok-with-kapt3),
[5](https://github.com/rzwitserloot/lombok/issues/1416),
[6](https://github.com/rzwitserloot/lombok/issues/1169),
[7](https://discuss.kotlinlang.org/t/kotlin-java-lombok-interop/1442))

Looking through it, there were some suggestions of it being possible using Kapt &/or Delombok, but not much of clear guidance, until I found [this answer](https://discuss.kotlinlang.org/t/kotlin-java-lombok-interop/1442):
> If you put Java and Kotlin code in different modules, it should work. Rationale: Kotlin will see whatever declarations get to the byte code, but it can’t see whatever Lombok generates on-the-fly in the source code

This project shows a Hello World app using a Gradle multi-project build, but it should also work for Maven if you split the Java & Kotlin into [separate modules](https://github.com/rzwitserloot/lombok/issues/1169).

Sharing this so that no one who wants to try using Kotlin in an existing Java+Lombok project gets stuck in the process.

## References ##

This hello-world app is an adapted version of JetBrains' [mixed-java-kotlin-hello-world](https://github.com/JetBrains/kotlin-examples/tree/master/gradle/mixed-java-kotlin-hello-world) example.

See the [Gradle Tutorial](https://guides.gradle.org/creating-multi-project-builds/) for more info on multi-project builds (& [code on GitHub](https://github.com/gradle-guides/creating-multi-project-builds/tree/master/src/example)).

[Kotlin - Using Gradle](https://kotlinlang.org/docs/reference/using-gradle.html)

## Running the app ##

Versions used:
* Gradle: 4.4.1 (use gradle wrapper)
* Kotlin: 1.2.20
* Java: 1.8.0.152
* Lombok: 1.16.20

### Gradle ###

Run `Main.kt`:
```shell
$ cd kotlin-lombok-integration
$ ./gradlew build
$ ./gradlew run

> Task :kotlin-subproject:run
Hi Harry and Ron and Hermione

BUILD SUCCESSFUL in 0s
4 actionable tasks: 1 executed, 3 up-to-date
```

Run Tests:
```
(  ) at Fri 1.19.18 in kotlin-lombok-integration on  master [!]
❯❯❯ ./gradlew test

> Task :kotlin-subproject:test

demo.GreetingJoinerTest > getJoinedGreeting PASSED


BUILD SUCCESSFUL in 2s
5 actionable tasks: 2 executed, 3 up-to-date
```

### IntelliJ ###

Importing: `Import Project` -> `Import project from external model` -> Gradle

Note: In the IntelliJ preferences, make sure you enable the Lombok plugin & annotation processing for the project.

Open `Main.kt`. Click the run/start symbol & select Run `demo.MainKt`. Kotlin code should be able to call any Lombok-generated methods on Java classes (e.g., `"${greeter.greeting} ..."` in `GreetingJoiner.kt`). 
