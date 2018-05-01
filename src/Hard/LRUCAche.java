package Hard;

import java.util.HashMap;

/**
 * Created by kusha on 2/11/2018.
 */
public class LRUCAche {
        static class Node{
            int val;
            Node next=null,prev=null;
        }


        HashMap<Integer,Integer> keyMap;
        HashMap<Integer,Node> nodeMap;
        Node root;
        Node end;
        int capacity;

        public LRUCAche(int capacity) {
            this.capacity=capacity;
            this.keyMap=new HashMap<Integer,Integer>();
            this.nodeMap=new HashMap<Integer,Node>();
            root=new Node();
            end=root;
        }

        private void print(){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }

        public int get(int key) {

            if(keyMap.containsKey(key)){
                Node node=nodeMap.get(key);
                node.prev.next=node.next;
                node.next.prev=node.prev;
                end.next=node;
                node.prev=end;
                end=node;
            }
            return keyMap.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            if(keyMap.containsKey(key)){
                Node node=nodeMap.get(key);
                node.prev.next=node.next;
                node.next.prev=node.prev;
                end.next=node;
                node.prev=end;
                end=node;
                keyMap.put(key,value);
            }else{
                Node node=new Node();
                node.val=key;
                node.prev=end;
                end.next=node;
                end=node;
                print();
                if(nodeMap.size()>=capacity){
                    root.next=root.next.next;
                    root.next.prev=root;
                }
                print();
                this.nodeMap.put(key,node);
                this.keyMap.put(key,value);
            }
        }

    public static void main(String[] args) {
        LRUCAche lrucAche=new LRUCAche(2);
        lrucAche.put(1,1);
        lrucAche.put(2,2);
        lrucAche.get(1);
        lrucAche.put(3,3);
    }
}
