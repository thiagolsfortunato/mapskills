/*
 * @(#)SceneListWrapper.java 1.0 28/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.serializer.SceneListDeserializer;
import br.gov.sp.fatec.mapskills.restapi.serializer.SceneListSerializer;
/**
 * 
 * A classe {@link SceneListWrapper} encapsula uma colecao
 * de cenas de um tema de jogo para que seja serializada
 * ou deserializada.
 *
 * @author Marcelo
 * @version 1.0 28/12/2016
 */
@JsonSerialize(using = SceneListSerializer.class)
@JsonDeserialize(using = SceneListDeserializer.class)
public class SceneListWrapper {
	
	private final Collection<Scene> scenes = new ArrayList<>();

	public SceneListWrapper(final Collection<Scene> scenes) {
		this.scenes.addAll(scenes);
	}
	
	public Collection<Scene> getScenes() {
		return Collections.unmodifiableCollection(scenes);
	}

}
