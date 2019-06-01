package com.inz.projekat.cbr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.inz.projekat.connector.YamlPreventionConnector;
import com.inz.projekat.model.dto.PreventiveContainer;
import com.inz.projekat.model.dto.PreventiveDescription;
import com.inz.projekat.similarity.SymptomSimilarity;

import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class PreventiveCBR implements StandardCBRApplication {

	Connector _connector;
	/** Connector object */
	CBRCaseBase _caseBase;
	/** CaseBase object */
	
	static Collection<RetrievalResult> requestResults;

	NNConfig simConfig;

	/** KNN configuration */

	public void configure() throws ExecutionException {
		_connector = new YamlPreventionConnector();

		_caseBase = new LinealCaseBase(); // Create a Lineal case base for in-memory organization

		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average()); // global similarity function = average

		Attribute gender = new Attribute("gender", PreventiveDescription.class);
		simConfig.setWeight(gender, 0.1);
		simConfig.addMapping(gender, new Equal());

		Attribute age = new Attribute("age", PreventiveDescription.class);
		simConfig.setWeight(age, 0.1);
		simConfig.addMapping(age, new Interval(5));
		
		Attribute pastConditions = new Attribute("pastConditions", PreventiveDescription.class);
		simConfig.setWeight(pastConditions, 1.0);
		simConfig.addMapping(pastConditions, new SymptomSimilarity());
	
		Attribute familyHistory = new Attribute("familyHistory", PreventiveDescription.class);
		simConfig.setWeight(familyHistory, 0.7);
		simConfig.addMapping(familyHistory, new SymptomSimilarity());
		
		Attribute otherRiskFactors = new Attribute("otherRiskFactors", PreventiveDescription.class);
		simConfig.setWeight(otherRiskFactors, 0.3);
		simConfig.addMapping(otherRiskFactors, new SymptomSimilarity());
		
		// SymptomSimilarity());

		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y)
		// = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a
		// threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case
		// letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring
		// that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their
		// distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their
		// cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed
		// values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity)
	}

	public PreventiveCBR() {
		super();
		try {
			this.configure();
			this.preCycle();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 10);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval) {
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
		}

		requestResults = eval;

	}

	public void postCycle() throws ExecutionException {

	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		
		for (CBRCase c : cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}
/*
	public static void main(String[] args) {

		PreventiveCBR cbr = new PreventiveCBR();
				
		PreventiveDescription pD = new PreventiveDescription();

		pD.setAge(27);
		pD.setGender('M');
		
		pD.getPastConditions().add("Anxiety");
		pD.getFamilyHistory().add("Depression");
		pD.getOtherRiskFactors().add("Stress");
		
		 
		cbr.evaluateCase(pD);
		
		pD.getRecommendedPreventiveTests().add("Mental_screening");

		try {
			//cbr.addEntry(pD);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
*/
	public Collection<RetrievalResult> evaluateCase(PreventiveDescription pD) {
		try {
			
			CBRQuery query = new CBRQuery();

			query.setDescription(pD);
			
			cycle(query);

			return requestResults;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	public void addEntry(PreventiveDescription pD) throws IOException {

		Map<String, Object> data = new HashMap<String, Object>();

		Collection<CBRCase> cases = _caseBase.getCases();
		
		PreventiveContainer pC = new PreventiveContainer();
		for (CBRCase c : cases) {
			pC.getCases().add((PreventiveDescription) c.getDescription());
		}
		pC.getCases().add(pD);

		data.put("cases", pC.getCases());

		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setPrettyFlow(true);

		Yaml yaml = new Yaml(options);

		FileWriter writer = new FileWriter("data/preventive.yaml");
		yaml.dump(data, writer);

	}

	public static void seedWriter() throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();

		PreventiveContainer pC = new PreventiveContainer();
		PreventiveDescription pD1 = new PreventiveDescription();

		pD1.setAge(21);
		pD1.setGender('M');
		
		pD1.getPastConditions().add("Depression");
		pD1.getPastConditions().add("Anxiety");

		
		pD1.getFamilyHistory().add("Depression");

		
		pD1.getOtherRiskFactors().add("Stress");
		
		pD1.getRecommendedPreventiveTests().add("Mental_screening");

		
		PreventiveDescription pD2 = new PreventiveDescription();

		pD2.setAge(25);
		pD2.setGender('F');
		
		pD2.getPastConditions().add("Anxiety");
		
		pD2.getOtherRiskFactors().add("Stress");
		
		pD2.getRecommendedPreventiveTests().add("Anxiety_test");


		pC.getCases().add(pD1);
		pC.getCases().add(pD2);

		data.put("cases", pC.getCases());

		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setPrettyFlow(true);

		Yaml yaml = new Yaml(options);

		FileWriter writer = new FileWriter("data/preventive.yaml");
		yaml.dump(data, writer);
	}

}