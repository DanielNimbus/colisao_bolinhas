import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Toolkit;
import java.util.*;


public class SimulationPanel extends JPanel{
    private List<Bola> bola = new ArrayList<>();
    private Timer timer;

    private int spawnX, spawnY;

    int altura, largura;
    Random rand = new Random();

    ActionListener action = new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e){
            for(Bola b : bola){
            b.movimentation();
            b.colisionWall(getHeight(), getWidth());
            b.gravidade();   
            b.resistenciaAr();
            }

            repaint();
            Toolkit.getDefaultToolkit().sync(); // precisa fazer isso aqui porque eu estou rodando linux e pobrema de buffer e tal
        }
    };

    SimulationPanel(int altura, int largura){
        this.altura = altura;
        this.largura = largura;

        spawnX = rand.nextInt(largura);
        spawnY = rand.nextInt(altura);



        System.out.println("X: " + spawnX + " | Y: " + spawnY);

        bola.add(new Bola(spawnX, spawnY, rand.nextInt(41)-20, rand.nextInt(41)-20 , rand.nextInt(50)+5, rand.nextInt(50), Color.GRAY));
        this.setBackground(Color.black);
        timer = new Timer(16, action);
        timer.start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Bola b : bola){
            b.desenhaBola(g);
            g.setColor(Color.white);
            g.drawString("Posição atual: (" + (int) b.getX() + ", " + (int) b.getY() + ")", 10, 40);
            g.drawString("Velocidades:", 10, 60);
            g.drawString("Vx -> " + String.format("%.2f", b.getVx()), 80, 60);
            g.drawString("Vy -> " + String.format("%.2f", b.getVy()), 80, 75);
        }
        g.setColor(Color.white);
        g.drawString("Spawn: (" + spawnX + ", " + spawnY + ")", 10, 20);

        
    }


}
