package Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class СуммаДвух {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                return new int[]{map.get(a), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
