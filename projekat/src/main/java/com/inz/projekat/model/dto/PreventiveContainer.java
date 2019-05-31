package com.inz.projekat.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PreventiveContainer {
	
	private List<PreventiveDescription> cases = new ArrayList<PreventiveDescription>();

	public List<PreventiveDescription> getCases() {
		return cases;
	}

	public void setCases(List<PreventiveDescription> cases) {
		this.cases = cases;
	}

	public PreventiveContainer() {
		super();
	}

	
}
