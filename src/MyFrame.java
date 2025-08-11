import javax.swing.JFrame;
import java.awt.Color;

public class MyFrame extends JFrame {
    
    MyFrame(int altura, int largura){
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Olha só é uma simulação de bola Wow");
        this.setSize(largura,altura);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.BLACK);
        
        
        this.setVisible(true);
        
    }

}
