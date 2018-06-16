import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class NotepadActionListener implements ActionListener {

    Notepad notepad;

    NotepadActionListener(Notepad notepad) {
        this.notepad = notepad;
    }

    public void actionPerformed(ActionEvent e) {
        int option;
        switch (e.getActionCommand()) {
            case "Close":
                notepad.dispose();
                break;
            case "Open":
                JFileChooser open = new JFileChooser();
                option = open.showOpenDialog(notepad);
                if (option == JFileChooser.APPROVE_OPTION) {
                    notepad.textArea.setText("");
                    try {
                        Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                        while (scan.hasNext())
                            notepad.textArea.append(scan.nextLine() + "\n");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            case "Save":
                JFileChooser save = new JFileChooser();
                option = save.showSaveDialog(notepad);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                        out.write(notepad.textArea.getText());
                        out.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            default:
                break;
        }
    }
}
