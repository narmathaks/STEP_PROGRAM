
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CinemaBooking {
    public static void main(String[] args) {
        // The convenience fee per ticket, written in one place only
        final double CONVENIENCE_FEE = 20.0;

        // Base ticket prices per seat type
        Map<String, Double> prices = new HashMap<>();
        prices.put("REGULAR", 150.0);
        prices.put("PREMIUM", 250.0);
        prices.put("RECLINER", 400.0);

        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            // Calculate base price + convenience fee for all tickets in this booking
            double baseAmount = prices.get(seatType) * count;
            double feeAmount = CONVENIENCE_FEE * count;
            double amount = baseAmount + feeAmount;

            totalCollected += amount;

            // Print booking result formatted to two decimal places
            System.out.printf("%s: %.2f%n", seatType, amount);
        }

        // Print total collected formatted to two decimal places
        System.out.printf("Total: %.2f%n", totalCollected);
        
        scanner.close();
    }
}