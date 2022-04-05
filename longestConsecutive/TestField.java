package src;

import java.util.HashMap;
import java.util.Map;
//并查集
//通过将每个数的根找到，合并两根集合，找出具有某一性质的数
public class TestField {
    public static void main(String[] args ){
        int[] input = {1,2,3,4,21,21,23,0};
        Solution uniond = new Solution();
        int a = uniond.longestConsecutive(input);
        System.out.println(a);
    }
}
class Solution {
    private Map<Integer,Integer> m ;//建立一个表
    public int longestConsecutive(int[] nums) {
        m = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            m.put(nums[i],nums[i]);//一开始每个数的根是他本身
        }
        for(int num:nums){
            if(find(num+1)!=null){
                union(num,num+1);//按题目要求，遍历，合并连续集合
            }
        }
        int ans=0;
        for(int num:nums){
            int right=find(num);//找到根（因为上面是从小到大合并的，所以right肯定比num大）
            ans = Math.max(ans,right-num+1);//寻找已知根中最大的
        }
        return ans;
    }
    public Integer find(int x){//使用Integer类
// 1、Integer是int的包装类，int则是java的一种基本数据类型 
// 2、Integer变量必须实例化后才能使用，而int变量不需要 
// 3、Integer实际是对象的引用，当new一个Integer时，实际上是生成一个指针指向此对象；而int则是直接存储数据值 
// 4、Integer的默认值是null，int的默认值是0
        if(!m.containsKey(x))return null;
        if(m.get(x)==x)return x;
        else{
            m.put(x,find(m.get(x)));//路径压缩，原来为return find(m.get(x))，现在将当前节点的根直接置到祖先节点
            return m.get(x);
        }
    }
    public void union(int x,int y){
        x=find(x);y=find(y);
        if(x==y)return;
        else m.put(m.get(x),y);//针对这道题，将大一点的根更新为祖先根
    }
}