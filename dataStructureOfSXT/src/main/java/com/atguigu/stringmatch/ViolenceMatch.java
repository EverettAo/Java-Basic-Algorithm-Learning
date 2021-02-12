package com.atguigu.stringmatch;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/7/2021 6:52 PM
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "if you wanna cry, cry on my shoulder...";
        String s2 = "cry on my shoulder";
        System.out.println(violenceMatch(s1, s2));
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0, j = 0;   // i指向s1；j指向s2
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return (j >= s2Len) ? i - s2Len : -1;
    }
}
