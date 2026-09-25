import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = dfs(expression);
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        
        return ans;
    }

    private Set<String> dfs(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = 0;

        while (i < s.length()) {

            // Comma means OR
            if (s.charAt(i) == ',') {
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;
            }

            // Opening brace
            else if (s.charAt(i) == '{') {

                int count = 1;
                int j = i + 1;

                // Find matching closing brace
                while (count != 0) {

                    if (s.charAt(j) == '{') {
                        count++;
                    } 
                    else if (s.charAt(j) == '}') {
                        count--;
                    }

                    j++;
                }

                // Content inside { }
                String inside = s.substring(i + 1, j - 1);

                Set<String> temp = dfs(inside);

                // Concatenate with current
                current = combine(current, temp);

                i = j;
            }

            // Normal character
            else {

                Set<String> temp = new HashSet<>();
                temp.add(String.valueOf(s.charAt(i)));

                current = combine(current, temp);

                i++;
            }
        }

        // Add last part
        result.addAll(current);

        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}