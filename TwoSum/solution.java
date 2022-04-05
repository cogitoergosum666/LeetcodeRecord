class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []res=new int[2]; 
        int []coy = nums.clone();
        Arrays.sort(nums);
        int first = 0;int last = nums.length-1;
        while (true){
            int sum = nums[first]+nums[last];
            if(target == sum){
                int flag1 =0,flag2=0;
                for(int i =0;i<coy.length;i++){
                    if(coy[i]==nums[first]&&flag1==0){
                        res[0]=i;flag1++;
                        if(flag1==1&&flag2==1)break;
                    }
                    else if(coy[i]==nums[last]&&flag2==0){
                        res[1]=i;flag2++;
                        if(flag1==1&&flag2==1)break;
                    }
                }
                return res;
            }
            else if(sum>target){
                last--;
            }
            else{
                first++;
            }
        }

    }

}
//java的双指针解法，排序后使用两个指针从两侧推进，找到数值之后再返回原数组找原下标，应该还有优化空间。
//用时2ms，击败70%

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        Map<Integer,Integer>hashtable=new HashMap<Integer,Integer>(len-1);
        hashtable.put(nums[0],0);
        for(int i=1;i<len;i++){
            int a = target-nums[i];
            if(hashtable.containsKey(a)){
                return new int[]{hashtable.get(a),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}
//java版本的哈希表，用时1ms，击败99.5%，注意函数的运用