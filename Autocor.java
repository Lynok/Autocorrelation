import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Avtocor extends Frame {
FileDialog dialogLoad;

    public static void main (String [] argv){
Avtocor h = new Avtocor();
    }
TextField inputFileName;
    public class Listener1 implements ActionListener{
     public void actionPerformed(ActionEvent e) {
  inputFileName.setText(".txt");
  //System.exit(0);
     }
     }
TextField outputFileName;
    public class Listener2 implements ActionListener{
     public void actionPerformed(ActionEvent e) {
  outputFileName.setText(".txt");
  //System.exit(0);
     }
     }

 Frame myWindow;
public Avtocor()
 { 
 setTitle("Автокореляція");  
 setSize(400, 250);
 GridLayout grid1= new GridLayout(8,1);// кількість стовбців, кількість рядків
     setLayout(grid1);
  Label label1 = new Label ("Завантажити вихідний файл");
  add (label1);

  inputFileName = new TextField ("input.txt");
  add (inputFileName);
  
  Button BtDownload = new Button ("Обзор");
  add (BtDownload);
  
  Label label2 = new Label ("Створити файл збереження");
  add (label2);
  
  outputFileName = new TextField ("output.txt");
  add (outputFileName);
  
  Button BtDownload2 = new Button ("Вибрати файл");
  add (BtDownload2);

  Label label3 = new Label ("Автокореляція є кореляцією функції з самою собою зміщеною на певну величину незалежної змінної");
  add (label3);
  
  Button button3 = new Button ("Порахувати автокореляцію");
  add (button3);

	BtDownload.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dialogLoad = new FileDialog(myWindow, "Обзор", FileDialog.LOAD);
dialogLoad.show();
String file = dialogLoad.getFile();
String directory = dialogLoad.getDirectory();
String fullFileName = directory + file;
inputFileName.setText(fullFileName);
   	}
});


        BtDownload2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dialogLoad = new FileDialog(myWindow, "Вибрати файл", FileDialog.SAVE);
dialogLoad.show();
String file = dialogLoad.getFile();
String directory = dialogLoad.getDirectory();
String fullFileName = directory + file;
outputFileName.setText(fullFileName);

//System.exit(0);
  }
});

	button3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
MyFileClass fc = new MyFileClass();
fc.openFile(inputFileName.getText());
fc.readFile();
double [] mas=fc.calculateAutocovar();
fc.out();
fc.writeFile(outputFileName.getText());
//double [] mas = fc.getData();
//inputFileName.setText(new Double(mas[3]).toString());
//System.exit(0);
		}
	});

         setVisible(true);
 addWindowListener(new WindowAdapter(){
     public void windowClosing(WindowEvent e){ 
  System.exit(0);
     }
 });
 } 
}
