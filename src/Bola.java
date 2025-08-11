import java.awt.Color;
import java.awt.Graphics;

public class Bola {
    private double x, y, velocidadeX, velocidadeY, raio, massa;
    private Color cor;

    final double METROS_POR_PIXEL = 1.0/100;
    final double G_METROS = 9.8;
    final double GRAVIDADE_PIXELS = G_METROS/METROS_POR_PIXEL;

    Bola(double x, double y, double velocidadeX, double velocidadeY, double raio, double massa, Color cor){
        this.x = x;
        this.y = y;
        this.velocidadeX = velocidadeX;
        this.velocidadeY = velocidadeY;
        this.raio = raio;
        this.cor = cor;
        this.massa = massa;
    }

    public void desenhaBola(Graphics g){
        g.setColor(cor);
        g.fillOval((int)(x-raio), (int)(y-raio), (int) raio*2, (int) raio*2);
    }

    public void movimentation(){
        this.x += velocidadeX;
        this.y += velocidadeY;
    }

    public void colisionWall(int altura, int largura){
        if(x - raio < 0){
            x = raio;
            velocidadeX *= -1;
        }
        
        if(x + raio > largura){
            x = largura - raio;
            velocidadeX *= -1;
        }

        if(y - raio < 0){
            y = raio;
            velocidadeY *= -1;
        }

        if(y + raio > altura){
            y = altura - raio;
            velocidadeY *= -0.9;
            velocidadeX *= 0.95;
        }
    }

    public void gravidade(){
        velocidadeY += GRAVIDADE_PIXELS*0.0015;
    }

    public void resistenciaAr(){
        velocidadeX *= 0.995;
    }

    public double getX(){ return x;}
    public double getY(){ return y;}
    public void setX(double xNovo){ x = xNovo;}
    public void setY(double yNovo){ y = yNovo;}
    public double getVx(){ return velocidadeX;}
    public double getVy(){ return velocidadeY;}
    public double getRaio(){ return raio;}
}
