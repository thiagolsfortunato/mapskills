/*
 * @(#)QuestionWrapper.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.serializer.SceneDeserializer;

@JsonDeserialize(using = SceneDeserializer.class)
public class SceneWrapper {
	
	private final Scene scene;
	
	public SceneWrapper(final Scene scene) {
		this.scene = scene;
	}
	
	public Scene getScene() {
		return scene;
	}

}
