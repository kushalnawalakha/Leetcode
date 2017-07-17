package Easy;

/**
 * Created by kusha on 7/2/2017.
 */
public class Attendence551 {
    public boolean checkRecord(String s) {
        char prev=' ';
        boolean Aprev=false;
        for(char ch:s.toCharArray()){
            if(ch=='L'&&prev=='L'){
                return false;
            }else if(ch=='A'){
                if(Aprev){
                    return false;
                }
                Aprev=true;
            }
            prev=ch;
        }
        return true;
    }

    public static void main(String args[]){
        String st="PPALLL";
        Attendence551 attendence551=new Attendence551();
        attendence551.checkRecord(st);
    }
}
