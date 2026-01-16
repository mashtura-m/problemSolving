package mashtura_codes;

import java.util.*;

public class AssignmentSolutions {

    public static void main(String[] args) {
        calculateMaxDifference();
        calculatePrimeSum();
        calculateUniqueSum();
        findMissingNumber();
        countNumberOccurrences();
        findRepetitiveNumbers();
        analyzeUniqueCharacters();
        generatePermutations();
        createRandomPassword();
        removeSpecialCharacters();
        removeVowels();
        checkBinaryValidation();
        calculateLaptopCost();
        dispenseCurrency();
        calculateQuestionTypes();
    }

    private static void calculateMaxDifference() {
        int[] numbers = {11, 7, 2, 15, 6};
        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1];
        int secondMax = numbers[numbers.length - 2];
        System.out.println("Output: " + (max - secondMax));
    }

    private static void calculatePrimeSum() {
        int[] numbers = {11, 15, 2, 7, 6};
        int sum = 0;
        for (int number : numbers) {
            if (isPrime(number)) {
                sum += number;
            }
        }
        System.out.println("Output: " + sum);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void calculateUniqueSum() {
        int[] numbers = {11, 7, 7, 11, 2, 15, 6, 6};
        Set<Integer> uniqueSet = new HashSet<>();
        int sum = 0;
        for (int number : numbers) {
            if (uniqueSet.add(number)) {
                sum += number;
            }
        }
        System.out.println("Output: " + sum);
    }

    private static void findMissingNumber() {
        int[] numbers = {0, 1, 2, 4, 5};
        int n = 5;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        System.out.println("Output: " + (expectedSum - actualSum));
    }

    private static void countNumberOccurrences() {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int number : numbers) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }
        System.out.println("Output:");
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void findRepetitiveNumbers() {
        int[] numbers = {1, 2, 3, 4, 4, 5, 6, 6, 7};
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int number : numbers) {
            if (!seen.add(number)) {
                duplicates.add(number);
            }
        }
        System.out.println("Output: " + duplicates.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void analyzeUniqueCharacters() {
        String input = "abcaabbcc";
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!seen[c]) {
                seen[c] = true;
                if (count > 0) sb.append(", ");
                sb.append(c);
                count++;
            }
        }
        System.out.println("Unique characters: " + sb);
        System.out.println("Total unique characters: " + count);
    }

    private static void generatePermutations() {
        String input = "cat";
        List<String> results = new ArrayList<>();
        permute(input.toCharArray(), 0, results);
        System.out.println("Permutations: " + String.join(", ", results));
        System.out.println("Total permutations: " + results.size());
    }

    private static void permute(char[] arr, int k, List<String> results) {
        if (k == arr.length) {
            results.add(new String(arr));
        } else {
            for (int i = k; i < arr.length; i++) {
                swap(arr, i, k);
                permute(arr, k + 1, results);
                swap(arr, i, k);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void createRandomPassword() {
        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder sb = new StringBuilder(8);
        Random random = new Random();
        sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(26)));
        sb.append("abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26)));
        sb.append("0123456789".charAt(random.nextInt(10)));
        sb.append("!@#$%^&*".charAt(random.nextInt(8)));
        for (int i = 0; i < 4; i++) {
            sb.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        char[] password = sb.toString().toCharArray();
        for (int i = 0; i < password.length; i++) {
            int randIndex = random.nextInt(password.length);
            swap(password, i, randIndex);
        }
        System.out.println("Example Output: " + new String(password));
    }

    private static void removeSpecialCharacters() {
        String input = "s@atur!day";
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println("Output: " + sb);
    }

    private static void removeVowels() {
        String input = "I am a SQA Engineer";
        StringBuilder sb = new StringBuilder(input.length());
        boolean lastWasSpace = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ("AEIOUaeiou".indexOf(c) != -1) continue;
            if (Character.isWhitespace(c)) {
                if (!lastWasSpace) {
                    sb.append(' ');
                    lastWasSpace = true;
                }
            } else {
                sb.append(Character.toLowerCase(c));
                lastWasSpace = false;
            }
        }
        System.out.println("Output: " + sb.toString().trim());
    }

    private static void checkBinaryValidation() {
        String input1 = "1001";
        String input2 = "2001";
        System.out.println(input1 + " -> " + isBinary(input1));
        System.out.println(input2 + " -> " + isBinary(input2));
    }

    private static boolean isBinary(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0' && c != '1') return false;
        }
        return true;
    }

    private static void calculateLaptopCost() {
        String text = "A Core i7 laptop price is 85000 tk and a gaming mouse price is 2500 tk.";
        double total = 0;
        String[] parts = text.split("\\s+");
        for (int i = 0; i < parts.length - 1; i++) {
            if (parts[i + 1].startsWith("tk")) {
                try {
                    total += Integer.parseInt(parts[i]);
                } catch (NumberFormatException ignored) {}
            }
        }
        int finalPrice = (int) (total * 0.85);
        System.out.printf("Output: %,d tk%n", finalPrice);
    }

    private static void dispenseCurrency() {
        int amount = 546;
        int[] notes = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        System.out.println("Output:");
        for (int note : notes) {
            if (amount >= note) {
                int count = amount / note;
                amount %= note;
                System.out.println(note + " x " + count);
            }
        }
    }

    private static void calculateQuestionTypes() {
        int totalQuestions = 15;
        int totalMarks = 100;
        int y = (totalMarks - (5 * totalQuestions)) / 5;
        int x = totalQuestions - y;
        System.out.println("Output:");
        System.out.println("5-mark questions: " + x);
        System.out.println("10-mark questions: " + y);
    }
}