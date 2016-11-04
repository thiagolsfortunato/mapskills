package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.UserSerializer;

@JsonSerialize(using = UserSerializer.class)
public class UserWrapper {

}
