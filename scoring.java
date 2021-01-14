import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class scoring implements ActionListener{
  String str1 = "score: ";
  String score = "";
  String str2 = " / total: ";
  String total = "";

  JPanel p;
  JLabel l;
  JButton b;

  int totalscore = 0;
  int now = 0;
  String button_name = "採点";

  your_answer_space s;


  public scoring(){
    p = new JPanel();
    p.setBackground(Color.GRAY);
    p.setBounds(490,530,250,30);
    p.setLayout(new FlowLayout());

    b = new JButton(button_name);
    b.addActionListener(this);

    l = new JLabel(str1 + score + str2 + total);

    p.add(b);
    p.add(l);
  }

  JPanel get_panel(){
    return p;
  }


  void change_score(){
    p.remove(l);
    score = String.valueOf(totalscore);
    l.setText(str1 + score + str2 + total);
    p.add(l);
    p.revalidate();
    p.repaint();
  }
  void change_total(int total){
    this.total = String.valueOf(total);
  }

  void set_your_answer_space(your_answer_space s){
    this.s = s;
  }

  public void actionPerformed(ActionEvent e){
    now++;
    if(now % 3 == 0){
      now = 0;
      b.setText("採点");
    }
    else if(now == 1){
      b.setText("採点中..");
    }
    else{
      b.setText("採点結果");
      s.calc_score();
      change_score();
    }
  }
}
