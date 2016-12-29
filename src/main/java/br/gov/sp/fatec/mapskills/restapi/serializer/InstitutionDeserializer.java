package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionWrapper;

public class InstitutionDeserializer extends JsonDeserializer<InstitutionWrapper> {

	@Override
	public InstitutionWrapper deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
