package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.UserListSerializer;

@JsonSerialize(using = UserListSerializer.class)
public class UserListWrapper {

}
