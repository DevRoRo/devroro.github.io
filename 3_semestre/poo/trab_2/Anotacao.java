public class Anotacao {
    

/*                 // Define the opposite color variable
        Cor oppositeCor = (this.getCor() == Cor.PRETO) ? Cor.BRANCO : Cor.PRETO;

        // Define the direction check based on the color of the piece
        boolean validDirection = (this.getCor() == Cor.PRETO) ? (yFinal < yAtual) : (yFinal > yAtual);

        if (validDirection) {
            System.out.println("teste y direction");

            if (this.getCor() == Cor.PRETO && yFinal == yAtual - 1) {
                System.out.println("teste yf = y-1");

                if (xFinal == xAtual) {
                    System.out.println("teste x = x");
                    ehValido = (tabuleiro[yAtual - 1][xAtual].getCor() == Cor.VAZIO);
                } else {
                    System.out.println("teste cor");
                    boolean isEnemyOppositeLeft = (tabuleiro[yAtual - 1][xAtual - 1].getCor() == oppositeCor);
                    boolean isEnemyOppositeRight = (tabuleiro[yAtual - 1][xAtual + 1].getCor() == oppositeCor);

                    if (isEnemyOppositeLeft || isEnemyOppositeRight) {
                        System.out.println("teste inimigo");
                        if (yFinal == yAtual - 1 && (xFinal == xAtual + 1 || xFinal == xAtual - 1)) {
                            System.out.println("teste sobreposicao inimigo");
                            ehValido = true;
                        } else {
                            ehValido = false;
                        }
                    } else {
                        ehValido = false;
                    }
                }
            } else if (this.getCor() == Cor.BRANCO && yFinal == yAtual + 1) {
                System.out.println("teste yf = y+1");

                if (xFinal == xAtual) {
                    System.out.println("teste x = x");
                    ehValido = (tabuleiro[yAtual + 1][xAtual].getCor() == Cor.VAZIO);
                } else {
                    System.out.println("teste cor");
                    boolean isEnemyOppositeLeft = (tabuleiro[yAtual + 1][xAtual - 1].getCor() == oppositeCor);
                    boolean isEnemyOppositeRight = (tabuleiro[yAtual + 1][xAtual + 1].getCor() == oppositeCor);

                    if (isEnemyOppositeLeft || isEnemyOppositeRight) {
                        System.out.println("teste inimigo");
                        if (yFinal == yAtual + 1 && (xFinal == xAtual + 1 || xFinal == xAtual - 1)) {
                            System.out.println("teste sobreposicao inimigo");
                            ehValido = true;
                        } else {
                            ehValido = false;
                        }
                    } else {
                        ehValido = false;
                    }
                }
            } else if (primeiroMovimento) {
                System.out.println("teste primeiro movimento");
                ehValido = (this.getCor() == Cor.PRETO) ? (yFinal >= yAtual - 2) : (yFinal <= yAtual + 2);
            } else {
                ehValido = false;
            }
        } else {
            ehValido = false;
        } */


        /* if (this.getCor() == Cor.PRETO) {
            if (yFinal < yAtual) {
                System.out.println("teste yf < y");
                
                if (yFinal == yAtual - 1) {
                    System.out.println("teste yf = y+1");
                    
                    if (xFinal == xAtual) {
                        System.out.println("teste x = x");
                        ehValido = (tabuleiro[yAtual - 1][xAtual].getCor() == Cor.VAZIO);
                    } else if (this.getCor() == Cor.PRETO) {
                        System.out.println("teste cor");
                        
                        boolean isEnemyWhiteLeft = (tabuleiro[yAtual - 1][xAtual - 1].getCor() == Cor.BRANCO);
                        boolean isEnemyWhiteRight = (tabuleiro[yAtual - 1][xAtual + 1].getCor() == Cor.BRANCO);
                        
                        if (isEnemyWhiteLeft || isEnemyWhiteRight) {
                            System.out.println("teste inimigo");
                            if (yFinal == yAtual - 1 && (xFinal == xAtual + 1 || xFinal == xAtual - 1)) {
                                System.out.println("teste sobreposicao inimigo");
                                ehValido = true;
                            } else {
                                ehValido = false;
                            }
                        } else {
                            ehValido = false;
                        }
                    }
                } else if (primeiroMovimento) {
                    System.out.println("teste primeiro movimento");
                    ehValido = (yFinal >= yAtual - 2);
                } else {
                    ehValido = false;
                }
            } else {
                ehValido = false;
            }
        } else {
            if (yFinal > yAtual) {
                System.out.println("teste yf < y");
                
                if (yFinal == yAtual + 1) {
                    System.out.println("teste yf = y+1");
                    
                    if (xFinal == xAtual) {
                        System.out.println("teste x = x");
                        ehValido = (tabuleiro[yAtual + 1][xAtual].getCor() == Cor.VAZIO);
                    } else if (this.getCor() == Cor.BRANCO) {
                        System.out.println("teste cor");
                        
                        boolean isEnemyWhiteLeft = (tabuleiro[yAtual + 1][xAtual - 1].getCor() == Cor.PRETO);
                        boolean isEnemyWhiteRight = (tabuleiro[yAtual + 1][xAtual + 1].getCor() == Cor.PRETO);
                        
                        if (isEnemyWhiteLeft || isEnemyWhiteRight) {
                            System.out.println("teste inimigo");
                            if (yFinal == yAtual + 1 && (xFinal == xAtual + 1 || xFinal == xAtual - 1)) {
                                System.out.println("teste sobreposicao inimigo");
                                ehValido = true;
                            } else {
                                ehValido = false;
                            }
                        } else {
                            ehValido = false;
                        }
                    }
                } else if (primeiroMovimento) {
                    System.out.println("teste primeiro movimento");
                    ehValido = (yFinal <= yAtual + 2);
                } else {
                    ehValido = false;
                }
            } else {
                ehValido = false;
            }
        } */

        /* if (yFinal < yAtual) {
            System.out.println("teste yf < y");
            if (yFinal == yAtual-1) {
                System.out.println("teste yf = y+1");
                if (xFinal == xAtual) {
                    System.out.println("teste x = x");
                    if (tabuleiro[yAtual-1][xAtual].getCor() == Cor.VAZIO) {
                        ehValido = true;
                    } else {
                        ehValido = false;
                    }          
                } else if (this.getCor() == Cor.PRETO) {
                    System.out.println("teste cor");
                    if (tabuleiro[yAtual-1][xAtual+1].getCor() == Cor.BRANCO|| tabuleiro[yAtual-1][xAtual-1].getCor() == Cor.BRANCO) {
                        System.out.println("teste inimigo");
                        if (yFinal == yAtual-1 && xFinal == xAtual+1) {
                            System.out.println("teste sobreposicao inimigo 1");
                            ehValido = true;
                        } else if (yFinal == yAtual-1 && xFinal == xAtual-1) {
                            System.out.println("teste sobreposicao inimigo 2");
                            ehValido = true;
                        } else {
                            ehValido = false;
                        }
                    } else {
                        ehValido = false;
                    }
                }   
            } else if (primeiroMovimento) {
                System.out.println("teste primeiro movimento");
                if (yFinal >= yAtual-2) {
                    ehValido = true;
                } else {
                    ehValido = false;
                }
            } else {
                ehValido = false;
            }
        } else {
            ehValido = false;
        } */
}
