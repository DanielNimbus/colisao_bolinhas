import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Toolkit;


public class SimulationPanel extends JPanel{
    private Bola bola;
    private Timer timer;
    int altura, largura;

    ActionListener action = new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            bola.movimentation();
            bola.colisionWall(getHeight(), getWidth());
            bola.gravidade();   
            bola.resistenciaAr();

            repaint();
            Toolkit.getDefaultToolkit().sync(); // precisa fazer isso aqui porque eu estou rodando linux e pobrema de buffer e tal
        }
    };

    SimulationPanel(int altura, int largura){
        this.altura = altura;
        this.largura = largura;
        bola = new Bola(400, 400, 20, 10, 40,20, Color.WHITE);
        this.setBackground(Color.black);
        timer = new Timer(16, action);
        timer.start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bola.desenhaBola(g);
    }


}
