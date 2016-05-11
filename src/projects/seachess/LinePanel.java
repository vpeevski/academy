package projects.seachess;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public final class LinePanel {
	
	private List<FieldPanel> _fieldPanels;
	
	private JPanel _innerLinePanel;
	
	public LinePanel (int line, int size) {
		_innerLinePanel = new JPanel();
		_innerLinePanel.setLayout(new BoxLayout(_innerLinePanel, BoxLayout.X_AXIS));
		for (int i = 0; i < size; i++) {
			FieldPanel fieldPanel = new FieldPanel(line, i);
//			if(i % 2 == 0)
//			   fieldPanel.mark("projects/seachess/circle_green.png");
//			else 
//				fieldPanel.mark("projects/seachess/cross_red.png");
			_innerLinePanel.add(fieldPanel.asPanel());
			if(i != size -1) {
				//_innerLinePanel.add(new JSeparator(JSeparator.VERTICAL));
			}
		}
	}
	
	public JPanel asPanel () {
		return _innerLinePanel;
	}

}
