package algorithm;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo3 {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int result = getPosition(str1, str2);
        if (result != -1) {
            System.out.print("匹配位置是：str1[");
            System.out.println(result + "]");
        } else {
            System.out.println("匹配失败");
        }
    }

    /**
     * 得到匹配字符串的部分匹配表
     *
     * @param matchStr 用于匹配的字符串
     * @return 部分匹配表
     */
    public static int[] getTable(String matchStr) {
        //部分匹配值的数组
        int[] sectionTable = new int[matchStr.length()];
        //匹配字符串的第一个元素没有前缀与后缀，部分匹配值为0
        sectionTable[0] = 0;
        //i用来指向部分匹配字符串末尾的字符，j用来指向开始的字符
        for (int i = 1, j = 0; i < matchStr.length(); i++) {
            //当j>0且前缀后缀不匹配时，使用部分匹配表中前一个表项的值
            while (j > 0 && matchStr.charAt(j) != matchStr.charAt(i)) {
                j = sectionTable[j - 1];
            }

            //如果前缀后缀匹配，j向后移，继续比较
            if (matchStr.charAt(j) == matchStr.charAt(i)) {
                j++;
            }
            //存入匹配值
            sectionTable[i] = j;
        }
        return sectionTable;
    }

    /**
     * 通过KMP算法匹配字符串，若匹配成功，返回第一个字符出现的位置
     *
     * @param str1 用于匹配的字符串
     * @param str2 要匹配的字符串
     * @return 第一个字符出现的位置，没有则返回-1
     */
    public static int getPosition(String str1, String str2) {
        //获得str2的部分匹配表
        int[] sectionTable = getTable(str2);
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //两个字符匹配
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
                if (j == str2.length()) {
                    //如果匹配完成，返回第一个字符出现位置
                    return i - str2.length() + 1;
                }
            } else {
                //如果匹配失败了，使用部分匹配表，跳转到str1对应位置
                //如果j==0，说明没有字符被被匹配，直接让i指向str1的下一个字符
                if (j == 0) {
                    continue;
                }
                //跳转步数 = 已经匹配的字符个数 - 部分匹配表对应的值
                int position = j - sectionTable[j - 1];
                i += position;
                //因为循环后会+1，所以此处i-1
                i--;
                //重置j，重新匹配
                j = 0;
            }
        }
        return -1;
    }

}
