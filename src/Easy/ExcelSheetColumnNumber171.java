package Easy;

/**
 * Created by kusha on 5/16/2017.
 */
public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String s) {
        StringBuilder stringBuilder=new StringBuilder(s);
        s=stringBuilder.reverse().toString();
        char[]ch=s.toCharArray();
        int colNumber=0,mul=1;
        for(char c:ch){
            colNumber=colNumber+(c-'A'+1)*mul;
            mul=mul*26;
        }
        return colNumber;
    }
    public static void main(String[] args) {
        ExcelSheetColumnNumber171 obj=new ExcelSheetColumnNumber171();
        System.out.println(obj.titleToNumber("AAA"));
    }
}
