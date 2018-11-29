package hhu;

public class No8 {
    public static void main(String[] args){
        System.out.println(myAtoi("18446744073709551617"));
    }
    public static int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }
        int index = 0;
        char[] stringToChars = str.toCharArray();
        for(;index < stringToChars.length;index++){
            if(stringToChars[index] != ' ')
                break;
        }
        if(index >= stringToChars.length)
            return 0;
        if(stringToChars[index] != '+' && stringToChars[index] != '-' && !(stringToChars[index] >= '0' && stringToChars[index] <= '9'))
            return 0;
        long result = 0;
        boolean isPositive = true;
        if(stringToChars[index] == '-')
            isPositive = false;
        if(stringToChars[index] >= '0' && stringToChars[index] <= '9')
            result += stringToChars[index] - '0';
        for(int i = index + 1;i < stringToChars.length;i++){
            if(!(stringToChars[i] >= '0' && stringToChars[i] <= '9'))
                break;
            result = result * 10 + (stringToChars[i] - '0');
            if(result >= Integer.MAX_VALUE)
                break;
        }
        result = isPositive ? result : -1 * result;
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int)result;
    }
}
