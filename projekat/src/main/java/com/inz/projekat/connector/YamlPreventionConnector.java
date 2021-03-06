package com.inz.projekat.connector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import org.yaml.snakeyaml.Yaml;

import com.inz.projekat.model.dto.PreventiveContainer;
import com.inz.projekat.model.dto.PreventiveDescription;

import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;

public class YamlPreventionConnector implements Connector {

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();

		Yaml yaml = new Yaml();
		
		InputStream file;
		try {
			file = new FileInputStream("data/preventive.yaml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
				
		PreventiveContainer preventiveContainer = yaml.loadAs(file, PreventiveContainer.class);
		
		for(PreventiveDescription cd : preventiveContainer.getCases()) {
			CBRCase cbrCase = new CBRCase();
			cbrCase.setDescription(cd);
			cases.add(cbrCase);
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