
public class Main {
    public static void main(String[] args) {   
        int altura = 600;
        int largura = 600;
        
        MyFrame myFrame = new MyFrame(altura,largura);
        SimulationPanel painel = new SimulationPanel(altura, largura);

        myFrame.add(painel);
    }
}
