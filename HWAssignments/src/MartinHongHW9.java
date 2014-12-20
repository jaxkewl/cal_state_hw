import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MartinHongHW9 extends JPanel {

	private int diameter = 10;

	public void setDiameter(int diameter) {
		this.diameter = diameter;
		repaint();
	}

	@Override
	public void paintComponent(Graphics arg0) {

		super.paintComponent(arg0);
		arg0.fillOval(10, 10, diameter, diameter);
	}

	public static void main(String[] args) {
		SliderFrame sliderFrame = new SliderFrame();
		sliderFrame.setVisible(true);
	}

}

class SliderFrame extends JFrame {
	private JSlider jSlider;
	private JTextField jTextField;
	private JLabel jLabel;
	private MartinHongHW9 myPanel;

	JPanel topPanel;

	private static final int maxCircleSize = 200;

	public SliderFrame() {
		super("Martin Hong HW 9");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 325);

		topPanel = new JPanel();

		myPanel = new MartinHongHW9();
		myPanel.setBackground(Color.YELLOW);
		add(myPanel, BorderLayout.CENTER);

		jSlider = new JSlider(SwingConstants.HORIZONTAL, 0, maxCircleSize, 10);
		jSlider.setMajorTickSpacing(10);
		jSlider.setPaintTicks(true);
		jSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				jTextField.setText(Integer.toString(jSlider.getValue()));
				myPanel.setDiameter(jSlider.getValue());
			}
		});
		add(jSlider, BorderLayout.SOUTH);

		jTextField = new JTextField(5);
		jTextField.setText(Integer.toString(jSlider.getValue()));
		topPanel.setLayout(new FlowLayout());
		jLabel = new JLabel("Size of Circle");
		topPanel.add(jLabel);
		topPanel.add(jTextField, BorderLayout.NORTH);

		add(topPanel, BorderLayout.NORTH);

		jTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					int newValue = Integer.parseInt(jTextField.getText());

					// only allow the value if its less than the max circle size
					if (newValue <= maxCircleSize) {
						myPanel.setDiameter(newValue);
						jSlider.setValue(newValue);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
					JOptionPane.showInputDialog(SliderFrame.this,
							"Enter an integer");
				}

			}
		});

	}

}
