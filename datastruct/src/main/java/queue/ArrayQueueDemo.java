package queue;

import java.util.Scanner;

/**
 * @author luzc
 * @date 2020/7/10 15:27
 * @desc 用数组来模拟队列,队列最明显的特点便是先进先出，用两个类变量来控制即可。
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //create queue
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                        System.out.println("取出的数据为"+queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());;
                    }
                    break;

                case 'h'://查看队列头的数据
                    try {
                        int queue = arrayQueue.headQueue();
                        System.out.println("取出头的数据为"+queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());;
                    }
                    break;
            }
            System.out.println("程序退出");

        }


    }
}

//如下方法是顺序队列，存在加溢出的现象
class ArrayQueue {
    private int maxSize;// 表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据，模拟队列

    //创建队列的构造函数
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部的前一个位置
        rear = -1;  //指向队列的尾部（即就是队列最后一个数据）
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;//rear 后移
        arr[rear] = n;

    }

    //获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            //通过抛异常处理
            throw new RuntimeException("队列空，不能放数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据。。。。");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);

        }
    }

    //显示队列的头数据，注意不是取数据
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据。。。。");
            throw new RuntimeException();
        }
        return arr[front + 1];
    }

}