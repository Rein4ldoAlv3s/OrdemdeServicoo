package com.reinaldo.domain.enums;

public enum Prioridade {

	BAIXA(0, "Baixa"),
	MEDIA(1, "Média"),
	ALTA(2, "Alta");
	
	private int cod;
	private String descricao;
		
	private Prioridade(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Prioridade toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida! " + cod);
	}
}
