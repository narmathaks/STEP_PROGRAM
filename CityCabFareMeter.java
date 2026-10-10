import java.util.Scanner;

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        double totalFare = 0.0;

        for (int i = 0; i < n; i++) {
            String cab = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            // Check night service validity for MINI
            if (cab.equals("MINI") && time.equals("NIGHT")) {
                System.out.println(cab + ": night service not available");
                continue;
            }

            double ratePerKm = 0.0;
            switch (cab) {
                case "MINI": ratePerKm = 10.0; break;
                case "SEDAN": ratePerKm = 14.0; break;
                case "SUV": ratePerKm = 18.0; break;
            }

            double fare = km * ratePerKm;
            if (fare < 100.0) {
                fare = 100.0; // Minimum fare rule
            }

            if (time.equals("NIGHT")) {
                fare *= 1.20; // Add 20% for night service
            }

            totalFare += fare;
            System.out.printf("%s: %.2f%n", cab, fare);
        }

        System.out.printf("Total: %.2f%n", totalFare);
        scanner.close();
    }
}