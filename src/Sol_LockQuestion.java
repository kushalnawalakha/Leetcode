import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by kusha on 9/23/2017.
 */
public class Sol_LockQuestion {
    public static int check(String[] events){
        Stack<Integer> lockStack=new Stack<>();
        HashSet<Integer> locksAquired=new HashSet<>();
        int loc=0;
        for(String val:events){
            loc++;
            String text=val.split(" ")[0];
            Integer number=Integer.parseInt(val.split(" ")[1]);
            if(text.equals("AQUIRE")){
                if(locksAquired.contains(number)){
                    return loc;
                }else{
                    lockStack.push(number);
                    locksAquired.add(number);
                }
            }else{
                if(!locksAquired.contains(number)){
                    return loc;
                }else if(!lockStack.peek().equals(number)){
                    return loc;
                }else{
                    locksAquired.remove(number);
                    lockStack.pop();
                }
            }
        }
        if(lockStack.size()>0){
            return events.length+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        String check[]={"AQUIRE 1","AQUIRE 2","AQUIRE 1","RELEASE 3","RELEASE 2","RELEASE 1","AQUIRE 1","RELEASE 1"};
        System.out.println(check(check));
    }
}
