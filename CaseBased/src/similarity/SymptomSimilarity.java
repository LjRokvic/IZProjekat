package similarity;

import java.util.List;

import ucm.gaia.jcolibri.exception.NoApplicableSimilarityFunctionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class SymptomSimilarity implements LocalSimilarityFunction {
	
	@Override
	public double compute(Object value1, Object value2) throws NoApplicableSimilarityFunctionException {

		@SuppressWarnings("unchecked")
		List<String> val1 = (List<String>) value1;
		@SuppressWarnings("unchecked")
		List<String> val2 = (List<String>) value2;
		
		double sum = 0;
		
		for(String st : val1) {
			if(val2.contains(st)) {
				sum += 1;
			} else {
				sum += 0;
			}
		}
		
		for(String st : val2) {
			if(val1.contains(st)) {
				sum += 1;
			} else {
				sum += 0;
			}
		}
		
		sum = sum/(val1.size()+val2.size());
		
		return sum;
	}

	@Override
	public boolean isApplicable(Object value1, Object value2) {
		return true;
	}

	


	
	
}
