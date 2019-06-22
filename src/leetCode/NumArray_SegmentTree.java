package leetCode;

class NumArray_SegmentTree {

    int nums[], segment_tree[];

    public NumArray_SegmentTree(int[] nums) {
        if (nums.length > 0) {
            int val = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
            int size = 2 * (int) Math.pow(2, val) - 1;
            this.segment_tree = new int[size];
            this.nums = nums;

            createSegmentTree(0, nums.length - 1, 0);
        }
    }

    private int createSegmentTree(int array_start, int array_end, int st_index) {
        if (array_start == array_end) {
            segment_tree[st_index] = nums[array_start];
            return nums[array_start];
        }
        int mid = getMid(array_start, array_end);
        segment_tree[st_index] = createSegmentTree(array_start, mid, st_index * 2 + 1) +
                createSegmentTree(mid + 1, array_end, st_index * 2 + 2);
        return segment_tree[st_index];


    }

    private int getMid(int array_start, int array_end) {
        return array_start + (array_end - array_start) / 2;
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;

        updateValue(diff, i, 0, nums.length - 1, 0);
    }

    private void updateValue(int diff, int pos, int array_start, int array_end, int segment_index) {
        if (pos < array_start || pos > array_end)  return;

        segment_tree[segment_index] += diff;
        if (array_start != array_end) {
            int mid = getMid(array_start, array_end);
            updateValue(diff, pos, array_start, mid, 2 * segment_index + 1);
            updateValue(diff, pos, mid + 1, array_end, 2 * segment_index + 2);
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j >= nums.length || i > j)
            return -1;
        return getSum(i, j, 0, nums.length - 1, 0);

    }

    private int getSum(int i, int j, int array_start, int array_end, int segment_index) {
        if (i <= array_start && j >= array_end)
            return segment_tree[segment_index];
        if (i > array_end || j < array_start)
            return 0;

        int mid = getMid(array_start, array_end);
        return getSum(i, j, array_start, mid, 2 * segment_index + 1) +
                getSum(i, j, mid + 1, array_end, 2 * segment_index + 2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */