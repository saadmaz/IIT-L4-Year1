public class ArrayTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the size of the student arrays
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Declare the student arrays
        String[] students = new String[numStudents];
        double[] scores = new double[numStudents];

        // Read student names and scores
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Enter name %d: ", i + 1);
            students[i] = scanner.nextLine();

            System.out.printf("Enter score for %s: ", students[i]);
            scores[i] = scanner.nextDouble();
            scanner.nextLine(); // Consume remaining newline character
        }

        // Calculate overall average
        double totalScore = 0;
        for (double score : scores) {
            totalScore += score;
        }
        double averageScore = totalScore / numStudents;

        // Display overall average
        System.out.println("Overall average score: " + averageScore);

        // Display individual student information
        for (int i = 0; i < numStudents; i++) {
            double difference = scores[i] - averageScore;
            System.out.printf("%s: score = %.2f, difference from average = %.2f\n",
                    students[i], scores[i], difference);
        }

        scanner.close();
    }
}
