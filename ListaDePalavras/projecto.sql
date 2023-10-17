# SQL Manager 2005 for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : projecto


SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `projecto`;

CREATE DATABASE `projecto`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `projecto`;

#
# Structure for the `amor` table : 
#

DROP TABLE IF EXISTS `amor`;

CREATE TABLE `amor` (
  `id_amor` int(11) NOT NULL AUTO_INCREMENT,
  `pal_amor` varchar(500) NOT NULL,
  PRIMARY KEY (`id_amor`),
  UNIQUE KEY `pal_amor` (`pal_amor`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

#
# Data for the `amor` table  (LIMIT 0,500)
#

INSERT INTO `amor` (`id_amor`, `pal_amor`) VALUES 
  (14,'\"O amor � assim, imprevisto, louco, engra�ado, sem limites, as vezes voc� ri e as vezes voc� chora, � disso que se trata, n�o existe o relacionamento perfeito s� existem pessoas que apesar das circunst�ncias lutam para construir uma vida ao lado da pessoa que amam.\" '),
  (15,'\"O melhor na vida � encontrar algu�m que\n conhe�a todos os seus defeitos, erros e\n fraquezas, e ainda pense que voc� �\n completamente incr�vel\".'),
  (9,'Eu j� amava a sua risada, mas quando a sua misturou com a minha, pude perceber ali que era o som que eu queria ouvir pro resto da minha vida.'),
  (13,'Haver� um dia em que Deus vai lhe apresentar uma pessoa, e depois de conversar com ela voc� vai chorar e dizer baixinho: \"Meu Deus foi exatamente o que eu pedi em ora��o\"'),
  (11,'Juro de dedinho te dar todos os dias motivos para me amar, e que cada afeto que me dar te devolverei em dobro'),
  (10,'Quando o vi, entendi que quando algu�m te ama de verdade, n�o importa onde voc� esteja porque para essa pessoa voc� sempre estar� em seu cora��o');

COMMIT;

#
# Structure for the `casamento` table : 
#

DROP TABLE IF EXISTS `casamento`;

CREATE TABLE `casamento` (
  `id_casa` int(11) NOT NULL AUTO_INCREMENT,
  `pal_cas` varchar(500) NOT NULL,
  PRIMARY KEY (`id_casa`),
  UNIQUE KEY `pal_cas` (`pal_cas`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

#
# Data for the `casamento` table  (LIMIT 0,500)
#

INSERT INTO `casamento` (`id_casa`, `pal_cas`) VALUES 
  (9,'\nCasamento Eh Como Uma Constru�ao , Sem Confian�a , N�o Vaii Pra Frente , Ele Desaba ??????\n\nSuellen Ferrari ??\n'),
  (13,'\"Eu sei que vir�o dias tensos, problemas dif�ceis, e maus tempos, mas pe�o a Deus que nos ajude a superar tudo isso, e que nos mantenha sempre unidos em qualquer situa��o.\" ????\n'),
  (11,'Casamento Eh Amar Eh Ser Amado ! Primeiramente Ter Respeito Um Pelo Outro , Sabendo Oh Limite Do Seu Parceiro , Ameh Muito , Mais Primeiro Tenha Amor Proprio .. ????????'),
  (10,'Casamento Eh Assim Ainda Que Falassemos Ah Linqua Dos Anjos , Sem Amor Nada Seriamos , Pois Oh Amor Td Cre , Td Sofre Eh Td Suporta ????????\n'),
  (14,'Em vez de jogar o casamento fora, por que n�o jogar fora o que est� estragando o casamento? '),
  (12,'O verdadeiro homem n�o � aquele que conquista v�rias mulheres e sim aquele que conquista v�rias vezes a mesma mulher ');

COMMIT;

#
# Structure for the `utilizadores` table : 
#

DROP TABLE IF EXISTS `utilizadores`;

CREATE TABLE `utilizadores` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(20) NOT NULL,
  `nom_compl` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `idade` int(11) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nom_user` (`nom_user`),
  UNIQUE KEY `senha` (`senha`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for the `utilizadores` table  (LIMIT 0,500)
#

INSERT INTO `utilizadores` (`id_usuario`, `nom_user`, `nom_compl`, `senha`, `idade`, `sexo`) VALUES 
  (1,'pillwey','pillwey softh','0000',20,'maxo'),
  (3,'j','jon','333',23,'Masculino'),
  (4,'gfg','gffdgbvfd','111',433,'Masculino');

COMMIT;

