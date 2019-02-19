import java.util.LinkedList;

public class LC273_IntegerToEnglishWords {
    private static final String[] smalls = {"Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] bigs = {"", "Thousand", "Million", "Billion"};
    private static final String hundred = "Hundred";

    public String numberToWords(int num) {
        if(num < 20) return smalls[num];

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while(num > 0){
            if(num % 1000 != 0){
                parts.addFirst(bigs[chunkCount]);
                parts.addFirst(convertChunk(num % 1000));
            }
            num /= 1000;
            chunkCount++;
        }

        return listToString(parts);
    }

    private String convertChunk(int num){
        LinkedList<String> parts = new LinkedList<>();

        if(num >= 100){
            parts.addLast(smalls[num / 100]);
            parts.addLast(hundred);
            num %= 100;
        }
        if(num >= 10){
            if(num < 20){
                parts.addLast(smalls[num]);
            } else {
                parts.addLast(tens[num / 10]);
                num %= 10;
            }
        }
        if(num >= 1 && num <= 9){
            parts.addLast(smalls[num]);
        }

        return listToString(parts);
    }

    private String listToString(LinkedList<String> list){
        StringBuilder sb = new StringBuilder();
        for(String part: list){
            sb.append(part).append(" ");
        }
        return sb.toString().trim();
    }
}
