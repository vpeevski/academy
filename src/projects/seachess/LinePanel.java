package projects.seachess;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public final class LinePanel {
	
	private JPanel _innerLinePanel;
	
	public LinePanel (GameController gameController, int line, int size) {
		_innerLinePanel = new JPanel();
		_innerLinePanel.setLayout(new BoxLayout(_innerLinePanel, BoxLayout.X_AXIS));
		for (int i = 0; i < size; i++) {
			FieldPanel fieldPanel = new FieldPanel(gameController, line, i);
			_innerLinePanel.add(fieldPanel.asPanel());
		}
	}
	
	public JPanel asPanel () {
		return _innerLinePanel;
	}

}
