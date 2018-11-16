package hhu;

public class No5 {
    public static void main(String args[]){

        System.out.println(longestPalindrome("a"));
    }
    public static String longestPalindrome(String s){
        boolean p[][] = new boolean[s.length()][s.length()];
        int start = 0,maxLength = 1;
        //i要从最后一行开始计算，如果从第一行开始，当计算p[0][2]时需要用到
        //p[1][1]的值，但此时p[1][1]还尚未赋值，导致结果出错，而j只需要>=i的值
        for(int i=s.length() - 1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i == j){ //只有一个字母的情况
                    p[i][j] = true;
                }
                else if(i == j - 1){ //两个字母的情况
                    p[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    p[i][j] = p[i+1][j-1] & (s.charAt(i) == s.charAt(j));
                }
                //计算结束后，如果当前的子串是回文的，且长度比之前的长，进行替换
                if(p[i][j] && j-i+1 > maxLength){
                    maxLength = j-i+1;
                    start=i;
                }
            }
        }
        String result = "";
        // 当输入是空字符串时，maxLength默认长度是1，此时截取子串会越界，所以需判断一下
        if(start + maxLength <= s.length()){
            result = s.substring(start,start+maxLength);
        }
        return result;
    }

    /** 求公共子串的解法
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 0;
        for(int i = 0;i<s.length();i++){
            for(int j=s.length() - 1;j>=0;j--){
                int m = i,n = j,length = 0;
                while(m < s.length() && n >= 0 ){
                    if(s.charAt(m) != s.charAt(n))
                        break;
                    length++;
                    m++;
                    n--;
                }
                if(length > maxLength){
                    if(j - i == length - 1) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start + maxLength);
    }
     */
}
