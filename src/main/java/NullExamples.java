import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NullExamples {

    public static void main(String[] args) {

        Integer @NonNull [] numbers = null;
        @NonNull Object foo = null;

        // @NonNull is default
        Object ref = null;
        ref.toString();

        //

        @Nullable Integer x = null;
        x.toString();
        x.toString();

        //

        @NonNull Object neverNull = new Object();

        if (neverNull == null) {
            System.out.println("??");
        }

        //

        @MonotonicNonNull Object lazyInitialized = null;

        lazyInitialized = new Object();
        lazyInitialized.toString();

        lazyInitialized = null;
    }
}