package projects.seachess;

import java.net.URL;

import javax.swing.ImageIcon;

public final class Player {
	
	private final String _name;

	private final ImageIcon _imageIcon;
	
	private int _playerId;
	
	public Player (String name, int id, String iconPath) {
		_name = name;
		URL imageURL = getClass().getClassLoader().getResource(iconPath);
		_imageIcon = new ImageIcon(imageURL);
		_playerId = id;
	}
	
	public String getName() {
		return _name;
	}

	public ImageIcon getImageIcon() {
		return _imageIcon;
	}
	
	public int getId () {
		return _playerId;
	}

}
