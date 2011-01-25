-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: 27 nov, 2010 at 12:19 
-- Versione MySQL: 5.1.41
-- Versione PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jlotto`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `configurazione`
--

CREATE TABLE IF NOT EXISTS `configurazione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice` varchar(100) NOT NULL,
  `valore` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dump dei dati per la tabella `configurazione`
--


-- --------------------------------------------------------

--
-- Struttura della tabella `estrazioni`
--

CREATE TABLE IF NOT EXISTS `estrazioni` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `ruota` int(11) NOT NULL,
  `estrazione_1` int(11) NOT NULL,
  `estrazione_2` int(11) NOT NULL,
  `estrazione_3` int(11) NOT NULL,
  `estrazione_4` int(11) NOT NULL,
  `estrazione_5` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='latin1_swedish_ci' AUTO_INCREMENT=1 ;

--
-- Dump dei dati per la tabella `estrazioni`
--


-- --------------------------------------------------------

--
-- Struttura della tabella `ruote`
--

CREATE TABLE IF NOT EXISTS `ruote` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODICE` varchar(5) NOT NULL,
  `DESCRIZIONE` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dump dei dati per la tabella `ruote`
--

INSERT INTO `ruote` (`ID`, `CODICE`, `DESCRIZIONE`) VALUES
(7, 'FI', 'Firenze'),
(6, 'CA', 'Cagliari'),
(5, 'BA', 'Bari'),
(8, 'GE', 'Genova'),
(9, 'MI', 'Milano'),
(10, 'NA', 'Napoli'),
(11, 'PA', 'Palermo'),
(12, 'ROMA', 'Roma'),
(13, 'TO', 'Torino'),
(14, 'VE', 'Venezia'),
(15, 'NAZ', 'Nazionale');