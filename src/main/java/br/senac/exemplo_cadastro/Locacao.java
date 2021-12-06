package br.senac.exemplo_cadastro;

public class Locacao {
	
	private String data_hora_inicial;
	private String data_hora_final;
	private float valor;
	private String status_locacao;
	private String quadra_nome;
	private String nome;
	private String tipo_pagamento;

	public String getData_hora_inicial() {
		return data_hora_inicial;
	}

	public void setData_hora_inicial(String data_hora_inicial) {
		this.data_hora_inicial = data_hora_inicial;
	}

	public String getData_hora_final() {
		return data_hora_final;
	}

	public void setData_hora_final(String data_hora_final) {
		this.data_hora_final = data_hora_final;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getStatus_locacao() {
		return status_locacao;
	}

	public void setStatus_locacao(String status_locacao) {
		this.status_locacao = status_locacao;
	}

	public String getQuadra_nome() {
		return quadra_nome;
	}

	public void setQuadra_nome(String quadra_nome) {
		this.quadra_nome = quadra_nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}
	
	

}
