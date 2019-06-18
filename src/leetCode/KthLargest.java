package leetCode;


import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue(k);
        int i = 0;
        for (; i< k; i++)
            queue.add(nums[i]);

        for (; i<nums.length && !queue.isEmpty(); i++) {
            if (queue.peek() < nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();
    }

}
