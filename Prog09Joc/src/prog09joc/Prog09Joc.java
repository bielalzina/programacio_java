/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog09joc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gabriel
 */
public class Prog09Joc {
// Atributs

    private String[][] tauler = new String[5][5];
    private static final String[] idColumna = {"A", "B", "C", "D", "E"};
    private static final int[] idFila = {1, 2, 3, 4, 5};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Prog09Joc partida = new Prog09Joc();
        Fitxa fb = null;
        Fitxa fn = null;
        Casella posFB = null;
        Casella posFN = null;
        Casella posFBPossible = null;
        Casella posFNPossible = null;
        Casella posBloc = null;
        String fitxaBlanca = null;
        String fitxaNegra = null;
        String idFitxaBlanca = null;
        String idFitxaNegra = null;
        String idFitxaBlancaOcupaBloc = null;
        String idFitxaNegraOcupaBloc = null;
        String idCasellaBloc = "\u001B[41;34mX\u001B[0m";
        String filaBlanca = null;
        String columnaBlanca = null;
        String filaNegra = null;
        String columnaNegra = null;
        String filaBloc = null;
        String columnaBloc = null;
        String videsTorre = null;
        int indexFilaBlanca = -1;
        int indexColumnaBlanca = -1;
        int indexFilaNegra = -1;
        int indexColumnaNegra = -1;
        int indexFilaBloc = -1;
        int indexColumnaBloc = -1;

        System.out.println("*****************");
        System.out.println("* JOC DE FITXES *");
        System.out.println("*****************");

        // Demanam a l'usuari quina serà la fitxa blanca
        do {
            fitxaBlanca = lecturaTeclat("\nQUINA ÉS LA FITXA BLANCA: TORRE (T) ALFIL (A): ");
            if (fitxaBlanca.equals("T") || fitxaBlanca.equals("t")) {

                //TORRE BLANCA
                fitxaBlanca = "torre";
                fb = new Torre();
                fb.setColor("b");
                idFitxaBlanca = "\u2656";

                //ALFIL NEGRE
                fitxaNegra = "alfil";
                fn = new Alfil();
                fn.setColor("n");
                idFitxaNegra = "\u265D";
                idFitxaNegraOcupaBloc = "\u001B[41;34m" + idFitxaNegra + "\u001B[0m";

            } else if (fitxaBlanca.equals("A") || fitxaBlanca.equals("a")) {

                //ALFIL BLANC
                fitxaBlanca = "alfil";
                fb = new Alfil();
                fb.setColor("b");
                idFitxaBlanca = "\u2657";
                idFitxaBlancaOcupaBloc = "\u001B[41;34m" + idFitxaBlanca + "\u001B[0m";

                //TORRE NEGRE
                fitxaNegra = "torre";
                fn = new Torre();
                fn.setColor("n");
                idFitxaNegra = "\u265C";

            } else {
                fitxaBlanca = "X";
            }

        } while (fitxaBlanca.equals("X"));

        System.out.print("\n");

        System.out.println("\u001B[34mLA FITXA BLANCA ÉS: " + fitxaBlanca.toUpperCase() + ". ES REPRESENTADA EN EL TAULER AMB LA FIGURA: \u001B[0m" + idFitxaBlanca);
        System.out.println("\u001B[34mLA FITXA NEGRA ÉS: " + fitxaNegra.toUpperCase() + ". ES REPRESENTADA EN EL TAULER AMB LA FIGURA: \u001B[0m" + idFitxaNegra);
        System.out.print("\n");

        // Emplenam el tauler amb valors inicials (zeros)
        partida.emplenaTauler();

        // Demanam a l'usuari quina serà la posicio de la fitxa blanca
        System.out.println("ARA CAL DEFINIR LA POSICIÓ INICIAL DE LA FITXA BLANCA (" + fitxaBlanca.toUpperCase() + ")");
        System.out.println("HAS D'INDICAR LA FILA (1, 2, 3, 4 o 5) I LA COLUMNA (A, B, C, D, o E)");
        System.out.println("EN EL TAULER, LES CASELLES BUIDES S'IDENTIFIQUEN AMB EL CARACTER (·) ");
        System.out.print("\n");

