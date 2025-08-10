
public class Main {
    public static void main(String[] args) {   
        int altura = 480;
        int largura = 700;
        
        MyFrame myFrame = new MyFrame(altura,largura);
        SimulationPanel painel = new SimulationPanel(altura, largura);

        myFrame.add(painel);
    }
}
