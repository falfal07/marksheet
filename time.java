import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.thread;

public class time extends Thread implements ActionListener{
  JPanel p;
  JButton b;
  JLabel l;

  String str = "";
  String str0 = "time ";
  String hour = "";
  String mid = ":";
  String minute = "00";
  String second = "00";

  int now = 0;

  long start_time = 0;
  long stop_time = 0;

  int dt = 0;
  int dh = 0;
  int dm = 0;
  int ds = 0;

  Thread th = null;


  public time(){
    p = new JPanel();
    p.setBounds(10,5,180,30);
    p.setLayout(new FlowLayout());
    p.setBackground(Color.GRAY);

    str = str0+minute+mid+second;
    l = new JLabel(str);

    b = new JButton("start");
    b.addActionListener(this);

    p.add(l);
    p.add(b);

  }

  JPanel get_panel(){
    return p;
  }
  public void actionPerformed(ActionEvent e){
    now++;
    if(now%3 == 0){
      b.setText("start");
      str = str0+"00"+mid+"00";
      l.setText(str);
      now = 0;
    }
    else if(now == 1){
      start_time = System.currentTimeMillis();
      b.setText("stop");
      if(th == null){
        th = new Thread(this);
        th.start();
      }
    }
    else{
      th = null;
      stop_time = System.currentTimeMillis();
      b.setText("reset");
      dt = (int)(stop_time-start_time)/1000;
      dm = dt/60;
      ds = dt%60;

      time_show();
      l.setText(str);
    }
  }
  String convert(long a){
    String str = "";
    if(a<10){
      str = "0"+String.valueOf(a);
    }
    else{
      str = String.valueOf(a);
    }
    return str;
  }
  void time_show(){
    if(dm < 60){
      str = str0 + convert(dm) + mid + convert(ds);
    }
    else{
      dh = dm/60;
      dm = dm%60;
      str = str0 + convert(dh) + mid + convert(dm) + mid + convert(ds);
    }
  }
  public void run(){
    while(now == 1){
      stop_time = System.currentTimeMillis();
      dt = (int)(stop_time-start_time)/1000;
      dm = dt/60;
      ds = dt%60;

      time_show();
      l.setText(str);

      try{
        th.sleep(1000);
        if (th == null)
          break;
      }catch(InterruptedException e){
        break;

      }

    }
  }
}
