-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mapskills
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alternative`
--

LOCK TABLES `alternative` WRITE;
/*!40000 ALTER TABLE `alternative` DISABLE KEYS */;
INSERT INTO `alternative` VALUES (1,'Me tornar presidente desta Rede.',6,1),(2,'Abrir minha propria franquia.',4,1),(3,'Planejo continuar gerenciando esta pizzaria.',3,1),(4,'Usar as experiências adquiridas aqui para abrir o próprio negócio',0,1),(5,'Deixar os sabores mais simples, porém aumentar a quantidade de recheio.',0,2),(6,'Fazer uma pesquisa local entre os cidadãos locais.',4,2),(7,'Seguir o padrão da concorrencia.',2,2),(8,'Usar o feedback dos clientes para decidir.',0,2),(9,'Renegociar os preços com os fornecedores.',1,3),(10,'Pesquisar novos fornecedores de nível superior',6,3),(11,'Pesquisar fornecedores mais baratas.',3,3),(12,'Diminuir tamanho da pizza',3,3),(13,'Contrata um atendente experiente, para suprir a demanda e coordenar a equipe.',0,4),(14,'Faz um programa de treinamento, supervisionado pessoalmente.',3,4),(15,'Discutir o problema pessoalmente com cada atendente.',2,4),(16,'Implementar um sistema de cotas de vendas diárias com bonificação.',4,4),(17,'Contratar mais um motoboy.',1,5),(18,'Aumentar o tempo de entrega.',2,5),(19,'Comprar outra moto mais potente.',2,5),(20,'Agilizar a cozinha dando o tempo necessário ao motoboy.',3,5),(21,'(Cutuca)Não é bom dormir em serviço.',3,6),(22,'(Bate na mesa)Não quero que isso se repita.',2,6),(23,'Cutuca o funcionário.',3,6),(24,'Acorde, vá dormir na sua casa, quero que venha trabalhar direito amanhã',6,6),(25,'Criar um serviço de entregas online.',5,7),(26,'Criar promoções para pedidos específicos.',4,7),(27,'Baratear o preço da entrega.',0,7),(28,'Aumentar os preços.',1,7),(29,'Observar a situação a distância',1,8),(30,'Perguntar o que está acontecendo',3,8),(31,'Pedir para outro funcionário verificar a situação',2,8),(32,'Ignora e vai tratar de outro assunto',1,8),(33,'Desculpe senhor, gostaria de trocar a pizza?',3,9),(34,'Por favor senhor, poderia sair da fila, podemos conversar em outro lugar.',5,9),(35,'(chama um funcionário) tente resolver isso para mim.',4,9),(36,'Desculpe senhor, o que podemos fazer para nos desculpar.',5,9),(37,'Manter a posição e continuar investindo no projeto',6,10),(38,'Reduzir o orçamento do projeto',0,10),(39,'Abortar o projeto',3,10),(40,'Postergar o projeto',2,10),(41,'Teu aumento já está agendado para uma data futura, no momento isto é inviável.',1,11),(42,'Talvez em uma data futura possamos negociar um aumento mais condizente com a situação da empresa.',1,11),(43,'Me desculpe, mas não será possível com a situação atual da empresa.',6,11),(44,'As últimas mudanças na empresa tornaram difícil a entrega de tal beneficio sem um planejamento prévio.',5,11),(45,'Compre mais ingredientes, vamos improvisar até você chegar!',0,12),(46,'Digam que vamos servir as sobremesas (é o que ainda está com uma boa quantidade)',2,12),(47,'Vamos improvisar com o que temos mesmo.',5,12),(48,'Peça para os fornecedores trazerem os ingredientes o mais rápido possivel!',3,12),(49,'Vamos abaixar o preço das pizzas',3,13),(50,'Vamos dominar a entrega de pizzas, fazendo promoções acima de preço X',5,13),(51,'Extras para quem comprar pizzas por um tempo predeterminado.',0,13),(52,'Contratar um serviço de publicidade.',3,13),(53,'Planeje as entrevistas para o sábado às 15h',0,14),(54,'Espalhe pela cidade informações sobre as vagas de emprego, conforme chegarem faremos as entrevistas',2,14),(55,'Coloque no panfleto: marquem hora para as entrevistas',4,14),(56,'Marque no panfleto que estarei esperando entrevistas às 15h todos os dias.',5,14),(57,'Ampliar a área física do estoque reduzindo a área de lazer dos funcionários',6,15),(58,'Criar um estoque secundário externo a instalação principal.',1,15),(59,'Comprar ingredientes de acordo com a sua rotatividade para diminuir espaço físico ocupado',4,15),(60,'Chamar os fornecedores duas vezes por dia',3,15),(61,'Coloco mais recheio nas pizzas',6,16),(62,'Diminui o preço da pizza por um tempo para ter menos prejuízo.',0,16),(63,'Aumenta o tamanho da pizza por um tempo.',1,16),(64,'Promoção! Ganhe um brotinho na compra de uma pizza grande.',5,16),(65,'(Sussurro no telefone) Façam o possível, agora estou em uma reunião.(desliga o telefone)<br /> Parece que houve um assalto na pizzaria, providencias estão sendo tomadas',3,17),(66,'(Sussurra no telefone) Depois eu cubro as despezas',2,17),(67,'(Sussurra no telefone) Façam o B.O., depois da reunião eu resolvo o resto<br />(Continua a reuniao...)',2,17),(68,'Parece que houve um assalto na pizzaria, Tenho que fazer o B.O. o mais rápido possivel. Podemos remarcar a Reunião?',2,17),(69,'Vou contratar seguranças para que não se repita.',1,18),(70,'Instalarei cameras por todas as partes.',0,18),(71,'Colocarei alarmes.',4,18),(72,'Vou incrementar a segurança com tudo possivel, cameras, alarmes e seguranças.',5,18),(73,'Aproveitaremos o ocorrido para fazer reformas que ajudarão na segurança de todos.',4,19),(74,'De jeito nenhum, nossa equipe estará a serviço assim que forem feitas reformas.',3,19),(75,'Após um breve descanso da equipe, voltaremos com força total.',4,19),(76,'Não necessariamente.',2,19),(77,'Aviso: reforma, voltamos em breve.',2,20),(78,'Fechado para reforma.',5,20),(79,'Retornamos em breve.',6,20),(80,'REFORMA! voltamos dia X.',3,20),(81,'Reuniao geral)- Mostrar a todos as mudanças implementadas.',1,21),(82,'Avisar a todos que o bandido está preso.',3,21),(83,'O que acham das Alterações?',0,21),(84,'(Fingir que nada aconteceu)',2,21),(85,'Implementar trabalho transacional de 3 dias para se adequar aos poucos a rotina.',2,22),(86,'(Acompanha-lo e auxilia-lo de perto algumas horas por dia.)',5,22),(87,'(Dá um descanço para ele.)',1,22),(88,'(Pedir para que ele se recomponha.)',2,22),(89,'Comprar materiais novos para o(a) sucessor(a).',3,23),(90,'Deixar o dinheiro como fundo emergencial para a pizzaria.',4,23),(91,'Pagar alguem para fazer um relatorio completo sobre o periodo.',5,23),(92,'Continuar na rotina normal, e entregar um relatorio padrão.',6,23),(93,'Organiza a equipe para receber o novo gerente.',2,24),(94,'Deixa uma lista de afazeres preparada para o sucessor.',1,24),(95,'Se foca no dia a dia para manter a pizzaria funcionando normalmente até a sucessão.',4,24),(96,'Deixa todo o ambiente pronto para a sucessão sozinho, para evitar despedidas.',2,24),(97,'Os funcionários estavam completamente desfocados sem ninguem no comando.',5,25),(98,'Não havia administração competente dos recursos.',0,25),(99,'Mau aproveitamento do espaço e dá equipe.',1,25),(100,'Acomodação dos funcionários.',0,25);
/*!40000 ALTER TABLE `alternative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'050','Logistica','NOTURNO','146'),(2,'060','Estruturas Leves','NOTURNO','146'),(3,'070','Manutenção de Aeronaves','NOTURNO','146');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `game_theme`
--

