package t1.view.objects;

import java.util.Calendar;
import java.util.Date;

import t1.view.annotations.Coluna;

public class Livro {

	private Long ID;

	private String tituloLivro;

	private String nomeAutor;

	private Date dataRetirada;

	private Date dataDevolucao;

	/**
	 * Dias que o livro vence, depois de ter sido retirado, por padrão é 7;
	 */
	private Integer diasDeVencimento = 7;

	private Boolean vencido = (this.dataRetirada == null) ? false : (this.verificaVencimento());

	@Coluna(nome = "ID", posicao = 0)
	public Long getID() {
		return this.ID;
	}

	@Coluna(nome = "Título", posicao = 1)
	public String getTituloLivro() {
		return this.tituloLivro;
	}

	@Coluna(nome = "Autor", posicao = 2)
	public String getNomeAutor() {
		return this.nomeAutor;
	}

	@Coluna(nome = "Data Retirada", posicao = 3)
	public Date getDataRetirada() {
		return this.dataRetirada;
	}

	@Coluna(nome = "Data Devolução", posicao = 4)
	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}

	public Integer getDiasDeVencimento() {
		return this.diasDeVencimento;
	}

	@Coluna(nome = "Vencido", posicao = 5)
	public Boolean getVencido() {
		return this.vencido;
	}

	public void setID(Long iD) {
		this.ID = iD;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public void setDiasDeVencimento(Integer diasDeVencimento) {
		this.diasDeVencimento = diasDeVencimento;
	}

	public void setVencido(Boolean vencido) {
		this.vencido = vencido;
	}

	private boolean verificaVencimento() {
		Calendar c = Calendar.getInstance();
		c.setTime(this.dataRetirada);
		c.add(Calendar.DATE, 1);
		return (c.getTime().after(new Date()));
	}

}
