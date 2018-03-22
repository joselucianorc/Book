package br.com.joselucianorc.livraria.dto;

public class SaraivaDto
{
    private String name;
    private String sku;
    private Price price;
    private String brand;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSku () {
        return sku;
    }

    public void setSku (String sku) {
        this.sku = sku;
    }
 
    public Price getPrice () {
        return price;
    }

    public void setPrice (Price price) {
        this.price = price;
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

	@Override
	public String toString() {
		return super.toString();
	}
    
} 