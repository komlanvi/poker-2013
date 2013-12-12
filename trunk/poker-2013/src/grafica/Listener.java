package grafica;

// GESTIONE DEL BOTTONE INVIA DELLA CHAT

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import progettoPoker.*;
import progettoPoker.Comando.Tipo;

public class Listener implements KeyListener,ActionListener,MouseListener {

	JTextArea Chat = new JTextArea();
	JTextField ConsChat = new JTextField();
	JTextArea Statistiche=new JTextArea();
	JScrollPane ScrollChat = new JScrollPane(Chat);
	JScrollPane ScrollStat = new JScrollPane(Statistiche);
	
	ImageIcon VisChatSelected=new ImageIcon(GraficaPoker.Bottoni.getAbsolutePath()+"\\VisChatSel.png");
	ImageIcon StatSelected=new ImageIcon(GraficaPoker.Bottoni.getAbsolutePath()+"\\StatsSel.png");
	ImageIcon VisualizzaChat=new ImageIcon(GraficaPoker.Bottoni.getAbsolutePath()+"\\VisChat.png");
	ImageIcon Statistics=new ImageIcon(GraficaPoker.Bottoni.getAbsolutePath()+"\\Stats.png");
	
	
	public Listener(JTextArea a, JTextField b,JTextArea c,JScrollPane sc,JScrollPane ss) {
		this.Chat = a;
		this.ConsChat = b;
		this.Statistiche=c;
		this.ScrollChat=sc;
		this.ScrollStat=ss;



	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if (this.ConsChat.getText().length() > 0) 
			{
				this.Chat.setText(this.Chat.getText() + "  Nickname: "	+ ConsChat.getText()+ "\n" );
				ConsChat.setText("");
			}
			this.Statistiche.setText(this.Chat.getText()+" STAT: "+ConsChat.getText()+"\n");
			ConsChat.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==GraficaPoker.VisChat)
		{
			this.Statistiche.setVisible(false);
			this.ScrollStat.setVisible(false);
			this.Chat.setVisible(true);
			this.ScrollChat.setVisible(true);
			this.ConsChat.setVisible(true);
			GraficaPoker.Invia.setVisible(true);
			GraficaPoker.VisChat.setIcon(VisChatSelected);;
            GraficaPoker.Stats.setIcon(Statistics);
		}
		if(arg0.getSource()==GraficaPoker.Stats)
		{
			this.Chat.setVisible(false);
			this.ScrollChat.setVisible(false);
			this.Statistiche.setVisible(true);
			this.ScrollStat.setVisible(true);
			this.ConsChat.setVisible(false);
			GraficaPoker.Invia.setVisible(false);
            GraficaPoker.Stats.setIcon(StatSelected);
			GraficaPoker.VisChat.setIcon(VisualizzaChat);
			

		}
			
		if(arg0.getSource()==GraficaPoker.Invia)
		{
			if (this.ConsChat.getText().length() > 0) 
			{
				this.Chat.setText(this.Chat.getText() + "  Nickname: "	+ ConsChat.getText()+ "\n" );
				ConsChat.setText("");
			}
		}
		if(arg0.getSource()==GraficaPoker.Fold)
		{
             GraficaPoker.com=new Comando(Tipo.FOLD);
		}
		if(arg0.getSource()==GraficaPoker.Raise)
		{
             GraficaPoker.com=new Comando(Tipo.RAISE);//TODO scroll o textbox per inserire raise
		}
		if(arg0.getSource()==GraficaPoker.Call)
		{
             GraficaPoker.com=new Comando(Tipo.CHECK_CALL);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
