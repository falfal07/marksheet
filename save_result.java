import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.filechooser.*;

public class save_result implements ActionListener{

  JPanel p;
  JButton b;
  JLabel l;

  String file_name = "";
  File current_directory = new File("/Users/kokinomac/Desktop");
  String ext;



  window w;
  quiz_name qn;

  save_result(){
    p = new JPanel();
    p.setBounds(10,530,300,30);
    p.setLayout(new FlowLayout());
    p.setBackground(Color.GRAY);
    b = new JButton("save result");
    b.addActionListener(this);
    l = new JLabel("");
    p.add(b);
    p.add(l);
  }


  public void actionPerformed(ActionEvent e) {
    file_name = qn.get_test_name();
    l.setText("");

    JFileChooser filechooser = new JFileChooser();
    if(file_name.equals("")){
      file_name = "input name";
    }
    filechooser.setSelectedFile(new File(current_directory,file_name));

    //filechooser.setFileFilter();
    filechooser.setAcceptAllFileFilterUsed(false);
    ExtensionFilter filter1 = new ExtensionFilter("png");
    ExtensionFilter filter2 = new ExtensionFilter("jpg");
    filechooser.addChoosableFileFilter(filter1);
    filechooser.addChoosableFileFilter(filter2);

    int selected = filechooser.showSaveDialog(w);

    if(selected == JFileChooser.APPROVE_OPTION){
      File file = filechooser.getSelectedFile();

      current_directory = filechooser.getCurrentDirectory();
      file_name = file.getName();
      ext = filechooser.getFileFilter().getDescription();
      ext = ext.substring(1);
      try{
        try{
          screenshot();
        }catch(AWTException e1){

        }
      }catch(IOException e2){

      }
      l.setText("saved as " + file_name + ext);
    }
    else if(selected == JFileChooser.CANCEL_OPTION){
      l.setText("cancelled");
    }
    else if(selected == JFileChooser.ERROR_OPTION){
      l.setText("error");
    }

  }

  void screenshot() throws AWTException, IOException{
    Robot robot = new Robot();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage image = robot.createScreenCapture(new Rectangle(w.x, w.y+22 ,w.width, w.height-22));
    ImageIO.write(image,"PNG", new File(current_directory, file_name+ext));

  }

  JPanel get_panel(){
    return p;
  }

  void set_window(window w){
    this.w = w;
  }
  void set_quiz_name(quiz_name qn){
    this.qn = qn;
  }
}
