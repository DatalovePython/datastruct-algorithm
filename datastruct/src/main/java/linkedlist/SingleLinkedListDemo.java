package linkedlist;

import java.util.Stack;

/**
 * @author luzc
 * @date 2020/7/15 9:48
 * @desc 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
//
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        普通添加
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);

        //不按顺序添加
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
//        singleLinkedList.addByOrder(node1);

        //test modify the node
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "卢球球");
//        singleLinkedList.update(newHeroNode);
//        singleLinkedList.list();

        //test del the node
//        singleLinkedList.del(1);
//        singleLinkedList.del(4);
//        System.out.println("del>>>>>>");
//        singleLinkedList.list();

        //test1 ; count
//        System.out.println("count" + getLength(singleLinkedList.getHead()));

        //test2:findLastIndexNode
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),2);
//        System.out.println(res);

        //test3:reverse linked list
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();

        //test4 : print reverse linked list
        reversePrint(singleLinkedList.getHead());


    }

    //get linked list count exclude head node
    public static int getLength(HeroNode head) {

        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //search the reverse k node
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //reverse linked list
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;// 这个只是作为临死变量存储用的
        HeroNode reverseHead = new HeroNode(0, "", "");

        //todo:最有意思的就是这里了 这四行代码
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;// 在这一步，将之前的reverse保存了下来
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }


    //print reverse linked list
    //1:first reverse ,then print .problem: break the origin linked list
    //2:take use of stack,
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

//定义singleLinkedList

class SingleLinkedList {
    public HeroNode getHead() {
        return head;
    }

    //先初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");


    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1.找到 当前链表的最后节点
//    2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {

//        因为head节点不能动，我们需要一个辅助遍历temp
        HeroNode temp = head;
//        遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
//            如果没有找到就后移
            temp = temp.next;

        }
//        当退出while，temp就指向了最后
        temp.next = heroNode;

    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break; //
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在

                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag 的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //    修改节点的信息，根据no
    public void update(HeroNode newHeroNode) {
//        判断链表是否为空，
        if (head.next == null) {
            System.out.println("link is null");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//show if find the node
        while (true) {
            if (temp == null) {
                break;

            }
            if (temp.no == newHeroNode.no) {
                //finded
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;

        } else {
            System.out.println("can't find the node");
        }

    }

    /*
    * 从单链表中删除一个节点的思路
1.  我们先找到 需要删除的这个节点的前一个节点 temp
2.  temp.next = temp.next.next
3. 被删除的节点，将不会有其它引用指向，会被垃圾回收机制回收
    * */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;// if find
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("can't find the del no");
        }
    }


    //    显示链表【遍历】
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //        因为head节点不能动，我们需要一个辅助遍历temp
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;

            }
            //            输出节点信息

            System.out.println(temp);
//           找到就后移
            temp = temp.next;

        }
    }

}

//定义heronode，每个和heronode都是一个节点
class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {

        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

