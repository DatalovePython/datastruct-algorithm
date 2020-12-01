package queue;

import java.util.Scanner;

/**
 * @author luzc
 * @date 2020/7/13 14:46
 * @desc 循环队列，可重复利用已经用掉的空间
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例");
        //create queue
        CirCleArrayQueue arrayQueue = new CirCleArrayQueue(4);//说明设置4，其队列的有效数据最大是3
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头信息");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个值");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g'://取出数据

                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println("取出的数据为" + queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                    break;

                case 'h'://查看队列头的数据
                    try {
                        int queue = arrayQueue.headQueue();
                        System.out.println("取出头的数据为" + queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                    break;
            }
            System.out.println("程序退出");

        }


    }
}

class CirCleArrayQueue {
    private int maxSize;// 表示数组的最大容量

    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear; //队列尾

    private int[] arr; //该数组用于存放数据，模拟队列

    //创建队列的构造函数
    public CirCleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];

    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
        //还有种写法
        //return (rear + 1 -front)% maxsize == 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加队列数据
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入");
            return;
        }
        arr[rear] = n;
        //rear 后移,这里必须考虑取模
        rear = (rear + 1) % maxSize;


    }

    //获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            //通过抛异常处理
            throw new RuntimeException("队列空，不能放数据");
        }
        //1.先把front对应的值保存到一个临时变量
        //2.把front后移，考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据。。。。");
        }
        //从front开始遍历，遍历多少个元素

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    //求出当前队列的有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，注意不是取数据
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据。。。。");
            throw new RuntimeException();
        }
        return arr[front];
    }
}