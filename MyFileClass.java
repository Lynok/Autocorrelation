import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class MyFileClass
{	static int N;
 static double[] x = new double[10000];
static double[ ] au = new double[10000];
protected static int n, maxShift=3;
static Scanner scn;	

    public static void out()
    {
        for(int i=0;i<n;i++){
            System.out.print(x[i]+ " ");
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
        int i=0;
        while(scn.hasNext() && (i<x.length)){
            x[i] = Double.parseDouble(scn.next());
            i++;
        }
        n=i;
    }


 public static double[ ] calculateAutocovar()
{
 double total = 0;
for (int i = 0; i < x.length; i++) {
total += x[i];
}
double mean = total / x.length;

 int stop = Math.min(x.length, maxShift);
double[ ] auto = new double[stop];
double [ ] D= new double[1000];
System.out.print("n=");
System.out.print(n);
for (int i = 0; i < stop; i++) {
  for (int j = 0; j < n - i; j++) {
    D [i] += (x[j]-mean) * (x[j]-mean);
    auto[i] += ((x[j]-mean) * (x[j + i]-mean));
  }
au[i]=auto[i] /D[i];
}
N=n;
return au;
}

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
System.out.print("N=");
System.out.print(N);
  for(int i=0;i<maxShift;i++){
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
