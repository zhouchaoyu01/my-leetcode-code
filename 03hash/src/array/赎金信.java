package array;

/**
 * @author ChanceZhou
 * @create 2022-01-21-21:20
 */
public class 赎金信 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] record = new int[26];
            int temp;

            for (int i = 0; i < magazine.length(); i++) {
                temp = magazine.charAt(i) - 'a';
                record[temp]++;
            }
            for (int j = 0; j < ransomNote.length(); j++) {
                temp = ransomNote.charAt(j) - 'a';
                record[temp]--;
                if (record[temp] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