        partida.mostraTauler();

        do {
            filaBlanca = lecturaTeclat("\nFILA INICIAL PER A " + idFitxaBlanca + ": ");

            boolean filaOK;

            filaOK = partida.validaFila(filaBlanca);

            if (!filaOK) {
                filaBlanca = "X";
            } else {
                indexFilaBlanca = Integer.parseInt(filaBlanca) - 1;
            }

        } while (filaBlanca.equals("X"));

        do {
            columnaBlanca = lecturaTeclat("\nCOLUMNA INICIAL PER A " + idFitxaBlanca + ": ");

            boolean columnaOK;
            columnaOK = partida.validaColumna(columnaBlanca);
            if (!columnaOK) {
                System.out.println("\n" + "\u001B[31mHAS INTRODUIT UNA COLUMNA INCORRECTA!!!!\u001B[0m");
                columnaBlanca = "X";
            } else {
                indexColumnaBlanca = partida.calculaIndexColumna(columnaBlanca);
            }

        } while (columnaBlanca.equals("X"));

        // Declaram valor per posFB
        posFB = new Casella(indexFilaBlanca, indexColumnaBlanca);

        // Set posFB en fb
        fb.setPosicio(posFB);

        // Assignam posicio fitxa blanca en tauler
        partida.insereixPosicio(fb.getPosicio(), idFitxaBlanca);

        // Demanam a l'usuari quina serà la posicio de la fitxa blanca
        System.out.println("ARA CAL DEFINIR LA POSICIÓ INICIAL DE LA FITXA NEGRA (" + fitxaNegra.toUpperCase() + ")");
        System.out.println("HAS D'INDICAR LA FILA (1, 2, 3, 4 o 5) I LA COLUMNA (A, B, C, D, o E)");
        System.out.println("NO POTS ESCOLLIR LA CASELLA OCUPADA PER LA FITXA BLANCA");
        System.out.println("EN EL TAULER, LES CASELLES BUIDES S'IDENTIFIQUEN AMB EL CARACTER (·) ");
        System.out.print("\n");

        partida.mostraTauler();

        boolean posicioOcupada;

        do {
            do {
                filaNegra = lecturaTeclat("\nFILA INICIAL PER A " + idFitxaNegra + ": ");

                boolean filaOK;

                filaOK = partida.validaFila(filaNegra);

                if (!filaOK) {
                    filaNegra = "X";
                } else {
                    indexFilaNegra = Integer.parseInt(filaNegra) - 1;
                }

            } while (filaNegra.equals("X"));
            do {
                columnaNegra = lecturaTeclat("\nCOLUMNA INICIAL PER A " + idFitxaNegra + ": ");

                boolean columnaOK;
                columnaOK = partida.validaColumna(columnaNegra);
                if (!columnaOK) {
                    System.out.println("\n" + "\u001B[31mHAS INTRODUIT UNA COLUMNA INCORRECTA!!!!\u001B[0m");
                    columnaNegra = "X";
                } else {
                    indexColumnaNegra = partida.calculaIndexColumna(columnaNegra);

                }

            } while (columnaNegra.equals("X"));

            // Cal comprovar que no s'introdueixi la casella ocupada per la fitxa blanca
            posicioOcupada = false;

            if (indexFilaNegra == fb.getPosicio().getFila() && indexColumnaNegra == fb.getPosicio().getColumna()) {
                System.out.println("\n" + "\u001B[31mAQUESTA CASELLA ESTÀ OCUPADA PER LA FITXA BLANCA!!!!\u001B[0m");
                posicioOcupada = true;
            }
        } while (posicioOcupada);

        // Declaram valor per posFN
        posFN = new Casella(indexFilaNegra, indexColumnaNegra);

        // Set posFN en fn
        fn.setPosicio(posFN);

        // Assignam posicio fitxa blanca en tauler
        partida.insereixPosicio(fn.getPosicio(), idFitxaNegra);

        partida.mostraTauler();

