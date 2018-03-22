package br.com.joselucianorc.livraria.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import br.com.joselucianorc.livraria.dto.SaraivaDto;

public class SaraivaUtil {

	private static final String API_SARAIVA_PRODUTO_PDP_SKU_0_0_1 = "https://api.saraiva.com.br/sc/produto/pdp/{SKU}/0/0/1/";

	public static SaraivaDto getBooksInfo(Integer sku) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<String, String>();
		   vars.put("SKU", String.valueOf(sku.toString()));
		   SaraivaDto result = restTemplate.getForObject(API_SARAIVA_PRODUTO_PDP_SKU_0_0_1, SaraivaDto.class, vars);
		return result;
	}
}
