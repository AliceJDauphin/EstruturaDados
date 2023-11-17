package Componentes;

public class Tree {
	public TreeNo root;
	public TreeNo atual;
	
	public Tree() {
		this.root = null;
	}

	public void iniciar(String NomeJog){
		root = new TreeNo(NomeJog + " estava na rua, dai ele ficou com fome", NomeJog + " Estava pensando em chamar o Cornelio", NomeJog + " Foi atrás de comida, sem seu amigo");

		atual = root;

		TreeNo no2 = new TreeNo( NomeJog + " Então, liga para Cornelio, ele  começou a explanar uma história que lhe ocorreu\nCabelo Curto estava atras dele querendo lhe passar a pexeira...",
						"Desliga o telefone, e corre de Cabelo Curto, indo em direção a Cornelio... ", "Luta contra ela...");
		TreeNo no3 = new TreeNo( NomeJog + " você prosseguiu sem seu amigo à procura de algo para papar"
						,"Ir pela praça", "Ir pelo beco da Poeira");
		
		root.createFilhoEsq(no2);
		root.createFilhaDir(no3);

		
		//No2
		TreeNo no4 = new TreeNo( NomeJog + " conseguiu fugir de Cabelo Curto, e continuou falando com Cornelio para ver onde ele estava\nCornelio disse que estava logo atrás de " + NomeJog + "\ncom o carro ULTRA MEGA VELOZ, apelidado de BetoCarreroWORLD bichi bichi(Barulho do chicote)."
				,"Pedir carona para Cornelio","Continuar correndo(Você tem TDAH).");
		TreeNo no5 = new TreeNo("VOCÊ TEVE CORAGEM PARA ENFRENTAR uma louca com uma peixeira, não que você seja normal, até por quê você desejava a peixeira dela, agora você tem duas opções", "Pegar peixeira", "Você deixa para lá a peixeira e pega seu dedo do meio, agora você tem o poder do f*da-se.");
		
		no5.Event = 'E';
		no5.EventAux = 2;
		
		
		no2.createFilhoEsq(no4);	
		no2.createFilhaDir(no5);

		//No3
		TreeNo no6 = new TreeNo( NomeJog + " caminhando pela praça você é chamado até a quadra, lá você encontra um cara gigante aspirante a goleiro profissional\ncom o vulgo de MURALHA, Muralha começa a falar com você de forma ignorante(você não entendeu o que ele falou)\nvocê não da muita bola ao que ele fala, e logo que ele termina de falar, você: ", "Você fica de migué, e vai direção ao bar", "Você vai meter 5 bolas pra dentro do MURALHA");
		TreeNo no7 = new TreeNo( NomeJog + " então, decidiu ir pelo Beco da Poeira. Estava vazio e escuro para variar, você percebe algo lá na frente", "Recuar como um covarde", "Ir até o final do beco");

		no3.createFilhoEsq(no6);
		no3.createFilhaDir(no7);

		//No4
		TreeNo no8 = new TreeNo( "Você então pediu uma carona para Cornelio, o mesmo disse que faria por 250 Reais. Você não parece ter essa grana"
					,"Oferecer um aperto de mão", "Oferece um abraço de BROTHER");
		TreeNo no9 = new TreeNo("Você bate a cabeça no poste, e acorda, descobrindo que tudo que se passou foi cronicas da sua esquizofrenia, e que agora tudo voltou ao normal, pois você foi medicado.", "Fim de jogo", "");
		
		no4.createFilhoEsq(no8);
		no4.createFilhaDir(no9);
		
		//No5
		
		TreeNo no10 = new TreeNo("Você então pega a Peixeira, ela fedia a peixe, mas isso não incomodava pois agora Cornelio estava livre daquele monstro", " Relatar para Cornelio sua vitoria", "");
		TreeNo no11 = new TreeNo("Você então ignora aquela arma, e percebe que com suas proprias mãos era possivel conseguir o que deseja", " Relatar para Cornelio sua vitoria", "");
		
		no10.Event = 'I';
		no10.EventAux = 0;
		
		no11.Event = 'I';
		no11.EventAux = 1;
		
		no5.createFilhoEsq(no10);
		no5.createFilhaDir(no11);
		
		//No6
		TreeNo no12 = new TreeNo("Chegando ao bar, você toma todas até passar mal, e desmaia, ao acordar você percebe que o MURALHA está preste a lhe espancar", "VOCÊ FOI ESPANCADO", " Você acorda e acaba descobrindo que tudo que se passou foi cronicas da sua esquizofrenia\nagora que você está medicado percebe que tem um banguela lhe explicando a teoria da relatividade, e ele é semelhante ao Albert Einstein.");
		TreeNo no13 = new TreeNo("Ao golear o Muralha, ele parte para cima de você querendo lhe espancar", "Você corre", "VOCÊ CAI PARA PORRADA");
		
		no6.createFilhoEsq(no12);
		no6.createFilhaDir(no13);
		
		//No7
		TreeNo no14 = new TreeNo("Quando você dá meia volta, se depara com Carlinho, o Ladrão de Motos que roubou a Moto do Cornelio umas semanas atrás, ele pergunta o que faz perdido no Beco da Poeira","Tentar se explicar e sair dali", "falar : [Eu irei descer o K7 em você Carlinhos, pelo que fez ao meu amigo]");
		TreeNo no15 = new TreeNo("Você ignora o Beco escuro e empoeirado e prossegue sua jornada, quando chega no final so se depara com o final do Beco em seu outro lado, não tinha nada a temer", "", "");
		
		no7.createFilhoEsq(no14);
		no7.createFilhaDir(no15);

		//No8

		TreeNo no16 = new TreeNo("Você chega ao Shopping, não tinha muitas opções, mas escolha uma :D", " Ir comer no TaMec Lanches", " Ir no Banheiro");
		TreeNo no17 = new TreeNo("Cornelio acha ofensivo isso, pois o mesmo so aceita contato de Mulheres 0800, ele revela a sua real forma.... Cornelio, O cafetão", "Tentar acalmar Cornelio", "");

		no8.createFilhoEsq(no16);
		no8.createFilhaDir(no17);

		//No9 ( VAZIO )

		//No10 e No 11

		TreeNo no20 = new TreeNo("Você então corre para a casa de Cornelio para comemorar a vitoria contra Cabelo Curto\nao chegar em sua casa, percebe um grande movimento no seu quarto\nNão dava pra acreditar, Cornelio e sua Esposa estavam tendo um Vukt Vukt Slep Slep em sua propria casa\nNão dava pra acreditar que seu melhor amigo fez isso", "Jurar vingança ao Cornelio", "Se juntar ao Vukt Vukt Slep Slep");

		no10.createFilhaDir(no20);
		no10.createFilhoEsq(no20);

		no11.createFilhaDir(no20);
		no11.createFilhoEsq(no20);

		//No12 (Vazio)


		//No13

		TreeNo no26 = new TreeNo("Você sai correndo do Muralha, não foi uma boa ideia derrotar ele, o mesmo não sabia perder\nEntão " + NomeJog , "Correu para o Shopping", "Tentou escalar uma Arvore");
		TreeNo no27 = new TreeNo( "Após derrotar o Muralha, ele afirma que ninguem consegue derrotar Muralha\nO mesmo então se transforma numa bola, deixando um Hamburgão no chão", "Pegar Hamburgão", "");

		no27.Event = 'E';
		no27.EventAux = 1;

		no13.createFilhoEsq(no26);
		no13.createFilhaDir(no27);

		//No14

		TreeNo no28 = new TreeNo("Carlinhos não se importa com o que você diz e parte pra Capoeira", "Se defender", "Gritar :{Vamos Dançar}");

		no14.createFilhoEsq(no28);
		no14.createFilhaDir(no28);

		//No16

		TreeNo no38 = new TreeNo("Chegando no TaMec lanches, você pede um Hamburgão\nMas lá ja não havia nada, pois Muralha, um Goleiro local, havia comido todos", "Pedir fritas", "Ir ao Banheiro");
		TreeNo no39 = new TreeNo( "Chegando no banheiro, você se depara com uma coisa terrivel, a PREGUIÇA\nPreguiçosamente a criadora dessa historia decide\nPôr o fim de sua jornada da forma mais\nPorca possivel, não tendo nada que o jogador possa fazer", "Poh cara", "Jogue denovo para ter mais finais :)");

		no16.createFilhoEsq(no38);
		no16.createFilhaDir(no39);

		//No17
		TreeNo no34 = new TreeNo("\nVocê então consegue derrota-lo, Parece que alguem esteve realmente entretido\nVendo todas as Alternativas, ou pelo menos encontrando a melhor\n\nVocê Ganhou o Game :D","","");

		no34.Event = 'E';
		no34.EventAux = 4;

		no17.createFilhoEsq(no34);
		no17.createFilhaDir(no34);

		//No20

		TreeNo no40 = new TreeNo("Cornelio gargalha de seu juramento, e lhe chama pra Capoeira\nNão tem muito o que fazer....\nMelhor estar preparado","Ah...", "Vamo nessa");

		no40.Event = 'E';
		no40.EventAux = 4;

		no20.createFilhaDir(no17);
		no20.createFilhoEsq(no40);

		//No26


		TreeNo no53 = new TreeNo("Você então, tenta subir numa ávore, mas acaba caindo\nCom sua queda, Muralha literalmente cai de gargalhar\nMas em cima de você, foi tragico..." ,"","");

		no26.createFilhoEsq(no16);
		no26.createFilhaDir(no53);
		//No27

		TreeNo no54 = new TreeNo("Você então coleta o Hamburgão no chão, lembrando que estava faminto\ntalvez seja uma boa ideia comer-lo", "Come o Hamburgão", "COME LOGO >:C");

		no54.Event = 'I';
		no54.EventAux = 2;

		no27.createFilhoEsq(no54);
		no27.createFilhaDir(no54);

		//No28

		TreeNo no56 = new TreeNo( "Você derrota Carlinhos, ele então pede piedade", "Roubar Ladrão (alias isso não seria crime certo ??)", "Da um beijinho na sua careca e vazar");

		no56.Event = 'E';
		no56.EventAux = 3;

		no28.createFilhoEsq(no56);
		no28.createFilhaDir(no56);

		//No38

		TreeNo no74 = new TreeNo("Você então lembra daquele TikTok, daonde pedir fritas sem sal\nForça os funcionários de refazer a remessa inteira\nIndignado e sabendo de seu plano, o funcionário decidiu lhe dar uma fritas 'especial'\nQuando você come as fritas, elas estavam tão quentes, que você derrete lá mesmo\nQuem diria que uma batata quente poderia lhe causar isso","Batata quente", "Quente Quente Quente Quente Quente Quente Quente Quente Quente Quente Quente Quente Quente Quente Queimou");

		no38.createFilhoEsq(no74);
		no38.createFilhaDir(no39);

		//No40



		//No54

		no54.createFilhaDir(no2);
		no54.createFilhoEsq(no2);

		//No56

		TreeNo no112 = new TreeNo("Você então leva o Capacete e Havaianas do Carlinhos\ndeixando ele completamente indefeso no Beco da Poeira\nChefe é Chefe né pai ", "Sair dali e ir à praça", "Ir mais à fundo do beco");
		TreeNo no113 = new TreeNo("Você então dalhe um beijinho em sua testa, isso lembra Carlinhos de sua infância\nO mesmo começa a chorar e fica la", "Ir para mais fundo do Beco", "Você é muito forte, confio em você :)");

		no112.Event = 'I';
		no112.EventAux = 3;

		no56.createFilhoEsq(no112);
		no56.createFilhaDir(no113);


		//No112

		TreeNo no224 = new TreeNo("Você se sente o Fodão. Após derrotas Carlinhos, imagina que nada seria capaz de lhe deter\nIndo mais à fundo do beco, você se depara com outro Ladrão de motos\nO mesmo muito mais agressivo e realmente armado\nAcho melhor não detalhar o que vem pra frente","Sério, não tem o que fazer", "Sua cabeça seria capaz de parar um tiro ?");

		no112.createFilhoEsq(no6);
		no112.createFilhaDir(no224);
		//No113

		no113.createFilhoEsq(no224);
		no113.createFilhaDir(no224);
	}

	public void goLeft(){
		atual = atual.getFilhoEsq();
	}

	public void goRight(){
		atual = atual.getFilhaDir();
	}
	public boolean GameOver(){
		if(atual == null){
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
}
