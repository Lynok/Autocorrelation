import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class MyFileClass
{	static int N;
 static double[] x = new double[N];
static double[ ] au = new double[N];
protected static int n, maxShift=3;
     //int
static Scanner scn;	

    public static void out()
    {
        for(int col=0;col<n;col++){
            System.out.print(x[col]+ " ");
            System.out.println();
        }
    }
    public static double [] getData()
    {
        return x;
    }

    public static void setData(double []newM)
    {
        x = newM;
        n=x.length;
    }

    public static void readFile()
    {
        int col=0;
        while(scn.hasNext() && (col<x.length)){
            x[col] = Double.parseDouble(scn.next());
            col++;
        }
        n=col;
    }


 public static double[] calculateAutocovar()//float[] x,int maxShift)
{
 double total = 0;
for (int i = 0; i < x.length; i++) {
total += x[i];
}
double mean = total / x.length;

 int stop = Math.min(x.length, maxShift);
double[ ] auto = new double[stop];
double [ ] D= new double[1000];
for (int i = 0; i < stop; i++) {
  for (int j = 0; j < x.length - i; j++) {
    D [i] += (x[j]-mean) * (x[j]-mean);
    auto[i] += ((x[j]-mean) * (x[j + i]-mean));
  }
au[i]=auto[i] /D[i];
return au;
}
}

//public static float[] calculateAutocovar(float[] x) {
// return calculateAutocovar(x, x.length);
// }



    public static void writeFile(String fileName)
    {
File file = new File(fileName);
try {
//проверяем, что если файл не существует то создаем его
if(!file.exists()){
file.createNewFile();
}
//PrintWriter обеспечит возможности записи в файл
PrintWriter out = new PrintWriter(file.getAbsoluteFile());
try {
  for(int i=0;i<N;i++){
out.print(au[i]);
out.println();
}
}
finally {
out.close();
}
}
catch(IOException e) {
throw new RuntimeException(e);
}
    }

    public static void openFile(String s)
    {
        try {
            scn = new Scanner(new File(s));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Файл не найден");
        }
    }
}
