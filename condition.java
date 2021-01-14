import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class condition implements ActionListener{
  int x = 440;
  int y = 5;
  int width = 300;
  int height = 30;

  JPanel p;
  JTextField text_total;
  JTextField text_choice;

  int number_of_quiz = 50;
  int number_of_choice = 4;

  your_answer_space yas;


  public condition(){
    p = new JPanel();
    p.setBackground(Color.GRAY);
    p.setBounds(x,y,width,height);
    p.setLayout(new FlowLayout());

    JLabel label_total = new JLabel("問題数");
    label_total.setHorizontalAlignment(JLabel.CENTER);
    p.add(label_total);

    text_total = new JTextField(String.valueOf(number_of_quiz), 3);
    p.add(text_total);

    JLabel label_choice = new JLabel("選択肢の数");
    label_choice.setHorizontalAlignment(JLabel.CENTER);
    p.add(label_choice);

    text_choice = new JTextField(String.valueOf(number_of_choice), 1);
    p.add(text_choice);

    JButton click = new JButton("決定");
    click.addActionListener(this);
    p.add(click);
  }
  JPanel get_panel(){
    return p;
  }

  public void actionPerformed(ActionEvent e){
    number_of_quiz = Integer.parseInt(text_total.getText());
    number_of_choice = Integer.parseInt(text_choice.getText());
    System.out.println(number_of_quiz);
    System.out.println(number_of_choice);
    change_sheet(yas);
  }
  void change_sheet(your_answer_space yas){
    yas.clear_panel();
    yas.put_quizes(number_of_quiz,number_of_choice);
    yas.get_panel().revalidate();
  }
  void set_your_answer_space(your_answer_space yas){
    this.yas = yas;
  }

}
