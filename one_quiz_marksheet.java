import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class one_quiz_marksheet implements ActionListener{
  int no = 0;
  int number_of_choice = 0;
  JPanel p = new JPanel();

  JButton[] bg;


  JButton your_answer = new JButton("invisible");
  JButton real_answer = new JButton("invisible");

  number_to_alphabet nta = new number_to_alphabet();

  scoring sc;

  public one_quiz_marksheet(int no){
    this.no = no;

  }
  JPanel get_panel(boolean tf){
    p.setLayout(new GridLayout(1,number_of_choice+1));
    bg = new JButton[number_of_choice]; 
    for(int i = 0; i < number_of_choice;i++){
      bg[i] = new JButton(nta.convert(i));
    }
    if(tf){
      JLabel no = new JLabel(String.valueOf(this.no));
      no.setHorizontalAlignment(JLabel.CENTER);
      for(int i= 0; i < number_of_choice; i++){
        bg[i].addActionListener(this);
      }

      p.add(no);
      for(int i = 0; i < number_of_choice; i++){
        p.add(bg[i]);
      }
    }
    else{
      p.setBackground(Color.GRAY);
    }

    return p;
  }
  public void actionPerformed(ActionEvent e){

    JButton pushed = (JButton)e.getSource();

    if(now() == 0){
      sc.totalscore = 0;
      if(your_answer != pushed){

        pushed.setOpaque(true);
        pushed.setForeground(Color.GREEN);
        //pushed.setBackground(Color.GREEN);
        your_answer.setForeground(null);
        //your_answer.setBackground(null);
        your_answer = pushed;
        p.revalidate();

      }
      else{
        your_answer.setForeground(null);
        //your_answer.setBackground(null);
        your_answer = new JButton("invisible");
      }
    }
    else if(now() == 1){
      pushed.setOpaque(true);

      if(real_answer != pushed){

        if(your_answer == pushed){
          pushed.setForeground(Color.BLUE);
          //pushed.setBackground(Color.RED);
          real_answer.setForeground(null);
        }
        else{
          if(your_answer == real_answer){
            pushed.setForeground(Color.RED);
            real_answer.setForeground(Color.GREEN);
          }
          else{
            pushed.setForeground(Color.RED);
            real_answer.setForeground(null);
            your_answer.setForeground(Color.GREEN);
          }
        }

        real_answer = pushed;

      }
      else{
        if(real_answer != your_answer){
          pushed.setForeground(null);
          //real_answer.setBackground(null);
        }
        else{
          pushed.setForeground(Color.GREEN);
        }
        real_answer = new JButton("invisible");
      }
      p.revalidate();
    }


  }
  void set_number_of_choice(int number_of_choice){
    this.number_of_choice = number_of_choice;
  }

  int now(){
    return sc.now;
  }

  void set_scoresheet(scoring sc){
    this.sc = sc;
  }
}
