package application.prod.vo;

/**
 * @class : ProdVO.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class ProdVO {
	
	
	// 상품ID
	private String prodId;
	
	// 상품명
	private String prodNm;
	
	// 상품가격
	private int prodPrice;
	
	// 상품판매자
	private String prodBuyer;
	
	//상품상세
	private String prodDetail;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdBuyer() {
		return prodBuyer;
	}

	public void setProdBuyer(String prodBuyer) {
		this.prodBuyer = prodBuyer;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	

}
