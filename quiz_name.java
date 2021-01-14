import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz_name{
  JPanel p;
  JTextField t;

  public quiz_name(){
    p = new JPanel();
    p.setBounds(200,5,230,30);
    p.setLayout(new FlowLayout());
    p.setBackground(Color.GRAY);

    JLabel l = new JLabel("test name");
    t = new JTextField("",10);

    p.add(l);
    p.add(t);
  }
  JPanel get_panel(){
    return p;
  }
  String get_test_name(){
    return t.getText();
  }
}
