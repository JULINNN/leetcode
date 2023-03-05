import com.google.gson.GsonBuilder;

public class UniquePaths_62 {

    public static void main(String[] args) {

        System.out.println(uniquePaths(53, 4));
    }


    public static int uniquePaths(int m, int n) {

        int total = m+n-2;
        double sum = 1;

        int min = Math.min(m,n);

        int count = 0; while (count++ < min - 1){
            sum*= total;
            total--;
        }


        for(int i= min-1;i>=2;i--){
            sum/=i;
        }
        return (int) sum;
    }
}
