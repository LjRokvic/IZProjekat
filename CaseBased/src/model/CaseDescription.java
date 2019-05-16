package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class CaseDescription implements CaseComponent {
	
	
	private char gender;
	private int age;
	private boolean abnormal_involuntary_movements;
	private boolean abusing_alcohol;
	private boolean acne_or_pimples;
	private boolean antisocial_behavior;
	private boolean anxiety_and_nervousness;
	private boolean breathing_fast;
	private boolean chest_tightness;
	private boolean decreased_appetite;
	private boolean delusions_or_hallucinations;
	private boolean depression;
	private boolean depressive_or_psychotic_symptoms;
	private boolean difficulty_eating;
	private boolean disturbance_of_memory;
	private boolean dizziness;
	private boolean drug_abuse;
	private boolean excessive_anger;
	private boolean excessive_appetite;
	private boolean fainting;
	private boolean fears_and_phobias;
	private boolean feeling_ill;
	private boolean headache;
	private boolean hostile_behavior;
	private boolean hysterical_behavior;
	private boolean increased_heart_rate;
	private boolean insomnia;
	private boolean irregular_heartbeat;
	private boolean lack_of_growth;
	private boolean loss_of_sex_drive;
	private boolean low_self_esteem;
	private boolean nightmares;
	private boolean obsessions_and_compulsions;
	private boolean palpitations;
	private boolean restlessness;
	private boolean sharp_chest_pain;
	private boolean shortness_of_breath;
	private boolean slurring_words;
	private boolean temper_problems;
	private boolean vomiting_blood;
	private boolean weight_gain;
	
	private String condition;
	
	
	@Override
	public String toString() {
		return "CaseDescription [gender=" + gender + ", age=" + age + ", abnormal_involuntary_movements="
				+ abnormal_involuntary_movements + ", abusing_alcohol=" + abusing_alcohol + ", acne_or_pimples="
				+ acne_or_pimples + ", antisocial_behavior=" + antisocial_behavior + ", anxiety_and_nervousness="
				+ anxiety_and_nervousness + ", breathing_fast=" + breathing_fast + ", chest_tightness="
				+ chest_tightness + ", decreased_appetite=" + decreased_appetite + ", delusions_or_hallucinations="
				+ delusions_or_hallucinations + ", depression=" + depression + ", depressive_or_psychotic_symptoms="
				+ depressive_or_psychotic_symptoms + ", difficulty_eating=" + difficulty_eating
				+ ", disturbance_of_memory=" + disturbance_of_memory + ", dizziness=" + dizziness + ", drug_abuse="
				+ drug_abuse + ", excessive_anger=" + excessive_anger + ", excessive_appetite=" + excessive_appetite
				+ ", fainting=" + fainting + ", fears_and_phobias=" + fears_and_phobias + ", feeling_ill=" + feeling_ill
				+ ", headache=" + headache + ", hostile_behavior=" + hostile_behavior + ", hysterical_behavior="
				+ hysterical_behavior + ", increased_heart_rate=" + increased_heart_rate + ", insomnia=" + insomnia
				+ ", irregular_heartbeat=" + irregular_heartbeat + ", lack_of_growth=" + lack_of_growth
				+ ", loss_of_sex_drive=" + loss_of_sex_drive + ", low_self_esteem=" + low_self_esteem + ", nightmares="
				+ nightmares + ", obsessions_and_compulsions=" + obsessions_and_compulsions + ", palpitations="
				+ palpitations + ", restlessness=" + restlessness + ", sharp_chest_pain=" + sharp_chest_pain
				+ ", shortness_of_breath=" + shortness_of_breath + ", slurring_words=" + slurring_words
				+ ", temper_problems=" + temper_problems + ", vomiting_blood=" + vomiting_blood + ", weight_gain="
				+ weight_gain + ", condition=" + condition + "]";
	}


	public char getGender() {
		return gender;
	}




	public void setGender(char gender) {
		this.gender = gender;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public boolean isAbnormal_involuntary_movements() {
		return abnormal_involuntary_movements;
	}




	public void setAbnormal_involuntary_movements(boolean abnormal_involuntary_movements) {
		this.abnormal_involuntary_movements = abnormal_involuntary_movements;
	}




	public boolean isAbusing_alcohol() {
		return abusing_alcohol;
	}




	public void setAbusing_alcohol(boolean abusing_alcohol) {
		this.abusing_alcohol = abusing_alcohol;
	}




	public boolean isAntisocial_behavior() {
		return antisocial_behavior;
	}




	public void setAntisocial_behavior(boolean antisocial_behavior) {
		this.antisocial_behavior = antisocial_behavior;
	}




	public boolean isAnxiety_and_nervousness() {
		return anxiety_and_nervousness;
	}




	public void setAnxiety_and_nervousness(boolean anxiety_and_nervousness) {
		this.anxiety_and_nervousness = anxiety_and_nervousness;
	}




	public boolean isBreathing_fast() {
		return breathing_fast;
	}




	public void setBreathing_fast(boolean breathing_fast) {
		this.breathing_fast = breathing_fast;
	}




	public boolean isChest_tightness() {
		return chest_tightness;
	}




	public void setChest_tightness(boolean chest_tightness) {
		this.chest_tightness = chest_tightness;
	}




	public boolean isDecreased_appetite() {
		return decreased_appetite;
	}




	public void setDecreased_appetite(boolean decreased_appetite) {
		this.decreased_appetite = decreased_appetite;
	}




	public boolean isDelusions_or_hallucinations() {
		return delusions_or_hallucinations;
	}




	public void setDelusions_or_hallucinations(boolean delusions_or_hallucinations) {
		this.delusions_or_hallucinations = delusions_or_hallucinations;
	}




	public boolean isDepression() {
		return depression;
	}




	public void setDepression(boolean depression) {
		this.depression = depression;
	}




	public boolean isDepressive_or_psychotic_symptoms() {
		return depressive_or_psychotic_symptoms;
	}




	public void setDepressive_or_psychotic_symptoms(boolean depressive_or_psychotic_symptoms) {
		this.depressive_or_psychotic_symptoms = depressive_or_psychotic_symptoms;
	}




	public boolean isDifficulty_eating() {
		return difficulty_eating;
	}




	public void setDifficulty_eating(boolean difficulty_eating) {
		this.difficulty_eating = difficulty_eating;
	}




	public boolean isDisturbance_of_memory() {
		return disturbance_of_memory;
	}




	public void setDisturbance_of_memory(boolean disturbance_of_memory) {
		this.disturbance_of_memory = disturbance_of_memory;
	}




	public boolean isDizziness() {
		return dizziness;
	}




	public void setDizziness(boolean dizziness) {
		this.dizziness = dizziness;
	}




	public boolean isDrug_abuse() {
		return drug_abuse;
	}




	public void setDrug_abuse(boolean drug_abuse) {
		this.drug_abuse = drug_abuse;
	}




	public boolean isExcessive_anger() {
		return excessive_anger;
	}




	public void setExcessive_anger(boolean excessive_anger) {
		this.excessive_anger = excessive_anger;
	}




	public boolean isExcessive_appetite() {
		return excessive_appetite;
	}




	public void setExcessive_appetite(boolean excessive_appetite) {
		this.excessive_appetite = excessive_appetite;
	}




	public boolean isFainting() {
		return fainting;
	}




	public void setFainting(boolean fainting) {
		this.fainting = fainting;
	}




	public boolean isFears_and_phobias() {
		return fears_and_phobias;
	}




	public void setFears_and_phobias(boolean fears_and_phobias) {
		this.fears_and_phobias = fears_and_phobias;
	}




	public boolean isFeeling_ill() {
		return feeling_ill;
	}




	public void setFeeling_ill(boolean feeling_ill) {
		this.feeling_ill = feeling_ill;
	}




	public boolean isHeadache() {
		return headache;
	}




	public void setHeadache(boolean headache) {
		this.headache = headache;
	}




	public boolean isHostile_behavior() {
		return hostile_behavior;
	}




	public void setHostile_behavior(boolean hostile_behavior) {
		this.hostile_behavior = hostile_behavior;
	}




	public boolean isHysterical_behavior() {
		return hysterical_behavior;
	}




	public void setHysterical_behavior(boolean hysterical_behavior) {
		this.hysterical_behavior = hysterical_behavior;
	}




	public boolean isIncreased_heart_rate() {
		return increased_heart_rate;
	}




	public void setIncreased_heart_rate(boolean increased_heart_rate) {
		this.increased_heart_rate = increased_heart_rate;
	}




	public boolean isInsomnia() {
		return insomnia;
	}




	public void setInsomnia(boolean insomnia) {
		this.insomnia = insomnia;
	}




	public boolean isIrregular_heartbeat() {
		return irregular_heartbeat;
	}




	public void setIrregular_heartbeat(boolean irregular_heartbeat) {
		this.irregular_heartbeat = irregular_heartbeat;
	}




	public boolean isLack_of_growth() {
		return lack_of_growth;
	}




	public void setLack_of_growth(boolean lack_of_growth) {
		this.lack_of_growth = lack_of_growth;
	}




	public boolean isLoss_of_sex_drive() {
		return loss_of_sex_drive;
	}




	public void setLoss_of_sex_drive(boolean loss_of_sex_drive) {
		this.loss_of_sex_drive = loss_of_sex_drive;
	}




	public boolean isLow_self_esteem() {
		return low_self_esteem;
	}




	public void setLow_self_esteem(boolean low_self_esteem) {
		this.low_self_esteem = low_self_esteem;
	}




	public boolean isNightmares() {
		return nightmares;
	}




	public void setNightmares(boolean nightmares) {
		this.nightmares = nightmares;
	}




	public boolean isObsessions_and_compulsions() {
		return obsessions_and_compulsions;
	}




	public void setObsessions_and_compulsions(boolean obsessions_and_compulsions) {
		this.obsessions_and_compulsions = obsessions_and_compulsions;
	}




	public boolean isPalpitations() {
		return palpitations;
	}




	public void setPalpitations(boolean palpitations) {
		this.palpitations = palpitations;
	}




	public boolean isRestlessness() {
		return restlessness;
	}




	public void setRestlessness(boolean restlessness) {
		this.restlessness = restlessness;
	}




	public boolean isSharp_chest_pain() {
		return sharp_chest_pain;
	}




	public void setSharp_chest_pain(boolean sharp_chest_pain) {
		this.sharp_chest_pain = sharp_chest_pain;
	}




	public boolean isShortness_of_breath() {
		return shortness_of_breath;
	}




	public void setShortness_of_breath(boolean shortness_of_breath) {
		this.shortness_of_breath = shortness_of_breath;
	}




	public boolean isSlurring_words() {
		return slurring_words;
	}




	public void setSlurring_words(boolean slurring_words) {
		this.slurring_words = slurring_words;
	}




	public boolean isTemper_problems() {
		return temper_problems;
	}




	public void setTemper_problems(boolean temper_problems) {
		this.temper_problems = temper_problems;
	}




	public boolean isVomiting_blood() {
		return vomiting_blood;
	}




	public void setVomiting_blood(boolean vomiting_blood) {
		this.vomiting_blood = vomiting_blood;
	}




	public boolean isWeight_gain() {
		return weight_gain;
	}




	public void setWeight_gain(boolean weight_gain) {
		this.weight_gain = weight_gain;
	}




	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}




	public boolean isAcne_or_pimples() {
		return acne_or_pimples;
	}




	public void setAcne_or_pimples(boolean acne_or_pimples) {
		this.acne_or_pimples = acne_or_pimples;
	}




	public String getCondition() {
		return condition;
	}




	public void setCondition(String condition) {
		this.condition = condition;
	}
}
