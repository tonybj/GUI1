

	import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

	public class Gui extends JFrame implements ActionListener {

	    private JList list;
	    private DefaultListModel model;
	    private JTextArea texta;
	    private JPanel panel,southPanel,slPanel,srPanel;
	    private JButton okButton,butta;
	    private DefaultListModel modelSouth;
	    private JList southList;
	    private JLabel labelSouth;
	    private JTextArea textarea;
	    private JTextField dragText;
	    private JButton rnmBtn;
	    
	    
	    public Gui() {
	        initUI();
	    }

	    public final void initUI() {

	    	String[] array = {"2","4","45"};
	    	String[] allfonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	    	
	    	String[] fonts = new String[20];
	    	
	    	for(int i =0;i<fonts.length;i++){
	    		fonts[i]=allfonts[i];
	    	}
	    	
	    	
	    	/*
	    	 * Creating components
	    	 */
	    	
	        panel = new JPanel();
	        JPanel panelNorth = new JPanel();
	        texta = new JTextArea();
	        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        model = new DefaultListModel();	        
	        list = new JList(model);
	        okButton = new JButton("Ok");
	        JSlider slider = new JSlider(0,100,0);
	        JComboBox combo = new JComboBox(array);
	        JProgressBar progress = new JProgressBar();
	        JToggleButton toggle = new JToggleButton("Toggle");
	        JScrollPane scroList = new JScrollPane();
	        JList lista2 = new JList(fonts);
	        JScrollPane texScroll = new JScrollPane();
	        textarea = new JTextArea();
	        JScrollPane panePane = new JScrollPane();
	        JTextPane txtPane = new JTextPane();
	        JButton addBtn = new JButton("Add");
	        JButton rmvBtn = new JButton("Remove");
	        rnmBtn = new JButton("rename");
	        labelSouth = new JLabel();
	        southPanel = new JPanel();
	        slPanel = new JPanel();
	        srPanel = new JPanel();
	        modelSouth = new DefaultListModel(); 
	        southList = new JList(modelSouth);
	        dragText = new JTextField();
	        JTextField dragText2 = new JTextField();
	        
	        
	        /*
	         * MISC
	         */
	        
	        dragText.setDragEnabled(true);
	        dragText.setPreferredSize(new Dimension(80,25));
	        
	        dragText2.setTransferHandler(new TransferHandler("text"));
	        modelSouth.addElement("Hello");
	        modelSouth.addElement("Goodbye");
	        
	        
	        southPanel.setLayout(new BoxLayout(southPanel,BoxLayout.X_AXIS));
	        
	        txtPane.setContentType("text/html");
	        texta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        texta.setLineWrap(true);
	        
	        texScroll.setPreferredSize(new Dimension(100,100));	     
	        panePane.setPreferredSize(new Dimension(100,100));	     

	        pane.setPreferredSize(new Dimension(100,100));	     
	        pane.getViewport().add(texta);
	        
	        progress.setValue(12);
	        progress.setMaximumSize(new Dimension(150, 20));
	        progress.setMinimumSize(new Dimension(150, 20));
	        progress.setPreferredSize(new Dimension(150, 20));
	        
	        panePane.getViewport().add(txtPane);
	        scroList.getViewport().add(lista2);
	        texScroll.getViewport().add(textarea);
	        
	        
	        /*
	         * Adding stuff to the GUI containers
	         */
	        
	        panel.setLayout(new BorderLayout());
	        panel.add(okButton,BorderLayout.WEST);
	        panel.add(list,BorderLayout.CENTER);
	        panel.add(pane,BorderLayout.EAST);
	        panel.add(panelNorth,BorderLayout.NORTH);
	        panel.add(southPanel,BorderLayout.SOUTH);
	        panelNorth.add(slider,BorderLayout.NORTH);
	        panelNorth.add(combo);
	        panelNorth.add(progress);
	        panelNorth.add(toggle);
	        panelNorth.add(scroList);
	        panelNorth.add(texScroll);
	        panelNorth.add(panePane);
	        southPanel.add(slPanel);
	        southPanel.add(srPanel);
	        srPanel.add(addBtn);
	        srPanel.add(rmvBtn);
	        srPanel.add(rnmBtn);
	        srPanel.add(labelSouth);
	        slPanel.add(southList);
	        srPanel.add(dragText);
	        srPanel.add(dragText2);
	        //this is a test -_-
	        
	        
	        try {
	        	String cd = System.getProperty("user.dir") + "/";
	            txtPane.setPage(new URL("http://www.google.com"));
	            System.out.println(cd);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				 Logger.getLogger(Gui.class.getName()).log(Level.SEVERE,
		                    null, e1);			}
	        
	        addButton();
	        
	        
	        
	        add(panel);
	        
	        /*
	         * Listeners for the components
	         */
	        
	        okButton.addActionListener(this);
	        
	        textarea.addMouseMotionListener(new MouseMotionAdapter(){

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("" + arg0.getX());
					labelSouth.setText(String.valueOf(textarea.getSelectionEnd()));
				}

	        	
	        });
	        
	        addBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String newListEntry = JOptionPane.showInputDialog("gimme");
					modelSouth.addElement(newListEntry);
				}
	        	
	        });
	        
	        rmvBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ListSelectionModel listModel = southList.getSelectionModel();
					int index = listModel.getMinSelectionIndex();
					if (index >= 0){
						modelSouth.removeElementAt(index);
					}
					
				}
	        	
	        });
	        
	        rnmBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ListSelectionModel listModel = southList.getSelectionModel();
					int index = listModel.getMinSelectionIndex();
					if(index >=0){
						String newListEntry = JOptionPane.showInputDialog("hello",modelSouth.getElementAt(index));
						
					modelSouth.removeElementAt(index);
					modelSouth.add(index, newListEntry);
					
					}
				}
	        	
	        });
	        
	        lista2.addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					JList lis = (JList) arg0.getSource();
					String fontname = (String) lis.getSelectedValue();
					Font font = new Font(fontname,Font.PLAIN,10);
					okButton.setFont(font);
				}
	        	
	        });
	        
	        combo.addItemListener(new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					JComboBox comb = (JComboBox)arg0.getSource();
					
				    okButton.setText("" + comb.getSelectedItem());	
					
				}
	        	
	        });
	        
	        slider.addChangeListener( new ChangeListener(){
	        		
					@Override
					public void stateChanged(ChangeEvent arg0) {
						// TODO Auto-generated method stub
						JSlider slid = (JSlider)arg0.getSource();

				        okButton.setText("" + slid.getValue());	
					}	        		        	
	        });
	        
	        addComponentListener(new ComponentAdapter(){
	        	public void componentMoved(ComponentEvent e){
	        	System.out.println(e.getComponent().getX());
	        	}


				@Override
				public void componentResized(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("resizedf!");
				}


	        	
	        });

	        setTitle("Event object");
	        setSize(420, 250);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	    
	 

		public void addButton(){
	    	butta = new JButton("egen metod");
	    	southPanel.add(butta);
	    	butta.setEnabled(true);
	    	butta.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
		    	DefaultButtonModel model = (DefaultButtonModel) butta.getModel();
	    		if(model.isPressed()){
	    			System.out.println("pressed");
	    		}
			}
	    	
	    	});
	    }

	    public void actionPerformed(ActionEvent e) {

	        
	    	JDialog dialog = new JDialog();
	    	JLabel diaLabel = new JLabel("min label");
	    	dialog.add(diaLabel);
	    	dialog.setVisible(true);
	    	dialog.setSize(100,100);
	    	
	    	JFileChooser fileo = new JFileChooser();
	    	int ret = fileo.showDialog(this, "Open file");
	    	
	    	if(ret == JFileChooser.APPROVE_OPTION){
	    		File file = fileo.getSelectedFile();
	    		String text = file.toString();
	    		model.addElement(text);
	    	}
	    	
	    	
	    	Locale locale = Locale.getDefault();
	        Date date = new Date(e.getWhen());
	        String s = DateFormat.getTimeInstance(DateFormat.LONG,
	                locale).format(date);

	        //if (!model.isEmpty()) {
	        //    model.clear();
	        //}

	        if (e.getID() == ActionEvent.ACTION_PERFORMED) {
	            model.addElement(" Event Id: ACTION_PERFORMED");
	        }

	        model.addElement(" Time: " + s);

	        String source = e.getSource().getClass().getName();
	        model.addElement(" Source: " + source);

	        int mod = e.getModifiers();

	        StringBuffer buffer = new StringBuffer(" Modifiers: ");

	        if ((mod & ActionEvent.ALT_MASK) > 0) {
	            buffer.append("Alt ");
	        }

	        if ((mod & ActionEvent.SHIFT_MASK) > 0) {
	            buffer.append("Shift ");
	        }

	        if ((mod & ActionEvent.META_MASK) > 0) {
	            buffer.append("Meta ");
	        }

	        if ((mod & ActionEvent.CTRL_MASK) > 0) {
	            buffer.append("Ctrl ");
	        }

	        model.addElement(buffer);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {

	            public void run() {
	                Gui ex = new Gui();
	                ex.setVisible(true);
	            }
	        });
	    }
	}
	
	


