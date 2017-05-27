/*
SQLyog Ultimate v12.3.2 (32 bit)
MySQL - 5.7.17-log : Database - jd2_project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jd2_project` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `jd2_project`;

/*Table structure for table `ability` */

DROP TABLE IF EXISTS `ability`;

CREATE TABLE `ability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `key` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `hero` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hero` (`hero`),
  CONSTRAINT `ability_ibfk_1` FOREIGN KEY (`hero`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=671 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ability` */

insert  into `ability`(`id`,`name`,`key`,`hero`) values 
(1,'Blood Well','passive',1),
(2,'Dark Flight','Q',1),
(3,'Blood Thirst / Blood Price','W',1),
(4,'Blades of Torment','E',1),
(5,'Massacre','R',1),
(6,'Essence Theft','passive',2),
(7,'Orb of Deception','Q',2),
(8,'Fox-Fire','W',2),
(9,'Charm','E',2),
(10,'Spirit Rush','R',2),
(11,'Twin Disciplines','passive',3),
(12,'Mark of the Assassin','Q',3),
(13,'Twilight Shroud','W',3),
(14,'Crescent Slash','E',3),
(15,'Shadow Dance','R',3),
(16,'Triumphant Roar','passive',4),
(17,'Pulverize','Q',4),
(18,'Headbutt','W',4),
(19,'Trample','E',4),
(20,'Unbreakable Will','R',4),
(21,'Cursed Touch','passive',5),
(22,'Bandage Toss','Q',5),
(23,'Despair','W',5),
(24,'Tantrum','E',5),
(25,'Curse of the Sad Mummy','R',5),
(26,'Rebirth','passive',6),
(27,'Flash Frost','Q',6),
(28,'Crystallize','W',6),
(29,'Frostbite','E',6),
(30,'Glacial Storm','R',6),
(31,'Pyromania','passive',7),
(32,'Disintegrate','Q',7),
(33,'Incinerate','W',7),
(34,'Molten Shield','E',7),
(35,'Summon: Tibbers','R',7),
(36,'Frost Shot','passive',8),
(37,'Ranger\'s Focus','Q',8),
(38,'Volley','W',8),
(39,'Hawkshot','E',8),
(40,'Enchanted Crystal Arrow','R',8),
(41,'Center of the Universe','passive',9),
(42,'Starsurge','Q',9),
(43,'Celestial Expansion','W',9),
(44,'Comet of Legend','E',9),
(45,'Voice of Light','R',9),
(46,'Shurima\'s Legacy','passive',10),
(47,'Conquering Sands','Q',10),
(48,'Arise','W',10),
(49,'Shifting Sands','E',10),
(50,'Emperor\'s Divide','R',10),
(51,'Traveler\'s Call','passive',11),
(52,'Cosmic Binding','Q',11),
(53,'Caretaker\'s Shrine','W',11),
(54,'Magical Journey','E',11),
(55,'Tempered Fate','R',11),
(56,'Mana Barrier','passive',12),
(57,'Rocket Grab','Q',12),
(58,'Overdrive','W',12),
(59,'Power Fist','E',12),
(60,'Static Field','R',12),
(61,'Blaze','passive',13),
(62,'Sear','Q',13),
(63,'Pillar of Flame','W',13),
(64,'Conflagration','E',13),
(65,'Pyroclasm','R',13),
(66,'Concussive Blows','passive',14),
(67,'Winter\'s Bite','Q',14),
(68,'Stand Behind Me','W',14),
(69,'Unbreakable','E',14),
(70,'Glacial Fissure','R',14),
(71,'Headshot','passive',15),
(72,'Piltover Peacemaker\r\n','Q',15),
(73,'Yordle Snap Trap','W',15),
(74,'90 Caliber Net','E',15),
(75,'Ace in the Hole','R',15),
(76,'\r\nAdaptive Defenses','passive',16),
(77,'Precision Protocol','Q',16),
(78,'Tactical Sweep','W',16),
(79,'Hookshot','E',16),
(80,'The Hextech Ultimatum','R',16),
(81,'Serpentine Grace','passive',17),
(82,'Noxious Blast','Q',17),
(83,'Miasma','W',17),
(84,'\r\nTwin Fang','E',17),
(85,'Petrifying Gaze','R',17),
(86,'Carnivore','passive',18),
(87,'Rupture','Q',18),
(88,'Feral Scream','W',18),
(89,'Vorpal Spikes','E',18),
(90,'Feast','R',18),
(91,'Hextech Munitions','passive',19),
(92,'Phosphorus Bomb','Q',19),
(93,'Valkyrie','W',19),
(94,'Gatling Gun','E',19),
(95,'Missile Barrage','R',19),
(96,'Hemorrhage','passive',20),
(97,'Decimate','Q',20),
(98,'Crippling Strike','W',20),
(99,'Apprehend','E',20),
(100,'Noxian Guillotine','R',20),
(101,'Moonsilver Blade','passive',21),
(102,'Crescent Strike','Q',21),
(103,'Pale Cascade','W',21),
(104,'Moonfall','E',21),
(105,'Lunar Rush','R',21),
(106,'Adrenaline Rush\r\n','passive',22),
(107,'Infected Cleaver','Q',22),
(108,'Burning Agony','W',22),
(109,'Masochism','E',22),
(110,'Sadism','R',22),
(111,'League of Draven','passive',23),
(112,'Spinning Axe\r\n','Q',23),
(113,'Blood Rush','W',23),
(114,'Stand Aside','E',23),
(115,'Whirling Death','R',23),
(116,'Z-Drive Resonance','passive',24),
(117,'Timewinder','Q',24),
(118,'Parallel Convergence','W',24),
(119,'Phase Dive','E',24),
(120,'Chronobreak','R',24),
(121,'Spider Queen','passive',25),
(122,'Neurotoxin / Venomous Bite','Q',25),
(123,'Volatile Spiderling / Skittering Frenzy','W',25),
(124,'Cocoon / Rappel','E',25),
(125,'Spider Form','R',25),
(126,'Shadow Walk','passive',26),
(127,'Hate Spike','Q',26),
(128,'Dark Frenzy','W',26),
(129,'Ravage','E',26),
(130,'Agony\'s Embrace','R',26),
(131,'Rising Spell Force','passive',27),
(132,'\r\nMystic Shot','Q',27),
(133,'Essence Flux','W',27),
(134,'Arcane Shift','E',27),
(135,'\r\nTrueshot Barrage','R',27),
(136,'Dread','passive',28),
(137,'Terrify','Q',28),
(138,'Drain','W',28),
(139,'Dark Wind','E',28),
(140,'Crowstorm','R',28),
(141,'Duelist\'s Dance','passive',29),
(142,'Lunge','Q',29),
(143,'Riposte','W',29),
(144,'Bladework','E',29),
(145,'Grand Challenge','R',29),
(146,'\r\nNimble Fighter','passive',30),
(147,'Urchin Strike','Q',30),
(148,'Seastone Trident','W',30),
(149,'Playful / Trickster','E',30),
(150,'\r\nChum the Waters','R',30),
(151,'\r\nRunic Skin','passive',31),
(152,'Resolute Smite','Q',31),
(153,'Bulwark','W',31),
(154,'\r\nRighteous Gust','E',31),
(155,'Idol of Durand','R',31),
(156,'Trial by Fire','passive',32),
(157,'Parrrley','Q',32),
(158,'Remove Scurvy','W',32),
(159,'Powder Keg','E',32),
(160,'Cannon Barrage','R',32),
(161,'Perseverance','passive',134),
(162,'\r\nDecisive Strike','Q',134),
(163,'Courage','W',134),
(164,'Judgment','E',134),
(165,'Demacian Justice','R',134),
(166,'Rage Gene','passive',33),
(167,'Boomerang Throw / Boulder Toss','Q',33),
(168,'Hyper / Wallop','W',33),
(169,'Hop / Crunch','E',33),
(170,'GNAR','R',33),
(171,'Happy Hour','passive',34),
(172,'Barrel Roll','Q',34),
(173,'\r\nDrunken Rage','W',34),
(174,'Body Slam','E',34),
(175,'Explosive Cask\r\n','R',34),
(176,'New Destiny','passive',35),
(177,'End of the Line','Q',35),
(178,'\r\nSmoke Screen','W',35),
(179,'Quickdraw','E',35),
(180,'\r\nCollateral Damage','R',35),
(181,'Warpath','passive',36),
(182,'Rampage','Q',36),
(183,'Spirit of Dread','W',36),
(184,'Devastating Charge','E',36),
(185,'Onslaught of Shadows','R',36),
(186,'\r\nTechmaturgical Repair Bots','passive',37),
(187,'H-28G Evolution Turret','Q',37),
(188,'Hextech Micro-Rockets','W',37),
(189,'\r\nCH-2 Electron Storm Grenade','E',37),
(190,'UPGRADE','R',37),
(191,'Prophet of an Elder God','passive',38),
(192,'Tentacle Smash','Q',38),
(193,'Harsh Lesson','W',38),
(194,'Test of Spirit','E',38),
(195,'Leap of Faith','R',38),
(196,'\r\nIonian Fervor','passive',39),
(197,'Bladesurge','Q',39),
(198,'Hiten Style','W',39),
(199,'Equilibrium Strike','E',39),
(200,'\r\nTranscendent Blades','R',39),
(201,'\r\nFriend of the Forest','passive',40),
(202,'Rootcaller','Q',40),
(203,'Brushmaker','W',40),
(204,'Triggerseed','E',40),
(205,'Daisy','R',40),
(206,'Tailwind','passive',41),
(207,'\r\nHowling Gale','Q',41),
(208,'Zephyr','W',41),
(209,'Eye Of The Storm','E',41),
(210,'Monsoon','R',41),
(211,'Martial Cadence','passive',42),
(212,'Dragon Strike','Q',42),
(213,'Golden Aegis','W',42),
(214,'Demacian Standard','E',42),
(215,'Cataclysm','R',42),
(216,'Relentless Assault','passive',43),
(217,'Leap Strike','Q',43),
(218,'Empower','W',43),
(219,'Counter Strike','E',43),
(220,'Grandmaster\'s Might','R',43),
(221,'Hextech Capacitor','passive',44),
(222,'To the Skies! / Shock Blast','Q',44),
(223,'Lightning Field / Hyper Charge','W',44),
(224,'Thundering Blow / Acceleration Gate','E',44),
(225,'Mercury Cannon / Mercury Hammer','R',44),
(226,'Whisper','passive',45),
(227,'Dancing Grenade','Q',45),
(228,'Deadly Flourish','W',45),
(229,'Captive Audience','E',45),
(230,'Curtain Call','R',45),
(231,'Get Excited!\r\n','passive',46),
(232,'Switcheroo!','Q',46),
(233,'Zap','W',46),
(234,'Flame Chompers','E',46),
(235,'Super Mega Death Rocket!','R',46),
(236,'Martial Poise','passive',47),
(237,'Pierce','Q',47),
(238,'Sentinel','W',47),
(239,'Rend','E',47),
(240,'\r\nFate\'s Call','R',47),
(241,'Gathering Fire','passive',48),
(242,'Inner Flame','Q',48),
(243,'Focused Resolve','W',48),
(244,'Inspire','E',48),
(245,'Mantra','R',48),
(246,'Death Defied','passive',49),
(247,'Lay Waste','Q',49),
(248,'Wall of Pain','W',49),
(249,'Defile','E',49),
(250,'Requiem','R',49),
(251,'Void Stone','passive',50),
(252,'\r\nNull Sphere','Q',50),
(253,'Nether Blade','W',50),
(254,'Force Pulse','E',50),
(255,'Riftwalk','R',50),
(256,'Voracity','passive',51),
(257,'Bouncing Blade','Q',51),
(258,'Preparation','W',51),
(259,'Shunpo','E',51),
(260,'Death Lotus','R',51),
(261,'Holy Fervor','passive',52),
(262,'Reckoning','Q',52),
(263,'Divine Blessing','W',52),
(264,'Righteous Fury','E',52),
(265,'Intervention','R',52),
(266,'Mark of the Storm','passive',53),
(267,'Thundering Shuriken','Q',53),
(268,'Electrical Surge','W',53),
(269,'Lightning Rush','E',53),
(270,'Slicing Maelstrom','R',53),
(271,'Unseen Threat','passive',54),
(272,'Taste Their Fear','Q',54),
(273,'Void Spike','W',54),
(274,'Leap','E',54),
(275,'Void Assault','R',54),
(276,'Mark of the Kindred','passive',55),
(277,'Dance of Arrows','Q',55),
(278,'\r\nWolf\'s Frenzy','W',55),
(279,'Mounting Dread','E',55),
(280,'Lamb\'s Respite','R',55),
(281,'Skaarl, the Cowardly Lizard','passive',56),
(282,'Bear Trap on a Rope','Q',56),
(283,'Violent Tendencies','W',56),
(284,'Jousting','E',56),
(285,'Chaaaaaaaarge','R',56),
(286,'Icathian Surprise','passive',57),
(287,'Caustic Spittle','Q',57),
(288,'\r\nBio-Arcane Barrage','W',57),
(289,'Void Ooze','E',57),
(290,'Living Artillery','R',57),
(291,'\r\nSigil of Malice','passive',58),
(292,'Shatter Orb','Q',58),
(293,'Distortion','W',58),
(294,'Ethereal Chains','E',58),
(295,'Mimic','R',58),
(296,'Flurry','passive',59),
(297,'Sonic Wave / Resonating Strike','Q',59),
(298,'Safeguard / Iron Will','W',59),
(299,'Tempest / Cripple','E',59),
(300,'\r\nDragon\'s Rage','R',59),
(301,'Sunlight','passive',60),
(302,'Shield of Daybreak','Q',60),
(303,'Eclipse','W',60),
(304,'Zenith Blade','E',60),
(305,'\r\nSolar Flare','R',60),
(306,'Iceborn','passive',61),
(307,'Ice Shard','Q',61),
(308,'Ring of Frost','W',61),
(309,'Glacial Path','E',61),
(310,'\r\nFrozen Tomb','R',61),
(311,'Lightslinger','passive',62),
(312,'Piercing Light\r\n','Q',62),
(313,'Ardent Blaze','W',62),
(314,'Relentless Pursuit','E',62),
(315,'The Culling','R',62),
(316,'Pix, Faerie Companion','passive',63),
(317,'Glitterlance','Q',63),
(318,'Whimsy','W',63),
(319,'Help, Pix!','E',63),
(320,'Wild Growth','R',63),
(321,'Illumination','passive',64),
(322,'Light Binding','Q',64),
(323,'Prismatic Barrier','W',64),
(324,'Lucent Singularity','E',64),
(325,'Final Spark','R',64),
(326,'Granite Shield','passive',65),
(327,'Seismic Shard','Q',65),
(328,'Brutal Strikes','W',65),
(329,'Ground Slam','E',65),
(330,'Unstoppable Force','R',65),
(331,'Void Shift','passive',66),
(332,'Call of the Void','Q',66),
(333,'Void Swarm','W',66),
(334,'Malefic Visions','E',66),
(335,'Nether Grasp','R',66),
(336,'Sap Magic','passive',67),
(337,'Arcane Smash','Q',67),
(338,'Twisted Advance','W',67),
(339,'Sapling Toss','E',67),
(340,'Vengeful Maelstrom','R',67),
(341,'Double Strike','passive',68),
(342,'Alpha Strike','Q',68),
(343,'Meditate','W',68),
(344,'Wuju Style','E',68),
(345,'Highlander','R',68),
(346,'Love Tap','passive',69),
(347,'\r\nDouble Up','Q',69),
(348,'Strut','W',69),
(349,'Make It Rain','E',69),
(350,'\r\nBullet Time','R',69),
(351,'\r\nIron Man','passive',70),
(352,'Mace of Spades','Q',70),
(353,'Harvesters of Sorrow','W',70),
(354,'Siphon of Destruction','E',70),
(355,'Children of the Grave','R',70),
(356,'Soul Siphon','passive',71),
(357,'Dark Binding','Q',71),
(358,'\r\nTormented Soil','W',71),
(359,'\r\nBlack Shield','E',71),
(360,'\r\nSoul Shackles','R',71),
(361,'\r\nSurging Tides','passive',72),
(362,'Aqua Prison','Q',72),
(363,'\r\nEbb and Flow','W',72),
(364,'Tidecaller\'s Blessing','E',72),
(365,'\r\nTidal Wave','R',72),
(366,'Soul Eater','passive',73),
(367,'Siphoning Strike','Q',73),
(368,'Wither','W',73),
(369,'Spirit Fire','E',73),
(370,'Fury of the Sands','R',73),
(371,'Staggering Blow','passive',74),
(372,'Dredge Line','Q',74),
(373,'Titan\'s Wrath','W',74),
(374,'Riptide','E',74),
(375,'Depth Charge','R',74),
(376,'Prowl','passive',75),
(377,'Javelin Toss / Takedown','Q',75),
(378,'Bushwhack / Pounce','W',75),
(379,'Primal Surge / Swipe','E',75),
(380,'Aspect Of The Cougar','R',75),
(381,'Umbra Blades','passive',76),
(382,'Duskbringer','Q',76),
(383,'\r\nShroud of Darkness','W',76),
(384,'\r\nUnspeakable Horror','E',76),
(385,'Paranoia','R',76),
(386,'Visionary','passive',77),
(387,'Consume','Q',77),
(388,'Blood Boil','W',77),
(389,'\r\nIce Blast','E',77),
(390,'Absolute Zero','R',77),
(391,'\r\nBerserker Rage','passive',78),
(392,'Undertow','Q',78),
(393,'Vicious Strikes','W',78),
(394,'Reckless Swing','E',78),
(395,'Ragnarok','R',78),
(396,'Clockwork Windup','passive',79),
(397,'\r\nCommand: Attack','Q',79),
(398,'Command: Dissonance','W',79),
(399,'Command: Protect','E',79),
(400,'\r\nCommand: Shockwave','R',79),
(401,'Aegis Protection','passive',80),
(402,'Spear Shot','Q',80),
(403,'\r\nAegis of Zeonia','W',80),
(404,'Heartseeker Strike','E',80),
(405,'Grand Skyfall','R',80),
(406,'Iron Ambassador','passive',81),
(407,'\r\nHammer Shock','Q',81),
(408,'Steadfast Presence','W',81),
(409,'\r\nHeroic Charge','E',81),
(410,'Keeper\'s Verdict','R',81),
(411,'Harrier','passive',82),
(412,'\r\nBlinding Assault','Q',82),
(413,'Heightened Senses','W',82),
(414,'Vault','E',82),
(415,'Behind Enemy Lines','R',82),
(416,'\r\nSpiked Shell','passive',83),
(417,'Powerball','Q',83),
(418,'Defensive Ball Curl','W',83),
(419,'Puncturing Taunt','E',83),
(420,'Tremors','R',83),
(421,'Fury of the Xer\'Sai','passive',84),
(422,'Queen\'s Wrath / Prey Seeker','Q',84),
(423,'Burrow / Un-burrow','W',84),
(424,'Furious Bite / Tunnel','E',84),
(425,'Void Rush','R',84),
(426,'Reign of Anger','passive',85),
(427,'Cull the Meek','Q',85),
(428,'Ruthless Predator','W',85),
(429,'\r\nSlice and Dice','E',85),
(430,'Dominus','R',85),
(431,'Unseen Predator','passive',86),
(432,'Savagery','Q',86),
(433,'\r\nBattle Roar','W',86),
(434,'Bola Strike','E',86),
(435,'Thrill of the Hunt','R',86),
(436,'\r\nRunic Blade','passive',87),
(437,'Broken Wings','Q',87),
(438,'Ki Burst','W',87),
(439,'Valor','E',87),
(440,'\r\nBlade of the Exile','R',87),
(441,'Junkyard Titan','passive',88),
(442,'Flamespitter','Q',88),
(443,'Scrap Shield','W',88),
(444,'Electro Harpoon','E',88),
(445,'The Equalizer','R',88),
(446,'Arcane Mastery','passive',89),
(447,'Overload','Q',89),
(448,'Rune Prison','W',89),
(449,'\r\nSpell Flux','E',89),
(450,'Realm Warp','R',89),
(451,'Frost','passive',90),
(452,'Arctic Assault','Q',90),
(453,'Flail of the Northern Winds','W',90),
(454,'Permafrost','E',90),
(455,'\r\nGlacial Prison','R',90),
(456,'Backstab','passive',91),
(457,'Deceive','Q',91),
(458,'Jack In The Box','W',91),
(459,'Two-Shiv Poison','E',91),
(460,'Hallucinate','R',91),
(461,'\r\nKi Barrier','passive',92),
(462,'Twilight Assault','Q',92),
(463,'Spirit\'s Refuge','W',92),
(464,'Shadow Dash','E',92),
(465,'Stand United','R',92),
(466,'Fury of the Dragonborn','passive',93),
(467,'\r\nTwin Bite','Q',93),
(468,'Burnout','W',93),
(469,'\r\nFlame Breath','E',93),
(470,'Dragon\'s Descent','R',93),
(471,'Empowered Bulwark','passive',94),
(472,'Poison Trail','Q',94),
(473,'Mega Adhesive','W',94),
(474,'Fling','E',94),
(475,'Insanity Potion','R',94),
(476,'Glory in Death','passive',95),
(477,'Decimating Smash','Q',95),
(478,'Soul Furnace','W',95),
(479,'Roar of the Slayer','E',95),
(480,'\r\nUnstoppable Onslaught','R',95),
(481,'Fleet of Foot','passive',96),
(482,'Boomerang Blade','Q',96),
(483,'Ricochet','W',96),
(484,'Spell Shield','E',96),
(485,'On The Hunt','R',96),
(486,'\r\nCrystal Spires','passive',97),
(487,'\r\nCrystal Slash','Q',97),
(488,'Crystalline Exoskeleton','W',97),
(489,'Fracture','E',97),
(490,'Impale','R',97),
(491,'Power Chord','passive',98),
(492,'\r\nHymn of Valor','Q',98),
(493,'Aria of Perseverance','W',98),
(494,'Song of Celerity','E',98),
(495,'Crescendo','R',98),
(496,'Salvation','passive',99),
(497,'Starcall','Q',99),
(498,'Astral Infusion','W',99),
(499,'Equinox','E',99),
(500,'Wish','R',99),
(501,'Carrion Renewal','passive',100),
(502,'Decrepify','Q',100),
(503,'Nevermove','W',100),
(504,'Torment','E',100),
(505,'Ravenous Flock','R',100),
(506,'Transcendent','passive',101),
(507,'Dark Sphere','Q',101),
(508,'Force of Will','W',101),
(509,'Scatter the Weak','E',101),
(510,'Unleashed Power','R',101),
(511,'\r\nAn Acquired Taste','passive',102),
(512,'Tongue Lash','Q',102),
(513,'Devour','W',102),
(514,'Thick Skin','E',102),
(515,'Abyssal Voyage','R',102),
(516,'Rock Surfing','passive',103),
(517,'\r\nThreaded Volley','Q',103),
(518,'Seismic Shove','W',103),
(519,'Unraveled Earth','E',103),
(520,'\r\nWeaver\'s Wall','R',103),
(521,'Blade\'s End','passive',104),
(522,'Noxian Diplomacy','Q',104),
(523,'Rake','W',104),
(524,'\r\nAssassin\'s Path','E',104),
(525,'\r\nShadow Assault','R',104),
(526,'Bravado','passive',105),
(527,'Starlight\'s Touch','Q',105),
(528,'Bastion','W',105),
(529,'Dazzle','E',105),
(530,'Cosmic Radiance','R',105),
(531,'Guerrilla Warfare','passive',106),
(532,'Blinding Dart','Q',106),
(533,'Move Quick','W',106),
(534,'Toxic Shot','E',106),
(535,'\r\nNoxious Trap','R',106),
(536,'Damnation','passive',107),
(537,'Death Sentence','Q',107),
(538,'Dark Passage','W',107),
(539,'Flay','E',107),
(540,'The Box','R',107),
(541,'Draw a Bead','passive',108),
(542,'\r\nRapid Fire','Q',108),
(543,'Rocket Jump','W',108),
(544,'Explosive Charge','E',108),
(545,'\r\nBuster Shot','R',108),
(546,'\r\nKing\'s Tribute','passive',109),
(547,'Chomp','Q',109),
(548,'\r\nFrozen Domain','W',109),
(549,'Pillar of Ice','E',109),
(550,'Subjugate','R',109),
(551,'Battle Fury','passive',110),
(552,'Bloodlust','Q',110),
(553,'Mocking Shout','W',110),
(554,'\r\nSpinning Slash','E',110),
(555,'Undying Rage','R',110),
(556,'\r\nLoaded Dice','passive',111),
(557,'\r\nWild Cards','Q',111),
(558,'Pick A Card','W',111),
(559,'Stacked Deck','E',111),
(560,'Destiny','R',111),
(561,'Deadly Venom','passive',112),
(562,'Ambush\r\n','Q',112),
(563,'\r\nVenom Cask','W',112),
(564,'Contaminate','E',112),
(565,'Spray and Pray','R',112),
(566,'\r\nMonkey\'s Agility','passive',113),
(567,'Tiger Stance','Q',113),
(568,'Turtle Stance','W',113),
(569,'\r\nBear Stance','E',113),
(570,'Phoenix Stance','R',113),
(571,'Zaun-Touched Bolt Augmenter','passive',114),
(572,'Acid Hunter','Q',114),
(573,'Terror Capacitor','W',114),
(574,'Noxian Corrosive Charge','E',114),
(575,'Hyper-Kinetic Position Reverser','R',114),
(576,'Living Vengeance','passive',115),
(577,'\r\nPiercing Arrow','Q',115),
(578,'Blighted Quiver','W',115),
(579,'\r\nHail of Arrows','E',115),
(580,'\r\nChain of Corruption','R',115),
(581,'Night Hunter','passive',116),
(582,'Tumble','Q',116),
(583,'\r\nSilver Bolts','W',116),
(584,'Condemn','E',116),
(585,'Final Hour','R',116),
(586,'Phenomenal Evil Power','passive',117),
(587,'Baleful Strike','Q',117),
(588,'Dark Matter','W',117),
(589,'Event Horizon','E',117),
(590,'\r\nPrimordial Burst','R',117),
(591,'Organic Deconstruction','passive',118),
(592,'Plasma Fission','Q',118),
(593,'\r\nVoid Rift','W',118),
(594,'\r\nTectonic Disruption','E',118),
(595,'Life Form Disintegration Ray','R',118),
(596,'\r\nBlast Shield','passive',119),
(597,'Vault Breaker','Q',119),
(598,'Denting Blows','W',119),
(599,'Excessive Force','E',119),
(600,'Assault and Battery','R',119),
(601,'\r\nGlorious Evolution','passive',120),
(602,'Siphon Power','Q',120),
(603,'Gravity Field','W',120),
(604,'Death Ray','E',120),
(605,'Chaos Storm','R',120),
(606,'Crimson Pact','passive',121),
(607,'Transfusion','Q',121),
(608,'\r\nSanguine Pool','W',121),
(609,'\r\nTides of Blood','E',121),
(610,'Hemoplague','R',121),
(611,'Chosen of the Storm','passive',122),
(612,'\r\nRolling Thunder','Q',122),
(613,'\r\nRolling Thunder','W',122),
(614,'Majestic Roar','E',122),
(615,'Thunder Claws','R',122),
(616,'\r\nEternal Thirst','passive',123),
(617,'Hungering Strike','Q',123),
(618,'\r\nHunters Call','W',123),
(619,'\r\nBlood Scent','E',123),
(620,'Infinite Duress','R',123),
(621,'Stone Skin','passive',124),
(622,'Crushing Blow','Q',124),
(623,'Decoy','W',124),
(624,'\r\nNimbus Strike','E',124),
(625,'Cyclone','R',124),
(626,'Mana Surge','passive',125),
(627,'Arcanopulse','Q',125),
(628,'Eye of Destruction','W',125),
(629,'Shocking Orb','E',125),
(630,'Rite of the Arcane','R',125),
(631,'Challenge','passive',126),
(632,'\r\nThree Talon Strike','Q',126),
(633,'Battle Cry','W',126),
(634,'\r\nAudacious Charge','E',126),
(635,'\r\nCrescent Sweep','R',126),
(636,'Way of the Wanderer','passive',127),
(637,'\r\nSteel Tempest','Q',127),
(638,'Wind Wall','W',127),
(639,'Sweeping Blade','E',127),
(640,'Last Breath','R',127),
(641,'Shepherd of Souls','passive',128),
(642,'Last Rites','Q',128),
(643,'Dark Procession','W',128),
(644,'Mourning Mist','E',128),
(645,'Eulogy of the Isles','R',128),
(646,'Cell Division','passive',129),
(647,'Stretching Strike','Q',129),
(648,'Unstable Matter','W',129),
(649,'Elastic Slingshot','E',129),
(650,'\r\nLet\'s Bounce!','R',129),
(651,'Contempt for the Weak','passive',130),
(652,'Razor Shuriken','Q',130),
(653,'\r\nLiving Shadow','W',130),
(654,'Shadow Slash','E',130),
(655,'Death Mark','R',130),
(656,'\r\nShort Fuse','passive',131),
(657,'Bouncing Bomb','Q',131),
(658,'Satchel Charge','W',131),
(659,'Hexplosive Minefield','E',131),
(660,'Mega Inferno Bomb','R',131),
(661,'Time in a Bottle','passive',132),
(662,'Time Bomb','Q',132),
(663,'Rewind','W',132),
(664,'Time Warp','E',132),
(665,'Chronoshift','R',132),
(666,'Garden of Thorns','passive',133),
(667,'Deadly Spines','Q',133),
(668,'Rampant Growth','W',133),
(669,'Grasping Roots','E',133),
(670,'Stranglethorns','R',133);

/*Table structure for table `comments_common_topics` */

DROP TABLE IF EXISTS `comments_common_topics`;

CREATE TABLE `comments_common_topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) COLLATE utf8_bin NOT NULL,
  `user` int(11) NOT NULL,
  `common_topic` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `common_topic` (`common_topic`),
  CONSTRAINT `comments_common_topics_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `comments_common_topics_ibfk_2` FOREIGN KEY (`common_topic`) REFERENCES `common_topics` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `comments_common_topics` */

/*Table structure for table `comments_hero_topics` */

DROP TABLE IF EXISTS `comments_hero_topics`;

CREATE TABLE `comments_hero_topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) COLLATE utf8_bin NOT NULL,
  `user` int(11) DEFAULT NULL,
  `topic` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `comments_hero_topics_ibfk_2` (`topic`),
  CONSTRAINT `comments_hero_topics_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `comments_hero_topics_ibfk_2` FOREIGN KEY (`topic`) REFERENCES `topics_heroes` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `comments_hero_topics` */

/*Table structure for table `comments_news` */

DROP TABLE IF EXISTS `comments_news`;

CREATE TABLE `comments_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) COLLATE utf8_bin NOT NULL,
  `user` int(11) NOT NULL,
  `news` int(11) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `comments_news_ibfk_2` (`news`),
  CONSTRAINT `comments_news_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `comments_news_ibfk_2` FOREIGN KEY (`news`) REFERENCES `news` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `comments_news` */

/*Table structure for table `common_topics` */

DROP TABLE IF EXISTS `common_topics`;

CREATE TABLE `common_topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `text` text COLLATE utf8_bin NOT NULL,
  `user` int(11) NOT NULL,
  `global_topic` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `global_topic` (`global_topic`),
  CONSTRAINT `common_topics_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `common_topics_ibfk_2` FOREIGN KEY (`global_topic`) REFERENCES `global_topic` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `common_topics` */

/*Table structure for table `global_topic` */

DROP TABLE IF EXISTS `global_topic`;

CREATE TABLE `global_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `topics` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `global_topic` */

