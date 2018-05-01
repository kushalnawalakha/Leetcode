import java.util.TreeSet;

/**
 * Created by kushal on 8/27/17.
 */
class temp {
    int val;

    public temp(int val) {
        this.val = val;
    }
}

public class Test    {
    public static void main(String sp[]) {
        String test = "hello.my.mame.is.Kushal";
        int count = 'b' - 'B';

        System.out.println(count);
        TreeSet<temp> t = new TreeSet<>((a, b) -> a.val - b.val);
        temp t1 = new temp(100);
        temp t2 = new temp(200);
        temp t3 = new temp(300);
        temp t4 = new temp(400);
        temp t5 = new temp(500);
        temp t6 = new temp(600);
        temp t7 = new temp(700);
        temp t8 = new temp(800);
        temp t9 = new temp(900);
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);
        t.add(t5);
        t.add(t6);
        t.add(t7);
        t.add(t8);
        t.add(t9);
        System.out.print(t.first().val);
        t5.val = 10;
        temp x = t.first();
        t.remove(t.first());
        t.add(x);
        System.out.print(t.first().val);
    }

    int checkAnagram(String s1,String s2){
        if(s1.length()!=s2.length()){
            return -1;
        }
        char[] values=new char[26];
        for(char ch:s1.toCharArray()){
            values[ch-'a']++;
        }
        for(char ch:s2.toCharArray()){
            values[ch-'a']++;
        }
        int s=0;
        for(int i=0;i<values.length;i++){
            s+=values[i]<0?values[i]:0;
        }
        return -s;
    }
}
