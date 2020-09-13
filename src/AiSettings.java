import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AiSettings {
    private JButton[] button;
    private JPanel mainpanel;
    private JPanel boardpanel;
    private JPanel settingspanel;
    private JButton startWithDefensiveAIButton;
//    GameLogic gameLogic;
    private JButton startWithRandomAIButton;

    public AiSettings(JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JButton startWithDefensiveAIButton, JButton startWithRandomAIButton) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.startWithDefensiveAIButton = startWithDefensiveAIButton;
        this.startWithRandomAIButton = startWithRandomAIButton;
//        gameLogic = new GameLogic();
        choosePlayerButton();
    }

    private void choosePlayerButton() {
        startWithRandomAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Random AI");
                GameLogic.aiType = 0;
            }
        });

        startWithDefensiveAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Defensive AI");
                GameLogic.aiType = 1;
            }
        });
    }



}
