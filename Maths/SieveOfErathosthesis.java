import java.util.*;

class SieveOfErathosthesis {
    public static int findPrime(int n) {
        int count = 0;
        Boolean[] isPrime = new Boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false; // make all the multiple false if the no. is not prime
                }
                count++;
                System.out.print(i + " ");
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t *** Sieve of Erathosthesis algo *** \t");
        System.out.println("Enter the no. upto which prime no's you want to find : ");
        int n = sc.nextInt();

        System.out.println("\nAll prime no. upto n are: " + findPrime(n));
    }
}