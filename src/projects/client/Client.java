package projects.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		String serverAddress = JOptionPane
				.showInputDialog("Enter server IP Address");
		String port = JOptionPane.showInputDialog("Enter destination port");
		Socket s = null;
		try {
			s = new Socket(serverAddress, Integer.parseInt(port));
		} catch (IOException ioE) {
			JOptionPane.showMessageDialog(null,
					"Can not establish connection to host " + serverAddress
							+ " on port " + port, "Connetcion refused",
					JOptionPane.ERROR_MESSAGE);
		}
		ObjectInputStream input = new ObjectInputStream(s.getInputStream());
		Date answer = (Date) input.readObject();
		JOptionPane.showMessageDialog(null, answer);
	}
}
