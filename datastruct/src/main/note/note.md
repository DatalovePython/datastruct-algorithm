# 数据结构

## 队列

**顺序队列**会存在假溢出的现象。

 ![img](https://img-blog.csdn.net/20180703102512656?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NtaWxlX3poYW5ndw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70) 



用**循环队列**可以解决该问题

循环队列有种front 去追 rear的感觉。

取模用于循环真的非常好用。

 ![img](https://img-blog.csdn.net/20180703103827920?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NtaWxlX3poYW5ndw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70) 

消除假溢出就是当队尾指针rear和队头指针front到达存储空间最大值QueueSize时，让队尾指针自动转化为存储空间的最小值0.
新问题：
    在循环队列中，空队特征是front = rear, 队满时也会有front = rear; 判断条件将出现二义性
解决方案有三种：
1. 加设标志位，让删除动作使其为1，插入动作使其为0， 则可识别当前front == rear;
2. 使用一个计数器记录队列中元素个数（即队列长度）
3. 人为浪费一个单元，令队满特征为 front = (rear +1)%N---空闲单元法  
这里采用空闲单元法解决二义性问题。
空闲单元法

 ![img](https://img-blog.csdn.net/20180703105302743?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NtaWxlX3poYW5ndw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70) 



## 链表

### 特点

1. 链表是以节点的方式来存储

2. 每个节点包含data域，next域，指向下一个节点

3. 链表的各个节点 不一定是连续存储

4. 链表分是否带头节点

   1. 头节点

      不存放具体的数据，作用就是表示单链表头next

   

   

   