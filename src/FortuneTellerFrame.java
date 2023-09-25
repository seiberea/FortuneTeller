import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{

    JPanel main;
    int screenHeight;
    int screenWidth;

    JPanel topPnl;
    JLabel title;
    ImageIcon icon;

    JPanel displayPnl;
    JTextArea txtArea;
    JScrollPane scroller;

    JPanel controlPnl;
    JButton readBtn;
    JButton quitBtn;

    int i = -1;
    int randIndex;
    Random rnd;


    public FortuneTellerFrame(){
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(255, 255, 255));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        FortuneTellerLabel();
        main.add(topPnl, BorderLayout.NORTH);

        FortuneDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
    }
    private void FortuneTellerLabel(){
        topPnl = new JPanel();
        topPnl.setBackground(new Color(255, 255, 255));
        icon = new ImageIcon("src/fortune.jpg");
        title = new JLabel("Fortune Teller!", icon, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 48));
        title.setForeground(new Color(243, 207, 198));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        topPnl.add(title);
    }
    private void FortuneDisplay(){
        displayPnl = new JPanel();
        displayPnl.setBackground(new Color(255, 255, 255));
        txtArea = new JTextArea(20, 60);
        txtArea.setFont(new Font("SansSerif", Font.ITALIC, 12));
        scroller = new JScrollPane(txtArea);
        displayPnl.add(scroller);
    }
    private void ControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setBackground(new Color(255, 255, 255));
        controlPnl.setLayout(new GridLayout(1, 2));

        ArrayList<String> fortuneList = new ArrayList<>();
        fortuneList.add("I sense good things within you...");
        fortuneList.add("Your soul houses a dark evil...");
        fortuneList.add("You will eat at Burger King today...");
        fortuneList.add("AI will take your job one day...");
        fortuneList.add("You should focus more on your schoolwork...");
        fortuneList.add("You will pass your exam...");
        fortuneList.add("You should study more...");
        fortuneList.add("You should take care of yourself more...");
        fortuneList.add("Go out and have some fun today...");
        fortuneList.add("You will find $20 on the ground today...maybe...");
        fortuneList.add("You will win a scratch off lottery ticket....");
        fortuneList.add("You will lose $20 today...be careful...");

        readBtn = new JButton("Read my fortune!");
        readBtn.addActionListener((ActionEvent ae) ->{
            rnd = new Random();
            do{
                randIndex = rnd.nextInt(11);
            }while(randIndex == i);
            String fortune = fortuneList.get(randIndex);
            i = randIndex;
            txtArea.append("Your fortune: " + fortune + "\n");
        });
        readBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        controlPnl.add(readBtn);
        controlPnl.add(quitBtn);
    }
}