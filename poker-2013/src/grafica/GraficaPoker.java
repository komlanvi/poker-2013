package grafica;

import java.awt.*;
import java.awt.event.MouseEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.File;
//import java.net.*;







import javax.swing.*;

import progettoPoker.Carta;
import progettoPoker.Comando;

public class GraficaPoker extends JFrame {
	
	public GiocatoreGrafico Giocatori[]=new GiocatoreGrafico[8];
	static Comando com=null;

	
	/**	 Setta le prime 3 carte sul tavolo
	 */
	public void setFlop(Carta [] c)
	{
		this.cartaT1.setIcon(Icone.getCarta(c[0].getIndice()));
		this.cartaT1.setVisible(true);
		this.cartaT2.setIcon(Icone.getCarta(c[1].getIndice()));
		this.cartaT2.setVisible(true);
		this.cartaT3.setIcon(Icone.getCarta(c[2].getIndice()));
		this.cartaT3.setVisible(true);
	}
	/**
	 * Setta la 4a carta sul tavolo
	 */
	public void setTurn(Carta c1)
	{
		this.cartaT4.setIcon(Icone.getCarta(c1.getIndice()));
		this.cartaT4.setVisible(true);
	}
	/**
	 * Setta la 5a carta sul tavolo
	 */
	public void setRiver(Carta c1)
	{
		this.cartaT5.setIcon(Icone.getCarta(c1.getIndice()));
		this.cartaT5.setVisible(true);
	}
	/**
	 * Restituisce un Comando
	 */
	public Comando getComando()
	{
		return com;
	}
	/**
	 * Resetta il comando
	 */
	public void resetComando()
	{
		com=null;
	}
	
	FinestraPunteggio FP = new FinestraPunteggio(); // CREAZIONE FINESTRA PUTNEGGIO
	Container principale = this.getContentPane();   //CREAZIONE DEL CONTAINER DOVE VIENE INSERITO TUTTO
	
	
	/**Scrive un messaggio in chat
	 */ 
	public static void scriviChat(String messaggio)
	{
		Chat.append(" "+messaggio+"\n");
	}
	/**Scrive un messaggio nella console delle statistiche
	 */ 
	public static void scriviStatistica(String messaggio)
	{
		Statistiche.append(" "+messaggio+"\n");
	}
	/**Se settato a true disabilita il fold, settato a false lo riabilita
	 */ 
	public void disableFold(boolean flag)
	{
		Fold.setEnabled(!flag);
	}
	/**Se settato a true disabilita il Raise, settato a false lo riabilita
	 */ 
	public void disableRaise(boolean flag)
	{
		Raise.setEnabled(!flag);
	}
	/**
	 * Chiamato con true disabilita tutti i bottoni,con false li riabilita.
	 */
	public void disableBottoni(boolean flag)
	{
		Fold.setEnabled(!flag);
		Raise.setEnabled(!flag);
		Call.setEnabled(!flag);
		AllIn.setEnabled(!flag);
	}

	// CREAZIONE BOTTONI
	static JButton Fold = new JButton("Fold");
	static JButton Call = new JButton("Call");
	static JButton Raise = new JButton("Raise");
	static JButton AllIn = new JButton("All-In");
	static JButton Invia = new JButton("Invia");
	       JButton SegnaPunti = new JButton("Punti");
	static JButton VisChat=new JButton("Chat");
	static JButton VisStat=new JButton("Stats");

	// GIOCATORE 1
	JLabel etiUtente1 = new JLabel();
	JLabel nome1 = new JLabel("Giocatore 1");
	JLabel fiches1 = new JLabel("10000");
	JLabel Gioc1Car1 = new JLabel();
	JLabel Gioc1Car2 = new JLabel();

	// GIOCATORE 2
	JLabel etiUtente2 = new JLabel();
	JLabel nome2 = new JLabel("Giocatore 2");
	JLabel fiches2 = new JLabel("10000");
	JLabel Gioc2Car1 = new JLabel();
	JLabel Gioc2Car2 = new JLabel();

	// GIOCATORE 3

	JLabel etiUtente3 = new JLabel();
	JLabel nome3 = new JLabel("Giocatore 3");
	JLabel fiches3 = new JLabel("10000");
	JLabel Gioc3Car1 = new JLabel();
	JLabel Gioc3Car2 = new JLabel();

	// GIOCATORE 4

