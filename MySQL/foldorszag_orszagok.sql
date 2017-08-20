-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: foldorszag
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orszagok`
--

DROP TABLE IF EXISTS `orszagok`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orszagok` (
  `orszag` varchar(27) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `fovaros` varchar(19) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `foldr_hely` varchar(37) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `terulet` decimal(11,2) NOT NULL DEFAULT '0.00',
  `allamforma` varchar(30) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `nepesseg` int(8) NOT NULL DEFAULT '0',
  `nep_fovaros` int(8) NOT NULL DEFAULT '0',
  `autojel` char(3) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `country` varchar(31) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `capital` varchar(19) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `penznem` varchar(20) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `penzjel` char(3) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `valtopenz` varchar(18) COLLATE latin2_hungarian_ci NOT NULL DEFAULT '',
  `telefon` int(3) NOT NULL DEFAULT '0',
  `gdp` int(5) NOT NULL DEFAULT '0',
  `kat` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orszag`)
) ENGINE=MyISAM DEFAULT CHARSET=latin2 COLLATE=latin2_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orszagok`
--

LOCK TABLES `orszagok` WRITE;
/*!40000 ALTER TABLE `orszagok` DISABLE KEYS */;
INSERT INTO `orszagok` VALUES 
('SPANYOLORSZÁG','MADRID','Dél-Európa:Ibériai-félsziget',504782.00,'alkotmányos monarchia',42700,5100,'E','SPANYOLORSZAG   ESPANOLA SPAIN','MADRID','euró','EUR','100 eurocent',34,21110,1),
('PORTUGÁLIA','LISSZABON','Dél-Európa:Ibériai-félsziget',92082.00,'köztársaság',10000,2600,'P','PORTUGALIA','LISBOA (LISSZABON)','euró','EUR','100 eurocent',351,14200,1),
('FRANCIAORSZÁG','PÁRIZS','Nyugat-Európa',547026.00,'köztársaság',60100,11300,'F','FRANCIAORSZAG FRANCE FRANCAISE','PARIS (PARIZS)','euró','EUR','100 eurocent',33,27520,1),
('NAGY-BRITANNIA','LONDON','Európa:Britt-szigetek',244046.00,'alkotmányos monarchia',59200,7200,'GB','NAGY-BRITANNIANGLIASKOCIAWALES','LONDON','font','GBP','100 penny',44,29070,1),
('NORVÉGIA','OSLO','Észak-Európa:Skandináv-félsziget',324219.00,'alkotmányos monarchia',4600,800,'N','NORVEGIA                NORWAY','OSLO','norvég korona','NOK','100 öre',47,49090,1),
('SVÉDORSZÁG','STOCKHOLM','Észak-Európa:Skandináv-félsziget',449964.00,'alkotmányos monarchia',8870,1600,'S','SVEDORSZAG              SWEDEN','STOCKHOLM','svéd korona','SEK','100 öre',46,31820,1),
('FINNORSZÁG','HELSINKI','Észak-Európa',338107.00,'köztársaság',5200,1100,'SF','FINNORSZAG             FINLAND','HELSINKI','euró','EUR','100 eurocent',358,30360,1),
('NÉMETORSZÁG','BERLIN','Nyugat-Európa',357042.00,'szövetségi köztársaság',82400,5900,'D','NEMETORSZAG DEUTSCHLANDGERMANY','BERLIN','euró','EUR','100 eurocent',49,28260,1),
('SVÁJC','BERN','Közép-Európa:Alpok',41293.00,'szövetségi köztársaság',7260,100,'CH','SVAJC      SWITZERLAND SCHWEIZ','BERN','svájci frank','CHF','100 rappen',41,42700,1),
('AUSZTRIA','BÉCS','Közép-Európa:Alpok',83858.00,'szövetségi köztársaság',8130,1600,'A','AUSZTRIA    OSTERREICH AUSTRIA','WIEN (BECS)','euró','EUR','100 eurocent',43,30180,1),
('OLASZORSZÁG','RÓMA','Dél-Európa:Appennini-félsziget',301252.00,'köztársaság',57400,3600,'I','OLASZORSZAG       ITALIA ITALY','ROMA','euró','EUR','100 eurocent',39,24390,1),
('MAGYARORSZÁG','BUDAPEST','Közép-Európa:Kárpát-medence',93036.00,'köztársaság',10100,2600,'H','MAGYARORSZAG    HUNGARY UNGARN','BUDAPEST','forint','HUF','100 fillér',36,11200,1),
('SZERBIA','BELGRÁD','Dél-Európa:Balkán-félsziget',88361.00,'szövetségi köztársaság',9400,1700,'SRB','JUGOSZLAVIA SZERBIA YUGOSLAVIA','BEOGRAD (BELGRAD)','dinár','CSD','100 para',381,3200,1),
('BULGÁRIA','SZÓFIA','Dél-Európa:Balkán-félsziget',110912.00,'köztársaság',7900,1140,'BG','BULGARIA','SZOFIJA (SZOFIA)','leva','BGL','100 sztotinka',359,2140,1),
('ROMÁNIA','BUKAREST','Kelet-Európa',237500.00,'köztársaság',22410,2200,'RO','ROMANIA','BUCURESTI  BUKAREST','lei','ROL','100 bani',40,2240,1),
('SZLOVÁKIA','POZSONY','Közép-Európa:Kárpátok',49036.00,'köztársaság',5400,500,'SK','SZLOVAKIA  SLOVAKIA  SLOVENSKO','BRATISLAVA  POZSONY','szlovák korona','SKK','100 heller',421,5810,1),
('CSEHORSZÁG','PRÁGA','Közép-Európa',78864.00,'köztársaság',10300,1300,'CZ','CSEHORSZAG        CSEHSZLOVAKIA','PRAHA (PRAGA)','cseh korona','CZK','100 haler',42,7990,1),
('LENGYELORSZÁG','VARSÓ','Közép-Európa',312677.00,'köztársaság',38600,2200,'PL','LENGYELORSZAG           POLAND','WARSZAWA (VARSO)','zloty','PLZ','100 grosz',48,5370,1),
('OROSZORSZÁG','MOSZKVA','Eurázsia',17075400.00,'szövetségi köztársaság',146000,12000,'RUS','OROSZORSZAG SZOVJETUNIO FAK SZU','MOSZKVA','rubel','RUR','100 kopejka',7,2910,1),
('GÖRÖGORSZÁG','ATHÉN','Dél-Európa:Balkán-félsziget',131944.00,'köztársaság',11000,3300,'GR','GOROGORSZAG GRIECHENLAND GREECE','ATHINE ATHENAI','euró','EUR','100 eurocent',30,15060,1),
('TÖRÖKORSZÁG','ANKARA','Eurázsia',780576.00,'köztársaság',71300,3600,'TR','TOROKORSZAG             TURKEY','ANKARA','lira','TRL','100 kurus',90,3110,1),
('DÁNIA','KOPPENHÁGA','Nyugat-Európa:Jylland',43075.00,'alkotmányos monarchia',5300,1100,'DK','DANIA                  DENMARK','KOPPENHAGA','dán korona','DKK','100 öre',45,38120,1),
('IZLAND','REYKJAVIK','Európa:Atlanti-óceán (szigetország)',102829.00,'köztársaság',277,100,'IS','IZLAND          ISLAND ICELAND','REYKJAVIK','izlandi korona','ISK','100 aurar',354,35780,1),
('ALBÁNIA','TIRANA','Dél-Európa:Balkán-félsziget',28748.00,'köztársaság',3490,400,'AL','ALBANIA','TIRANA','lek','ALL','100 quindarka',355,1690,1),
('BELGIUM','BRÜSSZEL','Nyugat-Európa',30519.00,'alkotmányos monarchia',10300,1700,'B','BELGIUM','BRUXELLES  BRUSSZEL','euró','EUR','100 eurocent',32,28800,1),
('HOLLANDIA','AMSZTERDAM','Nyugat-Európa',41548.00,'alkotmányos monarchia',16100,700,'NL','HOLLANDIANIEDERLANDENETHERLAND','AMSZTERDAM - HAGA','euró','EUR','100 eurocent',31,30800,1),
('LUXEMBURG','LUXEMBOURG','Nyugat-Európa',2586.40,'nagyhercegség',438,90,'L','LUXEMBURG','LUXEMBOURGLUXEMBURG','euro','EUR','100 eurocent',352,52510,1),
('LIECHTENSTEIN','VADUZ','Közép-Európa:Alpok(törpeállam)',160.00,'hercegség',30,5,'FL','LIECHTENSTEIN','VADUZ','svájci frank','CHF','100 rappen',41,41400,1),
('MÁLTA','VALLETTA','Európa:Földközi-tenger (szigetország)',316.00,'köztársaság',392,200,'M','MALTA','VALLETTA','máltai lira','MLT','100 cent',356,9840,1),
('CIPRUS','NICOSIA','Európa:Földközi-tenger (szigetország)',9251.00,'köztársaság',758,200,'CY','CIPRUS                  CYPRUS','NICOSIA','ciprusi font','CYP','100 cent',357,19010,1),
('ÍRORSZÁG','DUBLIN','Európa:Britt-szigetek',70283.00,'köztársaság',3800,1000,'IRL','IRORSZAG               IRELAND','DUBLIN','euró','EUR','100 erocent',353,38430,1),
('EGYIPTOM','KAIRÓ','Észak-Afrika',1001449.00,'elnöki köztársaság',71900,15900,'ET','EGYIPTOM','AL QAHIRAH (KAIRO)','egyiptomi font','EGP','100 piaszter',20,1300,1),
('MAROKKÓ','RABAT','Észak-Afrika:Atlasz',446550.00,'alkotmányos monarchia',30500,1600,'MA','MAROKKO         NYUGAT-SZAHARA','RABAT','marokkói dirham','MAD','100 cent',212,1499,1),
('INDIA','NEW DELHI','Ázsia:Hindusztáni-félsziget',3287590.00,'szövetségi köztársaság',1014000,10000,'IND','INDIA','NEW DELHI','indiai rupia','INR','100 paisa',91,500,1),
('JAPÁN','TOKIÓ','Ázsia:Távol-Kelet',372769.00,'alkotmányos monarchia',127600,31100,'J','JAPAN','TOKYO (TOKIO)','yen','JPY','100 sen',81,33350,1),
('KÍNA','PEKING','Ázsia',9608378.00,'népköztársaság',1311000,15800,'RC','KINA','PEKING','jüan','CNY','100 jiao',86,1090,1),
('KANADA','OTTAWA','Észak-Amerika',9976139.00,'szövetségi állam',31700,1100,'CDN','KANADA                  CANADA','OTTAWA','kanadai dollár','CAD','100 cent',1,25650,1),
('MEXIKÓ','MEXIKÓVÁROS','Közép-Amerika',1972547.00,'szövetségi köztársaság',103400,21200,'MEX','MEXIKO                  MEXICO','MEXIKOVAROS','mexikói peso','MXP','100 centavo',52,5930,1),
('KUBA','HAVANNA','Közép-Amerika (szigetország)',110922.00,'köztársaság',11300,2700,'C','KUBA                      CUBA','LA HABANA (HAVANNA)','kubai peso','CUP','100 centavo',53,1700,1),
('BRAZÍLIA','BRASÍLIA','Dél-Amerika',8511965.00,'szövetségi köztársaság',182100,2100,'BR','BRAZILIA','BRASILIA','cruzeiro real','BRR','100 centavo',55,2470,1),
('ARGENTÍNA','BUENOS AIRES','Dél-Amerika',2776889.00,'köztársaság',38400,2800,'RA','ARGENTINA','BUENOS AIRES','peso','ARP','100 centavo',54,3170,1),
('NEPÁL','KATMANDU','Ázsia:Himalája',140797.00,'alkotmányos monarchia',24700,1200,'NEP','NEPAL','KATMANDU','nepáli rupia','NPR','100 paisa',977,240,2),
('ALGÉRIA','ALGÍR','Észak-Afrika',2381741.00,'köztársaság',31800,3000,'DZ','ALGERIA','ALGER ALGIR','dinár','DZD','100 centime',213,2080,2),
('KENYA','NAIROBI','Kelet-Afrika',582646.00,'elnöki köztársaság',32000,3100,'EAK','KENYA','NAIROBI','kenyai shilling','KSH','100 cent',254,410,1),
('MONACO','MONACO','Európa:Francia-Riviéra (törpeállam)',1.95,'alkotmányos monarchia',30,1,'MC','MONACO','MONACO','euró','EUR','100 eurocent',33,34610,1),
('ANDORRA','ANDORRA LA VELLA','Európa:Pireneusok (törpeállam)',468.00,'autonóm hercegség',70,20,'AND','ANDORRA','ANDORRA LA VELLA','euró','EUR','100 eurocent',376,17140,1),
('IZRAEL','TEL-AVIV','Ázsia:Közel-Kelet',20770.00,'parlamentáris köztársaság',6400,700,'IL','IZRAEL','TEL AVIV-YAFO JAFFA','sékel','ISL','100 új agora',972,15420,1),
('LIBANON','BEJRUT','Ázsia:Közel-Kelet',10400.00,'köztársaság',3600,1200,'RL','LIBANON','BAYRUT (BEJRUT)','libanoni font','LBP','100 piaszter',961,4970,1),
('AUSZTRÁLIA','CANBERRA','Ausztrália',7686420.00,'államszövetség',19700,300,'AUS','AUSZTRALIA           AUSTRALIA','CANBERRA','dollár','AUD','100 cent',61,30060,1),
('TUNÉZIA','TUNISZ','Észak-Afrika',163610.00,'elnöki köztársaság',9800,1600,'TN','TUNEZIA','TUNISZ','tunéziai dinár','TND','1000 milliéme',216,2510,1),
('LÍBIA','TRIPOLI','Észak-Afrika',1759540.00,'iszlám népköztársaság',5500,1300,'LAR','LIBIA','TARABULUS (TRIPOLI)','libiai dinár','LYD','100 darham',218,4127,2),
('ETIÓPIA','ADDISZ-ABEBA','Kelet-Afrika',1130138.00,'köztársaság',70700,2700,'ETH','ETIOPIA','ADDISZ-ABEBA','birr','ETB','100 cent',251,90,2),
('ERITREA','ASZMARA','Kelet-Afrika',121320.00,'köztársaság',3500,900,'ER','ERITREA','ASZMARA','nafka','ETB','100 cent',291,180,3),
('KONGÓ (ZAIRE)','KINSHASA','Közép-Afrika',2345409.00,'elnöki köztársaság',52700,6500,'RDC','KONGO ZAIRE','KINSHASA','zadre','ZRN','100 makuta',243,110,3),
('IRAK','BAGDAD','Ázsia:Közel-Kelet',438466.00,'elnöki köztársaság',25100,5800,'IRQ','IRAK                      IRAQ','BAGHDAD (BAGDAD)','iraki dinár','IQD','1000 fil',964,2100,1),
('IRÁN','TEHERÁN','Ázsia:Közel-Kelet',1648000.00,'iszlám köztársaság',68900,11200,'IR','IRAN','TEHRAN (TEHERAN)','iráni rial','IRR','100 dinár',98,1900,1),
('SZÍRIA','DAMASZKUSZ','Ázsia:Közel-Kelet',185180.00,'elnöki köztársaság',17800,1900,'SYR','SZIRIA                   SYRIA','DIMASHO  DAMASZKUSZ','sziriai font','SYP','100 piaszter',963,1330,2),
('JORDÁNIA','AMMÁN','Ázsia:Közel-Kelet',97740.00,'alkotmányos monarchia',5500,2700,'JOR','JORDANIA','AMMAN','jordániai dinár','JOD','1000 fil',962,1840,2),
('MADAGASZKÁR','ANTANANARIVO','Kelet-Afrika (szigetország)',587041.00,'elnöki köztársaság',17400,1400,'RM','MADAGASZKAR','ANTANANARIVO','madagaszkári frank','MGF','100 centime',261,290,2),
('CHILE','SANTIAGO','Dél-Amerika:Andok',756626.00,'köztársaság',15100,5300,'RCH','CHILE','SANTIAGO','chilei peso','CLP','100 centavo',56,4390,2),
('PERU','LIMA','Dél-Amerika:Andok',1285216.00,'elnöki köztársaság',27100,8100,'PE','PERU','LIMA','sol','PES','100 centavo',51,2150,2),
('ECUADOR','QUITO','Dél-Amerika:Andok',283561.00,'elnöki köztársaság',13700,1800,'EC','ECUADOR','QUITO','sucre','ECS','100 centavo',593,1940,2),
('URUGUAY','MONTEVIDEO','Dél-Amerika',176215.00,'elnöki köztársaság',3400,1700,'U','URUGUAY','MONTEVIDEO','uruguayi peso','UYP','100 centésimo',598,2290,2),
('BOLÍVIA','LA PAZ','Dél-Amerika',1098581.00,'elnöki köztársaság',8400,1200,'BOL','BOLIVIA','LA PAZ','boliviano','BOB','100 centavo',591,980,2),
('PARAGUAY','ASUNCION','Dél-Amerika',406752.00,'elnöki köztársaság',5800,1500,'PY','PARAGUAY','ASUNCION','guarani','PYG','100 centimo',595,1400,2),
('KOLUMBIA','BOGOTÁ','Dél-Amerika',1138914.00,'elnöki köztársaság',44200,6800,'CO','KOLUMBIA              COLUMBIA','BOGOTA','kolumbiai peso','COP','100 centavo',57,1610,2),
('VENEZUELA','CARACAS','Dél-Amerika',912050.00,'köztársaság',25700,3500,'YV','VENEZUELA','CARACAS','bolivar','VEB','100 centimo',58,3120,2),
('GUYANA','GEORGETOWN','Dél-Amerika',214699.00,'köztársaság',810,200,'GUY','GUYANA','GEORGETOWN','guyanai dollár','GYD','100 cent',592,940,3),
('SURINAME','PARAMARIBO','Dél-Amerika',163265.00,'köztársaság',430,200,'SME','SURINAME','PARAMARIBO','surinamei gulden','SRG','100 cent',597,2250,3),
('VATIKÁN','VATIKÁN','Európa (városállam Rómánál)',0.44,'teokratikus abszolút monarchia',1,1,'V','VATIKAN','VATIKAN','euró','EUR','100 eurocent',379,0,1),
('PAKISZTÁN','ISLAMABAD','Közép-Ázsia',803943.00,'köztársaság',153300,800,'PAK','PAKISZTAN','ISLAMABAD','pakisztáni rupia','PKR','100 paisa',92,500,2),
('AFGANISZTÁN','KABUL','Közép-Ázsia',652225.00,'köztársaság',25814,2200,'AFG','AFGANISZTAN','KABUL','afgani','AFA','100 puli',93,700,2),
('BANGLADES','DHAKA','Ázsia:Hindusztáni-alföld',147570.00,'köztársaság',146700,10400,'BD','BANGLADES','DHAKA DACCA','taka','BDT','100 paisa',880,370,2),
('BHUTÁN','THIMBU','Ázsia:Himalája',47000.00,'alkotmányos monarchia',1500,60,'BTN','BHUTAN','THIMBU','ngultrum','INR','100 chetrum',975,1060,3),
('MIANMAR (BURMA)','RANGOON','Ázsia:Indokinai-félsziget',678528.00,'szocialista köztársaság',49500,5500,'MYA','BURMA                  MIANMAR','RANGOON      RANGUN','kyat','BUK','100 pya',95,590,3),
('THAIFÖLD','BANGKOK','Ázsia:Indokinai-félsziget',513115.00,'alkotmányos monarchia',63900,8800,'T','THAIFOLD              THAILAND','KRUNG THEP  BANGKOK','baht','THB','100 satang',66,2060,2),
('KAMBODZSA','PHNOM PENH','Ázsia:Indokinai-félsziget',181035.00,'köztársaság',14100,1200,'K','KAMBODZSA','PHNOM PENH','riel','KHR','100 sen',855,280,2),
('VIETNAM','HANOI','Ázsia:Indokinai-félsziget',329556.00,'szocialista köztársaság',81400,2600,'VN','VIETNAM','HA NOI (HANOI)','dong','VND','10 hao',84,460,2),
('LAOSZ','VIANGCHAN','Ázsia:Indokinai-félsziget',236800.00,'népköztársaság',5600,300,'LAO','LAOSZ','VIANGCHAN','kip','LAK','100 at',856,340,3),
('MALAJZIA','KUALA LUMPUR','Dél-Kelet-Ázsia',329749.00,'alkotmányos monarchia',24400,3700,'MAL','MALAYSIA MALAJZIA','KUALA LUMPUR','ringgit','MYR','100 cent',60,4090,2),
('INDONÉZIA','JAKARTA','Ázsia:Indonéz-szigetek',1919443.00,'köztársaság',224784,17900,'RI','INDONEZIA','JAKARTA','indonéz rupia','IDR','100 sen',62,970,2),
('BOTSWANA','GABORONE','Dél-Afrika:Kalahári-medence',600372.00,'elnöki köztársaság',1800,1500,'RB','BOTSWANA','GABORONE','pula','BWP','100 thebe',267,3900,2),
('LESOTHO','MASERU','Dél-Afrika',30355.00,'alkotmányos monarchia',1800,400,'LS','LESOTHO','MASERU','loti','LSL','100 lisente',266,380,2),
('ZIMBABWE','HARARE','Dél-Afrika',390622.00,'köztársaság',12900,2300,'ZW','ZIMBABWE','HARARE','zimbabwei dollár','ZWD','100 cent',263,910,3),
('ZAMBIA','LUSAKA','Dél-Afrika',752614.00,'elnöki köztársaság',10800,1800,'Z','ZAMBIA','LUSAKA','kwacha','ZMK','100 nrwee',260,320,3),
('NAMÍBIA','WINDHOEK','Dél-Afrika',823168.00,'köztársaság',1770,200,'NAM','NAMIBIA','WINDHOEK','dél-afrikai rand','ZAR','100 cent',264,1560,2),
('MOZAMBIK','MAPUTO','Dél-Kelet-Afrika',799380.00,'népköztársaság',18800,1600,'MOC','MOZAMBIK','MAPUTO','metical','MZM','100 centavo',258,230,3),
('MALAWI','LILONGWE','Dél-Kelet-Afrika',118484.00,'elnöki köztársaság',12100,500,'MW','MALAWI','LILONGWE','kwacha','MWK','100 tambala',265,180,3),
('ANGOLA','LUANDA','Dél-Afrika',1246700.00,'köztársaság',13600,2700,'ANG','ANGOLA','LUANDA','kwanza','NKZ','100 iwei',244,940,3),
('TANZÁNIA','DAR ES SALAAM','Kelet-Afrika',945087.00,'szövetségi köztársaság',37200,1500,'EAT','TANZANIA','DAR ES SALAAM','tanzániai shilling','TZS','100 cent',255,280,2),
('MONGÓLIA','ULÁNBÁTOR','Közép-Ázsia',1565000.00,'népköztársaság',2650,800,'MNG','MONGOLIA','ULANBATOR','tugrik','MNT','100 mongo',976,480,1),
('BELIZE','BELMOPAN','Közép-Amerika',22965.00,'alkotmányos monarchia',205,10,'BH','BELIZE','BELMOPAN','belizei dollár','BZD','100 cent',501,3410,3),
('HONDURAS','TEGUCIGALPA','Közép-Amerika',112088.00,'elnöki köztársaság',6800,1400,'HN','HONDURAS','TEGUCIGALPA','lempira','HNL','100 centavo',504,1010,3),
('SALVADOR','SAN SALVADOR','Közép-Amerika',21041.00,'elnöki köztársaság',6200,1800,'ES','SALVADOR','SAN SALVADOR','salvadori colon','SVC','100 cent',503,2340,2),
('NICARAGUA','MANAGUA','Közép-Amerika',130000.00,'elnöki köztársaság',4900,1400,'NIC','NICARAGUA','MANAGUA','cordoba','NIO','100 centavo',505,551,2),
('PANAMA','PANAMA','Közép-Amerika',75650.00,'elnöki köztársaság',3100,1100,'PA','PANAMA','PANAMA','balboa','PAB','100 centesimo',507,3710,2),
('GUATEMALA','GUATEMALA','Közép-Amerika',108889.00,'elnöki köztársaság',13900,2700,'GCA','GUATEMALA','GUATEMALA','quetzal','GTQ','100 centavo',502,1420,3),
('BAHAMA-SZIGETEK','NASSAU','Közép-Amerika:Nagy-Antillák',13939.00,'alkotmányos monarchia',266,173,'BS','BAHAMA-SZIGETEK','NASSAU','bahamai dollár','BSD','100 cent',1,18690,2),
('JAMAICA','KINGSTON','Közép-Amerika:Nagy-Antillák',10991.00,'alkotmányos monarchia',2600,900,'JA','JAMAICA','KINGSTON','jamaicai dollár','JMD','100 cent',1,3000,2),
('BENIN','PORTO NOVO','Nyugat-Afrika',112622.00,'elnöki köztársaság',6700,208,'DY','BENIN','PORTO NOVO','CFA-frank','XOF','100 centime',229,450,3),
('CSÁD','N\'DJAMENA','Közép-Afrika',1284000.00,'elnöki köztársaság',8600,600,'TCH','CSAD','N\'DJAMENA','CFA-frank','XAF','100 centime',235,210,3),
('GABON','LIBREVILLE','Közép-Nyugat-Afrika',267667.00,'elnöki köztársaság',1208,700,'GAB','GABON','LIBREVILLE','CFA-frank','XAF','100 centime',241,4190,3),
('GHÁNA','ACCRA','Nyugat-Afrika',238537.00,'köztársaság',20900,2800,'GH','GHANA','ACCRA','cedi','GHC','100 pesewa',233,340,3),
('GUINEA','CONAKRY','Nyugat-Afrika',245857.00,'elnöki köztársaság',8500,1800,'','GUINEA','CONAKRY','syli','GNF','100 cauri',224,360,3),
('KAMERUN','YAOUNDÉ','Közép-Nyugat-Afrika',475442.00,'elnöki köztársaság',16000,1400,'RCF','KAMERUN','YAOUNDE','CFA-frank','XAF','100 centime',237,670,3),
('KONGÓI KÖZTÁRSASÁG','BRAZZAVILLE','Közép-Afrika',342000.00,'köztársaság',3700,1200,'RCB','FRANCIA KONGOI KOZTARSASAG','BRAZZAVILLE','CFA-frank','XAF','100 centime',242,1040,3),
('LIBÉRIA','MONROVIA','Nyugat-Afrika',111369.00,'elnöki köztársaság',3300,1300,'LB','LIBERIA','MONROVIA','libériai dollár','LRD','100 cent',231,170,3),
('MALI','BAMAKO','Észak-Nyugat-Afrika',1240142.00,'elnöki köztársaság',10800,1300,'RMM','MALI','BAMAKO','CFA-frank','XOF','100 centime',223,280,3),
('MAURITÁNIA','NOUAKCHOTT','Észak-Nyugat-Afrika',1030700.00,'elnöki köztársaság',2900,700,'RIM','MAURITANIA','NOUAKCHOTT','ouguiya','MRO','5 khoum',222,370,3),
('NIGER','NIAMEY','Közép-Afrika',1267000.00,'elnöki köztársaság',11900,700,'RN','NIGER','NIAMEY','CFA-frank','XOF','100 centime',227,210,3),
('NIGÉRIA','LAGOS','Közép-Nyugat-Afrika',923768.00,'föderativ köztársaság',126500,600,'WAN','NIGERIA','LAGOS','naira','NGN','100 kobo',234,340,3),
('RUANDA','KIGALI','Közép-Afrika',26338.00,'elnöki köztársaság',8400,300,'RWA','RUANDA','KIGALI','ruandai frank','RWF','100 centime',250,210,3),
('SZENEGÁL','DAKAR','Nyugat-Afrika',196192.00,'köztársaság',10100,2500,'SN','SZENEGAL','DAKAR','CFA-frank','XOF','100 centime',221,590,3),
('SZOMÁLIA','MUQDISHO','Kelet-Afrika',637657.00,'köztársaság',8000,1200,'SP','SZOMALIA','MUQDISHO  MOGADISHU','szomáli shilling','SOS','100 centesimo',252,500,3),
('SZUDÁN','KARTÚM','Észak-Kelet-Afrika',2505813.00,'köztársaság',35000,5700,'SUD','SZUDAN','KARTUM','szudáni dinár','SDD','100 piaszter',249,440,3),
('SZVÁZIFÖLD','MBABANE','Dél-Kelet-Afrika',17364.00,'alkotmányos monarchia',1080,70,'SD','SZVAZIFOLD','MBABANE','lilangeni','SZL','100 cent',268,1490,3),
('TOGO','LOME','Nyugat-Afrika',56785.00,'elnöki köztársaság',4900,700,'TG','TOGO','LOME','CFA-frank','XOF','100 centime',228,290,3),
('UGANDA','KAMPALA','Közép-Kelet-Afrika',236036.00,'elnöki köztársaság',25800,1500,'EAU','UGANDA','KAMPALA','ugandai shilling','UGS','100 cent',256,260,3),
('DÉL-AFRIKAI KÖZTÁRSASÁG','PRETORIA','Dél-Afrika',1221037.00,'szövetségi köztársaság',45100,1600,'ZA','DEL-AFRIKAI KOZTARSASAG','PRETORIA','rand','ZAR','100 cent',27,3180,2),
('BURKINA FASO','OUAGADOUGOU','Nyugat-Afrika',274200.00,'köztársaság',13000,680,'BF','BURKINA FASO     (FELSO-VOLTA)','OUAGADOUGOU','CFA-frank','XOF','100 centime',226,270,3),
('SIERRA LEONE','FREETOWN','Nyugat-Afrika',71740.00,'elnöki köztársaság',5100,1100,'WAL','SIERRA LEONE','FREETOWN','leone','SLL','100 cent',232,170,3),
('ÚJ-ZÉLAND','WELLINGTON','Csendes-óceán (Óceániától délre)',269112.00,'alkotmányos monarchia',3800,300,'NZ','UJ-ZELAND           NEW-ZELAND','WELLINGTON','új-zélandi dollár','NZD','100 cent',64,18080,1),
('SRI LANKA','COLOMBO','Dél-Ázsia:Indiai-óceán (szigetország)',65610.00,'elnöki köztársaság',19200,2400,'CL','SRI LANKA               CEYLON','COLOMBO','rupia','LKR','100 cent',94,880,2),
('SZAUD-ARÁBIA','RIJÁD','Ázsia:Arab-félsziget',2149690.00,'iszlám abszolút monarchia',24200,3700,'KSA','SZAUD-ARABIA','AR RIYAD (RIJAD)','szaudi rial','SAR','100 halalah',966,9550,2),
('AMERIKAI EGYESÜLT ÁLLAMOK','WASHINGTON','Észak-Amerika',9809155.00,'szövetségi köztársaság',291200,600,'USA','AMERIKAI EGYESULT ALLAMOK  USA','WASHINGTON','dollár','USD','100 cent',1,37300,1),
('FÜLÖP-SZIGETEK','MANILA','Ázsia:Távol-Kelet',300000.00,'elnöki köztársaság',80100,13800,'RP','FULOP-SZIGETEK     PHILIPPINES','MANILA','peso','PHP','100 centavo',63,980,2),
('KATAR','DOHA','Ázsia:Arab-félsziget',11437.00,'abszolút monarchia',600,500,'Q','KATAR                    QATAR','AD DAWHAH (DOHA)','katari rial','QAR','100 dirham',974,32460,3),
('OMÁN','MASZKAT','Ázsia:Arab-félsziget',212457.00,'abszolút monarchia',2800,800,'OM','OMAN','MASQAT (MASZKAT)','ománi rial','OMR','100 baiza',968,8590,3),
('FIDZSI-SZIGETEK','SUVA','Óceánia:Melanézia',18272.00,'köztársaság',832,200,'FJI','FIDZSI-SZIGETEK           FIJI','SUVA','fidzsi dollár','FJD','100 cent',679,2090,3),
('SZAMOA','APIA','Óceánia:Polinézia',2842.00,'királyság',179,40,'WS','NYUGAT-SZAMOA        WESTSAMOA','APIA','tala','WST','100 sene',685,1480,3),
('DÉL-KOREA','SZÖUL','Ázsia:Koreai-félsziget',98484.00,'köztársaság',47700,19900,'ROK','DEL-KOREA','SEOUL (SZOUL)','won','KRW','100 hwan',850,10480,1),
('ÉSZAK-KOREA','PHENJAN','Ázsia:Koreai-félsziget',120538.00,'népi demokratikus köztársaság',22600,3200,'','ESZAK-KOREAI N.D.K.       KNDK','PHJONGJANG  PHENJAN','won','KPW','100 chon',82,1000,1),
('VANUATU','PORT-VILA','Óceánia:Melanézia',14763.00,'parlamentáris köztársaság',190,40,'VU','VANUATU','PORT-VILA','vatu','VUV','100 centime',678,1170,3)
,('TUVALU','FUNAFUTI','Óceánia:Melanézia:Ellice-szk.',26.00,'alkotmányos monarchia',11,5,'TUV','TUVALU','FUNAFUTI','ausztráliai dollár','AUD','100 cent',688,330,3),
('TONGA','NUKU\'ALOFA','Óceánia:Melanézia-Polinézia',748.00,'alkotmányos királyság',102,20,'TO','TONGA','NUKU\'ALOFA','tongai dollár','TOP','100 seniti',676,1550,3),
('NAURU','YAREN','Óceánia:Mikronézia-Melanézia',21.30,'parlamentáris köztársaság',12,5,'NAU','NAURU','YAREN','ausztrál dollár','AUD','100 cent',674,5000,3),
('KIRIBATI','BAIRIKI','Óceánia:Mikronézia-Polinézia',886.00,'elnöki köztársaság',80,30,'KIR','KIRIBATI','BAIRIKI','ausztrál dollár','AUD','100 cent',686,570,3),
('SAINT LUCIA','CASTRIES','Közép-Amerika:Kis-Antillák',616.00,'alkotmányos monarchia',158,60,'WL','SAINT LUCIA','CASTRIES','kelet-karib dollár','XCD','100 cent',1,4240,3),
('SAINT VINCENT ÉS GRENADINE','KINGSTOWN','Közép-Amerika:Kis-Antillák',389.00,'alkotmányos monarchia',110,20,'WV','SAINT VINCENT ES GRENADINE','KINGSTOWN','kelet-karib dollár','XCD','100 cent',1,3330,3),
('BARBADOS','BRIDGETOWN','Közép-Amerika:Kis-Antillák',430.00,'alkotmányos monarchia',276,80,'BDS','BARBADOS','BRIDGETOWN','barbadosi dollár','BBD','100 cent',1,9650,3),
('GRENADA','SAINT GEORGE\'S','Közép-Amerika:Kis-Antillák',344.00,'alkotmányos monarchia',91,14,'WG','GRENADA','SAINT GEORGE\'S','kelet-karib dollár','XCD','100 cent',1,2910,3),
('SAN MARINO','SAN MARINO','Európa (törpeállam Olaszországban)',60.57,'köztársaság',27,4,'RSM','SAN MARINO','SAN MARINO','euró','EUR','100 eurocent',378,27010,1),
('SZINGAPÚR','SZINGAPÚR','Dél-Kelet-Ázsia (városállam)',641.00,'köztársaság',4150,3600,'SGP','SZINGAPUR','SINGAPORE SZINGAPUR','szingapuri dollár','SGD','100 cent',65,22670,1),
('EGYESÜLT ARAB EMIRSÉGEK','ABU DHABI','Ázsia:Arab-félsziget',83600.00,'államszövetség',3000,500,'UAE','EGYESULT ARAB EMIRSEGEK','ABU ZABY  ABU DHABI','dirham','AED','100 fil',971,21850,3),
('KUVAIT','KUVAIT','Ázsia:Arab-félsziget',17818.00,'alkotmányos monarchia',2500,1700,'KWT','KUVAIT','AL KUWAYT (KUVAIT)','kuvaiti dinár','KWD','1000 fil',965,15820,1),
('BAHREIN','MANAMA','Ázsia:Közel-Kelet',678.00,'sejkség',634,500,'BRN','BAHREIN','MANAMA','bahreini dinár','BHD','1000 fil',973,13700,3),
('DZSIBUTI','DZSIBUTI','Kelet-Afrika',21783.00,'köztársaság',700,500,'','DZSIBUTI','DZSIBUTI   DJIBOUTI','dzsibuti frank','DJF','100 centime',0,780,3),
('GAMBIA','BANJUL','Nyugat-Afrika',11295.00,'köztársaság',1400,50,'WAG','GAMBIA','BANJUL','dalasi','GMD','100 butut',220,250,3),
('BISSAU-GUINEA','BISSAU','Nyugat-Afrika',36125.00,'köztársaság',1285,300,'GNB','BISSAU-GUINEA','BISSAU','CFA-frank','XOF','100 centime',245,460,3),
('BURUNDI','BUJUMBURA','Közép-Kelet-Afrika',27834.00,'elnöki köztársaság',6800,300,'RU','BURUNDI','BUJUMBURA','burundi frank','BIF','100 centime',257,100,3),
('COMORE-SZIGETEK','MORONI','Kelet-Afrika (Indiai-óceán)',1862.00,'iszlám szövetségi köztársaság',700,60,'COM','COMORE-SZIGETEK','MORONI','comorei frank','KMF','100 centime',269,440,3),
('MAURITIUS','PORT LOUIS','Indiai-óceán (Kelet-Afrika)',2045.00,'alkotmányos monarchia',1200,500,'MS','MAURITIUS','PORT LOUIS','mauritiusi rupia','MUR','100 cent',230,3830,2),
('JEMEN','SZANAA','Ázsia:Arab-félsziget',528000.00,'köztársaság',20100,1800,'ADN','JEMEN','SAN\'A (SZANAA)','rial','YER','100 fil',967,470,2),
('MALDIV-SZIGETEK','MALE','Indiai-óceán (Dél-Ázsia)',298.00,'elnöki köztársaság',301,80,'MV','MALDIV-SZIGETEK','MALE','maldiv rupia','MVR','100 laree',960,2110,3),
('COSTA RICA','SAN JOSÉ','Közép-Amerika',51100.00,'elnöki köztársaság',3900,1500,'CR','COSTA RICA','SAN JOSE','colon','CRC','100 centimo',506,4540,2),
('SALAMON-SZIGETEK','HONIARA','Óceánia:Melanézia',28446.00,'alkotmányos királyság',466,30,'SLB','SALAMON-SZIGETEK','HONIARA','salamon szk-i dollár','SBD','100 cent',0,720,3),
('TRINIDAD ÉS TOBAGO','PORT OF SPAIN','Közép-Amerika:Kis-Antillák',5128.00,'elnöki köztársaság',1300,300,'TT','TRINIDAD ES TOBAGO','PORT OF SPAIN','trinidadi dollár','TTD','100 cent',1,7380,3),
('ZÖLD-FOKI KÖZTÁRSASÁG','PRAIA','Atlanti-óceán (Nyugat-Afrika)',4033.00,'köztársaság',475,100,'','ZOLD-FOKI KOZTARSASAG','PRAIA','escudo','CVE','100 centavo',0,1650,3),
('SEYCHELLE-SZIGETEK','VICTORIA','Kelet-Afrika (Indiai-óceán)',454.00,'köztársaság',80,60,'SY','SEYCHELLE-SZIGETEK','VICTORIA','seychelle-i rupia','SCR','100 cent',248,7560,3),
('ANTIGUA ÉS BARBUDA','SAINT JOHN\'S','Közép-Amerika:Kis-Antillák',443.00,'alkotmányos monarchia',80,30000,'','ANTIGUA ES BARBUDA','SAINT JOHN\'S','kelet-karib dollár','XCD','100 cent',1,9700,3),
('DOMINIKAI KÖZTÁRSASÁG','SANTO DOMINGO','Közép-Amerika:Nagy-Antillák',48734.00,'elnöki köztársaság',8700,2900,'DOM','DOMINIKAI KOZTARSASAG','SANTO DOMINGO','peso','DOP','100 centavo',1,2730,3),
('DOMINIKAI KÖZÖSSÉG','ROSEAU','Közép-Amerika:Kis-Antillák',751.00,'köztársaság',72,20,'WD','DOMINIKAI KOZOSSEG','ROSEAU','kelet-karib dollár','XCD','100 cent',1,3520,3),
('EGYENLITŐI-GUINEA','MALABO','Közép-Nyugat-Afrika',28051.00,'elnöki köztársaság',474,100,'GQ','EGYENLITOI-GUINEA','MALABO','CFA-frank','XAF','100 centime',240,785,3),
('ELEFÁNTCSONTPART','YAMOUSSOUKRO','Nyugat-Afrika',322463.00,'elnöki köztársaság',16600,200,'CI','ELEFANTCSONTPART','YAMOUSSOUKRO','CFA-frank','XAF','100 centime',225,700,3),
('HAITI','PORT-AU-PRINCE','Közép-Amerika:Nagy-Antillák',27750.00,'elnöki köztársaság',8300,1800,'RH','HAITI','PORT-AU-PRINCE','gourde','HTG','100 centime',509,420,3),
('PÁPUA ÚJ-GUINEA','PORT MORESBY','Óceánia:Melanézia',461691.00,'alkotmányos monarchia',5700,300,'PNG','PAPUA UJ-GUINEA','PORT MORESBY','kina','PGK','100 toea',675,570,3),
('KÖZÉP-AFRIKAI KÖZTÁRSASÁG','BANGUI','Közép-Afrika',622984.00,'elnöki köztársaság',3800,800,'RCA','KOZEP-AFRIKAI KOZTARSASAG','BANGUI','CFA-frank','XAF','100 centime',236,310,3),
('SÁO TOMÉ ÉS PRINCIPE','SÁO TOMÉ','Nyugat-Afrika (Guineai-öböl)',1001.00,'köztársaság',160,50,'','SAO TOME ES PRINCIPE','SAO TOME','dobra','STD','100 centavo',239,390,3),
('BRUNEI','BANDAR SERI BEGAWAN','Dél-Kelet-Ázsia:Borneó',5765.00,'szultanátus',336,80,'BRU','BRUNEI','BANDAR SERI BEGAWAN','brunei dollár','BND','100 cent',673,24630,2),
('SAINT KITTS ÉS NEVIS','BASSETERRE','Közép-Amerika:Kis-Antillák',266.00,'alkotmányos monarchia',42,10,'','SAINT KITTS ES NEVIS','BASSETERRE','kelet-karib dollár','XCD','100 cent',0,7310,3),
('UKRAJNA','KIJEV','Kelet-Európa',603700.00,'köztársaság',49000,2800,'UR','UKRAJNA','KIJEV KIEV','hrivnya','UAH','100 kopejka',380,970,1),
('LITVÁNIA','VILNIUS','Európa:Baltikum',65300.00,'köztársaság',3620,500,'LT','LITVANIA','VILNIUS','litas','LTL','100 centas',370,3680,1),
('LETTORSZÁG','RIGA','Európa:Baltikum',64589.00,'köztársaság',2400,900,'LV','LETTORSZAG','RIGA','lat','LVL','100 santimi',371,3980,1),
('ÉSZTORSZÁG','TALLINN','Európa:Baltikum',45227.00,'köztársaság',1400,400,'EST','ESZTORSZAG','TALLINN','korona','EEK','100 senti',372,4710,1),
('HORVÁTORSZÁG','ZÁGRÁB','Dél-Európa',56538.00,'köztársaság',4400,700,'HR','HORVATORSZAG  CROATIA HRVATSKA','ZAGRAB  ZAGREB','kuna','HRK','100 lipa',385,5060,1),
('SZLOVÉNIA','LJUBLJANA','Dél-Európa:Alpok-Adria',20253.00,'köztársaság',2000,300,'SLO','SZLOVENIA            SLOVENIJA','LJUBLJANA','tolár','SLT','100 stotin',386,12530,1),
('BOSZNIA-HERCEGOVINA','SARAJEVO','Dél-Európa:Balkán',51129.00,'köztársaság',4400,600,'BIH','BOSZNIA-HERCEGOVINA','SARAJEVO  SZARAJEVO','konvertibilis márka','BAM','100 pfennig',387,1770,1),
('MACEDÓNIA','SKOPJE','Dél-Európa:Balkán-félsziget',25713.00,'köztársaság',2200,400,'MK','MACEDONIA MAKEDONIA MAKEDONIJA','SKOPJE','macedon dinár','XMD','100 para',389,2070,1),
('AZERBAJDZSÁN','BAKU','Elő-Ázsia:Kaukázus, Kaszpi-tenger',86600.00,'köztársaság',8400,2100,'AZ','AZERBAJDZSAN','BAKU','manát','AZM','100 gopik',994,1770,2),
('GRÚZIA','TBILISZI','Európa:Kaukázus, Fekete-tenger',69700.00,'köztársaság',5500,1400,'GE','GRUZIA','TBILISZI','lari','GEL','100 tetri',995,710,2),
('ÖRMÉNYORSZÁG','JEREVÁN','Európa:Kaukázus',29800.00,'köztársaság',3400,1200,'','ORMENYORSZAG','JEREVAN','dram','AMD','100 luma',374,660,2),
('BELARUSZ','MINSZK','Kelet-Európa',207600.00,'köztársaság',10300,1800,'BY','BELARUSZ FEHEROROSZORSZAG','MINSZK','belarusz rubel','BYR','100 kopek',375,1790,2),
('MOLDOVA','CHISINAU','Kelet-Európa',33700.00,'köztársaság',4430,800,'MD','MOLDOVA      MOLDAVIA  MOLDAVA','KISINYOV CHISINAU','lej','MDL','100 bani',373,380,2),
('ÜZBEGISZTÁN','TASKENT','Közép-Ázsia',447400.00,'köztársaság',25100,3500,'UZB','UZBEGISZTAN','TASKENT','szum','UZS','100 tijin',998,330,2),
('KAZAHSZTÁN','ASZTANA','Ázsia',2717300.00,'köztársaság',16730,300,'KZ','KAZAHSZTAN','ASZTANA  ASTANA','tenge','KZT','100 tein',7,2010,2),
('KIRGIZISZTÁN','BISKEK','Közép-Ázsia',198500.00,'köztársaság',5100,800,'KS','KIRGIZIA           KIRGIZISZTAN','BISKEK','szom','KGZ','100 tyijnsz',996,350,2),
('TÁDZSIKISZTÁN','DUSANBE','Közép-Ázsia',143100.00,'köztársaság',6200,800,'TD','TADZSIKISZTAN','DUSANBE','szomoni','TJR','100 kopejka',992,180,2),
('TÜRKMENISZTÁN','ASGABAT','Közép-Ázsia',488100.00,'köztársaság',4520,700,'TMN','TURKMENISZTAN','ASGABAT','manat','TMM','100 tenesi',7,950,2),
('TAJVAN','TAJPEJ','Ázsia:Távol-Kelet (szigetország)',36000.00,'köztársaság',22500,7900,'RC','TAJVAN  KINAI KOZTARSASAG','TAJPEJ','dollár','TWD','100 cent',886,12720,1),
('PALAU','KOROR','Óceánia:Mikronézia',508.00,'elnöki köztársaság',19,10,'PAL','PALAU','KOROR','dollár','USD','100 cent',680,5000,3),
('KELET-TIMOR','DILI','Ázsia:Indonéz-szigetek',15007.00,'köztársaság',840,60,'','KELET-TIMOR','DILI','dollár','USD','100 cent',0,520,3),
('MARSHALL-SZIGETEK','MAJURO','Óceánia:Mikronézia',180.00,'köztársaság',68,20,'MH','MARSHALL-SZIGETEK','MAJURO','dollár','USD','100 cent',692,2190,3),
('MIKRONÉZIA','PALIKIR','Óceánia:Mikronézia',702.00,'szövetségi köztársaság',133,10,'FSM','MIKRONEZIA','PALIKIR','dollár','USD','100 cent',691,2150,3),
('MONTENEGRO','PODGORICA','Dél-Európa:Balkán-félsziget',14026.00,'köztársaság',616,137,'MNE','MONTENEGRO CRNA GORA','PODGORICA','euro','EUR','100 eurocent',382,3100,1);
/*!40000 ALTER TABLE `orszagok` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-08 19:11:49
