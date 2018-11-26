package hhu;

public class No6 {
    public static  void main(String args[]){
        System.out.println(convert("AAFSFEWWRRWE",3));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int numCols = (s.length() / (2 * numRows -2) + 1) * (numRows - 1);
        char[][] array = new char[numRows][numCols];
        /**
         * 初始化数组
         */
        for(int i=0; i< numRows ;i++){
            for(int j=0;j<numCols;j++)
                array[i][j] = ' ';
        }
        char[] stringToChar = s.toCharArray();
        /**
         * 用zCol来标明Z字形排列的当前列数，zCol = 1时,行数全部占满
         */
        int zCol = 1;
        /**
         * 存入时，外层循环控制列，内存循环控制行，其中n控制字符串s的每一位
         */
        for(int i = 0,n = 0;i < numCols; i++){
            if(n >= stringToChar.length) {
                break;
            }
            for(int j=0;j<numRows;j++){
                /**
                 * 若zCol为1，则每一个行都存入值
                 * 否则，只有numRows - zCole存入值
                 */
               if(zCol == 1){
                   array[j][i] = stringToChar[n++];
               }
               else {
                   if(j == numRows - zCol)
                       array[j][i] = stringToChar[n++];
               }
               if (n >= stringToChar.length) {
                   break;
               }
            }
            /**
             * 若zCol的下一列为numRows，则置zCol为1，重新开始计算
             * 否则，zCol+1
             */
            zCol = (zCol + 1) == numRows ? 1 : zCol + 1;
        }

        String result = "";
        for(int i = 0;i < numRows;i++){
            for(int j=0;j<numCols;j++){
                if(array[i][j] == ' ')
                    continue;
                result += array[i][j];
            }
        }
        return result;
    }
}
