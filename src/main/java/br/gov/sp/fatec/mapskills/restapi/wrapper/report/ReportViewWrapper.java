package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;

@JsonSerialize(using = ReportViewSerializer.class)
public class ReportViewWrapper {
	
	private final List<Skill> skills = new ArrayList<>();
	private final List<ReportDefaultData> datas = new ArrayList<>();
	
	public ReportViewWrapper(final List<Skill> skills, final List<ReportDefaultData> datas) {
		this.skills.clear();
		this.skills.addAll(skills);
		this.datas.clear();
		this.datas.addAll(datas);
	}
	
	
	public List<Skill> getSkills() {
		return Collections.unmodifiableList(this.skills);
	}
	
	public List<ReportDefaultData> getDatas() {
		return Collections.unmodifiableList(this.datas);
	}

}
