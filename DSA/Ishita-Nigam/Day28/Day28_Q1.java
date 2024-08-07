//Longest Common Prefix
import java.util.Arrays;

public class Day28_Q1 {
    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Day28_Q1 solution = new Day28_Q1();
        // Test the longestCommonPrefix method with a sample input
        String[] strs = {"flower", "flow", "flight"};
        
        String result = solution.longestCommonPrefix(strs);
        System.out.println("The longest common prefix is: " + result);
    }
}
