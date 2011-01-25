/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sb.jlotto.srv.core;

import net.sb.jlotto.srv.core.model.CarattereValore;
import net.sb.jlotto.srv.core.model.Citta;
import net.sb.jlotto.srv.core.model.Ruota;

/**
 *
 * @author sbelli
 */
public interface Constants {

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


    Citta[] citta = {
        new Citta("NAZ"     , "Nazionale"),
        new Citta("BA"      , "Bari"),
        new Citta("CA"      , "Cagliari"),
        new Citta("FI"      , "Firenze"),
        new Citta("GE"      , "Genova"),
        new Citta("MI"      , "Milano"),
        new Citta("NA"      , "Napoli"),
        new Citta("PA"      , "Palermo"),
        new Citta("ROMA"    , "Roma"),
        new Citta("TO"      , "Torino"),
        new Citta("VE"      , "Venezia")
    };

    String SER_FILE_NAME = "estrazione.data";

/*
Nazionale 1 2 3 4 5
Bari 6 7 8 9 10
Cagliari 11 12 13 14 15
Firenze 16 17 18 19 20
Genova 21 22 23 24 25
Milano 26 27 28 29 30
Napoli 31 32 33 34 35
Palermo 36 37 38 39 40
Roma 41 42 43 44 45
Torino 46 47 48 49 50
Venezia 51 52 53 54 55
*/
}
