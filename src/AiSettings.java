import javax.swing.*;

public class AiSettings {
    private JButton[] button;
    private JPanel mainpanel;
    private JPanel boardpanel;
    private JPanel settingspanel;
    static int Type;
    private JButton startWithDefensiveAIButton;
    ;
    private JButton startWithRandomAIButton;
    public AiSettings(JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JButton startWithDefensiveAIButton, JButton startWithRandomAIButton) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.startWithDefensiveAIButton = startWithDefensiveAIButton;
        this.startWithRandomAIButton = startWithRandomAIButton;
    }

    public AiSettings(JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JButton startWithDefensiveAIButton, JButton startWithRandomAIButton, boolean state) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.startWithDefensiveAIButton = startWithDefensiveAIButton;
        this.startWithRandomAIButton = startWithRandomAIButton;
        choosePlayerButton();
    }

    private void choosePlayerButton() {
        startWithRandomAIButton.addActionListener(e -> {

            System.out.println("Random AI");
            setType(0);
            System.out.println("Type: "+Type);
        });

        startWithDefensiveAIButton.addActionListener(e -> {
            System.out.println("Defensive AI");
            setType(1);
            System.out.println("Type: "+Type);
        });
    }

    public void setType(int a)
    {
        Type = a;
    }
    public int getType()
    {
        return Type;
    }

}
