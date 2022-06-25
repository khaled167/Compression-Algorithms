package lzw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class LZW {    
    
public static void main(String[] args) throws FileNotFoundException, IOException {   
    Map<String,Integer> endecoder = new LinkedHashMap<>();
       File file = new File("ken.txt");
       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);
       String Prefix = "";
       int Char;
       PrintWriter writer = new PrintWriter("LZW.txt", "UTF-8");
       int[] optimizer = new int[90000];
       //Initialize the endecoder HashMap
       int code;
       while((code=br.read())!=-1){
       //optimizer[code] = optimizer[code]>=0?1:0;
            if(optimizer[code]==0) optimizer[code]=1;
       }
       code=1;
       for(int i =0;i<optimizer.length;i++)
          if(optimizer[i]!=0) {
            endecoder.put((char)i+"",code);
              System.out.println(i+" "+code);
            writer.print(i);
            writer.println();
           code++;
          }
       writer.print("#");
       writer.println();
        System.out.println("AAAAAAAAAAAAAAAAAAA"+endecoder.toString());
        file = new File("ken.txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        System.out.println(endecoder.toString());
        while((Char=br.read())!=-1){
            String pc = Prefix+(char)Char;
             System.out.println(Prefix+" "+(char)Char+" "+pc);
            if(endecoder.containsKey(pc))
                Prefix = pc;
            else {
                System.out.println(endecoder.get(Prefix));
                writer.print(endecoder.get(Prefix));
                writer.println();
                endecoder.put(pc,code++);
                Prefix = (char)Char+"";
        }
            
            System.out.println(endecoder.toString());
        }
           String pc = Prefix+(char)Char;
            if(!endecoder.containsKey(pc))
                writer.print(endecoder.get(Prefix));
            
        System.out.println("true");
        writer.close();
        //Decoding
        file = new File("LZW.txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        endecoder = new LinkedHashMap<>();
        String line;
        code = 1;
        while(!"#".equals(line = br.readLine()))
         endecoder.put((char)(Integer.parseInt(line))+"",code++);
          System.out.println(endecoder.toString());
         int CodeStream = Integer.parseInt(br.readLine());
         
}
}