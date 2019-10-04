import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {

        // Default is maybe present
        Optional<Integer> optionalIntegerWhichIsEmpty = Optional.empty();
        optionalIntegerWhichIsEmpty.get();

        Optional<Integer> optionalIntegerWhichIsNotEmpty = Optional.of(4);
        optionalIntegerWhichIsNotEmpty.get();

        // Safe use enforced by compiler
        Optional<Integer> optionalIntegerSafeUse = Optional.empty();
        if (optionalIntegerSafeUse.isPresent()) {
            optionalIntegerSafeUse.get();
        }
    }
}