package beans;

public class ValuesHelper {
	private String valorProduto;
	private String valorFrete;
	private String valorTotal;

	public String getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(String valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(String valorFrete) {
		this.valorFrete = valorFrete;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	// Métodos matemáticos
	
	public Float somarValorTotal(String valorProduto, String valorFrete) {
		return Float.parseFloat(valorProduto) + Float.parseFloat(valorFrete);
	}
	
}