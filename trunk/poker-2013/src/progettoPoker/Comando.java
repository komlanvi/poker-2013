package progettoPoker;

import java.io.Serializable;

public class Comando implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9198700338386482018L;
	enum Tipo{DAI_CARTA,FOLD,CHECK_CALL,RAISE,NOTIFICA, NICK_NAME};
	Carta c;
	Carta[] car=new Carta[3];
	int fiches;
	int gioc;
	Tipo t;
	Tipo t1;
	String nickName;
	
	public Comando(Tipo nickName, String name){
		this.t = nickName;
		this.nickName = name;
	}
	
	Comando(Tipo t){
		this.t=t;
	}
	Comando(Tipo t,Carta c){
		this.t=t;
		this.c=c;
	}
	Comando(Tipo t,Carta c,int i){
		this.t=t;
		this.c=c;
		this.fiches=i;
	}
	Comando(Tipo t,Carta[] c){
		this.t=t;
		this.car=c;
	}
	Comando(Tipo t,int i){
		this.t=t;
		this.fiches=i;
	}
	Comando(Tipo t, Tipo t1,int g){
		this.t=t;
		this.t1=t1;
		this.gioc=g;
	}
	
	public String getNickName(){
		return nickName;
	}
	public Carta getC() {
		return c;
	}
	public Carta[] getCar() {
		return car;
	}
	public int getFiches() {
		return fiches;
	}
	public Tipo getT() {
		return t;
	}

}
