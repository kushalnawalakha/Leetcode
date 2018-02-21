import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

public class SearchInLogFile_Twitter {
    public Collection<String> search(String[] logLines, LocalTime startDate,LocalTime endDate){
        ArrayList<String> list=new ArrayList<>();
        boolean prev=false;
        for(String logLine:logLines){
            if(!logLine.contains("\t")){
                if(prev){
                    list.add(logLine);
                }
            }else {
                prev=false;
            }
            String dateArray[]= logLine.split("\t")[0].split("T")[1].split(":");
            LocalTime date=LocalTime.of(Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[2].replace("Z","")));
            if(date.isAfter(startDate)||date.equals(startDate)){
                if(date.isBefore(endDate)||date.equals(endDate)){
                        list.add(logLine);
                        prev=true;
                    }
                }
            }
        return list;
    }


    public static void main(String sp[]){
        LocalTime startTime=LocalTime.of(3,21,56);
        LocalTime endTime=LocalTime.of(3,22,02);
        String log[]={
                "2016-02-12T03:21:54Z\tProgram x did operation y successfully.",
                "2016-02-12T03:21:56Z\tProgram x did operation y successfully.",
                "2016-02-12T03:21:57Z\tProgram x did operation y successfully.",
                "2016-02-12T03:21:58Z\tProgram x did operation y successfully.",
                "2016-02-12T03:21:59Z\tProgram x did operation y successfully.",
                "2016-02-12T03:22:01Z\tProgram x did operation y successfully.",
                "2016-02-12T03:22:02Z\tProgram x did operation y successfully.",
                "2016-02-12T03:22:03Z\tProgram x did operation y successfully."
        };
        SearchInLogFile_Twitter logFile_twitter=new SearchInLogFile_Twitter();
        logFile_twitter.search(log,startTime,endTime);
    }
}
