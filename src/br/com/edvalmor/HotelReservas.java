package br.com.edvalmor;

import java.util.Scanner;

public class HotelReservas {

    private static final int CAPACIDADE = 10;
    private static Reserva[] reservas = new Reserva[CAPACIDADE];
    private static int cont = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner leia = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("---BEM-VINDO(A) AO SISTEMA HOSPEDABAC---");
            System.out.println("Digite a opção desejada");
            System.out.println("1- Fazer nova reserva");
            System.out.println("2- Listar Reservas");
            System.out.println("3- Buscar reserva por nome de hóspede");
            System.out.println("4- Ordenar reservas");
            System.out.println("5- Sair");
            System.out.println("-----------------------------------------");
            int opcao = leia.nextInt();

            if (opcao == 5) {
                System.out.println("Sistema encerrado");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    if (cont == CAPACIDADE) {
                        System.out.println("Capacidade máxima do hotel atingida.");
                    } else {
                        fazerReserva();
                    }
                    break;
                case 2:
                    buscarReserva();
                    break;
                case 3:
                    leia.nextLine();
                    System.out.println("Digite o nome do hóspede para iniciar: ");
                    String nome = leia.nextLine();
                    buscarReservaPorNome(nome);
                    break;
                case 4:
                    ordenaReservas();
                    System.out.println("Reservas ordenadas por número de dias: ");
                    listarReservas();

                    break;
                default:
                    System.out.println("Digite um valor válido");
            }
        }

        leia.close();
    }

    private static void listarReservas() {
        if (cont == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.println("Lista de reservas:");
        for (int i = 0; i < cont; i++) {
            System.out.println(reservas[i]);
        }
    }

    private static void buscarReservaPorNome(String nome) {
        String nomeMinusculo = nome.toLowerCase();
        boolean encontra = false;
        System.out.println("Resultado da busca: ");
        for(int i = 0; i < cont; i++){
            if(reservas[i].getNomeHospede().toLowerCase().contains(nome)){
                System.out.println(reservas[i]);
                encontra = true;
            }
        }

        if (!encontra) {
            System.out.println("Nenhuma reserva foi encontrada com esse nome.");
        }
    }

    private static void ordenaReservas() {

        for (int i = 0; i < cont - 1; i++){
            for (int j = 0; j < cont - 1 - i; j++){
                if(reservas[j].getQntDias() < reservas[j+1].getQntDias()){
                    Reserva aux = reservas[j];
                    reservas[j] = reservas[j+1];
                    reservas[j+1] = aux;
                }
            }
        }
    }

    private static void buscarReserva() {
        if (cont == 0){
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.println("Lista de reservas: ");
        for (int i = 0; i < cont; i++){
            System.out.println(reservas[i]);
        }
    }

    private static void fazerReserva() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Nome do hóspede: ");
        String nome = leia.nextLine();

        System.out.println("Tipo do quarto (Standard, Luxo, Presidencial): ");
        String tipoQuarto = leia.nextLine();

        System.out.println("Número de dias de estadia: ");
        int dias = leia.nextInt();
        leia.nextLine();

        Reserva reserva = new Reserva(nome, tipoQuarto, dias);
        reservas[cont] = reserva;
        cont++;
        System.out.println("Reserva realizada com sucesso.");
    }
}
