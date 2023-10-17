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
  (14,'\"O amor é assim, imprevisto, louco, engraçado, sem limites, as vezes você ri e as vezes você chora, é disso que se trata, não existe o relacionamento perfeito só existem pessoas que apesar das circunstâncias lutam para construir uma vida ao lado da pessoa que amam.\" '),
  (15,'\"O melhor na vida é encontrar alguém que\n conheça todos os seus defeitos, erros e\n fraquezas, e ainda pense que você é\n completamente incrível\".'),
  (9,'Eu já amava a sua risada, mas quando a sua misturou com a minha, pude perceber ali que era o som que eu queria ouvir pro resto da minha vida.'),
  (13,'Haverá um dia em que Deus vai lhe apresentar uma pessoa, e depois de conversar com ela você vai chorar e dizer baixinho: \"Meu Deus foi exatamente o que eu pedi em oração\"'),
  (11,'Juro de dedinho te dar todos os dias motivos para me amar, e que cada afeto que me dar te devolverei em dobro'),
  (10,'Quando o vi, entendi que quando alguém te ama de verdade, não importa onde você esteja porque para essa pessoa você sempre estará em seu coração');

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
  (9,'\nCasamento Eh Como Uma Construçao , Sem Confiança , Não Vaii Pra Frente , Ele Desaba ??????\n\nSuellen Ferrari ??\n'),
  (13,'\"Eu sei que virão dias tensos, problemas difíceis, e maus tempos, mas peço a Deus que nos ajude a superar tudo isso, e que nos mantenha sempre unidos em qualquer situação.\" ????\n'),
  (11,'Casamento Eh Amar Eh Ser Amado ! Primeiramente Ter Respeito Um Pelo Outro , Sabendo Oh Limite Do Seu Parceiro , Ameh Muito , Mais Primeiro Tenha Amor Proprio .. ????????'),
  (10,'Casamento Eh Assim Ainda Que Falassemos Ah Linqua Dos Anjos , Sem Amor Nada Seriamos , Pois Oh Amor Td Cre , Td Sofre Eh Td Suporta ????????\n'),
  (14,'Em vez de jogar o casamento fora, por que não jogar fora o que está estragando o casamento? '),
  (12,'O verdadeiro homem não é aquele que conquista várias mulheres e sim aquele que conquista várias vezes a mesma mulher ');

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

