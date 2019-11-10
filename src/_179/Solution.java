package _179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String largestNumber(int[] nums) {

        List<String> list = new ArrayList<>();
        Arrays.stream(nums).forEach((o) -> list.add(String.valueOf(o)));
        list.sort(((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
        if ("0".equals(list.get(0))) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        list.forEach((o) -> builder.append(o));
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }
}


class Solution2 {
    public String largestNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i=0 ; i<nums.length ; i++) {
            strs[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (String s1,String s2) -> {
                if(s1.length()==s2.length()) {
                    return s2.compareTo(s1);
                }
                return (s2+s1).compareTo(s1+s2);
        });
        if("0".equals(strs[0])) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}