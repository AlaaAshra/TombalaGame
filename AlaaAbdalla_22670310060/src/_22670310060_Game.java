import java.io.File;
import java.io.IOException;
import java.util.*;

public class _22670310060_Game {
    private List<_22670310060_Player> players = new ArrayList<>(); 
    private HashMap<String, _22670310060_Kart> cards = new HashMap<>(); 
    private Set<Integer> drawnNumbers = new HashSet<>(); 
    private final int MAX_NUMBER = 20; 

   
    public void ReadFile(String fileName) throws IOException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            boolean readingPlayers = true;

            while (scanner.hasNextLine()) {
               String line = scanner.nextLine().trim(); 
                if (line.isEmpty()) continue;  

                if (line.startsWith("Oyun Kartları:")) {
                    readingPlayers = false; 
                    continue;
                }
                if (line.isEmpty() || line.equals("Kişiler ve Seçtikleri Kart:") ) {
                    continue;
                }

                if (readingPlayers) {
                	
                    String[] parts = line.split(" ");
                    String playerName = parts[0];
                    String cardName = parts[1]; 
                    players.add(new _22670310060_Player(playerName, cardName));
                } else {
                    String[] parts = line.split(" ");
                    String cardName = parts[0]; 
                    LinkedList<Integer> cardNumbers = new LinkedList<>();
                    for (int i = 1; i < parts.length; i++) {
                        cardNumbers.add(Integer.parseInt(parts[i])); 
                    }
                    cards.put(cardName, new _22670310060_Kart(cardName, cardNumbers));
                }
            }
        }
        System.out.println("Bilgiler.txt dosyası okundu."); 
    }

  
    public void start() throws InterruptedException {
        Random random = new Random();
        boolean gameOver = false; 

        while (!gameOver) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            if (drawnNumbers.contains(number)) continue; 

            drawnNumbers.add(number);

            System.out.println("Çekilen sayı: " + number);

            for (_22670310060_Player player : players) {
                _22670310060_Kart card = cards.get(player.getCardName()); 
                card.markNumber(number);

                System.out.println(player.getName() + " " + card);

                if (card.Finish()) {
                    System.out.println("\nOyun bitti.");
                    System.out.println("Kazanan: " + player.getName());
                    gameOver = true;
                    break;
                }
            }

            Thread.sleep(500); 
        }
    }

}


