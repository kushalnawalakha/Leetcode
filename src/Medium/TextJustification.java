package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kushaln on 3/2/2018.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        Queue<String> wordQ=new LinkedList();
        int len=-1;
        List<String> output=new ArrayList();
        StringBuilder builder=null;
        for(String word:words){
            if(len+word.length()<=maxWidth){
                wordQ.offer(word+" ");
                len=len+word.length()+1;
            }else{
                len--;
                builder=new StringBuilder();

                    int spaces=(maxWidth-len)/wordQ.size();
                    int extraSpaces=(maxWidth-len)%wordQ.size();

                    StringBuilder space=new StringBuilder();
                    for(int i=0;i<spaces;i++){
                        space.append(" ");
                    }
                    while(wordQ.size()>1){
                        builder.append(wordQ.poll()).append(space);
                        if(extraSpaces-->=0){
                            builder.append(" ");
                        }
                    }

                    builder.append(wordQ.poll().toString().trim());
                output.add(builder.toString());
                wordQ.offer(word+" ");
                len=word.length()+1;
            }
        }
        int spaces=(maxWidth-len)/wordQ.size();
        int extraSpaces=(maxWidth-len)%wordQ.size();

        StringBuilder space=new StringBuilder();
        for(int i=0;i<spaces;i++){
            space.append(" ");
        }
        while(wordQ.size()>1){
            builder.append(wordQ.poll()).append(space);
            if(extraSpaces-->=0){
                builder.append(" ");
            }
        }

        builder.append(wordQ.poll().toString().trim());
        output.add(builder.toString());

        return output;
    }

    public static void main(String[] args) {
        TextJustification justification=new TextJustification();

        String word[]={"This", "is", "an", "example", "of", "text", "justification."};

        justification.fullJustify(word,16);
    }
}
