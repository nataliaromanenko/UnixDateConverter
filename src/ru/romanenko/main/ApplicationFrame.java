package ru.romanenko.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplicationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainAppPane;
	static JTextField usualDateTf;
	static JTextField unixdateTf;
	static JTextField unixTsHexTf;
	static JTextField countDaysTf;
	static JTextField countDaysHexTf;
	static JTextField inputDateTf;
	static JPanel contentPane;
	public static String inputDate;

	/**
	 * Create the frame.
	 */
	public ApplicationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainAppPane = new JPanel();
		mainAppPane.setToolTipText("\u0414\u0414-\u041C\u041C-\u0413\u0413\u0413\u0413 \u0427\u0427-\u041C\u041C-\u0421\u0421");
		mainAppPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainAppPane);
		GridBagLayout gbl_mainAppPane = new GridBagLayout();
		gbl_mainAppPane.columnWidths = new int[]{100, 100, 0};
		gbl_mainAppPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainAppPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_mainAppPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainAppPane.setLayout(gbl_mainAppPane);
		
		JLabel label = new JLabel("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0442\u0438\u043F \u0438\u0441\u0445\u043E\u0434\u043D\u043E\u0439 \u0434\u0430\u0442\u044B:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		mainAppPane.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0434\u0430\u0442\u0443 \u0434\u043B\u044F \u043F\u0435\u0440\u0435\u0432\u043E\u0434\u0430:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		mainAppPane.add(label_1, gbc_label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u041E\u0431\u044B\u0447\u043D\u0430\u044F \u0434\u0430\u0442\u0430", "UnixTimestamp", "UnixTimestamp \u0432 HEX", "\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970", "\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970 \u0432 HEX"}));
		comboBox.setMaximumRowCount(5);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		mainAppPane.add(comboBox, gbc_comboBox);
		
		inputDateTf = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 1;
		mainAppPane.add(inputDateTf, gbc_textField_5);
		inputDateTf.setColumns(10);
		
				
		JButton btnNewButton = new JButton("\u041F\u0435\u0440\u0435\u0432\u0435\u0441\u0442\u0438");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputDate = inputDateTf.getText();
				
				String dateFormat = "";
				String inputFormat = "";
				
				switch (comboBox.getSelectedIndex()){
					case 0: 
						dateFormat = InputDateFormats.DATE_PATTERN;
						break;
					case 1:
						dateFormat = InputDateFormats.UNIXTIME_PATTERN;
						break;
					case 2:
						dateFormat = InputDateFormats.UNIXTIME_HEX_PATTERN;
						break;
					case 3:
						dateFormat = InputDateFormats.DAYS_SINCE_1970_PATTERN;
						break;
					case 4:
						dateFormat = InputDateFormats.DAYS_SINCE_1970_HEX_PATTERN;
						break;
				}
				
				try {
					InputDateFormats inputDateFormat = new InputDateFormats(inputDate, dateFormat);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
			
			/*	try {
					InputDateFormats.ValidateInputDayText(inputDate);
				} catch (java.text.ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}); */
			 
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		mainAppPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel label_2 = new JLabel("\u041F\u043E\u043B\u0443\u0447\u0435\u043D\u043D\u044B\u0439 \u0440\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		mainAppPane.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("\u041E\u0431\u044B\u0447\u043D\u0430\u044F \u0434\u0430\u0442\u0430");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 4;
		mainAppPane.add(label_3, gbc_label_3);
		
		usualDateTf = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		mainAppPane.add(usualDateTf, gbc_textField);
		usualDateTf.setColumns(10);
		
		JLabel lblUnixtimestamp = new JLabel("UnixTimestamp");
		GridBagConstraints gbc_lblUnixtimestamp = new GridBagConstraints();
		gbc_lblUnixtimestamp.anchor = GridBagConstraints.WEST;
		gbc_lblUnixtimestamp.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnixtimestamp.gridx = 0;
		gbc_lblUnixtimestamp.gridy = 5;
		mainAppPane.add(lblUnixtimestamp, gbc_lblUnixtimestamp);
		
		unixdateTf = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		mainAppPane.add(unixdateTf, gbc_textField_1);
		unixdateTf.setColumns(10);
		
		JLabel lblUnixtimestampHex = new JLabel("UnixTimestamp \u0432 HEX");
		GridBagConstraints gbc_lblUnixtimestampHex = new GridBagConstraints();
		gbc_lblUnixtimestampHex.anchor = GridBagConstraints.WEST;
		gbc_lblUnixtimestampHex.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnixtimestampHex.gridx = 0;
		gbc_lblUnixtimestampHex.gridy = 6;
		mainAppPane.add(lblUnixtimestampHex, gbc_lblUnixtimestampHex);
		
		unixTsHexTf = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		mainAppPane.add(unixTsHexTf, gbc_textField_2);
		unixTsHexTf.setColumns(10);
		
		JLabel label_4 = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 7;
		mainAppPane.add(label_4, gbc_label_4);
		
		countDaysTf = new JTextField();
		GridBagConstraints gbc_countDaysTf = new GridBagConstraints();
		gbc_countDaysTf.insets = new Insets(0, 0, 5, 0);
		gbc_countDaysTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_countDaysTf.gridx = 1;
		gbc_countDaysTf.gridy = 7;
		mainAppPane.add(countDaysTf, gbc_countDaysTf);
		countDaysTf.setColumns(10);
		
		JLabel label_5 = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970 \u0432 HEX");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 8;
		mainAppPane.add(label_5, gbc_label_5);
		
		countDaysHexTf = new JTextField();
		GridBagConstraints gbc_countDaysHexTf = new GridBagConstraints();
		gbc_countDaysHexTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_countDaysHexTf.gridx = 1;
		gbc_countDaysHexTf.gridy = 8;
		mainAppPane.add(countDaysHexTf, gbc_countDaysHexTf);
		countDaysHexTf.setColumns(10);
}
}