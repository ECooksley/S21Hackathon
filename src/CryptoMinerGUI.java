
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import CryptoMiner.CalculatedData;

public class CryptoMinerGUI extends JFrame implements ActionListener {
	private JLabel bitcoin = new JLabel("How much bitcoin would you like to mine?");
	private JTextField inField;
	private JTextArea hourDisplay, amountDisplay;
	private JLabel minerLabel = new JLabel("How many miners?");
	private JButton calculate;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JSpinner spinner;
	private JSeparator separator;
	private CryptoMiner cryptoMiner;
	private JComboBox comboBox;
	
	
	public CryptoMinerGUI(String title) {
		cryptoMiner = new CryptoMiner();
		inField = new JTextField(4);
		
		hourDisplay = new JTextArea("", 2, 20);
		amountDisplay = new JTextArea("", 5, 20);
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		
		JPanel bitcoinPanel = new JPanel();
		bitcoinPanel.setLayout(new GridLayout(1,3));
		bitcoinPanel.add(bitcoin);
		bitcoinPanel.add(inField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		outputPanel.add("North", hourDisplay);
		outputPanel.add("South", amountDisplay);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North", bitcoinPanel);
		
		String[] currency = {"BTC", "USD", "GBP", "EUR", "CAD"};
		comboBox = new JComboBox(currency);
		comboBox.setSelectedIndex(0);
		bitcoinPanel.add(comboBox);
		contentPane.add("South", outputPanel);
		
		separator = new JSeparator();
		outputPanel.add(separator, BorderLayout.CENTER);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.add(minerLabel);
		
		SpinnerModel value = new SpinnerNumberModel(0, 0, cryptoMiner.getNumberOfMiners(), 1);
		spinner = new JSpinner(value);
		panel_1.add(spinner);
		
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
	
		panel_2.add(calculate, BorderLayout.CENTER);
		
		setSize(700,300);
		setTitle(title);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calculate) {
			CalculatedData result = cryptoMiner.calcData(Float.parseFloat(inField.getText()), (Integer) spinner.getValue(), (String) comboBox.getSelectedItem());
			
			hourDisplay.setText("Hours Taken: " + result.time + "\tEnergy Cost: " + result.cost + " CAD");
			amountDisplay.setText("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CryptoMinerGUI("Bitcoin Calculator");
	}

}
