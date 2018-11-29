package hhu;

public class No11 {
    public static void main(String args[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
//    public static int maxArea(int[] height) {
//        int maxArea = 0;
//        for(int i = 0;i < height.length;i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = Math.min(height[i],height[j]) * (j - i);
//                if(area > maxArea)
//                    maxArea = area;
//            }
//        }
//        return maxArea;
//    }
    public static  int maxArea(int[] height){
        int i = 0,j = height.length - 1,maxArea = 0;
        while(i < j){
            System.out.println(i + " "+ j);
            int area = Math.min(height[i],height[j]) * (j - i);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[i] < height[j]){
                i++;
            }
            else
                j--;
        }
        return maxArea;
    }
}
