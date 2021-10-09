public class test {
    public static void main(String[] args) {

    }
    public boolean Find(int target, int [][] A) {
        if (A.length == 0 || A[0].length == 0) return false;
        int m = A.length, n = A[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (A[i][j] == target) return true;
            else if (A[i][j] > target) j --;
            else i ++;
        }
        return false;
    }
}
