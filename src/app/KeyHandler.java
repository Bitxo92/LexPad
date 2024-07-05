package app;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GUI gui;

	public KeyHandler(GUI gui) {
		this.gui = gui;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.save();
		}
		else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) {
			gui.edit.undo();
		}
		else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_R) {
			gui.edit.redo();
		}
		else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			gui.file.open();
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
