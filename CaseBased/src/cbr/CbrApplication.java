package cbr;

import java.util.Collection;

import connector.CsvConnector;
import model.CaseDescription;
import similarity.SymptomSimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
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

public class CbrApplication implements StandardCBRApplication {
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		
		// simConfig.addMapping(new Attribute("attribute", CaseDescription.class), new Interval(5));
		// TODO
		simConfig.addMapping(new Attribute("gender", CaseDescription.class), new Equal());		
		simConfig.addMapping(new Attribute("age", CaseDescription.class), new Interval(5));
		
		simConfig.addMapping(new Attribute("abnormal_involuntary_movements", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("abusing_alcohol", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("acne_or_pimples", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("antisocial_behavior", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("anxiety_and_nervousness", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("breathing_fast", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("chest_tightness", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("decreased_appetite", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("delusions_or_hallucinations", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("depression", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("depressive_or_psychotic_symptoms", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("difficulty_eating", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("disturbance_of_memory", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("dizziness", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("drug_abuse", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("excessive_anger", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("excessive_appetite", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("fainting", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("fears_and_phobias", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("feeling_ill", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("headache", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("hostile_behavior", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("hysterical_behavior", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("increased_heart_rate", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("insomnia", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("irregular_heartbeat", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("lack_of_growth", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("loss_of_sex_drive", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("low_self_esteem", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("nightmares", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("obsessions_and_compulsions", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("palpitations", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("restlessness", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("sharp_chest_pain", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("shortness_of_breath", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("slurring_words", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("temper_problems", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("vomiting_blood", CaseDescription.class), new SymptomSimilarity());
		simConfig.addMapping(new Attribute("weight_gain", CaseDescription.class), new SymptomSimilarity());


		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity) 
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 3);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		//java.util.Collection<CBRCase> cases = _caseBase.getCases();
		//for (CBRCase c: cases)
			//System.out.println(c.getDescription());
		return _caseBase;
	}

	public static void main(String[] args) {
		StandardCBRApplication recommender = new CbrApplication();
		try {
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();
			CaseDescription caseDescription = new CaseDescription();
			
			// TODO
			caseDescription.setAge(32);
			caseDescription.setGender('M');
			caseDescription.setAnxiety_and_nervousness(true);
			caseDescription.setDepression(true);
			caseDescription.setInsomnia(true);
			caseDescription.setHeadache(true);
			caseDescription.setShortness_of_breath(true);
			caseDescription.setDizziness(true);

			query.setDescription( caseDescription );

			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}