/*
 * @(#)SceneListDeserializer.java 1.0 08/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneListWrapper;
/**
 * 
 * A classe {@link SceneListDeserializer} e responsavel
 * por deserializar uma lista de cenas de um tema para
 * que seja cadastrados ou atualizados.
 *
 * @author Marcelo
 * @version 1.0 08/01/2017
 */
public class SceneListDeserializer extends DefaultJsonDeserializer<SceneListWrapper> {

	@Override
	protected SceneListWrapper deserialize(JsonNode node) {
		final int sizeArray = node.size();
        final Collection<Scene> scenes = new ArrayList<>(sizeArray);
        for(int i = 0; i < sizeArray; i++) {
        	final JsonNode nodeCurrent = node.get(i);
        	scenes.add(Scene.builder()
        			.id(jsonUtil.getFieldLongValue(nodeCurrent, "id"))
        			.index(this.getIndexFromNode(jsonUtil.getFieldIntegerValue(nodeCurrent, "index")))
        			.text(jsonUtil.getFieldTextValue(nodeCurrent, "text"))
        			.urlBackground(jsonUtil.getFieldTextValue(nodeCurrent.get("background"), "filename"))
        			.question(this.buildQuestion(jsonUtil.get(nodeCurrent, "question")))
        			.gameThemeId(jsonUtil.getFieldLongValue(nodeCurrent, "gameThemeId"))
        			.build());
        }
		return new SceneListWrapper(scenes);
	}
	
	private Question buildQuestion(final JsonNode node) {
		if(node.isNull()) {
			return null;
		}
		return Question.builder()
				.id(jsonUtil.getFieldLongValue(node, "id"))
				.alternatives(buildAlternatives(node.get("alternatives")))
				.skillId(jsonUtil.getFieldLongValue(node, "skillId"))
				.build();
	}
	
	private Collection<Alternative> buildAlternatives(final JsonNode node) {
		final Collection<Alternative> alternatives = new ArrayList<>(4);
		for(int i = 0; i < 4; i++) {
			alternatives.add(Alternative.builder()
					.id(jsonUtil.getFieldLongValue(node.get(i), "id"))
					.description(jsonUtil.getFieldTextValue(node.get(i), "description"))
					.skillValue(jsonUtil.getFieldIntegerValue(node.get(i), "skillValue"))
					.build());
		}
		return alternatives;
	}
	
	private int getIndexFromNode(final Integer index) {
		return index == null ? -1 : index;
	}

}
