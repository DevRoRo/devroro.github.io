import dgram from 'node:dgram';
import fs from 'fs';

const PORTA = 10000;
const PONTOS_VITORIA = 30;

class Jogador {
    constructor(nome, rinfo) {
        this.nome = nome;
        this.pontos = 0;
        this.rinfo = rinfo;
        this.resposta = null;
        this.tempoResposta = null;
    }

    ganharPontos(qtdPontos) {
        this.pontos += qtdPontos;
    }

    resetResposta() {
        this.resposta = null;
        this.tempoResposta = null;
    }
}

class ServidorBattleQuiz {
    constructor() {
        this.server = dgram.createSocket('udp4');
        this.jogadores = [];
        this.perguntas = [];
        this.perguntasUsadas = [];
        this.rodadaAtual = 0;
        this.aguardandoRespostas = false;
        this.respostasRecebidas = 0;
    }

    iniciar() {
        const rawData = fs.readFileSync('perguntas.json');
        this.perguntas = JSON.parse(rawData);

        this.server.on('error', (err) => {
            console.error('Erro no servidor:', err);
            this.server.close();
        });

        this.server.on('message', (msg, rinfo) => {
            this.processarMensagem(msg.toString().trim(), rinfo);
        });

        this.server.on('listening', () => {
            const address = this.server.address();
            console.log('      SERVIDOR BATTLE QUIZ - Duelo de Conhecimento');
            console.log(`Servidor escutando em ${address.address}:${address.port}`);
            console.log('Aguardando 2 jogadores...\n');
        });

        this.server.bind(PORTA);
    }

    processarMensagem(msg, rinfo) {
        if (this.jogadores.length === 2) {
            const jogador = this.jogadores.find(j =>
                j.rinfo.address === rinfo.address && j.rinfo.port === rinfo.port
            );

            if (jogador && this.aguardandoRespostas) {
                // Processar resposta do jogo
                if (msg.startsWith('RESPOSTA-')) {
                    if (!jogador.resposta) {
                        jogador.resposta = msg.split('-')[1];
                        jogador.tempoResposta = Date.now();
                        this.respostasRecebidas++;
                        var tempoResposta = new Date(jogador.tempoResposta).toISOString()
                        console.log(`${jogador.nome} respondeu: ${jogador.resposta}\n tempo de resposta: ${tempoResposta}`);

                        if (this.respostasRecebidas === 2) {
                            this.avaliarRespostas();
                        }
                    }
                } else if (msg === 'SIM' || msg === 'NAO') {
                    // Resposta para nova partida
                    jogador.respostaNovaPartida = msg;

                    if (this.jogadores[0].respostaNovaPartida && this.jogadores[1].respostaNovaPartida) {
                        if (this.jogadores[0].respostaNovaPartida === 'SIM' &&
                            this.jogadores[1].respostaNovaPartida === 'SIM') {
                            this.reiniciarJogo();
                        } else {
                            this.encerrarServidor();
                        }
                    }
                }
            }
            return;
        }

        // Cadastrar jogador
        if (this.jogadores.length < 2) {
            const jogador = new Jogador(msg, rinfo);
            this.jogadores.push(jogador);

            const msgBoasVindas = `Cliente Aceito para o BATTLE QUIZ! Bem-vindo, ${jogador.nome}!`;
            this.enviarMensagem(msgBoasVindas, rinfo);
            console.log(`✓ Jogador ${this.jogadores.length}: ${jogador.nome} conectado`);

            if (this.jogadores.length === 2) {
                setTimeout(() => this.iniciarPartida(), 1000);
            }
        }
    }

    enviarMensagem(mensagem, rinfo) {
        this.server.send(mensagem, rinfo.port, rinfo.address);
    }

    iniciarPartida() {
        console.log(`      PARTIDA: ${this.jogadores[0].nome} VS ${this.jogadores[1].nome}`);

        this.perguntasUsadas = [];
        this.rodadaAtual = 0;

        const msgInicio = `\n BATTLE QUIZ INICIADO! \nVocê vai enfrentar: ${this.jogadores[0].nome === this.jogadores[0].nome ? this.jogadores[1].nome : this.jogadores[0].nome}\nPrimeiro a fazer 30 pontos vence!\n`;
        
        this.jogadores.forEach(j => {
            const oponente = this.jogadores.find(oponente => oponente !== j);
            this.enviarMensagem(msgInicio.replace(this.jogadores[1].nome, oponente.nome), j.rinfo);
        });

        setTimeout(() => this.proximaRodada(), 2000);
    }

