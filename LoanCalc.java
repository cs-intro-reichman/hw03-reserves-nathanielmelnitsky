/**
 * Computes the periodical payment necessary to re-pay a given loan.
 */
public class LoanCalc {

    static double epsilon = 0.001;  // The computation tolerance (estimation error)
    static int iterationCounter;    // Monitors the efficiency of the calculation

    /**
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).
     */
    public static void main(String[] args) {
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // periodical payment with brute force search
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);

        // reset counter
        iterationCounter = 0;

        // periodical payment wt bisection search
        System.out.print("Periodical payment, using bi-section search: ");
        System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
    }

    /**
     * Uses a sequential search method  ("brute force") to compute an approximation
     * of the periodical payment that will bring the ending balance of a loan close to 0.
     * Given: the sum of the loan, the periodical interest rate (as a percentage),
     * the number of periods (n), and epsilon, a tolerance level.
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double low = 0;
        double high = loan * (1 + rate / 100) / n;
        double paymentSize = (low + high) / 2;

        while (Math.abs(endBalance(loan, rate, n, paymentSize)) > epsilon) {

            paymentSize += paymentSize;
            iterationCounter++;
        }
        return paymentSize;
    }

    /**
     * Uses bisection search to compute an approximation of the periodical payment
     * that will bring the ending balance of a loan close to 0.
     * Given: the sum of the loan, the periodical interest rate (as a percentage),
     * the number of periods (n), and epsilon, a tolerance level.
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        double low = 0;
        double high = loan * (1 + rate / 100) / n;
        double paymentSize = (low + high) / 2;

        while (Math.abs(endBalance(loan, rate, n, paymentSize)) > epsilon) {
            if (endBalance(loan, rate, n, paymentSize) > 0) {
                high = paymentSize;
            } else {
                low = paymentSize;
            }
            paymentSize = (low + high) / 2;
            iterationCounter++;
        }
        return paymentSize;
    }

    /**
     * Computes the ending balance of a loan, given the sum of the loan, the periodical
     * interest rate (as a percentage), the number of periods (n), and the periodical payment.
     */
    private static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance *= (1 + rate / 100);
            balance -= payment;
        }
        return balance;
    }
}
