package HackerRank;

import java.time.LocalTime;
import java.util.*;

/**
 * Created by kusha on 8/19/2017.
 */
public class test {

    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        String startAndEnd[]=sc.nextLine().split(",");
        sc.nextLine();
        TreeMap<String,TreeMap<String,Integer>> map=new TreeMap<>();
        while(sc.hasNextLine()){
            String current=sc.nextLine();
            if(current.equals("")){
                break;
            }
            String split[]=current.split(",");
            String date=split[0].trim().substring(0,7);
            TreeMap<String,Integer> currentMap=map.get(date);
            if(currentMap==null){
                currentMap=new TreeMap<String,Integer>();
            }
            Integer val=currentMap.get(split[1].trim());
            currentMap.put(split[1],(val==null?0:val)+Integer.parseInt(split[2].trim()));
            if(!map.containsKey(date)){
                map.put(date,currentMap);
            }
        }
        for(Map.Entry<String,TreeMap<String,Integer>> entry:map.descendingMap().entrySet()){
            if(entry.getKey().compareTo(startAndEnd[0].trim())>=0&&entry.getKey().compareTo(startAndEnd[1].trim())<0){
                System.out.print(entry.getKey());
                for(Map.Entry<String,Integer> e:entry.getValue().entrySet()){
                    System.out.print(","+e.getKey()+", "+e.getValue());
                }
                System.out.println();
            }
        }
    }
}
