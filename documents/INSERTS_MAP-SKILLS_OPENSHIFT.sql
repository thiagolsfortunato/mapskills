-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mapSKILLs
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
-- Dumping data for table `ADMINISTRATOR`
--

LOCK TABLES `ADMINISTRATOR` WRITE;
/*!40000 ALTER TABLE `ADMINISTRATOR` DISABLE KEYS */;
INSERT INTO `ADMINISTRATOR` VALUES (1);
/*!40000 ALTER TABLE `ADMINISTRATOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ALTERNATIVE`
--

LOCK TABLES `ALTERNATIVE` WRITE;
/*!40000 ALTER TABLE `ALTERNATIVE` DISABLE KEYS */;
INSERT INTO `ALTERNATIVE` VALUES (1,'Me tornar presidente desta Rede.',3,1),(2,'Abrir minha propria franquia.',2,1),(3,'Planejo continuar gerenciando esta pizzaria.',1,1),(4,'Usar as experiências adquiridas aqui para abrir o próprio negócio.',4,1),(5,'Deixar os sabores mais simples, porém aumentar a quantidade de recheio.',1,2),(6,'Fazer uma pesquisa local entre os cidadãos locais.',3,2),(7,'Seguir o padrão da concorrencia.',2,2),(8,'Usar o feedback dos clientes para decidir.',4,2),(9,'Renegociar os preços com os fornecedores.',3,3),(10,'Pesquisar novos fornecedores de nível superior.',4,3),(11,'Pesquisar fornecedores mais baratas.',2,3),(12,'Diminuir tamanho da pizza.',1,3),(13,'Contrata um atendente experiente, para suprir a demanda e coordenar a equipe.',3,4),(14,'Faz um programa de treinamento, supervisionado pessoalmente.',4,4),(15,'Discutir o problema pessoalmente com cada atendente.',2,4),(16,'Implementar um sistema de cotas de vendas diárias com bonificação.',1,4),(17,'Contratar mais um motoboy.',3,5),(18,'Aumentar o tempo de entrega.',1,5),(19,'Comprar outra moto mais potente.',4,5),(20,'Agilizar a cozinha dando o tempo necessário ao motoboy.',2,5),(21,'(Cutuca)Não é bom dormir em serviço.',4,6),(22,'(Bate na mesa)Não quero que isso se repita.',3,6),(23,'Cutuca o funcionário.',2,6),(24,'Acorde, vá dormir na sua casa, quero que venha trabalhar direito amanhã.',1,6),(25,'Criar um serviço de entregas online.',4,7),(26,'Criar promoções para pedidos específicos.',3,7),(27,'Baratear o preço da entrega.',2,7),(28,'Aumentar os preços.',1,7),(29,'Observar a situação a distância.',0,8),(30,'Perguntar o que está acontecendo.',0,8),(31,'Pedir para outro funcionário verificar a situação.',0,8),(32,'Ignora e vai tratar de outro assunto.',0,8),(33,'Desculpe senhor, gostaria de trocar a pizza?.',1,9),(34,'Por favor senhor, poderia sair da fila, podemos conversar em outro lugar.',2,9),(35,'(chama um funcionário) tente resolver isso para mim.',3,9),(36,'Desculpe senhor, o que podemos fazer para nos desculpar.',4,9),(37,'Manter a posição e continuar investindo no projeto.',4,10),(38,'Reduzir o orçamento do projeto.',3,10),(39,'Abortar o projeto.',1,10),(40,'Postergar o projeto.',2,10),(41,'Teu aumento já está agendado para uma data futura, no momento isto é inviável.',3,11),(42,'Talvez em uma data futura possamos negociar um aumento mais condizente com a situação da empresa.',2,11),(43,'Me desculpe, mas não será possível com a situação atual da empresa.',1,11),(44,'As últimas mudanças na empresa tornaram difícil a entrega de tal beneficio sem um planejamento prévio.',4,11),(45,'Compre mais ingredientes, vamos improvisar até você chegar!',4,12),(46,'Digam que vamos servir as sobremesas (é o que ainda está com uma boa quantidade)',3,12),(47,'Vamos improvisar com o que temos mesmo.',1,12),(48,'Peça para os fornecedores trazerem os ingredientes o mais rápido possivel!',2,12),(49,'Vamos abaixar o preço das pizzas.',2,13),(50,'Vamos dominar a entrega de pizzas, fazendo promoções acima de preço X.',4,13),(51,'Extras para quem comprar pizzas por um tempo predeterminado.',1,13),(52,'Contratar um serviço de publicidade.',3,13),(53,'Planeje as entrevistas para o sábado às 15h.',3,14),(54,'Espalhe pela cidade informações sobre as vagas de emprego, conforme chegarem faremos as entrevistas.',2,14),(55,'Coloque no panfleto: marquem hora para as entrevistas.',1,14),(56,'Marque no panfleto que estarei esperando entrevistas às 15h todos os dias.',4,14),(57,'Ampliar a área física do estoque reduzindo a área de lazer dos funcionários.',2,15),(58,'Criar um estoque secundário externo a instalação principal.',4,15),(59,'Comprar ingredientes de acordo com a sua rotatividade para diminuir espaço físico ocupado.',3,15),(60,'Chamar os fornecedores duas vezes por dia.',1,15),(61,'Coloco mais recheio nas pizzas.',3,16),(62,'Diminui o preço da pizza por um tempo para ter menos prejuízo.',4,16),(63,'Aumenta o tamanho da pizza por um tempo.',3,16),(64,'Promoção! Ganhe um brotinho na compra de uma pizza grande.',1,16),(65,'(Sussurro no telefone) Façam o possível, agora estou em uma reunião.(desliga o telefone)\\n Parece que houve um assalto na pizzaria, providencias estão sendo tomadas.',2,17),(66,'(Sussurra no telefone) Depois eu cubro as despezas.',1,17),(67,'(Sussurra no telefone) Façam o B.O., depois da reunião eu resolvo o resto\\n(Continua a reuniao...)',4,17),(68,'Parece que houve um assalto na pizzaria, Tenho que fazer o B.O. o mais rápido possivel. Podemos remarcar a Reunião?',3,17),(69,'Vou contratar seguranças para que não se repita.',4,18),(70,'Instalarei cameras por todas as partes.',3,18),(71,'Colocarei alarmes.',2,18),(72,'Vou incrementar a segurança com tudo possivel, cameras, alarmes e seguranças.',1,18),(73,'Aproveitaremos o ocorrido para fazer reformas que ajudarão na segurança de todos.',4,19),(74,'De jeito nenhum, nossa equipe estará a serviço assim que forem feitas reformas.',3,19),(75,'Após um breve descanso da equipe, voltaremos com força total.',2,19),(76,'Não necessariamente.',1,19),(77,'Aviso: reforma, voltamos em breve.',3,20),(78,'Fechado para reforma.',2,20),(79,'Retornamos em breve.',1,20),(80,'REFORMA! voltamos dia X.',4,20),(81,'Reuniao geral)- Mostrar a todos as mudanças implementadas.',3,21),(82,'Avisar a todos que o bandido está preso.',2,21),(83,'O que acham das Alterações?',1,21),(84,'(Fingir que nada aconteceu)',4,21),(85,'Implementar trabalho transacional de 3 dias para se adequar aos poucos a rotina.',3,22),(86,'(Acompanha-lo e auxilia-lo de perto algumas horas por dia.)',4,22),(87,'(Dá um descanço para ele.)',2,22),(88,'(Pedir para que ele se recomponha.)',1,22),(89,'Comprar materiais novos para o(a) sucessor(a).',3,23),(90,'Deixar o dinheiro como fundo emergencial para a pizzaria.',4,23),(91,'Pagar alguem para fazer um relatorio completo sobre o periodo.',2,23),(92,'Continuar na rotina normal, e entregar um relatorio padrão.',1,23),(93,'Organiza a equipe para receber o novo gerente.',4,24),(94,'Deixa uma lista de afazeres preparada para o sucessor.',3,24),(95,'Se foca no dia a dia para manter a pizzaria funcionando normalmente até a sucessão.',1,24),(96,'Deixa todo o ambiente pronto para a sucessão sozinho, para evitar despedidas.',1,24),(97,'Os funcionários estavam completamente desfocados sem ninguem no comando.',3,25),(98,'Não havia administração competente dos recursos.',4,25),(99,'Mau aproveitamento do espaço e dá equipe.',2,25),(100,'Acomodação dos funcionários.',1,25);
/*!40000 ALTER TABLE `ALTERNATIVE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `COURSE`
--

LOCK TABLES `COURSE` WRITE;
/*!40000 ALTER TABLE `COURSE` DISABLE KEYS */;
INSERT INTO `COURSE` VALUES (1,'048','Tecnologia em Análise e Desenvolvimento de Sistemas','NOTURNO','146'),(2,'114','Tecnologia em Automação Manufatura Digital','MATUTINO','146'),(3,'028','Tecnologia em Banco de Dados','NOTURNO','146'),(4,'077','Tecnologia em Gestão da Produção Industrial','NOTURNO','146'),(5,'064','Tecnologia em Gestão Empresarial','EaD','146'),(6,'074','Tecnologia em Logística','NOTURNO','146'),(7,'068','Tecnologia em Manutenção de Aeronaves','NOTURNO','146'),(8,'115','Tecnologia em Projetos de Estruturas Aeronáuticas','NOTURNO','146');
/*!40000 ALTER TABLE `COURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `GAME_THEME`
--

LOCK TABLES `GAME_THEME` WRITE;
/*!40000 ALTER TABLE `GAME_THEME` DISABLE KEYS */;
INSERT INTO `GAME_THEME` VALUES (1,'GERÊNCIA DE PIZZARIA','\0');
/*!40000 ALTER TABLE `GAME_THEME` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `INSTITUTION`
--

LOCK TABLES `INSTITUTION` WRITE;
/*!40000 ALTER TABLE `INSTITUTION` DISABLE KEYS */;
INSERT INTO `INSTITUTION` VALUES (1,'146','56381708000194','Jessen Vidal','São José','SUPERIOR',0);
/*!40000 ALTER TABLE `INSTITUTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `MENTOR`
--

LOCK TABLES `MENTOR` WRITE;
/*!40000 ALTER TABLE `MENTOR` DISABLE KEYS */;
INSERT INTO `MENTOR` VALUES (2,'146',NULL);
/*!40000 ALTER TABLE `MENTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `PROFILE`
--

LOCK TABLES `PROFILE` WRITE;
/*!40000 ALTER TABLE `PROFILE` DISABLE KEYS */;
INSERT INTO `PROFILE` VALUES (1,'ADMINISTRATOR'),(2,'MENTOR'),(3,'STUDENT');
/*!40000 ALTER TABLE `PROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `QUESTION`
--

LOCK TABLES `QUESTION` WRITE;
/*!40000 ALTER TABLE `QUESTION` DISABLE KEYS */;
INSERT INTO `QUESTION` VALUES (16,1),(1,2),(6,2),(8,2),(15,2),(17,2),(20,2),(22,2),(5,3),(11,3),(12,3),(13,4),(18,4),(21,4),(25,4),(4,5),(7,5),(10,5),(19,5),(2,6),(3,6),(9,6),(14,6),(23,6),(24,6);
/*!40000 ALTER TABLE `QUESTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `SCENE`
--

LOCK TABLES `SCENE` WRITE;
/*!40000 ALTER TABLE `SCENE` DISABLE KEYS */;
INSERT INTO `SCENE` VALUES (1,0,'sente-se.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(2,1,'Me diga!\\n O que planeja daqui a 3 anos?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,1),(3,2,'Hum... Interessante<br/>(o grupo conversa entre si)\\nVocê é exatamente o tipo de pessoa que precisamos no momento. O cargo de Gerente é seu. Você pode começar amanhã mesmo.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(4,3,'Bom dia, você deve ser o novo gerente.\\n Estamos com um problema, nossas receitas não estão agradando muitos clientes, precisamos fazer algo.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE03.jpg',1,NULL),(5,4,'Você tem alguma ideia de o que podemos fazer?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE03.jpg',1,2),(6,5,'Realmente isso deve resolver o problema.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE03.jpg',1,NULL),(7,6,'Mas também precisaremos comprar mais ingredientes, e temos um pequeno problema com isso tambem. A verba não está muito grande e precisamos fazer algo.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE04.jpg',1,NULL),(8,7,'Estes são os fornecedores disponíveis. o que deseja fazer?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE04.jpg',1,3),(9,8,'Ok, já liguei para estes, pela manha os ingredientes devem chegar.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE04.jpg',1,NULL),(10,9,'parece que as pizzas voltaram a vender como antes, mas nossa equipe de atendentes é muito inexperiente.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE05.jpg',1,NULL),(11,10,'o que planeja fazer a respeito?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE06.jpg',1,4),(12,11,'OK. Vamos por em pratica imediatamente.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE06.jpg',1,NULL),(13,12,'parece que temos um probleminha com as entregas.\\n elas estão chegando muito atrasadas.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE07.jpg',1,NULL),(14,13,'Mas é por culpa dessa moto que fica dando problema toda hora! \\n temos que dar um jeito nisso.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE07.jpg',1,5),(15,14,'Opa! beleza, isso deve ajudar muito.\\n daqui a pouco eu volto, tenho entregas a fazer!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE07.jpg',1,NULL),(16,15,'(você vê um funcionário dormindo durante o expediente)','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE08.jpg',1,NULL),(17,16,'(você vê um funcionário dormindo durante o expediente)','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE08.jpg',1,6),(18,17,'Hein?!.... Me desculpe chefe','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE09.jpg',1,NULL),(19,18,'hey! ta vendo o que ta acontecendo?\\n parece que a crise economica está bem complicada.\\n isso é ruim pros negócios, crise é igual a menos clientes. e agora?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE10.jpg',1,NULL),(20,19,'Chefe! não vimos você por aqui, o conselho superior ligou alertando sobre a crise.\\n querem que você tome alguma atitude preventiva...','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE11.jpg',1,7),(21,20,'imediatamente!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE11.jpg',1,NULL),(22,21,'QUE PORCARIA É ESSA!? Eu não vou comer isso aqui!\\nMas senhor, é exatamente o que você pediu.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE12.jpg',1,NULL),(23,22,'(O que fazer?)','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE12.jpg',1,8),(24,23,'EU QUERO FALAR COM O GERENTE! AGORA!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE12.jpg',1,NULL),(25,24,'AI ESTÁ VOCÊ!!\\n PODE ME DIZER O QUE É ISSO?\\nISSO NÃO É MUÇARELA! A VERDADEIRA MUÇARELA DE BÚFALA NÃO SE COMPARA COM ESTA PORCARIA\\n NÃO VOU PAGAR POR UMA PIZZA HORRIVEL DESSAS.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE13.jpg',1,NULL),(26,25,'TENTE SABOREAR UM POUCO ESTA PORCARIA. Eae? gostou?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE14.jpg',1,9),(27,26,'Humpf... to vendo que não vai sair nada de bom daqui, eu vou embora.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE14.jpg',1,NULL),(28,27,'Os investimentos recentes não estão dando retorno, e ainda por cima, as despezas tem aumentado.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE15.jpg',1,NULL),(29,28,'Tem certeza que é uma boa ideia manter o projeto em andamento?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE15.jpg',1,10),(30,29,'Certo,','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE15.jpg',1,NULL),(31,30,'Olá chefe. Sabe estive pensando um pouco e meio que..... estou precisando de um aumento.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE16.jpg',1,NULL),(32,31,'Será que é possivel?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE16.jpg',1,11),(33,32,'Entendo, desculpe por te incomodar.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE16.jpg',1,NULL),(34,33,'Hey chefe, A demanda está muito grande! Os ingredientes estão acabando!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE18.jpg',1,NULL),(35,34,'O que faremos?!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE18.jpg',1,12),(36,35,'Uffa, essa foi por pouco hein.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE18.jpg',1,NULL),(37,36,'Parece que abriu uma nova pizzaria na vizinhança?\\n talvez seja por isso que as vendas tem caído.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE19.jpg',1,NULL),(38,37,'se não fizermos nada, pode ser que eles comprometam nosso crescimento.\\n Tem algum plano?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE19.jpg',1,13),(39,38,'Está certo! vamos mostrar do que somos capazes!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE19.jpg',1,NULL),(40,39,'Os clientes estão voltando. A demanda está maior do que nunca, mas agora são muitos pedidos de entrega, e durante os horários de pico, não estamos dando conta.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE20.jpg',1,NULL),(41,40,'(a necessidade de mais funcionários é inegável, mas quando fazer as entrevistas?)','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE20.jpg',1,14),(42,41,'Certo, colocarei avisos pela cidade.(A nova equipe começara o mais rápido possivel)','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE20.jpg',1,NULL),(43,42,'Nunca imaginei que diria isso, mas nosso estoque está pequeno demais para suportar a quantidade de ingredientes que usamos semanalmente.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE22.jpg',1,NULL),(44,43,'Vamos deixar do jeito que está? ou faremos alguma modificação local?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE22.jpg',1,15),(45,44,'Vamos ver o que podemos fazer então','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE22.jpg',1,NULL),(46,45,'Mas o que vamos fazer com esse excesso de igredientes que temos no momento?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE22.jpg',1,NULL),(47,46,'Eles vão perecer logo.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE22.jpg',1,16),(48,47,'E não é que é uma otima ideia!','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE22.jpg',1,NULL),(49,48,'Ouvimos muita coisa da....\\n(celular toca com o número de emergência.)\\nPode atender.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(50,49,'(Atende) TEMOS UM PROBLEMA SERIO, ACABAMOS DE SER ASSALTADOS. O pessoal está em choque, o que devemos fazer agora?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE23.jpg',1,17),(51,50,'Certo!\\nRemarcaremos a reunião para uma data futura.\\ndeixe o relatório e discutiremos sobre ele na proxima reunião.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE23.jpg',1,NULL),(52,51,'(chegando no serviço, você vê o local bem destruido  e a equipe toda de cabeça baixa)\\n Eis que aparece um Policial: Jovem, me disseram que é a pessoa responsavel por este local.\\n Estamos fazendo tudo o possivel para achar o ladrão.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE24.jpg',1,NULL),(53,52,'Mas aconcelhamos aumentar a segurança do local.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE25.jpg',1,18),(54,53,'Certo, Vamos te atualizar sobre o caso assim que possível.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE24.jpg',1,NULL),(55,54,'Olá, sou reporter do Jornal X.\\n Já conversei com seus funcionários, mas será que poderia me responder uma pergunta?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE26.jpg',1,NULL),(56,55,'A sua pizzaria se tornou a mais popular na região. mas você acha que o incidente pode acarretar algum problema para os negocios?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE26.jpg',1,19),(57,56,'Muito obrigado pela breve entrevista, retornarei em breve.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE26.jpg',1,NULL),(58,57,'Aproveitando a destruição, o estabelecimento terá uma reconstrução.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE27.jpg',1,NULL),(59,58,'Que mensegem deixaremos para os clientes até que voltemos?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE27.jpg',1,20),(60,59,'Pronto! já está tudo em ordem','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE27.jpg',1,NULL),(61,60,'(Você recebe a informação de que o ladrão foi preso.)\\n Mas ao voltar o funcionamento da pizzaria, você percebe que a equipe não está muito animada.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE28.jpg',1,NULL),(62,61,'(como evitar o desanimo geral?)','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE28.jpg',1,21),(63,62,'A equipe entende seu esforço, e tenta melhorar o humor','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE28.jpg',1,NULL),(64,63,'O atendente que estava sendo feito de refém durante o assalto não está tendo um bom rendimento.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(65,64,'Ao ver esta situação, você...','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,22),(66,65,'Obrigado.(O atendende muda sua postura.  e em alguns dias ele) Desculpe!, vou me concentrar mais.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(67,66,'Parabens! sua filial foi considerada a de maior rendimento este mês, mesmo com os contratempos\\napresentados. Mas lembre-se, seu contrato acaba no final do mês que vem.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(68,67,'Estamos aumentando o seu orçamento para que faça os preparativos. Use bem estes recursos.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,23),(69,68,'Aguardaremos o relatório no final do período.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(70,69,'Está preocupado com alguma coisa? Você não parece estar muito bem.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE20.jpg',1,NULL),(71,70,'(ninguem está ciente de sua saida)Precisa de alguma coisa?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE20.jpg',1,24),(72,71,'Pode contar conosco sempre que precisar. Afinal somos amigos.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE20.jpg',1,NULL),(73,72,'Bom dia. Parece que hoje é o dia da sucessão.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL),(74,73,'Quais foram as dificuldades enfrentadas durante estes 6 meses?','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,25),(75,74,'Foi bom trabalhar contigo, Obrigado por seu serviço.','http://mapSKILLsserver-inacio.rhcloud.com/mapSKILLs/images/SCENE01.jpg',1,NULL);
/*!40000 ALTER TABLE `SCENE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `SKILL`
--

LOCK TABLES `SKILL` WRITE;
/*!40000 ALTER TABLE `SKILL` DISABLE KEYS */;
INSERT INTO `SKILL` VALUES (1,'Visão do futuro','Avalia projeção de perspectiva.'),(2,'Comunicação','Avalia dicção dos assuntos em grupo.'),(3,'Gestão do tempo','Avaliação a situação sob pressão no trabalho.'),(4,'Equilibrio emocional','Avalia o comportamento em situação de stress.'),(5,'Trabalho em equipe','Avalia a gestão do trablho em equipe.'),(6,'Resiliência','Avalia a facilidade de se adaptar às mudanças.');
/*!40000 ALTER TABLE `SKILL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `STUDENT`
--

LOCK TABLES `STUDENT` WRITE;
/*!40000 ALTER TABLE `STUDENT` DISABLE KEYS */;
INSERT INTO `STUDENT` VALUES (3,'1460481713000','1289003400','\0','048','146');
/*!40000 ALTER TABLE `STUDENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `STUDENT_QUESTION_EVENT`
--

LOCK TABLES `STUDENT_QUESTION_EVENT` WRITE;
/*!40000 ALTER TABLE `STUDENT_QUESTION_EVENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `STUDENT_QUESTION_EVENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'AdministradorCPS','admin@cps.sp.gov.br','$2a$10$q9jtl3BMIBxnpPZJm1hy5.7xDwKgUlfL93c0CbrzagZZUpyfRncVC',1),(2,'MENTOR','MENTOR@fatec.sp.gov.br','$2a$10$wEaMddZtyZp5Kkj/MpObjeCkYNoPFdoNwMKzxLuD7KjCyB63kf6Yy',2),(3,'STUDENT USER','aluno@fatec.sp.gov.br','$2a$10$MfkKiDmLJohCjQ45Kb7vnOAeALBR1SV0OTqkkB6IfcMDA87iOrgmG',3);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-26 17:00:31
