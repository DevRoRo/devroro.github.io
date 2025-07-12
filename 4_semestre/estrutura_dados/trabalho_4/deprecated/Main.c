#include <stdio.h>
#include "Regras.c"

void toString(Pilha* p, Pilha* p2, Pilha* p3, Pilha* p4, Pilha* p5, Pilha* p6) {
    Pilha* stacks[] = {p, p2, p3, p4};
    int heights[] = {p->qtd, p2->qtd, p3->qtd, p4->qtd};
    int max_height = 4;

    if (p5 != NULL && p6 != NULL) {
        printf("\n| %c |             | %c |\n\n", 
               p5->topo ? p5->topo->cor : ' ', 
               p6->topo ? p6->topo->cor : ' ');
    }

    // Print stacks from top to bottom
    for (int level = 0; level < max_height; level++) {
        for (int i = 0; i < 4; i++) {
            Argola* current = stacks[i]->topo;
            // Move to the correct level (from top)
            int pos_from_top = max_height - level - 1;
            int current_pos = 0;
            
            while (current != NULL && current_pos < pos_from_top) {
                current = current->proximo;
                current_pos++;
            }
            
            if (current != NULL && current_pos == pos_from_top) {
                printf("| %c | ", current->cor);
            } else {
                printf("|   | ");
            }
        }
        printf("\n");
    }
    printf("\n");
}

void displayMenu() {
    printf("\n=== MENU ===\n");
    printf("1. Mover argola\n");
    printf("2. Opcao 2 (vazia)\n");
    printf("3. Opcao 3 (vazia)\n");
    printf("4. Sair\n");
    printf("============\n");
    printf("Escolha uma opcao: ");
}

int main() {
    Pilha* p5 = criaPilha();
    push(p5, criarArgola(' '));
    Pilha* p6 = criaPilha();
    push(p6, criarArgola(' '));
    Pilha* pArray = criarTabuleiro();
    
    int choice;
    int origem, destino;
    int game_won = 0;
    
    do {
        // Display current state
        toString(&pArray[0], &pArray[1], &pArray[2], &pArray[3], p5, p6);
        
        // Check winning condition
        if (verificarVitoria(pArray)) {
            printf("\nPARABENS! VOCE VENCEU!\n");
            printf("Todas as pilhas principais tem 4 argolas da mesma cor!\n");
            game_won = 1;
            break;
        }
        
        displayMenu();
        scanf("%d", &choice);
        
        switch(choice) {
            case 1: // Move argola
                printf("Digite a pilha de origem (1-4, 5-6 para pilhas extras): ");
                scanf("%d", &origem);
                printf("Digite a pilha de destino (1-4, 5-6 para pilhas extras): ");
                scanf("%d", &destino);
                
                // Validate input
                if (origem < 1 || origem > 6 || destino < 1 || destino > 6) {
                    printf("Pilha invalida! Use valores entre 1 e 6.\n");
                    break;
                }
                
                // Get the correct stacks
                Pilha* pilhaOrigem = (origem <= 4) ? &pArray[origem-1] : 
                                    (origem == 5) ? p5 : p6;
                Pilha* pilhaDestino = (destino <= 4) ? &pArray[destino-1] : 
                                    (destino == 5) ? p5 : p6;
                
                // Execute the move
                movimentar(pilhaDestino, pilhaOrigem);
                break;
                
            case 2:
                printf("Opcao 2 selecionada (vazia)\n");
                break;
                
            case 3:
                printf("Opcao 3 selecionada (vazia)\n");
                break;
                
            case 4:
                printf("Saindo...\n");
                break;
                
            default:
                printf("Opcao invalida! Tente novamente.\n");
        }
        
    } while (choice != 4 && !game_won);
    
    return 0;
}