import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigInteger;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -3880026026104218593L;
	private Primes m_Primes;
	private JTextField tfPrimeFileName;
	private JTextField tfCrossFileName;
	private JLabel lblPrimeCount;
	private JLabel lblCrossCount;
	private JLabel lblLargestPrime;
	private JLabel lblLargestCross;
	private JLabel lblStatus;
	
	MainWindow(String name, Primes p)
	{
		super();
		this.m_Primes = p;
		
		// Main window creation
		GridBagLayout gridLayout = new GridBagLayout();
		setTitle(name);
		getContentPane().setBackground(new Color(80, 0, 0));
		getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		// Check out grid width
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		
		// Primes file panel
		JPanel pnlPrimes = new JPanel();
		pnlPrimes.setLayout(new GridBagLayout());
		
		tfPrimeFileName = new JTextField();
		tfPrimeFileName.setColumns(50);
		gbcPanel.gridx = 0;
		gbcPanel.gridwidth = 2;
		tfPrimeFileName.setText("primes.txt");
		pnlPrimes.add(tfPrimeFileName, gbcPanel);
		
		lblPrimeCount = new JLabel("0");
		lblPrimeCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrimeCount.setLabelFor(tfPrimeFileName);
		gbcPanel.gridx = 2;
		gbcPanel.gridwidth = 1;
		pnlPrimes.add(lblPrimeCount, gbcPanel);
		
		JLabel lblPrimeStart = new JLabel("Primes File");
		lblPrimeStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.gridwidth = 1;
		pnlPrimes.add(lblPrimeStart, gbcPanel);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		      	boolean status = FileAccess.loadPrimes(m_Primes, Config.DATAPATH + tfPrimeFileName.getText());
		      	if (status)
		      		lblStatus.setText("Status: Loaded primes file successfully.");
		      	else
		      		lblStatus.setText("Status: FAILED to load primes file.");
		      	
		      	updateStats();
		      }
		    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.gridwidth = 2;
		pnlPrimes.add(btnLoad, gbcPanel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
			      	boolean status = FileAccess.savePrimes(m_Primes, Config.DATAPATH + tfPrimeFileName.getText());
			      	if (status)
			      		lblStatus.setText("Status: Primes list saved successfully.");
			      	else
			      		lblStatus.setText("Status: FAILED to save primes list.");
			      }
		    });
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		pnlPrimes.add(btnSave, gbcPanel);
		
		add(pnlPrimes, gbcDialog);
		
		// Hexagon cross file panel
		JPanel pnlCrosses = new JPanel();
		pnlCrosses.setLayout(new GridBagLayout());
		
		lblCrossCount = new JLabel("0");
		lblCrossCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 0;
		gbcPanel.gridwidth = 1;
		pnlCrosses.add(lblCrossCount, gbcPanel);
		
		tfCrossFileName = new JTextField();
		lblCrossCount.setLabelFor(tfCrossFileName);
		tfCrossFileName.setColumns(50);
		gbcPanel.gridx = 0;
		tfCrossFileName.setText("crosses.txt");
		pnlCrosses.add(tfCrossFileName, gbcPanel);
		
		JLabel lblCrossStart = new JLabel("Hexagon Cross File");
		lblCrossStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlCrosses.add(lblCrossStart, gbcPanel);
		
		JButton btnLoadCross = new JButton("Load");
		btnLoadCross.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
			      	boolean status = FileAccess.loadCrosses(m_Primes, Config.DATAPATH + tfCrossFileName.getText());
			      	if (status)
			      		lblStatus.setText("Status: Loaded cross file successfully.");
			      	else
			      		lblStatus.setText("Status: FAILED to load cross list.");
			      	
			      	updateStats();
			  }
		    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlCrosses.add(btnLoadCross, gbcPanel);
		
		JButton btnSaveCross = new JButton("Save");
		btnSaveCross.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
			      	boolean status = FileAccess.saveCrosses(m_Primes, Config.DATAPATH + tfCrossFileName.getText());
			      	if (status)
			      		lblStatus.setText("Status: Cross list saved successfully.");
			      	else
			      		lblStatus.setText("Status: FAILED to save cross list.");
			      }
		    });
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		pnlCrosses.add(btnSaveCross, gbcPanel);
		
		gbcDialog.gridy = 1;
		add(pnlCrosses, gbcDialog);
		
		// Bottom panel - buttons, status, fields, etc.

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  popupGeneratePrimes();
		      }
		    });
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		lblLargestPrime = new JLabel("The largest prime has 0 digits.");
		lblLargestPrime.setFont(new Font("Tahoma", Font.BOLD, 12));
		gbcPanel.gridx = 1;
		gbcPanel.anchor = GridBagConstraints.CENTER;
		pnlButtons.add(lblLargestPrime, gbcPanel);
		
		lblLargestCross = new JLabel("The largest cross has 0 and 0 digits.");
		lblLargestCross.setFont(new Font("Tahoma", Font.BOLD, 12));
		gbcPanel.gridy = 1;
		pnlButtons.add(lblLargestCross, gbcPanel);
		
		JButton btnGenerateCross = new JButton("Generate Crosses");
		btnGenerateCross.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	m_Primes.generateTwinPrimes();
	       		m_Primes.generateHexPrimes();
	       		lblStatus.setText("Status: Excited. Crosses have been generated.");
	       		updateStats();
		      }
		    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 2;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGenerateCross, gbcPanel);		
		
		gbcDialog.gridy = 2;
		add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		lblStatus = new JLabel("Status: Bored.");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlStatus.add(lblStatus, gbcPanel);
		
		gbcDialog.gridy = 3;
		add(pnlStatus, gbcDialog);
		
		
		setSize(1000,400);
		pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		setVisible(true);		
	}

	protected void popupGeneratePrimes()
	{
		JDialog dPrimes = new JDialog(this, "Prime Number Generation");
		GridBagLayout gridLayout = new GridBagLayout();
		dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		JPanel pnlGenerate = new JPanel();
		pnlGenerate.setLayout(new GridBagLayout());
		
		JLabel lblCount = new JLabel("Number of Primes to Generate");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlGenerate.add(lblCount, gbcPanel);
		
		JTextField tfCount = new JTextField();
		lblCount.setLabelFor(tfCount);
		tfCount.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfCount, gbcPanel);
		
		JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlGenerate.add(lblStart, gbcPanel);
		
		JTextField tfStart = new JTextField();
		lblStart.setLabelFor(tfStart);
		tfStart.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfStart, gbcPanel);
		
		dPrimes.add(pnlGenerate, gbcDialog);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try
      	{
      		BigInteger start = new BigInteger(tfStart.getText());
      		int count = Integer.parseInt(tfCount.getText());
       		m_Primes.generatePrimes(start, count);
       		lblStatus.setText("Status: Excited. Primes have been generated.");
       		updateStats();
      		dPrimes.dispose();
      	}
      	catch(NumberFormatException ex)
      	{
      		lblStatus.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
      		dPrimes.dispose();
      	}
      	
      }
    });
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		JButton btnCancel = new JButton("Cancel Generation");
		btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	dPrimes.dispose();
      }
    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		pnlButtons.add(btnCancel, gbcPanel);		
		
		gbcDialog.gridy = 1;
		dPrimes.add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 2;
		dPrimes.add(pnlStatus, gbcDialog);
		
		dPrimes.setSize(200,200);
		dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		dPrimes.setVisible(true);		
	}

	// This function updates all the GUI statistics. (# of primes, # of crosses, etc)
	private void updateStats()
	{
		lblPrimeCount.setText(String.valueOf(m_Primes.primeCount()));
		lblCrossCount.setText(String.valueOf(m_Primes.crossesCount()));
		lblLargestPrime.setText("The largest prime has " + m_Primes.sizeofLastPrime() + " digits.");
		lblLargestCross.setText("The largest cross has " + m_Primes.sizeofLastCross().left() + " and " + m_Primes.sizeofLastCross().left() + " digits.");
 	}

}
