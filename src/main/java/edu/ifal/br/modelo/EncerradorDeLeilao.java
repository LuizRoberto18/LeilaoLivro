package edu.ifal.br.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.ifal.br.repositorios.RepositorioDeLeiloes;

public class EncerradorDeLeilao {

	private int total = 0;
	private RepositorioDeLeiloes dao;
	private RepositorioDeLeiloes RepoLeilaoDao;
	private Carteiro carteiro;
	
	public EncerradorDeLeilao(RepositorioDeLeiloes daoFalso) {
		this.dao = daoFalso;
	}

	public void EcerradorDeLeilao(RepositorioDeLeiloes RepoLeilaoDao, Carteiro carteiro) {
		this.RepoLeilaoDao = RepoLeilaoDao;
		this.carteiro = carteiro;
	}

	public void encerra() {
		List<Leilao> todosLeiloesCorrentes = RepoLeilaoDao.correntes();

		for (Leilao leilao : todosLeiloesCorrentes) {
			try {
				if (comecouSemanaPassada(leilao)) {
					leilao.encerra();
					total++;
					RepoLeilaoDao.atulizar(leilao);
					carteiro.envia(leilao);
				}
			} catch (Exception e) {
				// salvo a exceção no sistema de logs e o loop continua
			}
		}
	}

	private boolean comecouSemanaPassada(Leilao leilao) {
		return diasEntre(leilao.getData(), Calendar.getInstance()) >= 7;
	}

	private int diasEntre(Date date, Calendar fim) {
		Calendar data = (Calendar) date.clone();
		int diasNoIntervalo = 0;

		while (data.before(fim)) {
			data.add(Calendar.DAY_OF_MONTH, 1);
			diasNoIntervalo++;
		}
		return diasNoIntervalo;
	}

	public int getTotalEncerrados() {
		return this.total;
	}

	public Object getQuantidadeDeEncerrados() {
		// TODO Auto-generated method stub
		return null;
	}
}
