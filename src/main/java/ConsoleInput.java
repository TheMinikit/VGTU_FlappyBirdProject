import java.io.IOException;

public class ConsoleInput {

    public int readConsoleInput() throws IOException {
        int inputKey;
        do {
            inputKey = System.in.read();
        } while (inputKey == 10);
        return inputKey;
    }

}