	JLabel etiUtente4 = new JLabel();
	JLabel nome4 = new JLabel("Giocatore 4");
	JLabel fiches4 = new JLabel("10000");
	JLabel Gioc4Car1 = new JLabel();
	JLabel Gioc4Car2 = new JLabel();

	// GIOCATORE 5

	JLabel etiUtente5 = new JLabel();
	JLabel nome5 = new JLabel("Giocatore 5");
	JLabel fiches5 = new JLabel("10000");
	JLabel Gioc5Car1 = new JLabel();
	JLabel Gioc5Car2 = new JLabel();

	// GIOCATORE 6

	JLabel etiUtente6 = new JLabel();
	JLabel nome6 = new JLabel("Giocatore 6");
	JLabel fiches6 = new JLabel("10000");
	JLabel Gioc6Car1 = new JLabel();
	JLabel Gioc6Car2 = new JLabel();

	// GIOCATORE 7

	JLabel etiUtente7 = new JLabel();
	JLabel nome7 = new JLabel("Giocatore 7");
	JLabel fiches7 = new JLabel("10000");
	JLabel Gioc7Car1 = new JLabel();
	JLabel Gioc7Car2 = new JLabel();

	// GIOCATORE 8
	JLabel etiUtente8 = new JLabel();
	JLabel nome8 = new JLabel("Giocatore 8");
	JLabel fiches8 = new JLabel("10000");
	JLabel Gioc8Car1 = new JLabel();
	JLabel Gioc8Car2 = new JLabel();

	// CREAZIONE CARTE SUL TAVOLO
	JLabel mazzo = new JLabel();
	JLabel cartaT1 = new JLabel();
	JLabel cartaT2 = new JLabel();
	JLabel cartaT3 = new JLabel(); // carte sul tavolo scoperte
	JLabel cartaT4 = new JLabel();
	JLabel cartaT5 = new JLabel();

	//BARRA DEL RAISE
	JScrollBar  BarRaise=new JScrollBar();
	JScrollPane ScrollRaise=new JScrollPane(BarRaise);
	JTextField ConsRaise=new JTextField();

	// CREAZIONE CHAT E STATISTICHE
	static JTextArea Chat = new JTextArea();
	JTextField ConsChat = new JTextField();
	static JTextArea Statistiche = new JTextArea();
	JScrollPane ScrollChat = new JScrollPane(Chat);
	JScrollPane ScrollStat = new JScrollPane(Statistiche);
	
	Listener list = new Listener(Chat, ConsChat,Statistiche,ScrollChat,ScrollStat,ScrollRaise,BarRaise,ConsRaise); // LISTENER

	JLabel sfondo = new JLabel(Icone.sfondo);
	

	// FONT
	Font fontnome = new Font("Comic Sans MS", Font.BOLD, 13);
	Font fontfiches = new Font("Comic Sans MS", Font.PLAIN, 10);
	Font font = new Font("Comic Sans MS", Font.ROMAN_BASELINE, 12);

