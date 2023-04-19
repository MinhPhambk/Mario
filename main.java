import javax.swing.JFrame;

public class main {
    public main (){
        JFrame frame = new JFrame();
        Gamepanel gamepanel = new Gamepanel();
        
        frame.add(gamepanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SNAKECODING");
        frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}
