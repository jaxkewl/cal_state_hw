package martinhongwk8hw;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MartinHongWk8HW_2 extends JFrame {

	private JComboBox<String> stringList;
	private String[] colors = { "Red", "Blue", "Black", "Purple", "Brown",
			"Violet" };

	private JCheckBox backGround;
	private JCheckBox foreGround;

	private JButton okButton;
	private JButton cancelButton;

	public MartinHongWk8HW_2() {
		super("Martin Hong Wk 8 Homework");

		// set layout manager to null and use absolute positioning
		setLayout(null);

		int width = 400;
		int height = 150;
		setSize(width, height);

		// add the top part, the JList.
		stringList = new JComboBox<String>(colors);
		stringList.setSize(350, 20);
		stringList.setLocation(10, 0);
		add(stringList);

		// add the center part, the check boxes
		backGround = new JCheckBox("Background");
		backGround.setSize(100, 25);
		backGround.setLocation(40, 30);
		add(backGround);

		foreGround = new JCheckBox("Foreground");
		foreGround.setSize(100, 25);
		foreGround.setLocation(165, 30);
		add(foreGround);

		// add the bottom part, the buttons
		okButton = new JButton("Ok");
		okButton.setSize(50, 25);
		okButton.setLocation(80, 60);
		add(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setSize(75, 25);
		cancelButton.setLocation(145, 60);
		add(cancelButton);

	}

	public static void main(String[] args) {

		MartinHongWk8HW_2 wk8hw = new MartinHongWk8HW_2();
		wk8hw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wk8hw.setVisible(true);

	}

}
