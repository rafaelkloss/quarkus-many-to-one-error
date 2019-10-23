package com.proposito.rest;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class AbstractRestController {

	/**
	 * Retorna uma lista de inteiros de acordo com um parâmetro recebido com números
	 * separados por vírgula. Coloca um 0 caso não exista nenhum parâmetro
	 * 
	 * @param requestParameter
	 * @return
	 */
	protected List<Integer> getIntegerListByStringSeparadoPorVirgula(String requestParameter) {
		if (Objects.isNull(requestParameter) || requestParameter.isEmpty() || requestParameter.equals("null")) {
			requestParameter = "0";
		}
		Pattern pattern = Pattern.compile(",");
		List<Integer> list = pattern.splitAsStream(requestParameter).map(Integer::valueOf).collect(Collectors.toList());
		return list;
	}

}
