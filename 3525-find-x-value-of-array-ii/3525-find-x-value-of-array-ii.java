import java.util.*;

class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            prod = 1;
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;

    // Merge two nodes
    Node merge(Node left, Node right) {

        Node result = new Node(k);

        // Product of complete segment
        result.prod = (left.prod * right.prod) % k;

        // Prefixes completely inside left
        for (int i = 0; i < k; i++) {
            result.cnt[i] = left.cnt[i];
        }

        // Prefixes that cross from left to right
        for (int r = 0; r < k; r++) {
            int newRemainder = (left.prod * r) % k;
            result.cnt[newRemainder] += right.cnt[r];
        }

        return result;
    }

    // Build segment tree
    void build(int node, int start, int end, int[] nums) {

        tree[node] = new Node(k);

        if (start == end) {

            int value = nums[start] % k;

            tree[node].prod = value;
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid, nums);
        build(node * 2 + 1, mid + 1, end, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Update one index
    void update(int node, int start, int end,
                int index, int value) {

        if (start == end) {

            value %= k;

            tree[node] = new Node(k);
            tree[node].prod = value;
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    // Range query
    Node query(int node, int start, int end,
               int left, int right) {

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        if (right <= mid) {
            return query(node * 2, start, mid, left, right);
        }

        if (left > mid) {
            return query(node * 2 + 1, mid + 1, end, left, right);
        }

        Node leftNode =
            query(node * 2, start, mid, left, right);

        Node rightNode =
            query(node * 2 + 1, mid + 1, end, left, right);

        return merge(leftNode, rightNode);
    }

    public int[] resultArray(int[] nums, int k,
                             int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        // Only remainder modulo k matters
        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Permanent update
            update(1, 0, n - 1, index, value);

            // Query [start ... n-1]
            Node result =
                query(1, 0, n - 1, start, n - 1);

            answer[i] = result.cnt[x];
        }

        return answer;
    }
}