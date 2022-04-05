class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
            int n=nums.size();
            unordered_map<int,int>hashmap;
        for(int i=0;i<n;i++){
            auto it = hashmap.find(target - nums[i]);
            if (it != hashmap.end()) {
                return {it->second, i};
            }
            hashmap[nums[i]] = i;
    }
    return {};
    }
};
//用时8ms的c++极致优化方案，如果从反方向扫入数据的话能优化到4ms
//建立map，挨个扫数进去，map下标是数值而值是数组下标，这样就能复合表示信息，如果找到满足条件的直接退出