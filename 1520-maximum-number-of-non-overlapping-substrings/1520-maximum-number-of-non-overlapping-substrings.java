class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        // Try every character as the starting point
        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            // Only first occurrence can start a valid substring
            if (first[ch] != i) {
                continue;
            }

            int end = last[ch];
            boolean valid = true;

            // Expand the interval
            for (int j = i; j <= end; j++) {

                int current = s.charAt(j) - 'a';

                // This character appeared before i
                if (first[current] < i) {
                    valid = false;
                    break;
                }

                // Include all occurrences of this character
                end = Math.max(end, last[current]);
            }

            if (!valid) {
                continue;
            }

            // Non-overlapping
            if (i > prevEnd) {
                ans.add(s.substring(i, end + 1));
            }
            // Overlapping -> replace previous with smaller interval
            else {
                ans.set(ans.size() - 1, s.substring(i, end + 1));
            }

            prevEnd = end;
        }

        return ans;
    }
}