    proximaRodada() {
        this.rodadaAtual++;
        this.respostasRecebidas = 0;
        this.jogadores.forEach(j => j.resetResposta());

        // Verificar se ainda há perguntas
        if (this.perguntasUsadas.length >= this.perguntas.length) {
            console.log('Todas as perguntas foram utilizadas!');
            this.finalizarJogo();
            return;
        }

        // Sortear pergunta
        let perguntaSorteada;
        do {
            const indice = Math.floor(Math.random() * this.perguntas.length);
            perguntaSorteada = this.perguntas[indice]; //pega o elemento json
        } while (this.perguntasUsadas.includes(perguntaSorteada.pergunta)); //pega a tag pergunta dentro do elemento json

        this.perguntasUsadas.push(perguntaSorteada.pergunta);
        this.perguntaAtual = perguntaSorteada;

        console.log(`\n--- RODADA ${this.rodadaAtual} ---`);
        console.log(`Pergunta: ${perguntaSorteada.pergunta.split('\n')[0]}`);
        console.log(`Resposta correta: ${perguntaSorteada.resposta}`);

        const mensagemPergunta = `\n RODADA ${this.rodadaAtual}\n${perguntaSorteada.pergunta}\n\nResponda com: A, B ou C`;

        this.jogadores.forEach(j => {
            this.enviarMensagem(mensagemPergunta, j.rinfo);
        });

        this.aguardandoRespostas = true;
    }

    avaliarRespostas() {
        this.aguardandoRespostas = false;

        const j1 = this.jogadores[0];
        const j2 = this.jogadores[1];
        const respostaCorreta = this.perguntaAtual.resposta;

        const j1Acertou = j1.resposta === respostaCorreta;
        const j2Acertou = j2.resposta === respostaCorreta;
        const j1Primeiro = j1.tempoResposta < j2.tempoResposta;

        let resultado = '';
        
        if (j1Acertou && j2Acertou) {
            // Ambos acertaram - quem respondeu primeiro ganha
            if (j1Primeiro) {
                j1.ganharPontos(5);
                resultado = `${j1.nome} acertou primeiro! +5 pontos`;
            } else {
                j2.ganharPontos(5);
                resultado = `${j2.nome} acertou primeiro! +5 pontos`;
            }
        } else if (j1Acertou && !j2Acertou) {
            
            var pontos;

            if(j1Primeiro) {
                pontos = 5
            } else {
                pontos = 3
            }

            j1.ganharPontos(pontos);
            resultado = `${j1.nome} acertou! +${pontos} pontos`;
            
        } else if (!j1Acertou && j2Acertou) {
            
            var pontos
            
            if (j1Primeiro) {
                pontos = 3
            } else {
                pontos = 5
            }

            j2.ganharPontos(5);
            resultado = `${j2.nome} acertou! +${pontos} pontos`;
        } else if (!j1Acertou && !j2Acertou) {
            // Ambos erraram
            resultado = 'Ambos erraram! Ninguém pontua.';
        }

        console.log(`Resultado: ${resultado}`);

        const placar = `\n${resultado}\nResposta correta: ${respostaCorreta}\n\n PLACAR:\n${j1.nome}: ${j1.pontos} pontos\n${j2.nome}: ${j2.pontos} pontos\n`;

        this.jogadores.forEach(j => {
            this.enviarMensagem(placar, j.rinfo);
        });

        // Verificar vitória
        if (j1.pontos >= PONTOS_VITORIA || j2.pontos >= PONTOS_VITORIA) {
            setTimeout(() => this.finalizarJogo(), 2000);
        } else {
            setTimeout(() => this.proximaRodada(), 3000);
        }
    }

    finalizarJogo() {
        const vencedor = this.jogadores[0].pontos > this.jogadores[1].pontos ? this.jogadores[0] : this.jogadores[1];
        
        console.log(`       VENCEDOR: ${vencedor.nome} `);

        const msgFinal = `\n FIM DE JOGO! \n\nVENCEDOR: ${vencedor.nome} com ${vencedor.pontos} pontos!\n\nPLACAR FINAL:\n${this.jogadores[0].nome}: ${this.jogadores[0].pontos} pontos\n${this.jogadores[1].nome}: ${this.jogadores[1].pontos} pontos\n\nDeseja jogar novamente? (Responda: SIM ou NAO)`;

        this.jogadores.forEach(j => {
            j.respostaNovaPartida = null;
            this.enviarMensagem(msgFinal, j.rinfo);
        });

        this.aguardandoRespostas = true;
    }

    reiniciarJogo() {
        console.log('\n Reiniciando jogo...\n');
        
        this.jogadores.forEach(j => {
            j.pontos = 0;
            j.resetResposta();
            j.respostaNovaPartida = null;
        });

        this.iniciarPartida();
    }

    encerrarServidor() {
        console.log('\nEncerrando servidor...');
        
        const msgDespedida = '\nObrigado por jogar Battle Quiz! Até a próxima!';
        this.jogadores.forEach(j => {
            this.enviarMensagem(msgDespedida, j.rinfo);
        });

        setTimeout(() => {
            this.server.close();
            console.log('Servidor encerrado.');
            process.exit(0);
        }, 1000);
    }
}

// Iniciar servidor
const servidor = new ServidorBattleQuiz();
servidor.iniciar();