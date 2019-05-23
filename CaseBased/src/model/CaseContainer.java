package model;

import java.util.ArrayList;
import java.util.List;

public class CaseContainer {
	
	private List<CaseDescription> cases = new ArrayList<CaseDescription>();

	public List<CaseDescription> getCases() {
		return cases;
	}

	public void setCases(List<CaseDescription> cases) {
		this.cases = cases;
	}

	public CaseContainer() {
		super();
	}

	
}
