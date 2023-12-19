public class lab2 {
    public static int factorialRecursion(int n) {
            if (n == 0) {
                return 1;
            } else {
                return n * factorialRecursion(n - 1);
            }
        }
    
      
        public static int factorialIteration(int n) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    
        public static void main(String[] args) {
            int num = 5; 
    

            long startTimeRecursion = System.nanoTime();
            int resultRecursion = factorialRecursion(num);
            long endTimeRecursion = System.nanoTime();
            long timeRecursion = endTimeRecursion - startTimeRecursion;
    
     
            long startTimeIteration = System.nanoTime();
            int resultIteration = factorialIteration(num);
            long endTimeIteration = System.nanoTime();
            long timeIteration = endTimeIteration - startTimeIteration;
    
     
            System.out.println("Using Recursion:");
            System.out.println("Factorial of " + num + " is: " + resultRecursion);
            System.out.println("Time taken: " + timeRecursion + " nanoseconds\n");
    
            System.out.println("Using Iteration:");
            System.out.println("Factorial of " + num + " is: " + resultIteration);
            System.out.println("Time taken: " + timeIteration + " nanoseconds");
        }
    }
    