	public GraficaPoker() {

		// DIMENSIONE E OPZIONI FINESTRA (completo)
		super("Real Poker");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // DA ELIMINARE
		this.setResizable(false);
		this.setBounds(115, 15, 1024, 700);
		this.setSize(1224, 700);
		this.setSize(1224, 701);
		this.setIconImage(Icone.logo.getImage().getScaledInstance(350, 300,Image.SCALE_SMOOTH));

		// SETTA IL LOGO DELLA FINESTRA PUNTEGGI
		FP.setIconImage(Icone.logo.getImage().getScaledInstance(350, 300,Image.SCALE_SMOOTH));

		// BOTTONI (FOLD,RAISE,CALL,ALL-IN,INVIA,CHAT,STATS)
		Fold.setIcon(Icone.Foldnot);
		Fold.setPressedIcon(Icone.Foldpre);
		Fold.setBounds(350, 600, 90, 30);
		Fold.setBorder(null);
		Call.setIcon(Icone.Callnot);
		Call.setPressedIcon(Icone.Callpre);
		Call.setBounds(445, 600, 90, 30);
		Call.setBorder(null);
		Raise.setIcon(Icone.Raisenot);
		Raise.setPressedIcon(Icone.Raisepre);
		Raise.setBounds(540, 600, 90, 30);
		Raise.setBorder(null);
		AllIn.setIcon(Icone.Allnot);
		AllIn.setPressedIcon(Icone.Allpre);
		AllIn.setBounds(635, 600, 90, 30);
		AllIn.setBorder(null);
		SegnaPunti.setIcon(Icone.Puntinot);
		SegnaPunti.setPressedIcon(Icone.Puntipre);
		SegnaPunti.setBounds(0, 645, 90, 30);
		SegnaPunti.setBorder(null);
		VisChat.setIcon(Icone.VisualizzaChat);
		VisChat.setBounds(1017, 512, 90, 30);
		VisChat.setBorder(null);
		VisStat.setIcon(Icone.StatSelected);
		VisStat.setBounds(927,512,90,30);
		VisStat.setBorder(null);

		// LE 5 CARTE SUL TAVOLO + MAZZO (completo ma devono essere modificabili)

		cartaT1.setBounds(320, 240, 100, 100); 
		cartaT2.setBounds(395, 240, 100, 100);
		cartaT3.setBounds(470, 240, 100,100); 
		cartaT4.setBounds(545, 240, 100, 100); 
		cartaT5.setBounds(620, 240, 100,100); 
		
		cartaT1.setIcon(Icone.zero);  //TODO da eliminare queste icone
		cartaT2.setIcon(Icone.tredici);
		cartaT3.setIcon(Icone.ventisei);  
		cartaT4.setIcon(Icone.trentanove);
		cartaT5.setIcon(Icone.uno);

		mazzo.setIcon(Icone.Mazzo);
		mazzo.setBounds(730, 230, 100, 120);

		// GIOCATORE 1 (CARTE SUL TAVOLO,ETICHETTA,NOME,FICHES)

		etiUtente1.setIcon(Icone.Etichetta);
		etiUtente1.setBounds(400, 520, 290, 55);
		nome1.setFont(fontnome);
		nome1.setBounds(565, 509, 100, 60); // +14,-10
		nome1.setForeground(Color.BLUE);
		fiches1.setFont(fontfiches); // rispetto a Utente1
		fiches1.setBounds(585, 526, 100, 60); // +35,+10
		fiches1.setForeground(Color.BLACK); 
		Gioc1Car1.setIcon(Icone.trenta);
		Gioc1Car1.setBounds(510, 420, 100, 100);
		Gioc1Car2.setIcon(Icone.quaranta);
		Gioc1Car2.setBounds(582, 420, 100, 100);
		GiocatoreGrafico Giocatore1 = new GiocatoreGrafico(etiUtente1, nome1,fiches1, Gioc1Car1, Gioc1Car2);
		Giocatori[0]=Giocatore1;
		
		// GIOCATORE 2 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente2.setIcon(Icone.Etichetta);
		etiUtente2.setBounds(400, 60, 290, 55);
		nome2.setFont(fontnome);
		nome2.setBounds(565, 49, 100, 60);
		nome2.setForeground(Color.BLUE);
		fiches2.setFont(fontfiches);
		fiches2.setBounds(585, 66, 100, 60);
		fiches2.setForeground(Color.BLACK);
		Gioc2Car1.setIcon(Icone.copertamezza);
		Gioc2Car1.setBounds(512, 5, 100, 100);
		Gioc2Car2.setIcon(Icone.copertamezza);
		Gioc2Car2.setBounds(582, 5, 100, 100);
		GiocatoreGrafico Giocatore2=new GiocatoreGrafico(etiUtente2,nome2,fiches2,Gioc2Car1,Gioc2Car2);
		Giocatori[1]=Giocatore2;
		
		// GIOCATORE 3 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente3.setIcon(Icone.Etichetta);
		etiUtente3.setBounds(75, 115, 290, 55);
		nome3.setFont(fontnome);
		nome3.setBounds(240, 104, 100, 60);
		nome3.setForeground(Color.BLUE);
		fiches3.setFont(fontfiches);
		fiches3.setBounds(260, 121, 100, 60);
		fiches3.setForeground(Color.BLACK);
		Gioc3Car1.setIcon(Icone.copertamezza);
		Gioc3Car1.setBounds(190, 60, 100, 100);
		Gioc3Car2.setIcon(Icone.copertamezza);
		Gioc3Car2.setBounds(260, 60, 100, 100);
		GiocatoreGrafico Giocatore3=new GiocatoreGrafico(etiUtente3,nome3,fiches3,Gioc3Car1,Gioc3Car2);
		Giocatori[2]=Giocatore3;
		
		// GIOCATORE 4 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente4.setIcon(Icone.Etichetta);
		etiUtente4.setBounds(730, 115, 290, 55);
		nome4.setFont(fontnome);
		nome4.setBounds(895, 104, 100, 60);
		nome4.setForeground(Color.BLUE);
		fiches4.setFont(fontfiches);
		fiches4.setBounds(915, 121, 100, 60);
		fiches4.setForeground(Color.BLACK);
		Gioc4Car1.setIcon(Icone.copertamezza);
		Gioc4Car1.setBounds(842, 60, 100, 100);
		Gioc4Car2.setIcon(Icone.copertamezza);
		Gioc4Car2.setBounds(912, 60, 100, 100);
		GiocatoreGrafico Giocatore4=new GiocatoreGrafico(etiUtente4,nome4,fiches4,Gioc4Car1,Gioc4Car2);
		Giocatori[3]=Giocatore4;

		// GIOCATORE 5 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente5.setIcon(Icone.Etichetta);
		etiUtente5.setBounds(75, 460, 290, 55);
		nome5.setFont(fontnome);
		nome5.setBounds(240, 449, 100, 60);
		nome5.setForeground(Color.BLUE);
		fiches5.setFont(fontfiches);
		fiches5.setBounds(260, 466, 100, 60);
		fiches5.setForeground(Color.BLACK);
		Gioc5Car1.setIcon(Icone.copertamezza);
		Gioc5Car1.setBounds(190, 405, 100, 100);
		Gioc5Car2.setIcon(Icone.copertamezza);
		Gioc5Car2.setBounds(260, 405, 100, 100);
		GiocatoreGrafico Giocatore5=new GiocatoreGrafico(etiUtente5,nome5,fiches5,Gioc5Car1,Gioc5Car2);
		Giocatori[4]=Giocatore5;

		// GIOCATORE 6 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente6.setIcon(Icone.Etichetta);
		etiUtente6.setBounds(730, 460, 290, 55);
		nome6.setFont(fontnome);
		nome6.setBounds(895, 449, 100, 60);
		nome6.setForeground(Color.BLUE);
		fiches6.setFont(fontfiches);
		fiches6.setBounds(915, 466, 100, 60);
		fiches6.setForeground(Color.BLACK);
		Gioc6Car1.setIcon(Icone.copertamezza);
		Gioc6Car1.setBounds(842, 405, 100, 100);
		Gioc6Car2.setIcon(Icone.copertamezza);
		Gioc6Car2.setBounds(912, 405, 100, 100);
		GiocatoreGrafico Giocatore6=new GiocatoreGrafico(etiUtente6,nome6,fiches6,Gioc6Car1,Gioc6Car2);
		Giocatori[5]=Giocatore6;

		// GIOCATORE 7 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente7.setIcon(Icone.Etichetta);
		etiUtente7.setBounds(-44, 287, 290, 55);  
		nome7.setFont(fontnome);
		nome7.setBounds(121, 276, 100, 60);
		nome7.setForeground(Color.BLUE);
		fiches7.setFont(fontfiches);
		fiches7.setBounds(141, 293, 100, 60);
		fiches7.setForeground(Color.BLACK);
		Gioc7Car1.setIcon(Icone.copertamezza);
		Gioc7Car1.setBounds(70, 232, 100, 100);
		Gioc7Car2.setIcon(Icone.copertamezza);
		Gioc7Car2.setBounds(140, 232, 100, 100);
		GiocatoreGrafico Giocatore7=new GiocatoreGrafico(etiUtente7,nome7,fiches7,Gioc7Car1,Gioc7Car2);
		Giocatori[6]=Giocatore7;

		// GIOCATORE 8 (ICONA CARTE,ETICHETTA,NOME,FICHES)
		etiUtente8.setIcon(Icone.Etichetta);
		etiUtente8.setBounds(845, 287, 290, 55);
		nome8.setFont(fontnome);               
		nome8.setBounds(1010, 276, 100, 60);
		nome8.setForeground(Color.BLUE);
		fiches8.setFont(fontfiches);
		fiches8.setBounds(1030, 293, 100, 60);
		fiches8.setForeground(Color.BLACK);
		Gioc8Car1.setIcon(Icone.copertamezza);
		Gioc8Car1.setBounds(960, 232, 100, 100);
		Gioc8Car2.setIcon(Icone.copertamezza);
		Gioc8Car2.setBounds(1030, 232, 100, 100);
		GiocatoreGrafico Giocatore8=new GiocatoreGrafico(etiUtente8,nome8,fiches8,Gioc8Car1,Gioc8Car2);
		Giocatori[7]=Giocatore8;

		// LISTENER
		SegnaPunti.addMouseListener(FP); // Apre la finestra dei Punteggi
		Invia.addActionListener(list); // Listener del bottone Invia (Chat)
		ConsChat.addKeyListener(list); // Listener della console della Chat
		Fold.addActionListener(list);
		Raise.addActionListener(list);
		Call.addActionListener(list);
		AllIn.addActionListener(list);
		VisChat.addActionListener(list);
		VisStat.addActionListener(list);
		
		BarRaise.addMouseListener(list);
		ScrollRaise.addMouseListener(list);


		
		
		//SCROLL DEL RAISE
		BarRaise.setOrientation(0); //MESSO IN ORIZZONTALE
		BarRaise.setMaximum(110);  //SETTA IL MASSIMO
		ScrollRaise.setBorder(null);
		ScrollRaise.setBounds(450,640,150,20);
		ConsRaise.setBounds(602,640,55,20);
		
		
		// CHAT
		ScrollChat.setBounds(927, 542, 290, 100);
		ScrollChat.setWheelScrollingEnabled(true);
		ScrollStat.setBounds(927,542,290,100);
		ScrollStat.setWheelScrollingEnabled(true);	
		
		Statistiche.setEditable(false);
		Statistiche.setForeground(Color.GREEN.darker());
		Statistiche.setFont(font);
		Chat.setEditable(false);
		Chat.setForeground(Color.BLUE);
		Chat.setFont(font);
		
		//Per far apparire prima la console all' avvio
		Chat.setVisible(false);
		ConsChat.setVisible(false);
		Invia.setVisible(false);
		
		ConsChat.setFont(font);
		ConsChat.setBounds(927, 643, 200, 30);
		ConsChat.setForeground(Color.BLACK);
		Invia.setIcon(Icone.Sendnot);
		Invia.setPressedIcon(Icone.Sendpre);
		Invia.setBounds(1128, 643, 90, 30);
		Invia.setBorder(null);


		// INSERIMENTO NELLA FINESTRA

		principale.add(ScrollChat);
		principale.add(ScrollStat);
		principale.add(ConsChat);

		principale.add(ScrollRaise);
		principale.add(ConsRaise);
		
		principale.add(Fold);
		principale.add(Call);
		principale.add(Raise);
		principale.add(AllIn);
		principale.add(Invia);
		principale.add(SegnaPunti);
		principale.add(VisStat);
		principale.add(VisChat);

		principale.add(mazzo);

		principale.add(cartaT1);
		principale.add(cartaT2);
		principale.add(cartaT3);
		principale.add(cartaT4);
		principale.add(cartaT5);

		principale.add(nome1);
		principale.add(fiches1);
		principale.add(etiUtente1);// sfondo per ultimo
		principale.add(Gioc1Car1);
		principale.add(Gioc1Car2);
		

		principale.add(nome2);
		principale.add(fiches2);
		principale.add(etiUtente2);
		principale.add(Gioc2Car1);
		principale.add(Gioc2Car2);
		
		principale.add(nome3);
		principale.add(fiches3);
		principale.add(etiUtente3);
		principale.add(Gioc3Car1);
		principale.add(Gioc3Car2);
		
		principale.add(nome4);
		principale.add(fiches4);
		principale.add(etiUtente4);
		principale.add(Gioc4Car1);
		principale.add(Gioc4Car2);
		
		principale.add(nome5);
		principale.add(fiches5);
		principale.add(etiUtente5);
		principale.add(Gioc5Car1);
		principale.add(Gioc5Car2);
		
		principale.add(nome6);
		principale.add(fiches6);
		principale.add(etiUtente6);
		principale.add(Gioc6Car1);
		principale.add(Gioc6Car2);
		
		principale.add(nome7);
		principale.add(fiches7);
		principale.add(etiUtente7);
		principale.add(Gioc7Car1);
		principale.add(Gioc7Car2);
		
		principale.add(nome8);
		principale.add(fiches8);
		principale.add(etiUtente8);
		principale.add(Gioc8Car1);
		principale.add(Gioc8Car2);
		
		principale.add(sfondo);

		// sfondo va inserito per ultimo

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GraficaPoker();
	}// main

}// GraficaPoker