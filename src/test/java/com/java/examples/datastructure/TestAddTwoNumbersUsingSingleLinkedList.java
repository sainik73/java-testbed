package com.java.examples.datastructure;

public class TestAddTwoNumbersUsingSingleLinkedList {

    public SingleListNode addTwoNumbers(SingleListNode l1, SingleListNode l2) {
        int rem = 0;
        SingleListNode r1 = new SingleListNode();

        return addNumbersRecursively(rem,r1,l1,l2);
    }

    public SingleListNode addNumbersRecursively(int remainder,SingleListNode r1,SingleListNode l1, SingleListNode l2){
        int rem = 0;
        int mod;
        rem+=  (l1 != null)?l1.val:0;
        rem+=  (l2 != null)?l2.val:0;
        mod = (rem + remainder)/10;
        rem = (rem + remainder)%10;
        r1.val = rem;//(rem!=0)? rem: (l1.val +l2.val);
        boolean l1bool = l1 != null && l1.next != null;
        boolean l2bool = l2 != null && l2.next != null;
        if(l1bool || l2bool){
            r1.next = new SingleListNode();
            addNumbersRecursively(mod,r1.next,(l1bool)?l1.next:null,(l2bool)?l2.next:null);
        }else if(mod !=0){
            r1.next = new SingleListNode();
            addNumbersRecursively(mod,r1.next,null, null);
        }
        return r1;
    }

    public static void main(String[] args) {
        SingleListNode t1 = new SingleListNode(3);
        SingleListNode t2 = new SingleListNode(4,t1);
        SingleListNode t3 = new SingleListNode(2,t2);

        SingleListNode t4 = new SingleListNode(4);
        SingleListNode t5 = new SingleListNode(6,t4);
        SingleListNode t6 = new SingleListNode(5,t5);
        SingleListNode t7 = new SingleListNode(1,t6);

        TestAddTwoNumbersUsingSingleLinkedList test = new TestAddTwoNumbersUsingSingleLinkedList();
        SingleListNode result = test.addTwoNumbers(t3,t7);
        System.out.println("Result: "+ result.val + result.next.val +result.next.next.val);
    }
}
