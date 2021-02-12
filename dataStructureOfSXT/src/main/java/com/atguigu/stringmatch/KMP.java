package com.atguigu.stringmatch;

import java.util.Arrays;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/7/2021 7:02 PM
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "ABC ABCDAB ABCDABCDABDE";
        String str2 = "ABCEABD";
        System.out.println(Arrays.toString(kmpNext(str2)));
        System.out.println(kmpSearch(str1, str2));
    }

    /**
     * 在s1中对s2进行匹配
     *
     * @param s1 母串
     * @param s2 子串
     * @return 能完全匹配的首字母的位置
     */
    public static int kmpSearch(String s1, String s2) {
        int[] next = kmpNext(s2);
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {  // 不等的时候，调整j
                j = next[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) { // 遇到相等的字母，在会走上面的while
                j++;
            }
            if (j == s2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;    // 如果字符串的长度是1，其部分匹配值就为0
        for (int i = 1, j = 0; i < s.length(); i++) {
            // 不等时，需要从next[j-1]获取新的j，直到发现有charAt[i] == charAt[j]成立时才退出
            while (j > 0 && s.charAt(i) != s.charAt(j)) {   // kmp的核心点
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {   // 相等时。
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
