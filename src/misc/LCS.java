package misc;



import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

class ReadFile
{
  private String path;
  public ReadFile(String file_path)
  {
    path = file_path;
  }
  public String OpenFile() throws IOException
  {
    String str="";
    FileReader fr = new FileReader(path);
    BufferedReader br = new BufferedReader(fr);
    String line="";
    
    StringBuffer string_rd= new StringBuffer();
    while((line=br.readLine())!=null)
    {
       string_rd = string_rd.append(line);
    }
    str  = string_rd.toString();
    br.close();
    return str; 
  }
}

class WriteFile
{
  private String path;
  private boolean append_to_file = false;
  
  public WriteFile(String file_path)
  {
    path = file_path;
  } 	

  public WriteFile(String file_path, boolean append_val)
  {
    path = file_path;
    append_to_file = append_val;
  }   

  public void writeToFile(String str) throws IOException
  {

    FileWriter write = new FileWriter(path,append_to_file);
    PrintWriter print_str = new PrintWriter(write);
    print_str.printf(str);
    print_str.close();
  }
}

class LCSAlgo
{
	
  HashMap<HashMap<String,String>, String> mTable = new HashMap<HashMap<String,String>, String>();
  int recursiveCalls = 0;
  public int[][] calLength(final char[] str1,final char[] str2)
  {
     //LCS obj = new LCS();
     int strx_len = str1.length + 1;
     int stry_len = str2.length + 1;
   
     //int run_inner = 0,run_outer = 0;
   
     int[][] matrix = new int[strx_len][stry_len];
   
     for(int i=0;i<strx_len;i++)
     {
       matrix[i][0] = 0;
     }
     for (int j=0;j<stry_len;j++) 
     {
       matrix[0][j] = 0;
     }
     for(int i=1;i<strx_len;i++) 
     {
       LCS.run_outer++;
       for (int j=1;j<stry_len;j++) 
       {
         LCS.run_inner++;
         if (str1[i-1] == str2[j-1]) 
         {
           matrix[i][j] = matrix[i-1][j-1] + 1;
         }
         else if (matrix[i-1][j] >= matrix[i][j-1 ]) 
         {
           matrix[i][j] = matrix[i-1][j];
         }
         else 
         {
           matrix[i][j] = matrix[i][j-1];
         }
       }
     }

     /*for(int i=1;i<strx_len;i++)
     {
       System.out.println();
       for (int j=1;j<stry_len;j++) 
       {
         System.out.print("\t"+matrix[i][j]);
       }
     }*/
     //System.out.println("Length"+matrix[strx_len][stry_len]);
     
     return matrix;
  }

  public String calRecLen(String str1, String str2)
  {
    int strx_len = str1.length();
    int stry_len = str2.length();
    if(strx_len == 0 || stry_len == 0)
    {
      return "";
    }
    else if(str1.charAt(strx_len-1) == str2.charAt(stry_len-1))
    { 
      LCS.run_rec++;
      return calRecLen(str1.substring(0,strx_len-1),str2.substring(0,stry_len-1)) + str1.charAt(strx_len-1);
    }
    else
    {
        LCS.run_rec = LCS.run_rec + 2;
        String x = calRecLen(str1, str2.substring(0,stry_len-1));
        String y = calRecLen(str1.substring(0,strx_len-1), str2);
        return (x.length() > y.length()) ? x : y;
    }
  }

  public String Run(String s,String t) 
  {
    mTable = new HashMap<HashMap<String,String>, String>();
    String result;
    result = MLCS(s,t);
    return result;
   }

  protected String MLCS(String s,String t)
  {
    if(s.length()==0 || t.length()==0)
    return "";

    HashMap<String,String> hashMap = new HashMap<String,String>();
    hashMap.put(s, t);
    String result = mTable.get(hashMap);
    if(result!=null)
      return result;

    if(s.charAt(0)==t.charAt(0))
    {
      recursiveCalls++;
      return s.charAt(0)+MLCS(s.substring(1),t.substring(1));
    }
    recursiveCalls += 2;
    String result1 = MLCS( s.substring(1), t );
    String result2 = MLCS( s, t.substring(1) );
    result = (result1.length() > result2.length() ? result1 : result2);
    HashMap<String,String> hashMap_2 = new HashMap<String,String>();
    hashMap_2.put(s, t);
    mTable.put(hashMap_2, result);
    return result;
  }
}
				
public class LCS
{
  HashMap<String,String> hashMap = new HashMap<String,String>();
  int recursiveCalls;
  public static int run_inner, run_outer, strx_len, stry_len, run_total;  
  public static int recLen, run_rec;
  public static int run_mrec;
  public static int[][] len;
  public static String l;
  public static void main(String[] args) throws IOException
  {
    LCSAlgo obj = new LCSAlgo();
   
    String file_name_x="filex.txt";
    String file_name_y="filey.txt";
    String file_name_o="output.txt";
    char[] aryx;
    char[] aryy;
       
    try
    {
      ReadFile filex = new ReadFile(file_name_x);
      String strx = filex.OpenFile();
      System.out.println("String1 "+strx);
      aryx = strx.toCharArray();
      strx_len = aryx.length;
      ReadFile filey = new ReadFile(file_name_y);
      String stry = filey.OpenFile();
      System.out.println("String2 "+stry);
      aryy = stry.toCharArray();
      stry_len = aryy.length;
      LCSAlgo calLen = new LCSAlgo();
      len = calLen.calLength(aryx,aryy);
  
      LCSAlgo calRLen = new LCSAlgo();
      l = calRLen.calRecLen(strx,stry);

      System.out.println("Length : "+len[strx_len][stry_len]);
      run_total = LCS.run_inner*LCS.run_outer;
      System.out.println("Run Time that computes the length of LCS : "+run_total);
      recLen = l.length();
      System.out.println("LCS : "+ recLen);
    }
    catch (IOException e)
    {
     System.out.println(e.getMessage());
    }
    WriteFile data = new WriteFile(file_name_o,true);
    data.writeToFile("Output for Q1\n");
    data.writeToFile("Length : "+len[strx_len][stry_len]+"\n");
    data.writeToFile("Run Time that computes the length of LCS : "+run_total+"\n\n");
    data.writeToFile("Output for Q2\n");
    data.writeToFile("Length : "+recLen+"\n");
    data.writeToFile("Run Time that computes the length of LCS : "+run_rec+"\n\n");
  }
}

