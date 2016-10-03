import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum = 0L;
        
        for(int i = 0; i < n; i++) {
            sum += in.nextLong();
        }
        in.close();
        System.out.println(sum);
    }
}
