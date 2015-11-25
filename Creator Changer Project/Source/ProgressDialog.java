import java.awt.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;public class ProgressDialog extends Dialog{	public ProgressDialog(Frame parent, boolean modal, ActionListener listener)	{		super(parent, modal);		// This code is automatically generated by Visual Cafe when you add		// components to the visual environment. It instantiates and initializes		// the components. To modify the code, only use code syntax that matches		// what Visual Cafe can generate, or Visual Cafe may be unable to back		// parse your Java file into its visual environment.		//{{INIT_CONTROLS		GridBagLayout gridBagLayout;		gridBagLayout = new GridBagLayout();		setLayout(gridBagLayout);		setVisible(false);		setSize(341,81);		setBackground(new Color(-1644826));		paramLabel = new java.awt.Label("Collecting Files...");		paramLabel.setBounds(11,2,318,25);		GridBagConstraints gbc;		gbc = new GridBagConstraints();		gbc.gridx = 1;		gbc.gridy = 0;		gbc.gridwidth = 3;		gbc.anchor = GridBagConstraints.NORTHWEST;		gbc.fill = GridBagConstraints.NONE;		gbc.insets = new Insets(0,0,0,0);		((GridBagLayout)getLayout()).setConstraints(paramLabel, gbc);		add(paramLabel);		fileLabel = new java.awt.Label("");		fileLabel.setBounds(11,27,318,21);		fileLabel.setFont(new Font("SansSerif", Font.PLAIN, 9));		gbc = new GridBagConstraints();		gbc.gridx = 1;		gbc.gridy = 1;		gbc.gridwidth = 3;		gbc.anchor = GridBagConstraints.NORTHWEST;		gbc.fill = GridBagConstraints.BOTH;		gbc.insets = new Insets(0,0,0,0);		((GridBagLayout)getLayout()).setConstraints(fileLabel, gbc);		add(fileLabel);		button1 = new java.awt.Button();		button1.setLabel("Stop");		button1.setBounds(271,53,58,20);		gbc = new GridBagConstraints();		gbc.gridx = 3;		gbc.gridy = 3;		gbc.anchor = GridBagConstraints.EAST;		gbc.fill = GridBagConstraints.NONE;		gbc.insets = new Insets(0,0,0,0);		((GridBagLayout)getLayout()).setConstraints(button1, gbc);		add(button1);		progressBar1 = new ProgressBar();		progressBar1.setBounds(11,58,250,14);		gbc = new GridBagConstraints();		gbc.gridx = 1;		gbc.gridy = 3;		gbc.gridwidth = 2;		gbc.fill = GridBagConstraints.NONE;		gbc.insets = new Insets(10,0,10,10);		((GridBagLayout)getLayout()).setConstraints(progressBar1, gbc);		add(progressBar1);		setTitle("Processing...");		//}}		setResizable(false);		setVisible(false);		fileCount = 0;		fileIndex = 0;		this.listener = listener;		//{{REGISTER_LISTENERS		SymWindow aSymWindow = new SymWindow();		this.addWindowListener(aSymWindow);		SymAction lSymAction = new SymAction();		button1.addActionListener(lSymAction);		//}}	}	public void setFileCount(int fileCount)	{		this.fileCount = fileCount;	}		public int getFileCount()	{		return fileCount;	}	public void setFileLabel(String label)	{		fileLabel.setText(label);	}		public String getFileLabel()	{		return fileLabel.getText();	}		public void setFileIndex(int fileIndex)	{		this.fileIndex = fileIndex;				String tempText = replace("<<number>>", "" + fileIndex, paramString);		paramLabel.setText(replace("<<total>>", "" + fileCount, tempText));		try		{			if (fileIndex > 0)			{				progressBar1.setPercent(fileIndex/(double) fileCount);			}			else			{				progressBar1.setPercent(0.0);			}		}		catch (IllegalArgumentException exc) { }	}		public int getFileIndex()	{		return fileIndex;	}		protected String replace(String what, String with, String source)	{		String result = new String(source);				int index = source.indexOf(what);		while (index >= 0)		{			result = (result.substring(0, index) + with + result.substring(index + what.length()));			index = result.indexOf(what);		}				return result;	}	    /**     * Shows or hides the component depending on the boolean flag b.     * @paramLabel b  if true, show the component; otherwise, hide the component.     * @see java.awt.Component#isVisible     */    public void setVisible(boolean b)	{		if(b)		{			Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();			Dimension dSize = getSize();				setLocation((sSize.width - dSize.width) >> 1, (int)(0.33333333 * sSize.height));		}		super.setVisible(b);	}	public void update(Graphics g)	{		paint(g);	}		//{{DECLARE_CONTROLS	java.awt.Label paramLabel;	java.awt.Label fileLabel;	java.awt.Button button1;	ProgressBar progressBar1;	//}}	class SymWindow extends java.awt.event.WindowAdapter	{		public void windowClosing(java.awt.event.WindowEvent event)		{			Object object = event.getSource();			if (object == ProgressDialog.this)				ProgressDialog_WindowClosing(event);		}	}		void ProgressDialog_WindowClosing(java.awt.event.WindowEvent event)	{		if (listener != null)			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Progress Stopped"));		setVisible(false);		dispose();	}	class SymAction implements java.awt.event.ActionListener	{		public void actionPerformed(java.awt.event.ActionEvent event)		{			Object object = event.getSource();			if (object == button1)				button1_ActionPerformed(event);		}	}	void button1_ActionPerformed(java.awt.event.ActionEvent event)	{		if (listener != null)			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Progress Stopped"));		setVisible(false);		dispose();	}	protected ActionListener listener;	protected int fileCount;	protected int fileIndex;	protected String paramString = "Processing file <<number>> of <<total>>:";}