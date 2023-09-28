package entidades;

public class Pessoa {
	private String nome;
	private double cpf;  //atributos privados da pessoa
	private int idade;
	
	public Pessoa(String nome, double cpf, int idade) { //construtor de pessoa que recebe nome, CPF e idade
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	//aqui pra baixo são os gets e sets dos atributos de pessoa
	public String getNome() { 
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCpf() {
		return cpf;
	}
	public void setCpf(double cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}