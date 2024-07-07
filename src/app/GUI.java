package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {

    JFrame window;

    // TextArea Components
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    boolean isSaved = true; // to track if the text is saved
    // Top MenuBar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuColor, menuFormat;
    // FileMenu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    // Format Menu
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24,
            iFontSize28;
    JMenu menuFont, menuFontSize;

    // Color Menu
    JMenuItem iColor1, iColor2, iColor3;

    // Edit Menu
    JMenuItem iUndo, iRedo;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);

    KeyHandler key = new KeyHandler(this);
    UndoManager um = new UndoManager();

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        this.createTextArea();
        this.createMenuBar();
        this.createFileMenu();
        this.createFormatMenu();
        this.createColorMenu();
        this.createEditMenu();
        // set default values to prevent nullPointers
        format.selectedFont = "Arial";
        format.createFont(16);
        color.changeColor("Light");

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                exitProcedure();
            }
        });
    }

    public void createTextArea() {

        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(key);

        // add undo/redo function to textarea
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
                isSaved = false; // mark as not saved
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open(CTRL+O)");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save(CTRL+S)");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
    }

    public void createColorMenu() {
        iColor1 = new JMenuItem("Light");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("Light");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Dark");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Dark");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Matrix");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Matrix");
        menuColor.add(iColor3);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo(CTRL+Z)");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo(CTRL+R)");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Save":
                file.save();
                isSaved = true; // mark as saved
                break;
            case "Exit":
                exitProcedure();
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "Comic Sans MS":
                format.setFont("Comic Sans MS");
                break;
            case "Times New Roman":
                format.setFont("Times New Roman");
                break;
            case "size8":
                format.createFont(8);
                break;
            case "size12":
                format.createFont(12);
                break;
            case "size16":
                format.createFont(16);
                break;
            case "size20":
                format.createFont(20);
                break;
            case "size24":
                format.createFont(24);
                break;
            case "size28":
                format.createFont(28);
                break;
            case "Light":
                color.changeColor("Light");
                break;
            case "Dark":
                color.changeColor("Dark");
                break;
            case "Matrix":
                color.changeColor("Matrix");
                break;
        }
    }

    private void exitProcedure() {
        if (!isSaved) {
            int option = JOptionPane.showConfirmDialog(window, "You have unsaved changes. Do you want to save before exiting?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                file.save();
                if (isSaved) {
                    System.exit(0);
                }
            } else if (option == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }
}
