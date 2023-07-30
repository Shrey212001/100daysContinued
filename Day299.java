/*

Topic:- A or B

Link:- https://www.hackerrank.com/challenges/aorb/problem?isFullScreen=true

Problem:-

Consider four numbers: , , , and . You must change at most  bits in  and  to form the numbers  and  satisfying the equation . Here, the | symbol denotes the bitwise OR operation.

Given  sets of the numbers defined above, find and print the respective values of  and  on new lines; if no such value exists, print  instead. If there are multiple solutions, make  as small as possible; if there are still multiple solutions, make  as small as possible.

Input Format

The first line contains an integer, , denoting the number of queries. The subsequent lines describe each respective query as follows:

The first line contains a single integer denoting the value of .
Each of the next  lines contains a Hexadecimal (base 16) number describing the respective values of , , and .

Output Format

Print two lines of output for each query:

The first line should contain a Hexadecimal (base 16) number denoting the value of  A'.
The second line must contain a Hexadecimal (base 16) number denoting the value of B'.
If no valid answer exists, you must instead print one line of output with the integer  1.

Note: The letters in Hexadecimal numbers must be in uppercase.




Solution:-
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class B
{
    String line;
    StringTokenizer inputParser;
    BufferedReader is;
    FileInputStream fstream;
    DataInputStream in;
    String FInput="";   
    void openInput(String file)
    {
            if(file==null)is = new BufferedReader(new InputStreamReader(System.in));
            else
            {
                    try{                          
                    fstream = new FileInputStream(file);
                    in = new DataInputStream(fstream);
                    is = new BufferedReader(new InputStreamReader(in));
                    }catch(Exception e)
                    {
                            System.err.println(e);
                    }
            }

    }   
    void readNextLine()
    {
        try {
            line = is.readLine();
            inputParser = new StringTokenizer(line, " ,\t");
        } catch (IOException e) {
            System.err.println("Unexpected IO ERROR: " + e);
        }    
        catch (NullPointerException e)
        {
            line=null;
            
        }   
    }   
    long NextLong()
    {
            String n = inputParser.nextToken();
            long val = Long.parseLong(n);         
             return val;
    }
    
    int NextInt()
    {
            String n = inputParser.nextToken();
            int val = Integer.parseInt(n);
            return val;
    }
    
    double NextDouble()
    {
            String n = inputParser.nextToken();
            double val = Double.parseDouble(n);
            return val;
    }
    
    String NextString()
    {
            String n = inputParser.nextToken();
            return n;
    }
    
    void closeInput()
    {
            try {
                    is.close();
            } catch (IOException e) {
                    System.err.println("Unexpected IO ERROR: " + e);
            }
                    
    }
    
    public static void main(String [] argv)
    {
            String filePath=null;
            if(argv.length>0)filePath=argv[0];
            new B(filePath);
            
    }
    
    public B(String inputFile)
    {
        openInput(inputFile);
        readNextLine();
        int T=NextInt();
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++)
        {
            readNextLine();
            int K = NextInt();
            readNextLine();
            boolean [] a = hexStringToBooleanArray(line);
            readNextLine();
            boolean [] b = hexStringToBooleanArray(line);
            readNextLine();
            boolean [] c = hexStringToBooleanArray(line);
            
            int len = a.length;
            len = Math.max(len, b.length);
            len = Math.max(len, c.length);
            boolean [] ra = new boolean[len];
            and(ra, a,c);
            boolean [] rb = new boolean[len];
            and(rb, b,c);
            boolean [] cxra = new boolean[len];
            xor(cxra, c, ra);
            or(rb, rb, cxra);
            boolean [] xa = new boolean[len];
            int da = xor(xa, ra, a);
            boolean [] xb = new boolean[len];
            int db = xor(xb, rb, b);
            if(da+db>K){
                sb.append("-1\n");
            }
            else{
                int dd = K - da - db;
                if(dd>0)
                {
                    boolean [] X = new boolean[len];
                    for(int i=0; i<ra.length&&dd>0; i++){
                        if(ra[i])
                        {
                            if(dd==1&&!rb[i])continue;
                            dd--;
                            X[i]=true;
                            if(!rb[i])dd--;
                        }
                    }
                    xor(ra, ra, X);
                    or(rb, rb, X);
                }
                sb.append(toStr(ra)+"\n");
                sb.append(toStr(rb)+"\n");
            }
        }
        System.out.print(sb);
        
        closeInput();        
    }
    
    private String toStr(boolean[] rb) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<rb.length; i++)
            if(rb[i])sb.append(1);
            else sb.append(0);
        BigInteger b = new BigInteger(sb.toString(), 2);
        return b.toString(16).toUpperCase();
    }

    private void or(boolean[] xa, boolean[] ra, boolean[] a) {
        int len = xa.length;
        len = Math.min(len, ra.length);
        len = Math.min(len, a.length);
        for(int i=0; i<len; i++){
            xa[xa.length-i-1] = a[a.length - i - 1]|ra[ra.length - i - 1];
        }
    }
    
    private int xor(boolean[] xa, boolean[] ra, boolean[] a) {
        int len = xa.length;
        len = Math.min(len, ra.length);
        len = Math.min(len, a.length);
        int ret = 0;
        for(int i=0; i<len; i++){
            xa[xa.length-i-1] = a[a.length - i - 1]^ra[ra.length - i - 1];
            if(xa[xa.length-i-1])ret++;
        }
        return ret;
    }

    private void and(boolean[] ra, boolean[] a, boolean[] b) {
        int len = a.length;
        len = Math.min(len, b.length);
        len = Math.min(len, ra.length);
        for(int i=0; i<len; i++){
            ra[ra.length-i-1] = a[a.length - i - 1]&b[b.length - i - 1];
        }
    }

    public boolean [] hexStringToBooleanArray(String s) {
        int len = s.length();
        boolean [] ret = new boolean[len*4];
        for(int i=0; i<len; i++){
            int x = Character.digit(s.charAt(i), 16);
            if((x&1)>0)ret[i*4+3] = true;
            if((x&2)>0)ret[i*4+2] = true;
            if((x&4)>0)ret[i*4+1] = true;
            if((x&8)>0)ret[i*4] = true;
        }
        return ret;
    }
    
    public byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
