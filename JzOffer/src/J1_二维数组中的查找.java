public class J1_二维数组中的查找 {
    public static boolean Find(int target, int[][] A) {
        if (A.length == 0 || A[0].length == 0) return false;
        int m = A.length, n = A[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (A[i][j] == target) return true;
            else if (A[i][j] > target) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 7;
        int[][] A = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(target, A));
        System.out.println();
    }
}
