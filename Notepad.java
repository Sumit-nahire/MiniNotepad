package sumit;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener{
           Container cp;
           JMenuBar mbr;
           JMenu file,Edit,View;
           JMenuItem Open,Save,Exit,Cut,Copy,Paste,Zoom,Statusbar,Wordwrap;
           JTextArea ta;
           
           public Notepad(String t) {
        	   super(t);
        	   cp=getContentPane();
        	   ta=new JTextArea();
        	   cp.add(ta);
        	   
        	   mbr = new JMenuBar();
        	   setJMenuBar(mbr);
        	   
        	   
        	   file = new JMenu("File");
        	   mbr.add(file);
        	   Edit = new JMenu("Edit");
        	   mbr.add(Edit);
        	   View = new JMenu("View");
        	   mbr.add(View);
        	   
        	   Open=new JMenuItem("Open");
        	   Save = new JMenuItem("Save");
        	   Exit= new JMenuItem("Exit");
        	   file.add(Open);
        	   file.add(Save);
        	   file.add(Exit);
        	   
        	   Cut = new JMenuItem("Cut");
        	   Copy = new JMenuItem("Copy");
        	   Paste = new JMenuItem("Paste");
        	   Edit.add(Cut);
        	   Edit.add(Copy);
        	   Edit.add(Paste);
        	   
        	   Zoom = new JMenuItem("Zoom");
        	   Statusbar = new JMenuItem("Statusbar");
        	   Wordwrap = new JMenuItem("Wordwrap");
        	   View.add(Zoom);
        	   View.add(Statusbar);
        	   View.add(Wordwrap);
        	   
        	   
        	   Open.addActionListener(this);
        	   Save.addActionListener(this);
        	   Exit.addActionListener(this);
        	   Cut.addActionListener(this);
        	   Copy.addActionListener(this);
        	   Paste.addActionListener(this);
        	   
        	   setSize(500,300);
        	   setVisible(true);
        	   
        	   
		}
	  
	public static void main(String[] args) {
                new Notepad("My Notepad");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jr = new JFileChooser();
		
		
			
			try {
				if(e.getSource() == Open) {
					jr.showOpenDialog(this);
					File f = jr.getSelectedFile();
				FileReader fr = new FileReader(f);
				StringBuffer b = new StringBuffer();
				
				int ch;
				while((ch = fr.read())!=-1) {
					b.append((char)ch);
				}
				ta.setText(b.toString());
				fr.close();
			     	
				}
				else 
					if(e.getSource() == Save) {
						jr.showSaveDialog(this);
						File f = jr.getSelectedFile();
						
						FileWriter fw = new FileWriter(f);
						fw.write(ta.getText());
						fw.close();
					}
					else
						if(e.getSource() == Exit) {
							this.dispose();
						}
						else
							if(e.getSource() == Cut) {
								ta.cut();
							}
							else
								if(e.getSource() == Copy) {
									ta.copy();
								}
								else
									if(e.getSource() == Paste) {
										ta.paste();
									}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}


