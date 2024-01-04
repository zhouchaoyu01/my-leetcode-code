package zfc;

/**
 * kmp
 *
 *
 * @author ChanceZhou
 * @code this file2022-01-29-19:26
 */
public class 实现Strstr {
    class Solution {
        public int strStr(String text, String pattern) {
            if(text == null || pattern == null){
                return -1;
            }
            if(pattern.length() == 0){
                return 0;
            }
            // 首先得到前缀表
            // 前缀表是一个一维数组，数组的下标表示遍历pattern的指针位置(j),
            // 数组的值表示当pattern的指针j和text的指针i对应的字符内容不同时(坏字符),j指针需要移动到pattern的位置
            int[] next = getNext(pattern);
            // 定义两个指针，i用来遍历text，j用来遍历pattern
            int i = 0;
            int j = 0;
            char[] charsT = text.toCharArray();
            char[] charsP = pattern.toCharArray();
            while(j < charsP.length && i < charsT.length){
                // 当指针i和j位置上的元素不匹配时，需要将j指针通过next数组移动到指定位置上
                if(charsT[i] != charsP[j]){
                    j = next[j];
                    // 如果j等于-1，说明j指针已经pattern的最前面了，并且已经没有共有字符串了，直接将j指针和i指针同时往后移动一位j++
                    // 这里就能体现将next[0]设置成-1的巧妙了，这样j++，i++的时候就意味着把text当做一个全新的字符串，
                    // 除去了[0,i)之前的元素，j=0也从pattern
                    // 的起始位置开始匹配
                    if(j == -1){
                        i++;
                        j++;
                    }
                }else{
                    //如果匹配上，那就正常进行下一个字符的匹配
                    i++;
                    j++;
                }
            }
            // 循环结束后，如果j和pattern长度相同，说明全部匹配完了，也就是在text中找到了第一次出现pattern的位置，
            // 这时候i指针已经到了pattern字符位置的最后一个字符的位置
            // 起始位置需要减掉pattern的长度
            if(j == charsP.length){
                return i - j;
            }
            return -1;
        }

        public int[] getNext(String pattern){
            //pattern 模式串
            // 先求出字符串的前缀表
            char[] charArr = pattern.toCharArray();
            int[] next = new int[charArr.length];
            // 因为字符串的第一个元素没有前后缀，所以共有最大字符串长度为0
            next[0] = 0;
            int len = 0;
            int i = 1;
        /*
            i   str          next[i]
            0   A            0
            1   AB           0
            2   ABA          1
            3   ABAB         2
            4   ABABC        0
            5   ABABCA       1
            6   ABABCAB      2
            7   ABABCABA     3
            8   ABABCABAA    1
        */
            while (i < charArr.length){
                // 1.举例：比如这次进来的字符串是上面的AB,此时上一次的共有字符串长度是len=0(因为上一次就一个A字符，没有共有字符串，当然是0)，
                // 要想判断这次共有字符串长度会不会加1，只需要判断这次的字符串AB比上次字符串A多出来的字符(也就是B)是不是和上次共有字符串长度位置上的字符相等
                // 也就是charArr[1(i)] == charArr[0(len)]?，这里是不等，所以不能加1
                // 2.比如这次进来的是ABA，上一次是AB，那么多出来的这个A和上次AB的共有字符串长度位置(len=0)上的字符是否相等，显然charArr[0] == charArr[2]，所以len++;
                // 3.再比如：这次进来的是ABAB,上一次是ABA,上一次的共有字符串长度是len=1，判断这次多出来的字符B是不是和charArr[1]相等，显然相等，len++;
                if(charArr[i] == charArr[len]){
                    len++;
                    next[i] = len;
                    i++;
                }else{
                    // 如果不相等，说明这次多出来的这个字符并没有让共有字符串的长度加1，而且，可能还会直接影响到上一次的共有字符串长度
                    // 这里的做法是：因为多出来一个字符，而且charArr[i] != charArr[len]，那这次已经不能拿上一次共有字符串位置上的字符来做比较了，必须拿上上一次的结果
                    // 比如：这次进来的是ABABC,上一次是ABAB，上一次共有字符串是AB,len=2,那charArr[2(len)]是A，和这次的多出来的C已经不一样了，那上次的len已经不能作为判断依据了，
                    // 必须拿上上一次的len,于是i不变，也就是说下一轮循环还是ABABC，但是len要拿上上一轮的长度，也就是AB这个字符串共有字符串的长度值，len=1，
                    // 此时charArr[1(len)]是B，还是和C不相同，说明这次的len还是不能作为判断，于是i继续不变，下一轮还是ABABC，len拿A的共有字符串长度值，len=0，
                    // 此时charArr[0(len)]是A，还是和C不相同，说明这次的len还是不能作为判断，理论上还得去那更早一次的len值，但是这时候有个临界情况，因为已经拿到第一次进来的len了，
                    // len拿不到更早一次的值了，或者说到这已经没有共有字符串了，说明这次加多出来的字符C。彻底让这个字符串ABABC没有了共有字符串，也就是len=0，可以放心的将这一轮字符串
                    // 的共有字符串长度设为0了，这轮len值设置完毕，i++，进行下一轮设置
                    if(len > 0){
                        len = next[len-1];
                    }else{
                        next[i] = len;
                        i++;
                    }
                }
            }
            // 到此，前缀表已经设置完毕，但是有个问题，就是next[0]和next[1]的位置一直都是0，为了后续使用的方便，需要将""和只有一个字符的字符串共有前缀区别开，
            // 而且，对共有字符串来说，前缀表的最后一项就是字符串本身的共有字符串长度，这个在实际使用的时候没有意义，所以直接将整个前缀表往后平移一位，空出来的
            // next[0]赋值为-1
            for (int j = next.length  -1; j > 0; j--) {
                next[j] = next[j-1];
            }
            next[0] = -1;
//        for (int m = 0; m < next.length; m++) {
//            System.out.print(next[m] + "");
//        }
            return next;
        }
    }


    class Solution1 {
        /**
         * 基于窗口滑动的算法
         * <p>
         * 时间复杂度：O(m*n)
         * 空间复杂度：O(1)
         * 注：n为haystack的长度，m为needle的长度
         */
        public int strStr(String haystack, String needle) {
            int m = needle.length();
            // 当 needle 是空字符串时我们应当返回 0
            if (m == 0) {
                return 0;
            }
            int n = haystack.length();
            if (n < m) {
                return -1;
            }
            int i = 0;
            int j = 0;
            while (i < n - m + 1) {
                // 找到首字母相等
                while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                    i++;
                }
                if (i == n) {// 没有首字母相等的
                    return -1;
                }
                // 遍历后续字符，判断是否相等
                i++;
                j++;
                while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == m) {// 找到
                    return i - j;
                } else {// 未找到
                    i -= j - 1;
                    j = 0;
                }
            }
            return -1;
        }
    }

}

