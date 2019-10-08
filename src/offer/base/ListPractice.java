package offer.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 链表联系
 *
 * @author huang
 * @create 2019-09-12 1:29 PM
 */
public class ListPractice {

    public void printListReverse(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for (Integer node: list) {
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        ListPractice pr = new ListPractice();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        pr.printListReverse(list);
    }
}