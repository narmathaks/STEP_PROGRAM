import java.util.Scanner;

public class CourierShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            double charge = 0.0;
            double insurance = 0.0;

            switch (type) {
                case "STANDARD":
                    charge = 40.0 + (10.0 * weight);
                    insurance = 0.0;
                    break;
                case "EXPRESS":
                    charge = 80.0 + (15.0 * weight);
                    insurance = 0.02 * declaredValue;
                    break;
                case "FRAGILE":
                    // Standard charge + 50 handling fee
                    charge = (40.0 + (10.0 * weight)) + 50.0;
                    insurance = 0.02 * declaredValue;
                    break;
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}