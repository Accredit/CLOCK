package pkg110; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import javax.swing.*; 
import javax.swing.Timer;  /**  *   * @author Administrator  */  
public class Clock extends JFrame implements ActionListener{  
public final int HEIGTH = 200, L0 = 50, T0 = 50,N=8;    
public final double RAD = Math.PI / 180.0;  
int x, y, old_X, old_Y, r, x0, y0, w, h, ang;  
int sdo, mdo, hdo, old_M, old_H, hh, mm, ss;  
int delay = 1000;  Calendar now;   
String st, alarm, Items1, Items2,str[];  
JButton jb;   
JComboBox jc1, jc2, jc3;  
JLabel jl1, jl2, jl3, jl4;  
JTextField jtf1, jtf2, time;  
JPanel jp1, jp2, jp3;  
Timer timer;   
TimeZone tz = TimeZone.getTimeZone("JST");  
Toolkit toolkit=Toolkit.getDefaultToolkit();     /**       * @param args the command line arguments      */      
public static void main(String[] args) {         // TODO code application logic here         
Clock cp = new Clock();         
cp.setVisible(true);    
}       
Clock() {   
super("闹钟");    
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
setSize(400,550);   
setVisible(true);    
Container contentPane = getContentPane();   
jp2 = new JPanel();    
jl1 = new JLabel("闹铃时间"); 
 

 
jl1.setFont(new Font("楷体", Font.BOLD, 18));   
time = new JTextField("00:00",10);   
alarm = time.getText();    
jb = new JButton("修改闹铃时间");   
jb.addActionListener(this);   
jb.setActionCommand("CC");   
jp2.add(jl1);   
jp2.add(time);   
jp2.add(jb);    
contentPane.add(jp2, BorderLayout.SOUTH);      
ClockPanel clock = new ClockPanel();   
contentPane.add(clock, BorderLayout.CENTER);     
ActionListener taskPerformer = new ActionListener() {    
public void actionPerformed(ActionEvent evt) {             
repaint();    
}   };    
new Timer(delay, taskPerformer).start();  
}    
Color waiquan= Color.magenta;  
Color bianxian= Color.black;  
Color biaopan= Color.yellow;  
Color juxing= Color.yellow; 
Color miaozhen= Color.red;  
Color fenzhen= Color.red;  
Color shizhen= Color.red;   
public class ClockPanel extends JPanel {   
public void paint(Graphics g) {    
h = getSize().height - 200;      
g.setColor(waiquan);     
g.fillOval(L0 + 30, T0 + 30, h - 60, h - 60);    
g.setColor(bianxian);     
g.drawOval(L0 + 31, T0 + 31, h - 62, h - 62);    
g.setColor(biaopan);     
g.fillOval(L0 + 50, T0 + 50, h - 100, h - 100);    
g.setColor(bianxian);     
g.drawOval(L0 + 51, T0 + 51, h - 102, h - 102); 
      r = h / 2 - 30;    
x0 = 30 + r - 5 + L0;    
y0 = 30 + r - 5 - T0;    
ang = 60;     
for (int i = 1; i <= 12; i++) {      
x = (int) ((r - 10) * Math.cos(RAD * ang) + x0);     
y = (int) ((r - 10) * Math.sin(RAD * ang) + y0);     
g.drawString("" + i, x, h - y);     
ang -= 30;   
 }    
 x0 = 30 + r + L0;    
y0 = 30 + r + T0;     
 now = Calendar.getInstance();   
 hh = now.get(Calendar.HOUR_OF_DAY);    
mm = now.get(Calendar.MINUTE);    
ss = now.get(Calendar.SECOND);    
g.setColor(juxing);     
g.fillRect(110,350, 150, 30);    
g.setColor(fenzhen);    
if (hh < 10)     
st = "0" + hh;    
else      
st = "" + hh;    
if (mm < 10)      
st = st + ":0" + mm;    
else      
st = st + ":" + mm;     
if(alarm.equals(st))     {       
if(toolkit!=null)      
toolkit.beep();      
else   {}     
}     
if (ss < 10)      
st = st + ":0" + ss;    
else      
st = st + ":" + ss;    {      
g.setFont(new Font("华文楷体", Font.BOLD, 16));     
g.drawString("当前时间:" + st, 115,370);    
} 
     sdo = 90 - ss * 6;    
mdo = 90 - mm * 6;     
hdo = 90 - hh * 30 - mm / 2;         
if (old_X > 0) {     
g.setColor(biaopan);    
} 
else {     
old_M = mdo;     
old_H = hdo;    
}       
g.setColor(miaozhen);     
x = (int) ((r - 26) * Math.cos(RAD * sdo) + x0);     
y = (int) ((r - 26) * Math.sin(RAD * sdo) + y0) - 2 * T0;    
g.drawLine(x0, y0, x, (h - y));      
old_X = x;    
old_Y = y;        
if (mdo != old_M) {     
g.setColor(biaopan);     
old_M = mdo;    
}     
if (hdo != old_H) {     
g.setColor(biaopan);     
old_H = hdo;    
}      
g.setColor(fenzhen);     
x = (int) ((r - 45) * Math.cos(RAD * mdo) + x0);     
y = (int) ((r - 45) * Math.sin(RAD * mdo) + y0) - 2 * T0;    
g.drawLine(x0, y0, x, (h - y));      
g.setColor(shizhen);     
x = (int) ((r - 70) * Math.cos(RAD * hdo) + x0);     
y = (int) ((r - 70) * Math.sin(RAD * hdo) + y0) - 2 * T0;    
g.drawLine(x0, y0, x, (h - y));   
}   
}    // 闹铃时间的判断及实现 
 // 闹铃声音的实现     
public void actionPerformed(ActionEvent e) {    
if (e.getActionCommand()=="CC") {    
int newHou, newMin;    
char c;     
String getTime = JOptionPane.showInputDialog(this, "请输入闹铃时间格式如：", "00:00");    
repaint();      
if(getTime==null)      
System.out.println(getTime);      
judge: if (getTime != null) {     
System.out.println(getTime);     
if (getTime.length() != 5) {       
JOptionPane.showMessageDialog(time, "格式错误\n请按格式输入5位数字", "Error",         JOptionPane.ERROR_MESSAGE);      
repaint();      break judge;     
}       
for (int i = 0; i < (getTime.length()); i++) {      
c = getTime.charAt(i);       
if (i == 2 && !Character.isDigit(c))      
continue;       
if (i != 2 && !Character.isDigit(c)) {        
JOptionPane.showMessageDialog(this, "格式错误\n请按格式输入5位数字",         "Error",JOptionPane.ERROR_MESSAGE);       
repaint();       
break judge;      
}     }      
char[] hour = { getTime.charAt(0), getTime.charAt(1) };     
char[] minute = { getTime.charAt(3), getTime.charAt(4) };     
newHou = Integer.parseInt(String.valueOf(hour));     
newMin = Integer.parseInt(String.valueOf(minute));  
if (newHou >= 24 || newHou < 0) {       
JOptionPane.showMessageDialog(this, "格式错误\n小时应该是不小于0不大于23的正数",         "Error", JOptionPane.ERROR_MESSAGE); 
     repaint();      
break judge;     
}      
if (newMin >= 60 || newHou < 0) {       
JOptionPane.showMessageDialog(this, "格式错误\n分钟应该是小于60的正数", "Error",         JOptionPane.ERROR_MESSAGE);      
repaint();      
break judge;     
}      
new SetTime(newHou, newMin);    
}   }      
toolkit=Toolkit.getDefaultToolkit();  
}    
class SetTime {   
String Hour;   
String Minute;     
public SetTime() { }    
public SetTime(int hour, int minute) {    
if (hour < 10) {      
Hour = "0" + String.valueOf(hour);    
} 
else {      
Hour = "" + String.valueOf(hour);   
 }     
if (minute < 10) {     
 Minute = "0" + String.valueOf(minute);    
} 
else {      
Minute = "" + String.valueOf(minute);    
}     
alarm = Hour + ":" + Minute;    
time.setText(alarm);    
repaint();   
}  }  }