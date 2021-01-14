import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class your_answer_space{
  JPanel p;

  int number_of_quiz = 0;

  one_quiz_marksheet[] qs;
  scoring sc;

  public your_answer_space(){
    p = new JPanel();

  }


  void set_panel(window w, scoring sc){
    this.sc = sc;
    put_quizes(number_of_quiz,0);

    p.setBackground(Color.GRAY);
    p.setBounds(10,40,w.get_width()-20,(int)((w.get_height()-20)*0.8));
  }
  JPanel get_panel(){
    return p;
  }

  void put_quizes(int number_of_quiz, int number_of_choice){
    this.number_of_quiz = number_of_quiz;
    int column = 2;
    if(number_of_quiz > 40){
      column = 2 + (number_of_quiz-40)/20 + 1;
    }
    int row = (number_of_quiz+column-1)/column;

    GridLayout layout = new GridLayout(row,column);
    layout.setHgap(10);
    layout.setVgap(5);
    p.setLayout(layout);
    qs = new one_quiz_marksheet[row*column];

    for(int i = 1; i <= row * column; i++){
      int x = (i+column-1)/column;
      int y = i%column;
      if(y == 0)
        y = column;
      int j = x + row*(y-1);

      qs[j-1] = new one_quiz_marksheet(j);
      qs[j-1].set_scoresheet(sc);
      qs[j-1].set_number_of_choice(number_of_choice);
      p.add(qs[j-1].get_panel(j <= number_of_quiz));
    }
    sc.total = String.valueOf(number_of_quiz);
  }
  void clear_panel(){
    p.removeAll();
    p.revalidate();
    p.repaint();
  }

  void calc_score(){
    if(sc.now == 2){
      sc.totalscore = 0;
      for(int i = 0; i < qs.length; i++){
        if(qs[i].your_answer == qs[i].real_answer){
          sc.totalscore++;
        }
      }
      //System.out.println("score: " + String.valueOf(sc.totalscore));
    }

  }

}
