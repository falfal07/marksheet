import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame{
  int x = 300;
  int y = 150;
  int width = 750;
  int height = 600;

  public window(){
    setTitle("テスト");
    setBounds(x,y,width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  int get_width(){
    return width;
  }
  int get_height(){
    return height;
  }
  void change_width(int w){
    setBounds(x,y,w,height);
    width = w;
  }
  void change_height(int h){
    setBounds(x,y,width,h);
    height = h;
  }

}
