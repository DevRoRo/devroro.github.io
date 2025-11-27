import dgram from 'node:dgram';
import readline from 'node:readline';

const PORTA_SERVIDOR = 10000;
const ENDERECO_SERVIDOR = 'localhost'; // Mude para o IP do servidor se necessário

class ClienteBattleQuiz {
    constructor() {
        this.client = dgram.createSocket('udp4');
        this.rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout,
        });
        this.conectado = false;
        this.emJogo = false;
    }

    iniciar() {
        console.log('      CLIENTE BATTLE QUIZ - Duelo de Conhecimento');

        this.client.on('error', (err) => {
            console.error('Erro no cliente:', err);
            this.client.close();
            process.exit(1);
        });

        this.client.on('message', (msg, rinfo) => {
            const mensagem = msg.toString();
            console.log(mensagem);

            if (mensagem.includes('Até a próxima')) {
                setTimeout(() => {
                    this.encerrar();
                }, 500);
            } else if (mensagem.includes('Deseja jogar novamente?')) {
                this.perguntarNovaPartida();
            } else if (mensagem.includes('RODADA') && mensagem.includes('Responda com:')) {
                this.aguardarResposta();
            }
        });

        this.solicitarNome();
    }

    enviarMensagem(mensagem) {
        this.client.send(mensagem, PORTA_SERVIDOR, ENDERECO_SERVIDOR);
    }

    solicitarNome() {
        this.rl.question('Digite seu nome (nickname): ', (nome) => {
            if (nome.trim()) {
                console.log(`\nEnviando nickname "${nome}" para o servidor...`);
                this.enviarMensagem(nome.trim());
                this.conectado = true;
            } else {
                console.log('Nome inválido! Tente novamente.');
                this.solicitarNome();
            }
        });
    }

    aguardarResposta() {
        this.rl.question('\nSua resposta (A, B ou C): ', (resposta) => {
            const respostaFormatada = resposta.trim().toUpperCase();
            
            if (['A', 'B', 'C'].includes(respostaFormatada)) {
                this.enviarMensagem(`RESPOSTA-${respostaFormatada}`);
                console.log(`✓ Resposta "${respostaFormatada}" enviada!`);
            } else {
                console.log(' Resposta inválida! Use A, B ou C.');
                this.aguardarResposta();
            }
        });
    }

    perguntarNovaPartida() {
        this.rl.question('\nSua resposta (SIM ou NAO): ', (resposta) => {
            const respostaFormatada = resposta.trim().toUpperCase();
            
            if (respostaFormatada === 'SIM' || respostaFormatada === 'NAO') {
                this.enviarMensagem(respostaFormatada);
                console.log(`✓ Resposta enviada: ${respostaFormatada}`);
                
                if (respostaFormatada === 'NAO') {
                    console.log('\nAguardando resposta do outro jogador...');
                }
            } else {
                console.log(' Resposta inválida! Use SIM ou NAO.');
                this.perguntarNovaPartida();
            }
        });
    }

    encerrar() {
        console.log('\n Encerrando cliente...');
        this.rl.close();
        this.client.close();
        process.exit(0);
    }
}

const cliente = new ClienteBattleQuiz();
cliente.iniciar();