/*Table structure for table `hero` */

DROP TABLE IF EXISTS `hero`;

CREATE TABLE `hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `hero` */

insert  into `hero`(`id`,`name`,`pass`) values 
(1,'Aatrox','resources/images/hero/aatrox.png'),
(2,'Ahri','resources/images/hero/ahri.png'),
(3,'Akali','resources/images/hero/akali.png'),
(4,'Alistar','resources/images/hero/alistar.png'),
(5,'Amumu','resources/images/hero/amumu.png'),
(6,'Anivia','resources/images/hero/anivia.png'),
(7,'Anie','resources/images/hero/annie.png'),
(8,'Ashe','resources/images/hero/ashe.png'),
(9,'Aurelion Sol','resources/images/hero/aurelion-sol.png'),
(10,'Azir','resources/images/hero/azir.png'),
(11,'Bard','resources/images/hero/bard.png'),
(12,'Blitzcrank','resources/images/hero/blitzcrank.png'),
(13,'Brand','resources/images/hero/brand.png'),
(14,'Braum','resources/images/hero/braum.png'),
(15,'Caitlyn','resources/images/hero/caitlyn.png'),
(16,'Camille','resources/images/hero/camille.png'),
(17,'Cassiopeia','resources/images/hero/cassiopeia.png'),
(18,'Cho\'Gath','resources/images/hero/chogath.png'),
(19,'Corki','resources/images/hero/corki.png'),
(20,'Darius','resources/images/hero/darius.png'),
(21,'Diana','resources/images/hero/diana.png'),
(22,'Dr.Mundo','resources/images/hero/dr-mundo.png'),
(23,'Draiven','resources/images/hero/draven.png'),
(24,'Ekko','resources/images/hero/ekko.png'),
(25,'Elise','resources/images/hero/elise.png'),
(26,'Evelynn','resources/images/hero/evelynn.png'),
(27,'Ezreal','resources/images/hero/ezreal.png'),
(28,'Fiddlesticks','resources/images/hero/fiddlesticks.png'),
(29,'Fiora','resources/images/hero/fiora.png'),
(30,'Fizz','resources/images/hero/fizz.png'),
(31,'Galio','resources/images/hero/galio.png'),
(32,'Gangplank','resources/images/hero/gangplank.png'),
(33,'Gnar','resources/images/hero/gnar.png'),
(34,'Gragas','resources/images/hero/gragas.png'),
(35,'Graves','resources/images/hero/graves.png'),
(36,'Hecarim','resources/images/hero/hecarim.png'),
(37,'Heimerdinger','resources/images/hero/heimerdinger.png'),
(38,'Illaoi','resources/images/hero/illaoi.png'),
(39,'Irelia','resources/images/hero/irelia.png'),
(40,'Ivern','resources/images/hero/ivern.png'),
(41,'Janna','resources/images/hero/janna.png'),
(42,'Jarvan IV','resources/images/hero/jarvan-iv.png'),
(43,'Jax','resources/images/hero/jax.png'),
(44,'Jayce','resources/images/hero/jayce.png'),
(45,'Jhin','resources/images/hero/jhin.png'),
(46,'Jinx','resources/images/hero/jinx.png'),
(47,'Kalista','resources/images/hero/kalista.png'),
(48,'Karma','resources/images/hero/karma.png'),
(49,'Karthus','resources/images/hero/karthus.png'),
(50,'Kassadin','resources/images/hero/kassadin.png'),
(51,'Katarina','resources/images/hero/katarina.png'),
(52,'Kayle','resources/images/hero/kayle.png'),
(53,'Kennen','resources/images/hero/kennen.png'),
(54,'Kha\'Zix','resources/images/hero/khazix.png'),
(55,'Kindred','resources/images/hero/kindred.png'),
(56,'Kled','resources/images/hero/kled.png'),
(57,'Kog\'Maw','resources/images/hero/kogmaw.png'),
(58,'LeBlanc','resources/images/hero/leblanc.png'),
(59,'Lee Sin','resources/images/hero/lee-sin.png'),
(60,'Leona','resources/images/hero/leona.png'),
(61,'Lissandra','resources/images/hero/lissandra.png'),
(62,'Lucian','resources/images/hero/lucian.png'),
(63,'Lulu','resources/images/hero/lulu.png'),
(64,'Lux','resources/images/hero/lux.png'),
(65,'Malphite','resources/images/hero/malphite.png'),
(66,'Malzahar','resources/images/hero/malzahar.png'),
(67,'Maokai','resources/images/hero/maokai.png'),
(68,'Master Yi','resources/images/hero/master-yi.png'),
(69,'Miss Fortune','resources/images/hero/miss-fortune.png'),
(70,'Mordekaiser','resources/images/hero/mordekaiser.png'),
(71,'Morgana','resources/images/hero/morgana.png'),
(72,'Nami','resources/images/hero/nami.png'),
(73,'Nasus','resources/images/hero/nasus.png'),
(74,'Nautilus','resources/images/hero/nautilus.png'),
(75,'Nidalee','resources/images/hero/nidalee.png'),
(76,'Nocturne','resources/images/hero/nocturne.png'),
(77,'Nunu','resources/images/hero/nunu.png'),
(78,'Olaf','resources/images/hero/olaf.png'),
(79,'Orianna','resources/images/hero/orianna.png'),
(80,'Pantheon','resources/images/hero/pantheon.png'),
(81,'Poppy','resources/images/hero/poppy.png'),
(82,'Quinn','resources/images/hero/quinn.png'),
(83,'Rammus','resources/images/hero/rammus.png'),
(84,'Rek\'Sai','resources/images/hero/reksai.png'),
(85,'Renekton','resources/images/hero/renekton.png'),
(86,'Rengar','resources/images/hero/rengar.png'),
(87,'Riven','resources/images/hero/riven.png'),
(88,'Rumble','resources/images/hero/rumble.png'),
(89,'Ryze','resources/images/hero/rumble.png'),
(90,'Sejuani','resources/images/hero/sejuani.png'),
(91,'Shaco','resources/images/hero/shaco.png'),
(92,'Shen','resources/images/hero/shen.png'),
(93,'Shyvana','resources/images/hero/shyvana.png'),
(94,'Singed','resources/images/hero/singed.png'),
(95,'Sion','resources/images/hero/sion.png'),
(96,'Sivir','resources/images/hero/sivir.png'),
(97,'Skarner','resources/images/hero/skarner.png'),
(98,'Sona','resources/images/hero/sona.png'),
(99,'Soraka','resources/images/hero/soraka.png'),
(100,'Swain','resources/images/hero/swain.png'),
(101,'Syndra','resources/images/hero/syndra.png'),
(102,'Tahm Kench','resources/images/hero/tahm-kench.png'),
(103,'Taliyah','resources/images/hero/taliyah.png'),
(104,'Talon','resources/images/hero/talon.png'),
(105,'Tarik','resources/images/hero/taric.png'),
(106,'Teemo','resources/images/hero/teemo.png'),
(107,'Thresh','resources/images/hero/thresh.png'),
(108,'Tristana','resources/images/hero/tristana.png'),
(109,'Trundle','resources/images/hero/trundle.png'),
(110,'Thryndamere','resources/images/hero/tryndamere.png'),
(111,'Twisted Fate','resources/images/hero/twisted-fate.png'),
(112,'Twitch','resources/images/hero/twitch.png'),
(113,'Udyr','resources/images/hero/udyr.png'),
(114,'Urgot','resources/images/hero/urgot.png'),
(115,'Varus','resources/images/hero/varus.png'),
(116,'Vayne','resources/images/hero/vayne.png'),
(117,'Veigar','resources/images/hero/veigar.png'),
(118,'Vel\'Koz','resources/images/hero/velkoz.png'),
(119,'Vi','resources/images/hero/vi.png'),
(120,'Viktor','resources/images/hero/viktor.png'),
(121,'Vladimir','resources/images/hero/vladimir.png'),
(122,'Volibear','resources/images/hero/volibear.png'),
(123,'Warwick','resources/images/hero/warwick.png'),
(124,'Wukong','resources/images/hero/wukong.png'),
(125,'Xerath','resources/images/hero/xerath.png'),
(126,'Xin Zhao','resources/images/hero/xin-zhao.png'),
(127,'Yasuo','resources/images/hero/yasuo.png'),
(128,'Yorick','resources/images/hero/yorick.png'),
(129,'Zac','resources/images/hero/zac.png'),
(130,'Zed','resources/images/hero/zed.png'),
(131,'Ziggs','resources/images/hero/ziggs.png'),
(132,'Zilean','resources/images/hero/zilean.png'),
(133,'Zyra','resources/images/hero/zyra.png'),
(134,'Garen','resources/images/hero/garen.png');

/*Table structure for table `hero_role` */

DROP TABLE IF EXISTS `hero_role`;

CREATE TABLE `hero_role` (
  `hero` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  KEY `role` (`role`),
  KEY `hero` (`hero`),
  CONSTRAINT `hero_role_ibfk_2` FOREIGN KEY (`role`) REFERENCES `role` (`id`),
  CONSTRAINT `hero_role_ibfk_3` FOREIGN KEY (`hero`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `hero_role` */

insert  into `hero_role`(`hero`,`role`) values 
(1,2),
(1,7),
(2,1),
(2,4),
(3,1),
(4,7),
(4,6),
(5,7),
(5,4),
(5,3),
(5,3),
(6,4),
(7,4),
(7,6),
(8,5),
(9,4),
(10,4),
(11,6),
(11,4),
(12,6),
(12,7),
(12,2),
(13,4),
(13,6),
(14,2),
(14,6),
(14,7),
(15,5),
(16,2),
(16,3),
(16,7),
(17,4),
(18,2),
(18,4),
(18,7),
(19,5),
(20,2),
(20,7),
(21,3),
(21,4),
(22,7),
(22,2),
(23,5),
(24,1),
(24,2),
(24,4),
(25,4),
(25,3),
(26,3),
(26,1),
(27,5),
(28,4),
(28,3),
(29,2),
(29,1),
(30,1),
(30,2),
(30,4),
(31,4),
(31,7),
(32,2),
(32,2),
(134,7),
(134,2),
(33,2),
(33,7),
(35,5),
(35,3),
(36,3),
(36,2),
(37,4),
(38,2),
(38,7),
(39,1),
(39,2),
(40,3),
(40,6),
(40,4),
(41,6),
(42,2),
(42,3),
(43,2),
(44,2),
(45,5),
(46,5),
(47,5),
(48,4),
(48,6),
(49,4),
(50,1),
(50,4),
(51,1),
(52,2),
(52,6),
(53,4),
(54,1),
(54,3),
(55,3),
(55,5),
(56,2),
(56,7),
(57,5),
(58,1),
(58,4),
(59,2),
(59,3),
(60,6),
(60,7),
(61,4),
(62,5),
(63,6),
(63,6),
(64,4),
(65,7),
(66,4),
(67,7),
(67,2),
(68,1),
(68,2),
(69,5),
(70,2),
(71,4),
(71,6),
(72,6),
(73,2),
(73,7),
(74,2),
(74,3),
(74,6),
(74,7),
(75,2),
(75,3),
(75,1),
(76,2),
(76,3),
(77,2),
(78,2),
(79,4),
(80,1),
(80,2),
(81,7),
(81,2),
(82,5),
(83,3),
(83,7),
(84,3),
(84,2),
(85,2),
(86,1),
(86,3),
(86,1),
(87,2),
(88,4),
(89,4),
(90,7),
(90,3),
(91,1),
(91,3),
(92,7),
(92,2),
(93,2),
(93,3),
(94,2),
(94,7),
(95,2),
(95,7),
(96,5),
(97,2),
(97,3),
(98,6),
(99,6),
(100,4),
(101,4),
(102,2),
(102,6),
(102,7),
(103,4),
(103,6),
(104,1),
(104,2),
(105,6),
(105,7),
(106,1),
(106,5),
(107,6),
(107,7),
(108,5),
(109,2),
(110,2),
(111,4),
(111,1),
(112,5),
(113,2),
(113,3),
(114,2),
(114,5),
(115,5),
(116,5),
(117,4),
(118,4),
(119,2),
(119,3),
(120,4),
(121,4),
(122,2),
(122,3),
(123,2),
(123,3),
(124,2),
(125,4),
(126,2),
(126,2),
(127,1),
(127,2),
(128,2),
(129,7),
(129,2),
(129,2),
(130,1),
(130,2),
(131,4),
(132,6),
(132,4),
(133,4),
(133,6);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `text` text COLLATE utf8_bin NOT NULL,
  `pass_to_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `news` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values 
(1,'assasin'),
(2,'fighter'),
(3,'jungler'),
(4,'mage'),
(5,'marksman'),
(6,'support'),
(7,'tank');

/*Table structure for table `topics_heroes` */

DROP TABLE IF EXISTS `topics_heroes`;

CREATE TABLE `topics_heroes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `text` varchar(50) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `hero` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hero` (`hero`),
  KEY `user` (`user`),
  CONSTRAINT `topics_heroes_ibfk_1` FOREIGN KEY (`hero`) REFERENCES `hero` (`id`),
  CONSTRAINT `topics_heroes_ibfk_2` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `topics_heroes` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) COLLATE utf8_bin NOT NULL,
  `login` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `second_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `pass_to_picture` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`role`,`login`,`password`,`name`,`second_name`,`mail`,`pass_to_picture`) values 
(2,'ADMIN','olfourd','041292','Олег','Гомза','olfourd@gmail.com','blabla');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
