import java.util.Scanner;

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String appliance = scanner.next();
            double hours = scanner.nextDouble();
            boolean hasSaver = scanner.hasNext("SAVER");
            if (hasSaver) {
                scanner.next(); // consume "SAVER" token
            }

            double powerW = 0.0;
            boolean supportsSaver = false;

            switch (appliance) {
                case "FRIDGE":
                    powerW = 150.0;
                    supportsSaver = false;
                    break;
                case "AC":
                    powerW = 1500.0;
                    supportsSaver = true;
                    break;
                case "TV":
                    powerW = 100.0;
                    supportsSaver = false;
                    break;
                case "WASHER":
                    powerW = 500.0;
                    supportsSaver = true;
                    break;
            }

            if (hasSaver && !supportsSaver) {
                System.out.println(appliance + ": saver mode not supported");
                continue;
            }

            double units = (powerW * hours) / 1000.0;
            if (hasSaver && supportsSaver) {
                units *= 0.75; // 25% reduction
            }

            double cost = units * 8.0;
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}