package br.com.teste.entity;

public class Filme {
	
	private String titulo;
	private String urlPoster;
	private String nota;
	private String ano;
	
	public Filme(String titulo, String urlPoster, String nota, String ano) {
		super();
		this.titulo = titulo;
		this.urlPoster = urlPoster;
		this.nota = nota;
		this.ano = ano;
	}
	
	public Filme(String moviesArray) {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrlPoster() {
		return urlPoster;
	}

	public void setUrlPoster(String urlPoster) {
		this.urlPoster = urlPoster;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	
}
