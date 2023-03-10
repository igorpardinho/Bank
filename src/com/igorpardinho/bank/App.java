package com.igorpardinho.bank;


import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank nubank = new Bank("0001");


        while (true){
            System.out.println("O que deseja fazer? 'C'=Criar conta, 'E'=Sair do programa ");
            String op = sc.nextLine().toUpperCase();

            if (op.equals("C")){
                System.out.println("Digite seu nome: ");
                String name = sc.nextLine();
               Account account = nubank.generateAccount(name);
                System.out.println(account);
                nubank.insertAccount(account);
                operation(account);

            } else if(op.equals("E")){
                break;
            } else{
                System.out.println("Comando inválido");
            }
        }

        List<Account> accounts = nubank.getAccounts();
        for(Account cc : accounts){
            System.out.println(cc);
        }
            nubank.bankTotal();


    }
    static void operation(Account account){
        Scanner sc = new Scanner(System.in);

        boolean exit = true;
        while (exit){
            System.out.println("O que deseja fazer? 'D' = Deposito, 'S' = Saque, 'E' = Sair da conta : ");
            String op = sc.next().toUpperCase();

            switch (op){
                case "S":
                    System.out.println("Digite o valor que deseja sacar: ");
                    double value = sc.nextDouble();
                    if (!account.withdraw(value)){
                        System.out.println("Saldo insuficiente para saque");
                    }
                    break;

                case "D":
                    System.out.println("Digite o valor que deseja depositar: ");
                    double value2 = sc.nextDouble();
                    account.deposit(value2);
                    break;

                case "E":
                    exit = false;
                    break;

                default:
                    System.out.println("Comando inválido");
            }

        }
    }
}