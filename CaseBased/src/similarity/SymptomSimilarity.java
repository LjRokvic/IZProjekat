package similarity;

import ucm.gaia.jcolibri.exception.NoApplicableSimilarityFunctionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class SymptomSimilarity implements LocalSimilarityFunction {
	
	@Override
	public double compute(Object value1, Object value2) throws NoApplicableSimilarityFunctionException {

		Boolean val1 = (Boolean) value1;
		Boolean val2 = (Boolean) value2;
		
		if(val1 && val2) 
			return 1;
		
		if(!val1 && !val2)
			return 0.9;
		
		return 0;
	}

	@Override
	public boolean isApplicable(Object value1, Object value2) {
		if (value1 instanceof Boolean && value2 instanceof Boolean)
			return true;
		return false;
	}

	


	
	
}
