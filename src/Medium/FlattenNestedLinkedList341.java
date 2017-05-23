package Medium;

import java.util.*;

/**
 * Created by kusha on 5/21/2017.
 */
public class FlattenNestedLinkedList341 {
    List nestestList=new ArrayList();
    List<List<Integer>> nestedList=new ArrayList<>();
    Stack stack=new Stack();
    public FlattenNestedLinkedList341(List nestedList) {
        this.nestedList=nestedList;
        for(int i=nestedList.size()-1;i>=0;i--){
            stack.push(nestedList.get(i));
        }

    }
    public Integer next() {
        while (!stack.isEmpty()) {
            if (stack.peek() instanceof Integer) {
                return (Integer) stack.pop();
            }else{
                ArrayList list=(ArrayList) stack.pop();
                for(int i=list.size()-1;i>=0;i--){
                    stack.push(list.get(i));
                }
            }
        }
        return null;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String sp[]){
        ArrayList lists=new ArrayList<>();
        ArrayList<Integer> i1=new ArrayList<>();
        i1.add(1);
        i1.add(1);
        ArrayList<Integer> i3=new ArrayList<>();
        i3.add(1);
        i3.add(1);
        lists.add(i1);
        lists.add(2);
        lists.add(i3);
        FlattenNestedLinkedList341 obj=new FlattenNestedLinkedList341(lists);
        while (obj.hasNext()){
            System.out.print(obj.next());
        }
    }
}
