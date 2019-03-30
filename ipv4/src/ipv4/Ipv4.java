/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipv4;

import java.util.Scanner;

/**
 *
 * @authores Douglas e João
 */
public class Ipv4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* oct= Octeto */

        String ipv4, opcao;
        int oct1, oct2, oct3, oct4;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem vindo ao IPV4 Analyser");
        do {
            System.out.println("Para começar digite uma sequencia de IPV4");
            System.out.println("Obs: Digite a sequencia com pontos!");
            //* Lendo o endereço IPV4
            ipv4 = leitor.nextLine();
            //* Estou quebrando o ipv4 com o metodo SPLIT para poder analisar cada octeto.
            String[] ipv4_separado = ipv4.split("[.]");
            //* Jogamos os valores para uma variavel para poder transforma-la em inteiro.
            oct1 = Integer.parseInt(ipv4_separado[0]);
            oct2 = Integer.parseInt(ipv4_separado[1]);
            oct3 = Integer.parseInt(ipv4_separado[2]);
            oct4 = Integer.parseInt(ipv4_separado[3]);

            //* Antes de mais nada estamos verificando se os octetos não ultrapassam o valor de 255.
            if (oct1 <= 255 && oct2 <= 255 && oct3 <= 255 & oct4 <= 255) {
                //* Aqui estaremos verificando a qual classe o IP pertence, e a partir dai estamos aproveitando 
                //* a informação da classe para formarmos os outros atributos.
                if (oct1 >= 192 && oct1 <= 223) {
                    System.out.println("IP de Classe C");
                    //* Aqui verificamos se o ip é de rede ou de broadcast.
                    if (oct4 == 0) {
                        System.out.println("IP de rede");
                    } else if (oct4 == 255) {
                        System.out.println("IP de Broadcast");
                    } else {
                        System.out.println("Mascara: 255.255.255.0");
                        System.out.println("Endereço de Rede: " + oct1 + "." + oct2 + "." + oct3 + "." + "0");
                        System.out.println("Endereço Inicial utilizável da Rede: " + oct1 + "." + oct2 + "." + oct3 + "." + "1");
                        System.out.println("Endereço Final utilizável da Rede: " + oct1 + "." + oct2 + "." + oct3 + "." + "254");
                        System.out.println("Broadcast " + oct1 + "." + oct2 + "." + oct3 + "." + "255");
                    }
                    //* Aqui verificamos se o IP é reservado para LAN.
                    if (oct1 == 192 && oct2 == 168 && oct3 <= 255 & oct4 <= 255) {
                        System.out.println("O IP é reservado para LAN");
                    } else {
                        System.out.println("O IP não é reservado para LAN");
                    }
                } else if (oct1 >= 128 && oct1 <= 191) {
                    System.out.println("IP de Classe B");
                    //* Aqui verificamos se o ip é de rede ou de broadcast.
                    if (oct3 == 0 && oct4 == 0) {
                        System.out.println("IP de rede");
                    } else if (oct3 == 255 && oct4 == 255) {
                        System.out.println("Ip de Broadcast");
                    } else {
                        System.out.println("Mascara: 255.255.0.0");
                        System.out.println("Endereço de Rede: " + oct1 + "." + oct2 + "." + "0" + "." + "0");
                        System.out.println("Endereço Inicial utilizável da Rede: " + oct1 + "." + oct2 + "." + "0" + "." + "1");
                        System.out.println("Endereço Final utilizável da Rede: " + oct1 + "." + oct2 + "." + "255" + "." + "254");
                        System.out.println("Broadcast " + oct1 + "." + oct2 + "." + "255" + "." + "255");
                        //* Aqui verificamos se o IP é reservado para LAN.
                        if (oct1 == 172 && oct2 >= 16 && oct2 <= 31 && oct3 <= 255 & oct4 <= 255) {
                            System.out.println("O IP é reservado para LAN");
                        } else if (oct1 == 169 && oct2 == 254 && oct3 <= 255 & oct4 <= 255) {
                            System.out.println("O IP é reservado para LAN"); 
                        } else {
                            System.out.println("O IP não é reservado para LAN");
                        }
                    }
                } else if (oct1 >= 1 && oct1 <= 126) {
                    System.out.println("IP de Classe A");
                    //* Aqui verificamos se o ip é de rede ou de broadcast.
                    if (oct2 == 0 && oct3 == 0 && oct4 == 0) {
                        System.out.println("IP de rede");
                    } else if (oct2 == 255 && oct3 == 255 & oct4 == 255) {
                        System.out.println("IP de Broadcast");
                    } else {
                        System.out.println("Mascara: 255.0.0.0");
                        System.out.println("Endereço de Rede: " + oct1 + "." + "0" + "." + "0" + "." + "0");
                        System.out.println("Endereço Inicial utilizável da Rede: " + oct1 + "." + "0" + "." + "0" + "." + "1");
                        System.out.println("Endereço Final utilizável da Rede: " + oct1 + "." + "255" + "." + "255" + "." + "254");
                        System.out.println("Broadcast " + oct1 + "." + "255" + "." + "255" + "." + "255");
                        //* Aqui verificamos se o IP é reservado para LAN.
                        if (oct1 == 10 && oct2 <= 255 && oct3 <= 255 & oct4 <= 255) {
                            System.out.println("O IP é reservado para LAN");
                        } else {
                            System.out.println("O IP não é reservado para LAN");
                        }
                    }
                } else if (oct1 == 127) {
                    System.out.println("IP reservado para localhost");

                } else if (oct1 >= 224 && oct1 <= 239) {
                    System.out.println("Classe D");
                    System.out.println("IP reservado para MultiCast");

                } else if (oct1 >= 240 && oct1 <= 255) {
                    System.out.println("Classe E");
                    System.out.println("IP reservado para uso futuro e testes");

                } else {
                    System.out.println("Endereço IP inválido!");
                }
            }
            System.out.println("> Deseja verificar outro endereço IP?");
            System.out.println("> Em caso afirmativo pressione enter");
            System.out.println("> Em caso negativo, digite sair");
            opcao = leitor.nextLine();
        } while (!"sair".equals(opcao));
    }
}
