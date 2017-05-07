/*
 * @(#)SceneDeserializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneWrapper;
/**
 * 
 * A classe {@link SceneDeserializer} e responsavel
 * por deserializar um <i>POST</i> de uma cena
 * para que seja cadastrada ou atualizada.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
public class SceneDeserializer extends DefaultJsonDeserializer<SceneWrapper> {
	
	private static final String IP_SERVER = "http://localhost:8585/mapskills/";
	
	@Override
	protected SceneWrapper deserialize(JsonNode node) {
		final String[] background = verifyBackground(node);    
        final String fileImageBase64 = background[0];
        final String filename = background[1];
        		
        final Question question = this.buildQuestion(node.get("question"));

        final Scene scene = Scene.builder()
        		.text(jsonUtil.getFieldTextValue(node, "text"))
        		.urlBackground(IP_SERVER + "images/" + filename)
        		.question(question)
        		.gameThemeId(jsonUtil.getFieldLongValue(node, "gameThemeId"))
        		.build();

        this.setIdAndIndex(node, scene);
        
		return new SceneWrapper(scene, fileImageBase64, filename);
	}
	
	private Question buildQuestion(final JsonNode node) {
		if(node == null || node.isNull()) {
			return null;
		}
		final List<Alternative> alternatives = buildAlternatives(node.get("alternatives"));
		final Question question = Question.builder().alternatives(alternatives).skillId(this.getSkillIdFromNode(node)).build();
		question.setId(jsonUtil.getFieldLongValue(node, "id"));
		return question;
	}
	
	private List<Alternative> buildAlternatives(final JsonNode node) {
		final List<Alternative> alternatives = new ArrayList<>(4);
		for(int i = 0; i < 4; i++ ) {
			final String position = String.valueOf(i);
			if(node.has(position)) {
				alternatives.add(Alternative
						.builder()
						.id(jsonUtil.getFieldLongValue(node.get(position), "id"))
						.description(jsonUtil.getFieldTextValue(node.get(position), "description"))
						.skillValue(jsonUtil.getFieldIntegerValue(node.get(position), "skillValue"))
						.build());
			} else {
				alternatives.add(Alternative
						.builder()
						.id(jsonUtil.getFieldLongValue(node.get(i), "id"))
						.description(jsonUtil.getFieldTextValue(node.get(i), "description"))
						.skillValue(jsonUtil.getFieldIntegerValue(node.get(i), "skillValue"))
						.build());
			}
		}
		return alternatives;
	}
	
	private String[] verifyBackground(final JsonNode node) {
		final String[] background = new String[2];
		if(!node.has("background")) {
			return null;
		}
		if(jsonUtil.has(node.get("background"), "base64")) {
			background[0] = jsonUtil.getFieldTextValue(node.get("background"), "base64");
        }
        if(jsonUtil.has(node.get("background"), "filename")) {
        	final String filename = jsonUtil.getFieldTextValue(node.get("background"), "filename");
        	final int lastIndex = filename.lastIndexOf("/");
        	background[1] = filename.substring(lastIndex + 1);
        }
        return background;
	}
	
	private long getSkillIdFromNode(final JsonNode node) {
		return jsonUtil.getFieldLongValue(node, "skillId");
	}
	
	private void setIdAndIndex(final JsonNode node, final Scene scene) {
		scene.setId(jsonUtil.getFieldLongValue(node, "id"));
		scene.putIndex(jsonUtil.getFieldIntegerValue(node, "index"));
	}
	
}
