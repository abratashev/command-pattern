import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Notepad extends JFrame {
    TextArea textArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
    MenuBar menuBar = new MenuBar();
    Menu file = new Menu();
    MenuItem openFile = new MenuItem();
    MenuItem saveFile = new MenuItem();
    MenuItem close = new MenuItem();
    Button saveButton = new Button();
    Button openButton = new Button();
    Button closeButton = new Button();

    Notepad() {
        NotepadActionListener listener = new NotepadActionListener(this);
        this.setSize(500, 300);
        this.setTitle("Java Notepad Tutorial");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));

        this.saveButton.setPreferredSize(new Dimension(150, 50));
        this.saveButton.addActionListener(listener);
        this.saveButton.setLabel("Save");
        this.saveButton.setActionCommand("Save");

        this.openButton.setPreferredSize(new Dimension(150, 50));
        this.openButton.addActionListener(listener);
        this.openButton.setLabel("Open");
        this.openButton.setActionCommand("Open");

        this.closeButton.setPreferredSize(new Dimension(150, 50));
        this.closeButton.addActionListener(listener);
        this.closeButton.setLabel("Close");
        this.closeButton.setActionCommand("Close");

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(saveButton, BorderLayout.CENTER);
        this.getContentPane().add(openButton, BorderLayout.LINE_START);
        this.getContentPane().add(closeButton, BorderLayout.LINE_END);
        this.getContentPane().add(textArea, BorderLayout.PAGE_START);
        this.setMenuBar(this.menuBar);
        this.menuBar.add(this.file);

        this.openFile.setLabel("Open");
        this.openFile.setActionCommand("Open");
        this.openFile.addActionListener(listener);
        this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));

        this.saveFile.setLabel("Save");
        this.saveFile.setActionCommand("Save");
        this.saveFile.addActionListener(listener);
        this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));

        this.close.setActionCommand("Close");
        this.close.setLabel("Close");
        this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.close.addActionListener(listener);

        this.file.setLabel("File");
        this.file.add(this.openFile);
        this.file.add(this.saveFile);
        this.file.add(this.close);
    }
}