LOCK TABLES `game_theme` WRITE;
/*!40000 ALTER TABLE `game_theme` DISABLE KEYS */;
INSERT INTO `game_theme` VALUES (1,'PIZZARIA','\0');
/*!40000 ALTER TABLE `game_theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES (1,'146','56381708000194','Jessen Vidal','São José',0);
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mentor`
--

LOCK TABLES `mentor` WRITE;
/*!40000 ALTER TABLE `mentor` DISABLE KEYS */;
INSERT INTO `mentor` VALUES (2,'146',NULL);
/*!40000 ALTER TABLE `mentor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'ADMINISTRATOR'),(2,'MENTOR'),(3,'STUDENT');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (3,1),(23,1),(4,2),(6,2),(19,2),(20,2),(1,3),(7,3),(18,3),(5,4),(10,4),(11,4),(13,4),(14,4),(16,4),(21,4),(24,4),(8,5),(12,5),(17,5),(22,5),(25,5),(2,6),(9,6),(15,6);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `scene`
--

LOCK TABLES `scene` WRITE;
/*!40000 ALTER TABLE `scene` DISABLE KEYS */;
INSERT INTO `scene` VALUES (1,0,'sente-se.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(2,1,'Me diga!<br /> O que planeja daqui a 3 anos?','http://localhost:8585/mapskills/images/scene1.jpg',1,1),(3,2,'Hum... Interessante<br/>(o grupo conversa entre si)<br />Você é exatamente o tipo de pessoa que precisamos no momento. O cargo de Gerente é seu. Você pode começar amanhã mesmo.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(4,3,'Bom dia, você deve ser o novo gerente.<br /> Estamos com um problema, nossas receitas não estão agradando muitos clientes, precisamos fazer algo.','http://localhost:8585/mapskills/images/scene3.jpg',1,NULL),(5,4,'Você tem alguma ideia de o que podemos fazer?','http://localhost:8585/mapskills/images/scene3.jpg',1,2),(6,5,'Realmente isso deve resolver o problema.','http://localhost:8585/mapskills/images/scene3.jpg',1,NULL),(7,6,'Mas também precisaremos comprar mais ingredientes, e temos um pequeno problema com isso tambem. A verba não está muito grande e precisamos fazer algo.','http://localhost:8585/mapskills/images/scene4.jpg',1,NULL),(8,7,'Estes são os fornecedores disponíveis. o que deseja fazer?','http://localhost:8585/mapskills/images/scene4.jpg',1,3),(9,8,'Ok, já liguei para estes, pela manha os ingredientes devem chegar.','http://localhost:8585/mapskills/images/scene4.jpg',1,NULL),(10,9,'parece que as pizzas voltaram a vender como antes, mas nossa equipe de atendentes é muito inexperiente.','http://localhost:8585/mapskills/images/scene5.jpg',1,NULL),(11,10,'o que planeja fazer a respeito?','http://localhost:8585/mapskills/images/scene6.jpg',1,4),(12,11,'OK. Vamos por em pratica imediatamente.','http://localhost:8585/mapskills/images/scene6.jpg',1,NULL),(13,12,'parece que temos um probleminha com as entregas.<br /> elas estão chegando muito atrasadas.','http://localhost:8585/mapskills/images/scene7.jpg',1,NULL),(14,13,'Mas é por culpa dessa moto que fica dando problema toda hora! <br /> temos que dar um jeito nisso.','http://localhost:8585/mapskills/images/scene7.jpg',1,5),(15,14,'Opa! beleza, isso deve ajudar muito.<br /> daqui a pouco eu volto, tenho entregas a fazer!','http://localhost:8585/mapskills/images/scene7.jpg',1,NULL),(16,15,'(você vê um funcionário dormindo durante o expediente)','http://localhost:8585/mapskills/images/scene8.jpg',1,NULL),(17,16,'(você vê um funcionário dormindo durante o expediente)','http://localhost:8585/mapskills/images/scene8.jpg',1,6),(18,17,'Hein?!.... Me desculpe chefe','http://localhost:8585/mapskills/images/scene9.jpg',1,NULL),(19,18,'hey! ta vendo o que ta acontecendo?<br /> parece que a crise economica está bem complicada.<br /> isso é ruim pros negócios, crise é igual a menos clientes. e agora?','http://localhost:8585/mapskills/images/scene10.jpg',1,NULL),(20,19,'Chefe! não vimos você por aqui, o conselho superior ligou alertando sobre a crise.<br /> querem que você tome alguma atitude preventiva...','http://localhost:8585/mapskills/images/scene11.jpg',1,7),(21,20,'imediatamente!','http://localhost:8585/mapskills/images/scene11.jpg',1,NULL),(22,21,'QUE PORCARIA É ESSA!? Eu não vou comer isso aqui!<br />Mas senhor, é exatamente o que você pediu.','http://localhost:8585/mapskills/images/scene12.jpg',1,NULL),(23,22,'(O que fazer?)','http://localhost:8585/mapskills/images/scene12.jpg',1,8),(24,23,'EU QUERO FALAR COM O GERENTE! AGORA!','http://localhost:8585/mapskills/images/scene12.jpg',1,NULL),(25,24,'AI ESTÁ VOCÊ!!<br /> PODE ME DIZER O QUE É ISSO?<br />ISSO NÃO É MUÇARELA! A VERDADEIRA MUÇARELA DE BÚFALA NÃO SE COMPARA COM ESTA PORCARIA<BR /> NÃO VOU PAGAR POR UMA PIZZA HORRIVEL DESSAS.','http://localhost:8585/mapskills/images/scene13.jpg',1,NULL),(26,25,'TENTE SABOREAR UM POUCO ESTA PORCARIA. Eae? gostou?','http://localhost:8585/mapskills/images/scene14.jpg',1,9),(27,26,'Humpf... to vendo que não vai sair nada de bom daqui, eu vou embora.','http://localhost:8585/mapskills/images/scene14.jpg',1,NULL),(28,27,'Os investimentos recentes não estão dando retorno, e ainda por cima, as despezas tem aumentado.','http://localhost:8585/mapskills/images/scene15.jpg',1,NULL),(29,28,'Tem certeza que é uma boa ideia manter o projeto em andamento?','http://localhost:8585/mapskills/images/scene15.jpg',1,10),(30,29,'Certo,','http://localhost:8585/mapskills/images/scene15.jpg',1,NULL),(31,30,'Olá chefe. Sabe estive pensando um pouco e meio que..... estou precisando de um aumento.','http://localhost:8585/mapskills/images/scene16.jpg',1,NULL),(32,31,'Será que é possivel?','http://localhost:8585/mapskills/images/scene16.jpg',1,11),(33,32,'Entendo, desculpe por te incomodar.','http://localhost:8585/mapskills/images/scene16.jpg',1,NULL),(34,33,'Hey chefe, A demanda está muito grande! Os ingredientes estão acabando!','http://localhost:8585/mapskills/images/scene18.jpg',1,NULL),(35,34,'O que faremos?!','http://localhost:8585/mapskills/images/scene18.jpg',1,12),(36,35,'Uffa, essa foi por pouco hein.','http://localhost:8585/mapskills/images/scene18.jpg',1,NULL),(37,36,'Parece que abriu uma nova pizzaria na vizinhança?<br /> talvez seja por isso que as vendas tem caído.','http://localhost:8585/mapskills/images/scene19.jpg',1,NULL),(38,37,'se não fizermos nada, pode ser que eles comprometam nosso crescimento.<br /> Tem algum plano?','http://localhost:8585/mapskills/images/scene19.jpg',1,13),(39,38,'Está certo! vamos mostrar do que somos capazes!','http://localhost:8585/mapskills/images/scene19.jpg',1,NULL),(40,39,'Os clientes estão voltando. A demanda está maior do que nunca, mas agora são muitos pedidos de entrega, e durante os horários de pico, não estamos dando conta.','http://localhost:8585/mapskills/images/scene20.jpg',1,NULL),(41,40,'(a necessidade de mais funcionários é inegável, mas quando fazer as entrevistas?)','http://localhost:8585/mapskills/images/scene20.jpg',1,14),(42,41,'Certo, colocarei avisos pela cidade.(A nova equipe começara o mais rápido possivel)','http://localhost:8585/mapskills/images/scene20.jpg',1,NULL),(43,42,'Nunca imaginei que diria isso, mas nosso estoque está pequeno demais para suportar a quantidade de ingredientes que usamos semanalmente.','http://localhost:8585/mapskills/images/scene22.jpg',1,NULL),(44,43,'Vamos deixar do jeito que está? ou faremos alguma modificação local?','http://localhost:8585/mapskills/images/scene22.jpg',1,15),(45,44,'Vamos ver o que podemos fazer então','http://localhost:8585/mapskills/images/scene22.jpg',1,NULL),(46,45,'Mas o que vamos fazer com esse excesso de igredientes que temos no momento?','http://localhost:8585/mapskills/images/scene22.jpg',1,NULL),(47,46,'Eles vão perecer logo.','http://localhost:8585/mapskills/images/scene22.jpg',1,16),(48,47,'E não é que é uma otima ideia!','http://localhost:8585/mapskills/images/scene22.jpg',1,NULL),(49,48,'Ouvimos muita coisa da....<br />(celular toca com o número de emergência.)<br />Pode atender.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(50,49,'(Atende) TEMOS UM PROBLEMA SERIO, ACABAMOS DE SER ASSALTADOS. O pessoal está em choque, o que devemos fazer agora?','http://localhost:8585/mapskills/images/scene23.jpg',1,17),(51,50,'Certo!<br />Remarcaremos a reunião para uma data futura.<br />deixe o relatório e discutiremos sobre ele na proxima reunião.','http://localhost:8585/mapskills/images/scene23.jpg',1,NULL),(52,51,'(chegando no serviço, você vê o local bem destruido  e a equipe toda de cabeça baixa)<br /> Eis que aparece um Policial: Jovem, me disseram que é a pessoa responsavel por este local.<br /> Estamos fazendo tudo o possivel para achar o ladrão.','http://localhost:8585/mapskills/images/scene24.jpg',1,NULL),(53,52,'Mas aconcelhamos aumentar a segurança do local.','http://localhost:8585/mapskills/images/scene25.jpg',1,18),(54,53,'Certo, Vamos te atualizar sobre o caso assim que possível.','http://localhost:8585/mapskills/images/scene24.jpg',1,NULL),(55,54,'Olá, sou reporter do Jornal X.<br /> Já conversei com seus funcionários, mas será que poderia me responder uma pergunta?','http://localhost:8585/mapskills/images/scene26.jpg',1,NULL),(56,55,'A sua pizzaria se tornou a mais popular na região. mas você acha que o incidente pode acarretar algum problema para os negocios?','http://localhost:8585/mapskills/images/scene26.jpg',1,19),(57,56,'Muito obrigado pela breve entrevista, retornarei em breve.','http://localhost:8585/mapskills/images/scene26.jpg',1,NULL),(58,57,'Aproveitando a destruição, o estabelecimento terá uma reconstrução.','http://localhost:8585/mapskills/images/scene27.jpg',1,NULL),(59,58,'Que mensegem deixaremos para os clientes até que voltemos?','http://localhost:8585/mapskills/images/scene27.jpg',1,20),(60,59,'Pronto! já está tudo em ordem','http://localhost:8585/mapskills/images/scene27.jpg',1,NULL),(61,60,'(Você recebe a informação de que o ladrão foi preso.)<br /> Mas ao voltar o funcionamento da pizzaria, você percebe que a equipe não está muito animada.','http://localhost:8585/mapskills/images/scene28.jpg',1,NULL),(62,61,'(como evitar o desanimo geral?)','http://localhost:8585/mapskills/images/scene28.jpg',1,21),(63,62,'A equipe entende seu esforço, e tenta melhorar o humor','http://localhost:8585/mapskills/images/scene28.jpg',1,NULL),(64,63,'O atendente que estava sendo feito de refém durante o assalto não está tendo um bom rendimento.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(65,64,'Ao ver esta situação, você...','http://localhost:8585/mapskills/images/scene1.jpg',1,22),(66,65,'Obrigado.(O atendende muda sua postura.  e em alguns dias ele) Desculpe!, vou me concentrar mais.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(67,66,'Parabens! sua filial foi considerada a de maior rendimento este mês, mesmo com os contratempos<br />apresentados. Mas lembre-se, seu contrato acaba no final do mês que vem.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(68,67,'Estamos aumentando o seu orçamento para que faça os preparativos. Use bem estes recursos.','http://localhost:8585/mapskills/images/scene1.jpg',1,23),(69,68,'Aguardaremos o relatório no final do período.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(70,69,'Está preocupado com alguma coisa? Você não parece estar muito bem.','http://localhost:8585/mapskills/images/scene20.jpg',1,NULL),(71,70,'(ninguem está ciente de sua saida)Precisa de alguma coisa?','http://localhost:8585/mapskills/images/scene20.jpg',1,24),(72,71,'Pode contar conosco sempre que precisar. Afinal somos amigos.','http://localhost:8585/mapskills/images/scene20.jpg',1,NULL),(73,72,'Bom dia. Parece que hoje é o dia da sucessão.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL),(74,73,'Quais foram as dificuldades enfrentadas durante estes 6 meses?','http://localhost:8585/mapskills/images/scene1.jpg',1,25),(75,74,'Foi bom trabalhar contigo, Obrigado por seu serviço.','http://localhost:8585/mapskills/images/scene1.jpg',1,NULL);
/*!40000 ALTER TABLE `scene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Visão do futuro','Avalia projeção de perspectiva.'),(2,'Comunicação','Avalia dicção dos assuntos em grupo.'),(3,'Gestão do tempo','Avaliação a situação sob pressão no trabalho.'),(4,'Equilibrio emocional','Avalia o comportamento em situação de stress.'),(5,'Trabalho em equipe','Avalia a gestão do trablho em equipe.'),(6,'Resiliencia','Avalia a facilidade de se adaptar às mudanças.');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (3,'1460501713000','1289003400','\0','050','146');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `student_question_event`
--

LOCK TABLES `student_question_event` WRITE;
/*!40000 ALTER TABLE `student_question_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_question_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'AdministradorCPS','admin@cps.sp.gov.br','$2a$10$q9jtl3BMIBxnpPZJm1hy5.7xDwKgUlfL93c0CbrzagZZUpyfRncVC',1),(2,'Mentor','mentor@fatec.sp.gov.br','$2a$10$wEaMddZtyZp5Kkj/MpObjeCkYNoPFdoNwMKzxLuD7KjCyB63kf6Yy',2),(3,'Student User','aluno@fatec.sp.gov.br','$2a$10$MfkKiDmLJohCjQ45Kb7vnOAeALBR1SV0OTqkkB6IfcMDA87iOrgmG',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-13  2:46:24
