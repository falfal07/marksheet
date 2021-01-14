import java.io.File;

public class getpath{
  public static void main(String[] args){
    String path = new File(".").getAbsoluteFile().getParent();
    System.out.println(path);
  }
}