        // Demanam a l'usuari quina casella bloqueja l'ALFIL
        System.out.println("\nL'ALFIL POT BLOQUEJAR UNA CASELLA, LA QUAL NO PODRA SER OCUPADA PER LA TORRE");
        System.out.println("HAS D'INDICAR LA FILA (1, 2, 3, 4 o 5) I LA COLUMNA (A, B, C, D, o E)");
        System.out.println("NO POTS ESCOLLIR LA CASELLA OCUPADA ACTUALMENT PER LA TORRE");
        System.out.print("\n");
        boolean posicioOcupadaTorre;
        do {
            do {
                filaBloc = lecturaTeclat("\nINDICA LA FILA DE LA CASELLA QUE VOLS BLOQUEJAR: ");
                boolean filaOK;
                filaOK = partida.validaFila(filaBloc);
                if (!filaOK) {
                    filaBloc = "X";
                } else {
                    indexFilaBloc = Integer.parseInt(filaBloc) - 1;
                }
            } while (filaBloc.equals("X"));
            do {
                columnaBloc = lecturaTeclat("\nINDICA LA COLUMNA DE LA CASELLA QUE VOLS BLOQUEJAR: ");
                boolean columnaOK;
                columnaOK = partida.validaColumna(columnaBloc);
                if (!columnaOK) {
                    System.out.println("\n" + "\u001B[31mHAS INTRODUIT UNA COLUMNA INCORRECTA!!!!\u001B[0m");
                    columnaBloc = "X";
                } else {
                    indexColumnaBloc = partida.calculaIndexColumna(columnaBloc);
                }
            } while (columnaBloc.equals("X"));
            // Cal comprovar que no s'introdueixi la casella ocupada per la torre
            posicioOcupadaTorre = false;

            if (fitxaBlanca.equals("torre")) {
                if (indexFilaBloc == fb.getPosicio().getFila() && indexColumnaBloc == fb.getPosicio().getColumna()) {
                    System.out.println("\n" + "\u001B[31mAQUESTA CASELLA ESTÀ OCUPADA PER LA TORRE!!!!\u001B[0m");
                    posicioOcupadaTorre = true;
                }
            } else if (indexFilaBloc == fn.getPosicio().getFila() && indexColumnaBloc == fn.getPosicio().getColumna()) {
                System.out.println("\n" + "\u001B[31mAQUESTA CASELLA ESTÀ OCUPADA PER LA TORRE!!!!\u001B[0m");
                posicioOcupadaTorre = true;
            }

        } while (posicioOcupadaTorre);

        // Declaram valor per posBloc
        posBloc = new Casella(indexFilaBloc, indexColumnaBloc);

        // Set atribut bloc per alfil
        if (fitxaBlanca.equals("alfil")) {
            ((Alfil) fb).setBloc(posBloc);
        } else {
            ((Alfil) fn).setBloc(posBloc);
        }

        // Assignam posicio casella bloquejada en tauler
        if (fitxaBlanca.equals("alfil")) {
            partida.insereixPosicio(((Alfil) fb).getBloc(), idCasellaBloc);
        } else {
            partida.insereixPosicio(((Alfil) fn).getBloc(), idCasellaBloc);
        }

        partida.mostraTauler();

        // Demanam a l'usuari el numero de vides de la TORRE
        System.out.println("\nSI L'ALFIL POT BLOQUEJAR UNA CASELLA, LA TORRE POT DISPOSAR DE n VIDES");
        int numVidesTorre = -1;
        do {
            videsTorre = lecturaTeclat("\nINDICA EL NUMERO SENCER (>=1) DE VIDES ASSIGNAT A LA TORRE: ");
            try {
                numVidesTorre = Integer.parseInt(videsTorre);
                if (numVidesTorre < 1) {
                    System.out.println("\n" + "\u001B[31mHAS INTRODUIT UN NUMERO INCORRECTE DE VIDES!!!!\u001B[0m");
                    videsTorre = "X";
                }
            } catch (Exception e) {
                System.out.println("\n" + "\u001B[31mHAS INTRODUIT UN FORMAT INCORRECTE DE VIDES!!!!\u001B[0m");
                videsTorre = "X";
            }
        } while (videsTorre.equals("X"));

