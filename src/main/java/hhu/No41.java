package hhu;

public class No41 {
    public int firstMissingPositive(int[] nums) {
        int max = nums.length;
        boolean[] exist = new boolean[max + 1];
        for(int i : nums){
            if(i <= 0 || i > max)
                continue;
            exist[i] = true;
        }
        int result = max + 1;
        for(int i = 1;i < exist.length;i++){
            if(!exist[i]){
                result = i;
                break;
            }
        }
        return result;
    }
}
