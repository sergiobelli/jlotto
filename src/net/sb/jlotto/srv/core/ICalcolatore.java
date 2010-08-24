package net.sb.jlotto.srv.core;

import net.sb.jlotto.srv.core.model.CarattereValore;

public interface ICalcolatore {

	String ERR_CARATTERE_NON_VALIDO = "Lettera/carattere specificato non presente";
	
	Integer calcola(String lettere);
	
	CarattereValore[] valori = {
                new CarattereValore(" ", 0),//LETTERA	 	=	0
		new CarattereValore("A", 1),//LETTERA	A	=	1
		new CarattereValore("B", 2),//LETTERA	B	=	2
		new CarattereValore("C", 3),//LETTERA	C	=	3
		new CarattereValore("D", 4),//LETTERA	D	=	4
		new CarattereValore("E", 5),//LETTERA	E	=	5
		new CarattereValore("F", 6),//LETTERA	F	=	6
		new CarattereValore("G", 7),//LETTERA	G	=	7
		new CarattereValore("H", 8),//LETTERA	H	=	8
		new CarattereValore("I", 9),//LETTERA	I	=	9
		new CarattereValore("J", 10),//LETTERA	J	=	10
		new CarattereValore("K", 20),//LETTERA	K	=	20
		new CarattereValore("L", 30),//LETTERA	L	=	30
		new CarattereValore("M", 40),//LETTERA	M	=	40
		new CarattereValore("N", 50),//LETTERA	N	=	50
		new CarattereValore("O", 60),//LETTERA	O	=	60
		new CarattereValore("P", 70),//LETTERA	P	=	70
		new CarattereValore("Q", 80),//LETTERA	Q	=	80
		new CarattereValore("R", 90),//LETTERA	R	=	90
		new CarattereValore("S", 100),//LETTERA	S	=	100
		new CarattereValore("T", 200),//LETTERA	T	=	200
		new CarattereValore("U", 300),//LETTERA	U	=	300
		new CarattereValore("V", 400),//LETTERA	V	=	400
		new CarattereValore("W", 500),//LETTERA	w	=	500
		new CarattereValore("X", 600),//LETTERA	X	=	600
		new CarattereValore("Y", 700),//LETTERA	Y	=	700
		new CarattereValore("Z", 800),//LETTERA	Z	=	800
		new CarattereValore("?", 99),//PUNTO	?	=	99
		new CarattereValore("!", 11),//PUNTO	!	=	11
            };

        //		ESEMPIO:S	E	R	G	I	O
//				100	5	90	7	9	60	=	SOMMA  	271
//				B	E	L	L	I
//				2	5	30	30	9		=	SOMMA	76

	
}