        // Set atribut VIDES per TORRE
        if (fitxaBlanca.equals("torre")) {
            ((Torre) fb).setVides(numVidesTorre);
        } else {
            ((Torre) fn).setVides(numVidesTorre);
        }

        System.out.print("\n");
        System.out.println("********************");
        System.out.println("*\u001B[32m COMENÇAM PARTIDA \u001B[0m*");
        System.out.println("********************");
        System.out.print("\n");

        boolean partidaAcabada = false;
        boolean movimentFBOK;
        boolean movimentFNOK;

        String fitxaGuanyadora = null;

        while (!partidaAcabada) {
            // MOU FITXA BLANCA

            movimentFBOK = false;
            do {
                partida.mostraTauler();
                // FILA FITXA BLANCA
                System.out.println("MOU FITXA BLANCA " + idFitxaBlanca);
                do {
                    filaBlanca = lecturaTeclat("INDICA FILA: ");
                    boolean filaOK;
                    filaOK = partida.validaFila(filaBlanca);
                    if (!filaOK) {
                        filaBlanca = "X";
                    } else {
                        indexFilaBlanca = Integer.parseInt(filaBlanca) - 1;
                    }
                } while (filaBlanca.equals("X"));
                // COLUMNA FITXA BLANCA
                do {
                    columnaBlanca = lecturaTeclat("INDICA COLUMNA: ");
                    boolean columnaOK;
                    columnaOK = partida.validaColumna(columnaBlanca);
                    if (!columnaOK) {
                        System.out.println("\n" + "\u001B[31mHAS INTRODUIT UNA COLUMNA INCORRECTA!!!!\u001B[0m");
                        columnaBlanca = "X";
                    } else {
                        indexColumnaBlanca = partida.calculaIndexColumna(columnaBlanca);
                    }
                } while (columnaBlanca.equals("X"));
                // Declaram possible valor 
                posFBPossible = new Casella(indexFilaBlanca, indexColumnaBlanca);
                // Passam objecte posFBPossible a metode moureA()
                // el qual determinara si el moviment és vàlid
                movimentFBOK = fb.moureA(posFBPossible);
                if (movimentFBOK) {
                    // Un cop comprovat que el moviment és valid, en el cas 
                    // que la fitxa blanca sigui la torre, cal comprovar 
                    // que no ocupi la casella bloqiejada per l'alfil
                    if (fitxaBlanca == "torre") {
                        if (indexFilaBlanca == indexFilaBloc && indexColumnaBlanca == indexColumnaBloc) {
                            //La torre vol ocupar la casella bloquejada, aquest moviment NO es possible 
                            System.out.println("\n" + "\u001B[31mLA TORRE NO POT OCUPAR LA CASELLA BLOQUEJADA PER L'ALFIL!!!!\u001B[0m");
                            movimentFBOK = false;
                        } else {
                            // La torre NO ocupa casella bloquejada
                            // Esborram posicio fitxa blanca (abans moviment) en tauler
                            partida.insereixPosicio(fb.getPosicio(), "·");
                            // Modificam posició en objecte fb
                            fb.setPosicio(posFBPossible);
                            // Assignam nova posicio fitxa blanca en tauler
                            partida.insereixPosicio(fb.getPosicio(), idFitxaBlanca);
                            movimentFBOK = true;
                            // Comprovam si fitxa blanca mata a fitxa negra
                            if (fb.getPosicio().getFila() == fn.getPosicio().getFila() && fb.getPosicio().getColumna() == fn.getPosicio().getColumna()) {
                                partidaAcabada = true;
                                fitxaGuanyadora = "fb";
                            }
                        }
                    } else {
                        // La fitxa blanca es l'alfil, per tant pot ocupar la casella bloquejada
                        // Esborram posicio fitxa blanca (abans moviment) en tauler
                        partida.insereixPosicio(fb.getPosicio(), "·");
                        // Tornam a assignar el valor X a la casella bloquejada
                        // per si l'alfil la va ocupar en el moviment anterior
                        partida.insereixPosicio(((Alfil) fb).getBloc(), idCasellaBloc);
                        // Modificam posició en objecte fb
                        fb.setPosicio(posFBPossible);
                        // Assignam nova posicio fitxa blanca en tauler
                        // Canviam el format de la fitxa a visualitzar en funció
                        // de si ocupa casella bloquetjada o no
                        if (fb.getPosicio().getFila() == ((Alfil) fb).getBloc().getFila()
                                && fb.getPosicio().getColumna() == ((Alfil) fb).getBloc().getColumna()) {
                            partida.insereixPosicio(fb.getPosicio(), idFitxaBlancaOcupaBloc);
                        } else {
                            partida.insereixPosicio(fb.getPosicio(), idFitxaBlanca);
                        }
                        movimentFBOK = true;
                        // Comprovam si fitxa blanca (ALFIL) mata a fitxa negra (TORRE)
                        if (fb.getPosicio().getFila() == fn.getPosicio().getFila() && fb.getPosicio().getColumna() == fn.getPosicio().getColumna()) {
                            //Cal comprovar quantes vides li queden a la torre
                            int videsRestantsTorre;
                            videsRestantsTorre = ((Torre) fn).getVides();
                            if (videsRestantsTorre > 1) {
                                // La partida encara no ha acabat
                                // Restam 1 vida a la torre
                                ((Torre) fn).setVides(videsRestantsTorre - 1);
                                // Resetejam tauler
                                partida.emplenaTauler();
                                // Retornam fitxes blanca i negra a les posicions escollides inicialment
                                // Feim el mateix en tauler
                                fb.setPosicio(posFB);
                                partida.insereixPosicio(fb.getPosicio(), idFitxaBlanca);
                                fn.setPosicio(posFN);
                                partida.insereixPosicio(fn.getPosicio(), idFitxaNegra);
                                // Tornam a inserir casella bloquejada
                                partida.insereixPosicio(((Alfil) fb).getBloc(), idCasellaBloc);
                                // Informam a l'usuari de la situació
                                System.out.print("\n");
                                System.out.println("\u001B[34mL'ALFIL HA GUANYAT UNA BATALLA, PERÒ LA GUERRA CONTINUA\u001B[0m");
                                System.out.println("\u001B[31mA LA TORRE LI QUEDEN " + ((Torre) fn).getVides() + " VIDES\u001B[0m");
                                System.out.println("\u001B[34mTORNA A COMENÇAR EL JOCS DES DE LES POSICIONS INICIALMENT ESCOLLIDES\u001B[0m");
                                System.out.print("\n");
                            } else {
                                // La partida ha acabat
                                partidaAcabada = true;
                                fitxaGuanyadora = "fb";
                            }
                        }
                    }
                }
            } while (!movimentFBOK);

            // MOU FITXA NEGRA
            if (!partidaAcabada) {
                movimentFNOK = false;
                do {
                    partida.mostraTauler();
                    // FILA FITXA NEGRA
                    System.out.println("MOU FITXA NEGRA " + idFitxaNegra);
                    do {
                        filaNegra = lecturaTeclat("INDICA FILA: ");
                        boolean filaOK;
                        filaOK = partida.validaFila(filaNegra);
                        if (!filaOK) {
                            filaNegra = "X";
                        } else {
                            indexFilaNegra = Integer.parseInt(filaNegra) - 1;
                        }
                    } while (filaNegra.equals("X"));
                    // COLUMNA FITXA NEGRA
                    do {
                        columnaNegra = lecturaTeclat("INDICA COLUMNA: ");
                        boolean columnaOK;
                        columnaOK = partida.validaColumna(columnaNegra);
                        if (!columnaOK) {
                            System.out.println("\n" + "\u001B[31mHAS INTRODUIT UNA COLUMNA INCORRECTA!!!!\u001B[0m");
                            columnaNegra = "X";
                        } else {
                            indexColumnaNegra = partida.calculaIndexColumna(columnaNegra);
                        }
                    } while (columnaNegra.equals("X"));
                    // Declaram possible valor 
                    posFNPossible = new Casella(indexFilaNegra, indexColumnaNegra);
                    // Passam objecte posFNPossible a metode moureA()
                    // el qual determinara si el moviment és vàlid
                    movimentFNOK = fn.moureA(posFNPossible);
                    if (movimentFNOK) {
                        // Un cop comprovat que el moviment és valid, en el cas 
                        // que la fitxa negra sigui la torre, cal comprovar 
                        // que no ocupi la casella bloqiejada per l'alfil
                        if (fitxaNegra == "torre") {
                            if (indexFilaNegra == indexFilaBloc && indexColumnaNegra == indexColumnaBloc) {
                                //La torre vol ocupar la casella bloquejada, aquest moviment NO es possible 
                                System.out.println("\n" + "\u001B[31mLA TORRE NO POT OCUPAR LA CASELLA BLOQUEJADA PER L'ALFIL!!!!\u001B[0m");
                                movimentFBOK = false;
                            } else {
                                // La torre NO ocupa casella bloquejada
                                // Esborram posicio fitxa negra (abans moviment) en tauler
                                partida.insereixPosicio(fn.getPosicio(), "·");
                                // Modificam posició en objecte fb
                                fn.setPosicio(posFNPossible);
                                // Assignam nova posicio fitxa negra en tauler
                                partida.insereixPosicio(fn.getPosicio(), idFitxaNegra);
                                movimentFNOK = true;
                                // Comprovam si fitxa negra mata a fitxa blanca
                                if (fn.getPosicio().getFila() == fb.getPosicio().getFila() && fn.getPosicio().getColumna() == fb.getPosicio().getColumna()) {
                                    partidaAcabada = true;
                                    fitxaGuanyadora = "fn";
                                }
                            }
                        } else {
                            // La fitxa negra es l'alfil, per tant pot ocupar la casella bloquejada
                            // Esborram posicio fitxa negra (abans moviment) en tauler
                            partida.insereixPosicio(fn.getPosicio(), "·");
                            // Tornam a assignar el valor X a la casella bloquejada
                            // per si l'alfil la va ocupar en el moviment anterior
                            partida.insereixPosicio(((Alfil) fn).getBloc(), idCasellaBloc);
                            // Modificam posició en objecte fb
                            fn.setPosicio(posFNPossible);
                            // Assignam nova posicio fitxa negra en tauler
                            // Canviam el format de la fitxa a visualitzar en funció
                            // de si ocupa casella bloquetjada o no
                            if (fn.getPosicio().getFila() == ((Alfil) fn).getBloc().getFila()
                                    && fn.getPosicio().getColumna() == ((Alfil) fn).getBloc().getColumna()) {
                                partida.insereixPosicio(fn.getPosicio(), idFitxaNegraOcupaBloc);
                            } else {
                                partida.insereixPosicio(fn.getPosicio(), idFitxaNegra);
                            }
                            movimentFNOK = true;
                            // Comprovam si la fitxa negra (ALFIL) mata a la fitxa blanca (TORRE)
                            if (fn.getPosicio().getFila() == fb.getPosicio().getFila() && fn.getPosicio().getColumna() == fb.getPosicio().getColumna()) {
                                //Cal comprovar quantes vides li queden a la torre
                                int videsRestantsTorre;
                                videsRestantsTorre = ((Torre) fb).getVides();
                                if (videsRestantsTorre > 1) {
                                    // La partida encara no ha acabat
                                    // Restam 1 vida a la torre
                                    ((Torre) fb).setVides(videsRestantsTorre - 1);
                                    // Resetejam tauler
                                    partida.emplenaTauler();
                                    // Retornam fitxes blanca i negra a les posicions escollides inicialment
                                    // Feim el mateix en tauler
                                    fb.setPosicio(posFB);
                                    partida.insereixPosicio(fb.getPosicio(), idFitxaBlanca);
                                    fn.setPosicio(posFN);
                                    partida.insereixPosicio(fn.getPosicio(), idFitxaNegra);
                                    // Tornam a inserir casella bloquejada
                                    partida.insereixPosicio(((Alfil) fn).getBloc(), idCasellaBloc);
                                    // Informam a l'usuari de la situació
                                    System.out.print("\n");
                                    System.out.println("\u001B[34mL'ALFIL HA GUANYAT UNA BATALLA, PERÒ LA GUERRA CONTINUA\u001B[0m");
                                    System.out.println("\u001B[31mA LA TORRE LI QUEDEN " + ((Torre) fb).getVides() + " VIDES\u001B[0m");
                                    System.out.println("\u001B[34mTORNA A COMENÇAR EL JOC DES DE LES POSICIONS INICIALMENT ESCOLLIDES\u001B[0m");
                                    System.out.print("\n");
                                } else {
                                    // La partida ha acabat
                                    partidaAcabada = true;
                                    fitxaGuanyadora = "fn";
                                }
                            }
                        }
                    }
                } while (!movimentFNOK);
            }

        }
        partida.mostraTauler();
        System.out.print("\n");
        System.out.println("********************");
        System.out.println("*\u001B[32m  PARTIDA ACABADA \u001B[0m*");
        System.out.println("********************");
        System.out.print("\n");

