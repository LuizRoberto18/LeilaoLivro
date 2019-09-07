package edu.ifal.br.modelo;

import java.util.Calendar;

import edu.ifal.br.interfaces.Relogio;

public class RelogioDoSistema implements Relogio{
    @Override
    public Calendar hoje(){
        return Calendar.getInstance();
    }
        
}
