public class AverageSalary_1491 {

    public static void main(String[] args) {

    }

    public double average(int[] salary) {
        int max = 0;
        int min = 100000;
        int sum = 0;
        for (int i : salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            sum += i;
        }
        return (sum - max - min) / (salary.length - 2.0);
    }
}
