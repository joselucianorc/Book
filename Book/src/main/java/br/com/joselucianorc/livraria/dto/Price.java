package br.com.joselucianorc.livraria.dto;

public class Price
{

    private String has_discount;

    private String original;

    private String value;

    private String is_free;

    public String getHas_discount ()
    {
        return has_discount;
    }

    public void setHas_discount (String has_discount)
    {
        this.has_discount = has_discount;
    }

    public String getOriginal ()
    {
        return original;
    }

    public void setOriginal (String original)
    {
        this.original = original;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getIs_free ()
    {
        return is_free;
    }

    public void setIs_free (String is_free)
    {
        this.is_free = is_free;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ has_discount = "+has_discount+", original = "+original+", value = "+value+", is_free = "+is_free+"]";
    }
	
 }
