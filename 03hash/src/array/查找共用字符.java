package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChanceZhou
 * @create 2022-01-21-16:28
 */
public class 查找共用字符 {

    class Solution {
        public List<String> commonChars(String[] words) {
            List<String> result = new ArrayList<>();
            if (words.length == 0) return result;

            int[] hash = new int[26];
            for (int i = 0; i < words[0].length(); i++) {
                hash[words[0].charAt(i) - 'a']++;
            }
            for (int i = 1; i < words.length; i++) {
                int[] otherHash = new int[26];
                for (int j = 0; j < words[i].length(); j++) {
                    otherHash[words[i].charAt(j) - 'a']++;
                }

                for (int k = 0; k < 26; k++) {
                    hash[k] = Math.min(hash[k], otherHash[k]);
                }

            }
            for (int i = 0; i < 26; i++) {
                while (hash[i] != 0) {
                    char c = (char) (i + 'a');
                    result.add(String.valueOf(c));
                    hash[i]--;
                }
            }
            return result;
        }
    }
}
