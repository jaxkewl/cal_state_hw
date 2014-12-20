package martinhongwk8hw;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MartinHongWk8HW extends JFrame {
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;

	private BorderLayout mainBorderLayout;

	private BorderLayout northBorderLayout;
	private BorderLayout centerBorderLayout;
	private BorderLayout southBorderLayout;

	private JList<String> stringList;
	private String[] colors = { "Red", "Blue", "Black", "Purple" };

	private JCheckBox backGround;
	private JCheckBox foreGround;

	private JButton okButton;
	private JButton cancelButton;

	public MartinHongWk8HW() {
		super("Martin Hong Wk 8 Homework");

		mainPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new BorderLayout());
		bottomPanel = new JPanel(new BorderLayout());

		// add the top part, the JList.
		stringList = new JList<String>(colors);
		//stringList.setVisibleRowCount(3);
		topPanel.add(new JScrollPane(stringList), BorderLayout.CENTER);

		// add the center part, the check boxes
		backGround = new JCheckBox("Background");
		foreGround = new JCheckBox("Foreground");
		centerPanel.add(backGround, BorderLayout.WEST);
		centerPanel.add(foreGround, BorderLayout.EAST);

		// add the bottom part, the buttons
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		bottomPanel.add(okButton, BorderLayout.WEST);
		bottomPanel.add(cancelButton, BorderLayout.EAST);

		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);

		add(mainPanel);
	}

	public static void main(String[] args) {

		MartinHongWk8HW wk8hw = new MartinHongWk8HW();
		wk8hw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wk8hw.setSize(400, 400);
		wk8hw.setVisible(true);

	}

}
