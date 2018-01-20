package demo;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Greeter {
    private final String greeting;
}
