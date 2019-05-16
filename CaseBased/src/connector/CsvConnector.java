package connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import model.CaseDescription;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector implements Connector {
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/data.csv")));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(",");

				CBRCase cbrCase = new CBRCase();

				CaseDescription caseDescription = new CaseDescription();

				caseDescription.setGender(values[0].charAt(0));
				caseDescription.setAge(Integer.parseInt(values[1]));
				caseDescription.setAbnormal_involuntary_movements(values[2].equals("1") ? true : false);
				caseDescription.setAbusing_alcohol(values[3].equals("1") ? true : false);
				caseDescription.setAcne_or_pimples(values[4].equals("1") ? true : false);
				caseDescription.setAntisocial_behavior(values[5].equals("1") ? true : false);
				caseDescription.setAnxiety_and_nervousness(values[6].equals("1") ? true : false);
				caseDescription.setBreathing_fast(values[7].equals("1") ? true : false);
				caseDescription.setChest_tightness(values[8].equals("1") ? true : false);
				caseDescription.setDecreased_appetite(values[9].equals("1") ? true : false);
				caseDescription.setDelusions_or_hallucinations(values[10].equals("1") ? true : false);
				caseDescription.setDepression(values[11].equals("1") ? true : false);
				caseDescription.setDepressive_or_psychotic_symptoms(values[12].equals("1") ? true : false);
				caseDescription.setDifficulty_eating(values[13].equals("1") ? true : false);
				caseDescription.setDisturbance_of_memory(values[14].equals("1") ? true : false);
				caseDescription.setDizziness(values[15].equals("1") ? true : false);
				caseDescription.setDrug_abuse(values[16].equals("1") ? true : false);
				caseDescription.setExcessive_anger(values[17].equals("1") ? true : false);
				caseDescription.setExcessive_appetite(values[18].equals("1") ? true : false);
				caseDescription.setFainting(values[19].equals("1") ? true : false);
				caseDescription.setFears_and_phobias(values[20].equals("1") ? true : false);
				caseDescription.setFeeling_ill(values[21].equals("1") ? true : false);
				caseDescription.setHeadache(values[22].equals("1") ? true : false);
				caseDescription.setHostile_behavior(values[23].equals("1") ? true : false);
				caseDescription.setHysterical_behavior(values[24].equals("1") ? true : false);
				caseDescription.setIncreased_heart_rate(values[25].equals("1") ? true : false);
				caseDescription.setInsomnia(values[26].equals("1") ? true : false);
				caseDescription.setIrregular_heartbeat(values[27].equals("1") ? true : false);
				caseDescription.setLack_of_growth(values[28].equals("1") ? true : false);
				caseDescription.setLoss_of_sex_drive(values[29].equals("1") ? true : false);
				caseDescription.setLow_self_esteem(values[30].equals("1") ? true : false);
				caseDescription.setNightmares(values[31].equals("1") ? true : false);
				caseDescription.setObsessions_and_compulsions(values[32].equals("1") ? true : false);
				caseDescription.setPalpitations(values[33].equals("1") ? true : false);
				caseDescription.setRestlessness(values[34].equals("1") ? true : false);
				caseDescription.setSharp_chest_pain(values[35].equals("1") ? true : false);
				caseDescription.setShortness_of_breath(values[36].equals("1") ? true : false);
				caseDescription.setSlurring_words(values[37].equals("1") ? true : false);
				caseDescription.setTemper_problems(values[38].equals("1") ? true : false);
				caseDescription.setVomiting_blood(values[39].equals("1") ? true : false);
				caseDescription.setWeight_gain(values[40].equals("1") ? true : false);
				caseDescription.setCondition(values[41]);

				
				cbrCase.setDescription(caseDescription);
				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}

}