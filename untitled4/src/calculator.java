import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.net.URI;

public class calculator {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Therapy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        JPanel panel = new JPanel();
        frame.add(panel);

        JTextField num1Field = new JTextField(20);
        //JTextField num2Field = new JTextField(20);
        JLabel sumLabel = new JLabel("result: ");

        JButton addButton = new JButton("Ask");

        addButton.addActionListener(e -> {
            String one = (num1Field.getText());
            //int num1 = Integer.parseInt(num1Field.getText());
            //int num2 = Integer.parseInt(num2Field.getText());
            //int sum = num1 + num2;

            if (one.contains("depression")) {

                String baseUrl = "https://openai.com/blog/chatgpt/";
                URI uri = null;
                try {
                    uri = new URI(baseUrl);
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(uri);
                        } catch (IOException b) {
                            b.printStackTrace();
                        }
                    }
                    sumLabel.setText("result: you should make an appointment with therapist asap here is the link:" + baseUrl);

            }
            if(one.compareTo("loneliness")==0){
                sumLabel.setText("result:take this pill A" );
            }
        });

        panel.add(num1Field);
        //panel.add(num2Field);
        panel.add(addButton);
        panel.add(sumLabel);

        frame.setVisible(true);
    }


}
