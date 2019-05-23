package cbr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import connector.YamlConnector;
import model.CaseContainer;
import model.CaseDescription;
import similarity.SymptomSimilarity;
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

public class ConditionCBR implements StandardCBRApplication {

	Connector _connector;
	/** Connector object */
	CBRCaseBase _caseBase;
	/** CaseBase object */
	
	static Collection<RetrievalResult> requestResults;

	NNConfig simConfig;

	/** KNN configuration */

	public void configure() throws ExecutionException {
		_connector = new YamlConnector();

		_caseBase = new LinealCaseBase(); // Create a Lineal case base for in-memory organization

		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average()); // global similarity function = average

		Attribute gender = new Attribute("gender", CaseDescription.class);
		simConfig.setWeight(gender, 0.1);
		simConfig.addMapping(gender, new Equal());

		Attribute age = new Attribute("age", CaseDescription.class);
		simConfig.setWeight(age, 0.1);
		simConfig.addMapping(age, new Interval(5));

		simConfig.addMapping(new Attribute("symptoms", CaseDescription.class), new SymptomSimilarity());
		// simConfig.addMapping(new Attribute("tests", CaseDescription.class), new
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

	public ConditionCBR() {
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
		eval = SelectCases.selectTopKRR(eval, 1);
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

	public static void main(String[] args) {

		ConditionCBR cbr = new ConditionCBR();

		CaseDescription cd1 = new CaseDescription();

		cd1.setAge(25);
		cd1.setGender('M');
		cd1.getSymptoms().add("Headache");
		cd1.getSymptoms().add("Depression");

		cbr.evaluateCase(cd1);
		cbr.evaluateCase(cd1);
		cbr.evaluateCase(cd1);

		cd1.setCondition("Panic_disorder");
		cd1.getTests().add("Test2");

		try {
			//cbr.addEntry(cd1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Collection<RetrievalResult> evaluateCase(CaseDescription cD) {
		try {
			
			CBRQuery query = new CBRQuery();

			query.setDescription(cD);
			
			cycle(query);

			return requestResults;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	public void addEntry(CaseDescription cD) throws IOException {

		Map<String, Object> data = new HashMap<String, Object>();

		Collection<CBRCase> cases = _caseBase.getCases();
		
		CaseContainer cC = new CaseContainer();
		for (CBRCase c : cases) {
			cC.getCases().add((CaseDescription) c.getDescription());
		}
		cC.getCases().add(cD);

		data.put("cases", cC.getCases());

		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setPrettyFlow(true);

		Yaml yaml = new Yaml(options);

		FileWriter writer = new FileWriter("data/cases.yaml");
		yaml.dump(data, writer);

	}

	public static void seedWriter() throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();

		CaseContainer cc = new CaseContainer();
		CaseDescription cd1 = new CaseDescription();

		cd1.setAge(21);
		cd1.setGender('M');
		cd1.getSymptoms().add("Anxiety");
		cd1.getSymptoms().add("Depression");
		cd1.getTests().add("Test3");
		cd1.getTests().add("Test2");
		cd1.setCondition("Panic_disorder");

		CaseDescription cd2 = new CaseDescription();

		cd2.setAge(21);
		cd2.setGender('M');
		cd2.getSymptoms().add("Headache");
		cd2.getSymptoms().add("Depression");
		cd2.getTests().add("Test4");
		cd2.getTests().add("Test5");
		cd2.setCondition("Panic_disorder");

		cc.getCases().add(cd1);
		cc.getCases().add(cd2);

		data.put("cases", cc.getCases());

		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setPrettyFlow(true);

		Yaml yaml = new Yaml(options);

		FileWriter writer = new FileWriter("data/cases.yaml");
		yaml.dump(data, writer);
	}

}