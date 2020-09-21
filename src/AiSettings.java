import javax.swing.*;

public class AiSettings {
    JButton[] button;
    JPanel mainpanel, boardpanel, settingspanel;
    static int Type;
    private JButton startWithDefensiveAIButton;
    private JButton startWithRandomAIButton;

    public AiSettings(JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JButton startWithDefensiveAIButton, JButton startWithRandomAIButton, boolean state) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.startWithDefensiveAIButton = startWithDefensiveAIButton;
        this.startWithRandomAIButton = startWithRandomAIButton;
        chooseAiButtonType();
    }

    private void chooseAiButtonType() {
        startWithRandomAIButton.addActionListener(e -> {
            setType(0);
        });

        startWithDefensiveAIButton.addActionListener(e -> {
            setType(1);
        });
    }

    public void setType(int a) {
        Type = a;
    }

    public int getType() {
        return Type;
    }

}
