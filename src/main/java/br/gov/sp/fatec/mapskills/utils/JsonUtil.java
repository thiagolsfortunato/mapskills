/*
 * @(#)JsonUtil.java 1.0 22/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A classe {@link JsonUtil} encapsula o acesso
 * aos valores dos campos de um objeto JSON.
 * 
 * @author Roberto Perillo
 * @author Danilo Ambrosio
 * @author Marcelo Inácio
 * @version 1.0 22/03/2017
 */
@Component
public class JsonUtil {
	/*
	 * constante que define a senha padrão de acesso a todos perfis.
	 */
	protected static final String ENCRYPTED_DEFAULT_PASSWORD = "$2a$10$TH9WvYSs4BYDi7NaesV.Uerv7ZyzXXrEuriWeo2qAl96i6fN3oz8G";
	
	@Autowired
	private PasswordEncoder encoder;

	public String getFieldTextValue(final JsonNode node, final String fieldName) {
		return node.has(fieldName) ? node.get(fieldName).textValue() : null;
	}

	public double getFieldDoubleValue(final JsonNode node, final String fieldName) {
		return node.has(fieldName) ? node.get(fieldName).doubleValue() : 0;
	}

	public long getFieldLongValue(final JsonNode node, final String fieldName) {
		return node.has(fieldName) ? node.get(fieldName).asLong() : 0;
	}

	public int getFieldIntegerValue(final JsonNode node, final String fieldName) {
		return node.has(fieldName) && node.hasNonNull(fieldName)? node.get(fieldName).asInt() : 0;
	}

	public boolean getFieldBooleanValue(final JsonNode node, final String fieldName) {
		return node.has(fieldName) ? node.get(fieldName).asBoolean() : false;
	}
	
	public boolean hasNonNull(final JsonNode node, final String fieldName) {
		return node.hasNonNull(fieldName);
	}

	public boolean has(final JsonNode node, final String fieldName) {
		return node.has(fieldName);
	}

	public JsonNode get(final JsonNode node, final String fieldName) {
		return node.get(fieldName);
	}

	public boolean isArray(final JsonNode node, final String fieldName) {
		return hasNonNull(node, fieldName) && get(node, fieldName).isArray();
	}
	/**
	 * Método que devolve um password codificado caso haja.
	 * se não devolve um password codificado padrão.
	 * @param node
	 * @return
	 */
	public String getFieldPasswordValue(final JsonNode node) {
		return node.has("password") && !StringUtils.isEmpty(node.get("password").asText()) ? encoder.encode(node.get("password").asText()) : ENCRYPTED_DEFAULT_PASSWORD;
	}
	
}
