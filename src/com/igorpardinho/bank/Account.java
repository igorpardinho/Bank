package com.igorpardinho.bank;

public class Account {
    private static final int MAX_LENGTH = 12;
    private String name;
    private String ag;
    private String cc;
    private double cash = 0;
    private Log logger = new Log();

    public Account(String ag, String cc, String name){
        this.name = name;
        this.ag = ag;
        this.cc = cc;
        setName(name);


    }

    public void setName(String name){
        if(name.length() > MAX_LENGTH){
          this.name = name.substring(0,MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        String result = "A conta " + this.name + " " + this.ag + " / " + this.cc + " Possui: R$ " + this.cash;
        return result;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public boolean withdraw(double value){
        if (value > cash) {
            logger.out("SAQUE - R$ " + value + " - Saldo na sua conta atualmente é de: " + cash);
            return false;
        }
        cash -= value;
        logger.out("SAQUE - R$ " + value + " - Saldo na sua conta atualmente é de: " + cash);
        return true;

    }

    public void deposit(double value){
        cash += value;

        logger.out("DEPOSITO - R$ " + value + " - Saldo na sua conta atualmente é de: " + cash);
    }

}
