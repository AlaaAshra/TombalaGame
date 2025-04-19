import java.util.LinkedList;

public class _22670310060_Kart {
    private String name;
    private LinkedList<Integer> numbers;
    private LinkedList<Integer> markedNumbers; 

    public _22670310060_Kart(String name, LinkedList<Integer> numbers) {
        this.name = name;
        this.numbers = new LinkedList<>(numbers);
        this.markedNumbers = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public boolean markNumber(int number) {
        if (numbers.contains(number) && !markedNumbers.contains(number)) {
            markedNumbers.add(number); 
            return true;
        }
        return false;
    }

    public boolean Finish() {
        return markedNumbers.size() == numbers.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            if (markedNumbers.contains(num)) {
                sb.append(num).append("# "); 
            } else {
                sb.append(num).append(" "); 
            }
        }
        return sb.toString().trim();
    }
}
