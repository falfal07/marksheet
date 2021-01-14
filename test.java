import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test{
  public static void main(String[] args){
    window w = new window();
    w.setLayout(null);


    condition c = new condition();
    JPanel p_condition = c.get_panel();

    scoring sc = new scoring();
    JPanel p_score = sc.get_panel();

    your_answer_space s = new your_answer_space();
    s.set_panel(w,sc);
    s.put_quizes(c.number_of_quiz,c.number_of_choice);
    JPanel p = s.get_panel();

    c.set_your_answer_space(s);
    sc.set_your_answer_space(s);

    quiz_name qn = new quiz_name();
    JPanel p_qn = qn.get_panel();

    time t = new time();
    JPanel p_time = t.get_panel();

    save_result sr = new save_result();
    sr.set_window(w);
    sr.set_quiz_name(qn);
    JPanel p_save = sr.get_panel();


    w.add(p_condition);
    w.add(p);
    w.add(p_score);
    w.add(p_qn);
    w.add(p_time);
    w.add(p_save);
    w.setVisible(true);

  }
}
