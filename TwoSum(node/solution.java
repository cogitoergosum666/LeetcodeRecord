/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return build(getnum(l1)+getnum(l2));
    }
    public long getnum(ListNode l){
        long pow = 1;
        long sum=0;
        while(true){
            sum+=Long.parseLong(String.valueOf(pow*l.val));
            
            pow*=10;
            if(l.next!=null)l=l.next;
            else break;
        }

        return sum;
    }
    public ListNode build(long sum){
        ListNode l=new ListNode();
        ListNode res =l;
        while(sum!=0){
            l.val=Integer.parseInt(String.valueOf(sum%10));
            sum = sum/10;if(sum==0)break;
            ListNode newnode = new ListNode();
            l.next=newnode;l=newnode;
        }
        return res;
    }
}
//失败的解法，忽视了long的最大长度，但是要注意里面用到的字符串转换函数
Long.parseInt(String.valueOf())
Integer.parseInt(String.valueOf())

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cf = 0;ListNode front = l1;
        while(true){
            if(cf==1){
                l1.val+=1;cf=0;
            }
            if(l1.val+l2.val>9){
                l1.val=l1.val+l2.val-10;cf=1;
            }
            else l1.val+=l2.val;
            if(l1.next==null&&l2.next==null){
                if(cf==0)return front;
                else{
                    l1.next=new ListNode(1);
                    return front;
                }
            }
            if(l1.next==null)l1.next=new ListNode(0);
            if(l2.next==null)l2.next=new ListNode(0);
            l1=l1.next;l2=l2.next;
        }
    }
}

//成功！但是内存仍然有优化的空间。