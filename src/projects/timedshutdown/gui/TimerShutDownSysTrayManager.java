package projects.timedshutdown.gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TimerShutDownSysTrayManager {
	final JFrame timedShutDownWindow;

	public TimerShutDownSysTrayManager(final JFrame paramJFrame) {
		timedShutDownWindow = paramJFrame;
		final PopupMenu popup = new PopupMenu();
		TrayIcon trayIcon = new TrayIcon(createImage("clock.jpg",
				"Timed Shut Down"));

		final SystemTray tray = SystemTray.getSystemTray();

		// Create a popup menu components
		MenuItem exitItem = new MenuItem("Exit");
		//MenuItem abortItem = new MenuItem("Abort");
		//popup.add(abortItem);
		popup.add(exitItem);
		
		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}

		trayIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					paramJFrame.setVisible(true);
				}

			}
		});

		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		
//		abortItem.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//
//			}
//		});
		 
	}

	// Obtain the image URL
	public static Image createImage(String path, String description) {
		URL imageURL = TimerShutDownSysTrayManager.class.getResource(path);

		if (imageURL == null) {
			System.err.println("Resource not found: " + path);
			return null;
		} else {
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}
}
