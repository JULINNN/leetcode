public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        if(n <= 3){
            return n;
        }
        int[] arr = new int[n+1];
        arr[2] = 2;
        arr[3] = 3;


        for(int i = 4;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