        if (fitxaGuanyadora.equals("fb")) {
            System.out.println("\u001B[34mHA GUANYAT LA FITXA BLANCA (" + fitxaBlanca.toUpperCase() + "): \u001B[0m" + idFitxaBlanca);
        } else {
            System.out.println("\u001B[34mHA GUANYAT LA FITXA NEGRA (" + fitxaNegra.toUpperCase() + "): \u001B[0m" + idFitxaNegra);
        }

    }

    //---------------------------------------------------------------        
    // Metodes captura teclat
    //---------------------------------------------------------------      
    private static String lecturaTeclat(String text) {

        String informacioInserida;
        Scanner entradaTeclat = new Scanner(System.in);

        System.out.println(text);
        informacioInserida = entradaTeclat.nextLine();

        return informacioInserida;

    }

    // METODE PER EMPLENAR TAULER AMB VALORS INICIALS (·)
    public void emplenaTauler() {

        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                tauler[i][j] = "·";
            }
        }
    }

    // METODE PER MOSTRAR TAULER 
    public void mostraTauler() {

        System.out.println("+---+---+---+---+---+---+");
        System.out.print("|   | ");
        for (int m = 0; m < idColumna.length; m++) {
            System.out.print("\u001B[35m" + idColumna[m] + "\u001B[0m" + " | ");
        }
        System.out.print("\n");
        System.out.println("+---+---+---+---+---+---+");

        for (int i = 0; i < tauler.length; i++) {
            System.out.print("| " + "\u001B[32m" + idFila[i] + "\u001B[0m" + " | ");
            for (int j = 0; j < tauler[i].length; j++) {
                System.out.print(tauler[i][j] + " | ");
            }
            System.out.print("\n");
            System.out.println("+---+---+---+---+---+---+");
        }
    }

    //Metode per validar fila
    public boolean validaFila(String fila) {
        try {
            int indexFila = Integer.parseInt(fila);
            if (indexFila < 1 || indexFila > 5) {
                System.out.println("\n" + "\u001B[31mHAS INTRODUIT UN NUMERO DE FILA INCORRECTA!!!!\u001B[0m");
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            System.out.println("\n" + "\u001B[31mHAS INTRODUIT UN FORMAT DE FILA INCORRECTA!!!!\u001B[0m");
            return false;
        }
    }

    //Metode per validar columna
    public boolean validaColumna(String columna) {

        // EXPRESSIÓ REGULAR COLUMNA
        String codiRegex = "^[A-E]{1}$";
        Pattern patro = Pattern.compile(codiRegex);
        Matcher validacio = patro.matcher(columna);
        return validacio.matches();

    }

    //Metode per calcular index columna
    public int calculaIndexColumna(String columna) {

        if (columna.equals("A")) {
            return 0;
        } else if (columna.equals("B")) {
            return 1;
        } else if (columna.equals("C")) {
            return 2;
        } else if (columna.equals("D")) {
            return 3;
        } else {
            return 4;
        }

    }

    // Inserim posició fitxa en Tauler
    public void insereixPosicio(Casella posicio, String fitxa) {

        int fila = posicio.getFila();
        int columna = posicio.getColumna();
        tauler[fila][columna] = fitxa;

    }

}
