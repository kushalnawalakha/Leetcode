package Contest;

public class Compression {
    private char[] getCharFromNumber(int count){
        char num[]=new char[(""+count).length()];
        int i=num.length-1;
        while(count!=0){
            num[i--]=(char)(count%10+'0');
            count=count/10;
        }
        return num;
    }

    public int compress(char[] chars) {
        if(chars==null||chars.length==0){
            return 0;
        }
        char prev=chars[0];
        int count=1;
        int location=0;
        for(int i=1;i<chars.length;i++){
            if(prev==chars[i]){
                count++;
            }else{
                if(count==1){
                    chars[location++]=prev;
                }else{
                    chars[location++]=prev;
                    for(char ch:getCharFromNumber(count)){
                        chars[location++]=ch;
                    }
                }
                count=1;
                prev=chars[i];
            }
        }
        if(count==1){
            chars[location++]=chars[chars.length-1];
        }else{
            chars[location++]=chars[chars.length-1];
            for(char ch:getCharFromNumber(count)){
                chars[location++]=ch;
            }
        }
        return location;
    }

    public static void main(String[] args) {
        char nums[]={'a','b','b','c'};
        Compression compression=new Compression();
        compression.compress(nums);
    }
}
