import org.checkerframework.checker.tainting.qual.Tainted;
import org.checkerframework.checker.tainting.qual.Untainted;

public class TaintingExamples {

    public static void main(String[] args) {
        new TaintingExamples().processRequest();
    }

    private @Tainted String getUserInput() {
        return "SQL injection";
    }

    private void processRequest() {
        String data = getUserInput();
        executeQuery(data);
    }

    private void executeQuery(final @Untainted String input) {
        // Do some SQL Query
    }
}