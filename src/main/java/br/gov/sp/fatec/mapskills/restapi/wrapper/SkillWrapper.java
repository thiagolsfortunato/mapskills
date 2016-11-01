/*
 * @(#)SkillWrapper.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.SkillDeserializer;
import br.gov.sp.fatec.mapskills.restapi.serializer.SkillSerializer;

@JsonDeserialize(using = SkillDeserializer.class)
@JsonSerialize(using = SkillSerializer.class)
public class SkillWrapper {

}
