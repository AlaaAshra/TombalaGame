import java.io.IOException;

public class _22670310060_Main {
    public static void main(String[] args) throws InterruptedException {
        String fileName = "Bilgiler.txt";
        _22670310060_Game game = new _22670310060_Game();

        try {
            game.ReadFile(fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        game.start();
    }
}

