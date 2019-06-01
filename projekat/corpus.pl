condition('Panic_disorder', ['Anxiety_and_nervousness','Depression','Shortness_of_breath','Depressive_or_psychotic_symptoms','Sharp_chest_pain','Dizziness','Insomnia','Abnormal_involuntary_movements','Chest_tightness','Palpitations','Irregular_heartbeat','Breathing_fast']).

symptom_relation('Panic_disorder', 'Anxiety_and_nervousness', 0.88).
symptom_relation('Panic_disorder', 'Depression', 0.55).
symptom_relation('Panic_disorder', 'Shortness_of_breath', 0.4).
symptom_relation('Panic_disorder', 'Depressive_or_psychotic_symptoms', 0.33).
symptom_relation('Panic_disorder', 'Sharp_chest_pain', 0.33).
symptom_relation('Panic_disorder', 'Dizziness', 0.24).
symptom_relation('Panic_disorder', 'Insomnia', 0.18).
symptom_relation('Panic_disorder', 'Abnormal_involuntary_movements', 0.16).
symptom_relation('Panic_disorder', 'Chest_tightness', 0.14).
symptom_relation('Panic_disorder', 'Palpitations', 0.13).
symptom_relation('Panic_disorder', 'Irregular_heartbeat', 0.11).
symptom_relation('Panic_disorder', 'Breathing_fast', 0.1).

test_for_condition('Panic_disorder', 'Psychotherapy').
test_for_condition('Panic_disorder', 'Mental_health_counseling').
test_for_condition('Panic_disorder', 'Electrocardiogram').
test_for_condition('Panic_disorder', 'Depression_screen_(Depression_screening)').
test_for_condition('Panic_disorder', 'Toxicology_screen').
test_for_condition('Panic_disorder', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Panic_disorder', 'Occupational_therapy_assessment_(Speech_therapy)').

treatment_for_condition('Panic_disorder', 'Lorazepam').
treatment_for_condition('Panic_disorder', 'Alprazolam_(Xanax)').
treatment_for_condition('Panic_disorder', 'Clonazepam').
treatment_for_condition('Panic_disorder', 'Paroxetine_(Paxil)').
treatment_for_condition('Panic_disorder', 'Venlafaxine_(Effexor)').
treatment_for_condition('Panic_disorder', 'Mirtazapine').
treatment_for_condition('Panic_disorder', 'Buspirone_(Buspar)').
treatment_for_condition('Panic_disorder', 'Fluvoxamine_(Luvox)').
treatment_for_condition('Panic_disorder', 'Imipramine').
treatment_for_condition('Panic_disorder', 'Desvenlafaxine_(Pristiq)').
treatment_for_condition('Panic_disorder', 'Clomipramine').
treatment_for_condition('Panic_disorder', 'Acamprosate_(Campral)').
treatment_for_condition('Panic_disorder', 'Disulfiram_(Antabuse)').

condition('Eating_disorder', ['Depression','Anxiety_and_nervousness','Depressive_or_psychotic_symptoms','Decreased_appetite','Abusing_alcohol','Excessive_appetite','Difficulty_eating','Weight_gain','Excessive_anger','Insomnia','Vomiting_blood','Acne_or_pimples']).

symptom_relation('Eating_disorder', 'Depression', 0.63).
symptom_relation('Eating_disorder', 'Anxiety_and_nervousness', 0.51).
symptom_relation('Eating_disorder', 'Depressive_or_psychotic_symptoms', 0.43).
symptom_relation('Eating_disorder', 'Decreased_appetite', 0.41).
symptom_relation('Eating_disorder', 'Abusing_alcohol', 0.24).
symptom_relation('Eating_disorder', 'Excessive_appetite', 0.24).
symptom_relation('Eating_disorder', 'Difficulty_eating', 0.2).
symptom_relation('Eating_disorder', 'Weight_gain', 0.17).
symptom_relation('Eating_disorder', 'Excessive_anger', 0.13).
symptom_relation('Eating_disorder', 'Insomnia', 0.13).
symptom_relation('Eating_disorder', 'Vomiting_blood', 0.09).
symptom_relation('Eating_disorder', 'Acne_or_pimples', 0.09).

test_for_condition('Eating_disorder', 'Psychotherapy').
test_for_condition('Eating_disorder', 'Mental_health_counseling').
test_for_condition('Eating_disorder', 'Depression_screen_(Depression_screening)').
test_for_condition('Eating_disorder', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Eating_disorder', 'Occupational_therapy_assessment_(Speech_therapy)').
test_for_condition('Eating_disorder', 'Other_diagnostic_radiology_and_related_techniques').

treatment_for_condition('Eating_disorder', 'Fluoxetine_(Prozac)').
treatment_for_condition('Eating_disorder', 'Trazodone').
treatment_for_condition('Eating_disorder', 'Quetiapine_(Seroquel)').
treatment_for_condition('Eating_disorder', 'Lamotrigine_(Lamictal)').
treatment_for_condition('Eating_disorder', 'Topiramate_(Topamax)').
treatment_for_condition('Eating_disorder', 'Venlafaxine_(Effexor)').
treatment_for_condition('Eating_disorder', 'Aripiprazole_(Abilify)').
treatment_for_condition('Eating_disorder', 'Minocycline').
treatment_for_condition('Eating_disorder', 'Benzoyl_Peroxide_Topical').
treatment_for_condition('Eating_disorder', 'Tranylcypromine_(Parnate)').
treatment_for_condition('Eating_disorder', 'Phenelzine_(Nardil)').
treatment_for_condition('Eating_disorder', 'Chlorpromazine_(Thorazine)').
treatment_for_condition('Eating_disorder', 'Lisdexamfetamine_(Vyvanse)').

condition('Attention_deficit_hyperactivity_disorder_(ADHD)', ['Depressive_or_psychotic_symptoms','Depression','Anxiety_and_nervousness','Hostile_behavior','Excessive_anger','Restlessness','Temper_problems','Drug_abuse','Obsessions_and_compulsions','Low_self-esteem','Lack_of_growth','Antisocial_behavior']).

symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Depressive_or_psychotic_symptoms', 0.53).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Depression', 0.34).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Anxiety_and_nervousness', 0.32).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Hostile_behavior', 0.17).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Excessive_anger', 0.17).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Restlessness', 0.15).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Temper_problems', 0.09).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Drug_abuse', 0.08).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Obsessions_and_compulsions', 0.08).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Low_self-esteem', 0.04).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Lack_of_growth', 0.04).
symptom_relation('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Antisocial_behavior', 0.02).

test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Psychotherapy').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Mental_health_counseling').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Depression_screen_(Depression_screening)').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Occupational_therapy_assessment_(Speech_therapy)').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Electroencephalogram_(EEG)_(Eeg)').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Cerebral_arteriogram_(Angiography_cerebral)').
test_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Arterio-_or_venogram_(not_heart_and_head)').

treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Methylphenidate').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Adderall').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Clonidine').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Atomoxetine_(Strattera)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Dexmethylphenidate_(Focalin)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Risperidone').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Lisdexamfetamine_(Vyvanse)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Aripiprazole_(Abilify)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Guanfacine_(Intuniv)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Oxcarbazepine_(Trileptal)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Melatonin').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Dextroamphetamine_(Adderall)').
treatment_for_condition('Attention_deficit_hyperactivity_disorder_(ADHD)', 'Cyproheptadine').

condition('Asperger_syndrome', ['Depressive_or_psychotic_symptoms','Anxiety_and_nervousness','Depression','Temper_problems','Lack_of_growth','Fainting','Antisocial_behavior','Delusions_or_hallucinations','Hostile_behavior','Excessive_anger','Obsessions_and_compulsions','Nightmares']).

symptom_relation('Asperger_syndrome', 'Depressive_or_psychotic_symptoms', 0.6).
symptom_relation('Asperger_syndrome', 'Anxiety_and_nervousness', 0.53).
symptom_relation('Asperger_syndrome', 'Depression', 0.36).
symptom_relation('Asperger_syndrome', 'Temper_problems', 0.18).
symptom_relation('Asperger_syndrome', 'Lack_of_growth', 0.18).
symptom_relation('Asperger_syndrome', 'Fainting', 0.15).
symptom_relation('Asperger_syndrome', 'Antisocial_behavior', 0.12).
symptom_relation('Asperger_syndrome', 'Delusions_or_hallucinations', 0.08).
symptom_relation('Asperger_syndrome', 'Hostile_behavior', 0.08).
symptom_relation('Asperger_syndrome', 'Excessive_anger', 0.04).
symptom_relation('Asperger_syndrome', 'Obsessions_and_compulsions', 0.04).
symptom_relation('Asperger_syndrome', 'Nightmares', 0.04).

test_for_condition('Asperger_syndrome', 'Psychotherapy').
test_for_condition('Asperger_syndrome', 'Mental_health_counseling').
test_for_condition('Asperger_syndrome', 'Occupational_therapy_assessment_(Speech_therapy)').
test_for_condition('Asperger_syndrome', 'Depression_screen_(Depression_screening)').
test_for_condition('Asperger_syndrome', 'Electroencephalogram_(EEG)_(Eeg)').
test_for_condition('Asperger_syndrome', 'Psychological_and_psychiatric_evaluation_and_therapy').

treatment_for_condition('Asperger_syndrome', 'Methylphenidate').
treatment_for_condition('Asperger_syndrome', 'Risperidone').
treatment_for_condition('Asperger_syndrome', 'Clonidine').
treatment_for_condition('Asperger_syndrome', 'Aripiprazole_(Abilify)').
treatment_for_condition('Asperger_syndrome', 'Adderall').
treatment_for_condition('Asperger_syndrome', 'Atomoxetine_(Strattera)').
treatment_for_condition('Asperger_syndrome', 'Guanfacine_(Intuniv)').
treatment_for_condition('Asperger_syndrome', 'Melatonin').
treatment_for_condition('Asperger_syndrome', 'Dexmethylphenidate_(Focalin)').
treatment_for_condition('Asperger_syndrome', 'Lisdexamfetamine_(Vyvanse)').
treatment_for_condition('Asperger_syndrome', 'Oxcarbazepine_(Trileptal)').
treatment_for_condition('Asperger_syndrome', 'Fluvoxamine_(Luvox)').
treatment_for_condition('Asperger_syndrome', 'Amantadine').

condition('Bipolar_disorder', ['Depressive_or_psychotic_symptoms','Depression','Anxiety_and_nervousness','Insomnia','Hostile_behavior','Delusions_or_hallucinations','Abusing_alcohol','Drug_abuse','Excessive_anger','Temper_problems','Fears_and_phobias','Obsessions_and_compulsions']).

symptom_relation('Bipolar_disorder', 'Depressive_or_psychotic_symptoms', 0.64).
symptom_relation('Bipolar_disorder', 'Depression', 0.62).
symptom_relation('Bipolar_disorder', 'Anxiety_and_nervousness', 0.48).
symptom_relation('Bipolar_disorder', 'Insomnia', 0.21).
symptom_relation('Bipolar_disorder', 'Hostile_behavior', 0.21).
symptom_relation('Bipolar_disorder', 'Delusions_or_hallucinations', 0.2).
symptom_relation('Bipolar_disorder', 'Abusing_alcohol', 0.18).
symptom_relation('Bipolar_disorder', 'Drug_abuse', 0.18).
symptom_relation('Bipolar_disorder', 'Excessive_anger', 0.15).
symptom_relation('Bipolar_disorder', 'Temper_problems', 0.13).
symptom_relation('Bipolar_disorder', 'Fears_and_phobias', 0.07).
symptom_relation('Bipolar_disorder', 'Obsessions_and_compulsions', 0.04).

test_for_condition('Bipolar_disorder', 'Psychotherapy').
test_for_condition('Bipolar_disorder', 'Mental_health_counseling').
test_for_condition('Bipolar_disorder', 'Toxicology_screen').
test_for_condition('Bipolar_disorder', 'Depression_screen_(Depression_screening)').
test_for_condition('Bipolar_disorder', 'Blood_alcohol').
test_for_condition('Bipolar_disorder', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Bipolar_disorder', 'Occupational_therapy_assessment_(Speech_therapy)').
test_for_condition('Bipolar_disorder', 'Electroencephalogram_(EEG)_(Eeg)').

treatment_for_condition('Bipolar_disorder', 'Quetiapine_(Seroquel)').
treatment_for_condition('Bipolar_disorder', 'Lamotrigine_(Lamictal)').
treatment_for_condition('Bipolar_disorder', 'Divalproex_Sodium_(Depakote)').
treatment_for_condition('Bipolar_disorder', 'Lithium_(Li)').
treatment_for_condition('Bipolar_disorder', 'Aripiprazole_(Abilify)').
treatment_for_condition('Bipolar_disorder', 'Clonazepam').
treatment_for_condition('Bipolar_disorder', 'Risperidone').
treatment_for_condition('Bipolar_disorder', 'Bupropion_(Wellbutrin)').
treatment_for_condition('Bipolar_disorder', 'Olanzapine_(Zyprexa)').
treatment_for_condition('Bipolar_disorder', 'Ziprasidone_(Geodon)').
treatment_for_condition('Bipolar_disorder', 'Benztropine').
treatment_for_condition('Bipolar_disorder', 'Oxcarbazepine_(Trileptal)').
treatment_for_condition('Bipolar_disorder', 'Haloperidol').

condition('Obsessive_compulsive_disorder_(OCD)', ['Anxiety_and_nervousness','Depression','Depressive_or_psychotic_symptoms','Obsessions_and_compulsions','Temper_problems','Hostile_behavior','Low_self-esteem','Excessive_anger','Feeling_ill','Fears_and_phobias','Hysterical_behavior','Lack_of_growth']).

symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Anxiety_and_nervousness', 0.68).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Depression', 0.56).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Depressive_or_psychotic_symptoms', 0.47).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Obsessions_and_compulsions', 0.33).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Temper_problems', 0.14).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Hostile_behavior', 0.13).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Low_self-esteem', 0.12).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Excessive_anger', 0.1).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Feeling_ill', 0.1).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Fears_and_phobias', 0.1).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Hysterical_behavior', 0.04).
symptom_relation('Obsessive_compulsive_disorder_(OCD)', 'Lack_of_growth', 0.04).

test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Psychotherapy').
test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Mental_health_counseling').
test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Depression_screen_(Depression_screening)').
test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Occupational_therapy_assessment_(Speech_therapy)').
test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Electroencephalogram_(EEG)_(Eeg)').
test_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Diagnostic_spinal_tap_(Spinal_tap)').

treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Fluoxetine_(Prozac)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Clonazepam').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Sertraline_(Zoloft)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Risperidone').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Quetiapine_(Seroquel)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Fluvoxamine_(Luvox)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Methylphenidate').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Aripiprazole_(Abilify)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Buspirone_(Buspar)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Clomipramine').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Ziprasidone_(Geodon)').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Mirtazapine').
treatment_for_condition('Obsessive_compulsive_disorder_(OCD)', 'Atomoxetine_(Strattera)').

condition('Post-traumatic_stress_disorder_(PTSD)', ['Anxiety_and_nervousness','Depression','Depressive_or_psychotic_symptoms','Insomnia','Delusions_or_hallucinations','Drug_abuse','Excessive_anger','Temper_problems','Abusing_alcohol','Low_self-esteem','Hostile_behavior','Fears_and_phobias']).

symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Anxiety_and_nervousness', 0.7).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Depression', 0.66).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Depressive_or_psychotic_symptoms', 0.57).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Insomnia', 0.23).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Delusions_or_hallucinations', 0.19).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Drug_abuse', 0.16).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Excessive_anger', 0.14).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Temper_problems', 0.11).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Abusing_alcohol', 0.1).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Low_self-esteem', 0.09).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Hostile_behavior', 0.09).
symptom_relation('Post-traumatic_stress_disorder_(PTSD)', 'Fears_and_phobias', 0.09).

test_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Psychotherapy').
test_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Mental_health_counseling').
test_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Depression_screen_(Depression_screening)').
test_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Occupational_therapy_assessment_(Speech_therapy)').

treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Clonazepam').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Quetiapine_(Seroquel)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Trazodone').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Bupropion_(Wellbutrin)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Fluoxetine_(Prozac)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Risperidone').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Lamotrigine_(Lamictal)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Aripiprazole_(Abilify)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Mirtazapine').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Lithium_(Li)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Olanzapine_(Zyprexa)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Eszopiclone_(Lunesta)').
treatment_for_condition('Post-traumatic_stress_disorder_(PTSD)', 'Oxcarbazepine_(Trileptal)').

condition('Dysthymic_disorder', ['Depression','Anxiety_and_nervousness','Depressive_or_psychotic_symptoms','Insomnia','Excessive_anger','Low_self-esteem','Disturbance_of_memory','Temper_problems','Fears_and_phobias','Slurring_words','Loss_of_sex_drive','Antisocial_behavior']).

symptom_relation('Dysthymic_disorder', 'Depression', 0.76).
symptom_relation('Dysthymic_disorder', 'Anxiety_and_nervousness', 0.72).
symptom_relation('Dysthymic_disorder', 'Depressive_or_psychotic_symptoms', 0.44).
symptom_relation('Dysthymic_disorder', 'Insomnia', 0.22).
symptom_relation('Dysthymic_disorder', 'Excessive_anger', 0.07).
symptom_relation('Dysthymic_disorder', 'Low_self-esteem', 0.07).
symptom_relation('Dysthymic_disorder', 'Disturbance_of_memory', 0.06).
symptom_relation('Dysthymic_disorder', 'Temper_problems', 0.04).
symptom_relation('Dysthymic_disorder', 'Fears_and_phobias', 0.04).
symptom_relation('Dysthymic_disorder', 'Slurring_words', 0.03).
symptom_relation('Dysthymic_disorder', 'Loss_of_sex_drive', 0.02).
symptom_relation('Dysthymic_disorder', 'Antisocial_behavior', 0.02).

test_for_condition('Dysthymic_disorder', 'Psychotherapy').
test_for_condition('Dysthymic_disorder', 'Mental_health_counseling').
test_for_condition('Dysthymic_disorder', 'Depression_screen_(Depression_screening)').
test_for_condition('Dysthymic_disorder', 'Lipid_panel').
test_for_condition('Dysthymic_disorder', 'Toxicology_screen').
test_for_condition('Dysthymic_disorder', 'Psychological_and_psychiatric_evaluation_and_therapy').
test_for_condition('Dysthymic_disorder', 'Varicose_vein_stripping;_lower_limb').
test_for_condition('Dysthymic_disorder', 'Other_OR_therapeutic_procedures_on_nose;_mouth_and_pharynx').

treatment_for_condition('Dysthymic_disorder', 'Escitalopram_(Lexapro)').
treatment_for_condition('Dysthymic_disorder', 'Fluoxetine_(Prozac)').
treatment_for_condition('Dysthymic_disorder', 'Bupropion_(Wellbutrin)').
treatment_for_condition('Dysthymic_disorder', 'Clonazepam').
treatment_for_condition('Dysthymic_disorder', 'Citalopram_(Celexa)').
treatment_for_condition('Dysthymic_disorder', 'Paroxetine_(Paxil)').
treatment_for_condition('Dysthymic_disorder', 'Venlafaxine_(Effexor)').
treatment_for_condition('Dysthymic_disorder', 'Buspirone_(Buspar)').
treatment_for_condition('Dysthymic_disorder', 'Atomoxetine_(Strattera)').
treatment_for_condition('Dysthymic_disorder', 'Doxepin').
treatment_for_condition('Dysthymic_disorder', 'Desvenlafaxine_(Pristiq)').
treatment_for_condition('Dysthymic_disorder', 'Darunavir_(Prezista)').
treatment_for_condition('Dysthymic_disorder', 'Lopinavir').

condition('Anxiety', ['Anxiety_and_nervousness','Depression','Sharp_chest_pain','Depressive_or_psychotic_symptoms','Shortness_of_breath','Headache','Insomnia','Palpitations','Abnormal_involuntary_movements','Irregular_heartbeat','Fears_and_phobias','Increased_heart_rate']).

symptom_relation('Anxiety', 'Anxiety_and_nervousness', 0.82).
symptom_relation('Anxiety', 'Depression', 0.43).
symptom_relation('Anxiety', 'Sharp_chest_pain', 0.38).
symptom_relation('Anxiety', 'Depressive_or_psychotic_symptoms', 0.35).
symptom_relation('Anxiety', 'Shortness_of_breath', 0.29).
symptom_relation('Anxiety', 'Headache', 0.27).
symptom_relation('Anxiety', 'Insomnia', 0.24).
symptom_relation('Anxiety', 'Palpitations', 0.13).
symptom_relation('Anxiety', 'Abnormal_involuntary_movements', 0.12).
symptom_relation('Anxiety', 'Irregular_heartbeat', 0.09).
symptom_relation('Anxiety', 'Fears_and_phobias', 0.06).
symptom_relation('Anxiety', 'Increased_heart_rate', 0.05).

test_for_condition('Anxiety', 'Psychotherapy').
test_for_condition('Anxiety', 'Electrocardiogram').
test_for_condition('Anxiety', 'Mental_health_counseling').
test_for_condition('Anxiety', 'Cardiac_monitoring_(Cardiac_monitor)').
test_for_condition('Anxiety', 'Depression_screen_(Depression_screening)').
test_for_condition('Anxiety', 'Toxicology_screen').
test_for_condition('Anxiety', 'Blood_alcohol').
test_for_condition('Anxiety', 'Psychological_and_psychiatric_evaluation_and_therapy').

treatment_for_condition('Anxiety', 'Lorazepam').
treatment_for_condition('Anxiety', 'Alprazolam_(Xanax)').
treatment_for_condition('Anxiety', 'Clonazepam').
treatment_for_condition('Anxiety', 'Buspirone_(Buspar)').
treatment_for_condition('Anxiety', 'Clorazepate').
treatment_for_condition('Anxiety', 'Oxazepam').
treatment_for_condition('Anxiety', 'Loxapine').
treatment_for_condition('Anxiety', 'L-Methylfolate').
treatment_for_condition('Anxiety', 'Flurazepam').
treatment_for_condition('Anxiety', 'Meprobamate_(Miltown)').
treatment_for_condition('Anxiety', 'Phenelzine_(Nardil)').

condition('Schizophrenia', ['Depressive_or_psychotic_symptoms','Delusions_or_hallucinations','Depression','Anxiety_and_nervousness','Hostile_behavior','Fears_and_phobias','Drug_abuse','Insomnia','Temper_problems','Excessive_anger','Hysterical_behavior','Low_self-esteem']).

symptom_relation('Schizophrenia', 'Depressive_or_psychotic_symptoms', 0.6).
symptom_relation('Schizophrenia', 'Delusions_or_hallucinations', 0.56).
symptom_relation('Schizophrenia', 'Depression', 0.43).
symptom_relation('Schizophrenia', 'Anxiety_and_nervousness', 0.32).
symptom_relation('Schizophrenia', 'Hostile_behavior', 0.31).
symptom_relation('Schizophrenia', 'Fears_and_phobias', 0.18).
symptom_relation('Schizophrenia', 'Drug_abuse', 0.14).
symptom_relation('Schizophrenia', 'Insomnia', 0.14).
symptom_relation('Schizophrenia', 'Temper_problems', 0.08).
symptom_relation('Schizophrenia', 'Excessive_anger', 0.06).
symptom_relation('Schizophrenia', 'Hysterical_behavior', 0.03).
symptom_relation('Schizophrenia', 'Low_self-esteem', 0.02).

test_for_condition('Schizophrenia', 'Psychotherapy').
test_for_condition('Schizophrenia', 'Mental_health_counseling').
test_for_condition('Schizophrenia', 'Toxicology_screen').
test_for_condition('Schizophrenia', 'Blood_alcohol').
test_for_condition('Schizophrenia', 'Liver_function_tests_(Liver_test)').
test_for_condition('Schizophrenia', 'Arterial_blood_gases_(ABGs)').
test_for_condition('Schizophrenia', 'Prothrombin_time_assay_(Prothrombin_time)').
test_for_condition('Schizophrenia', 'Blood_culture').

treatment_for_condition('Schizophrenia', 'Risperidone').
treatment_for_condition('Schizophrenia', 'Benztropine').
treatment_for_condition('Schizophrenia', 'Olanzapine_(Zyprexa)').
treatment_for_condition('Schizophrenia', 'Haloperidol').
treatment_for_condition('Schizophrenia', 'Quetiapine_(Seroquel)').
treatment_for_condition('Schizophrenia', 'Divalproex_Sodium_(Depakote)').
treatment_for_condition('Schizophrenia', 'Aripiprazole_(Abilify)').
treatment_for_condition('Schizophrenia', 'Ziprasidone_(Geodon)').
treatment_for_condition('Schizophrenia', 'Clozapine').
treatment_for_condition('Schizophrenia', 'Fluphenazine_(Prolixin)').
treatment_for_condition('Schizophrenia', 'Lithium_(Li)').
treatment_for_condition('Schizophrenia', 'Perphenazine').
treatment_for_condition('Schizophrenia', 'Paliperidone_(Invega)').

symptom('Abnormal_involuntary_movements').
symptom('Abusing_alcohol').
symptom('Acne_or_pimples').
symptom('Antisocial_behavior').
symptom('Anxiety_and_nervousness').
symptom('Breathing_fast').
symptom('Chest_tightness').
symptom('Decreased_appetite').
symptom('Delusions_or_hallucinations').
symptom('Depression').
symptom('Depressive_or_psychotic_symptoms').
symptom('Difficulty_eating').
symptom('Disturbance_of_memory').
symptom('Dizziness').
symptom('Drug_abuse').
symptom('Excessive_anger').
symptom('Excessive_appetite').
symptom('Fainting').
symptom('Fears_and_phobias').
symptom('Feeling_ill').
symptom('Headache').
symptom('Hostile_behavior').
symptom('Hysterical_behavior').
symptom('Increased_heart_rate').
symptom('Insomnia').
symptom('Irregular_heartbeat').
symptom('Lack_of_growth').
symptom('Loss_of_sex_drive').
symptom('Low_self-esteem').
symptom('Nightmares').
symptom('Obsessions_and_compulsions').
symptom('Palpitations').
symptom('Restlessness').
symptom('Sharp_chest_pain').
symptom('Shortness_of_breath').
symptom('Slurring_words').
symptom('Temper_problems').
symptom('Vomiting_blood').
symptom('Weight_gain').

test('Varicose_vein_stripping;_lower_limb').
test('Arterio-_or_venogram_(not_heart_and_head)').
test('Cardiac_monitoring_(Cardiac_monitor)').
test('Other_OR_therapeutic_procedures_on_nose;_mouth_and_pharynx').
test('Electroencephalogram_(EEG)_(Eeg)').
test('Psychological_and_psychiatric_evaluation_and_therapy').
test('Liver_function_tests_(Liver_test)').
test('Blood_culture').
test('Occupational_therapy_assessment_(Speech_therapy)').
test('Mental_health_counseling').
test('Lipid_panel').
test('Other_diagnostic_radiology_and_related_techniques').
test('Toxicology_screen').
test('Cerebral_arteriogram_(Angiography_cerebral)').
test('Diagnostic_spinal_tap_(Spinal_tap)').
test('Blood_alcohol').
test('Arterial_blood_gases_(ABGs)').
test('Prothrombin_time_assay_(Prothrombin_time)').
test('Depression_screen_(Depression_screening)').
test('Psychotherapy').
test('Electrocardiogram').

treatment('Benzoyl_Peroxide_Topical').
treatment('Ziprasidone_(Geodon)').
treatment('Risperidone').
treatment('Lorazepam').
treatment('Minocycline').
treatment('Guanfacine_(Intuniv)').
treatment('Lamotrigine_(Lamictal)').
treatment('Phenelzine_(Nardil)').
treatment('Haloperidol').
treatment('Desvenlafaxine_(Pristiq)').
treatment('Escitalopram_(Lexapro)').
treatment('Disulfiram_(Antabuse)').
treatment('Atomoxetine_(Strattera)').
treatment('Dexmethylphenidate_(Focalin)').
treatment('Tranylcypromine_(Parnate)').
treatment('Aripiprazole_(Abilify)').
treatment('Methylphenidate').
treatment('Imipramine').
treatment('Topiramate_(Topamax)').
treatment('Melatonin').
treatment('Quetiapine_(Seroquel)').
treatment('Chlorpromazine_(Thorazine)').
treatment('L-Methylfolate').
treatment('Oxazepam').
treatment('Citalopram_(Celexa)').
treatment('Clorazepate').
treatment('Adderall').
treatment('Oxcarbazepine_(Trileptal)').
treatment('Eszopiclone_(Lunesta)').
treatment('Olanzapine_(Zyprexa)').
treatment('Paliperidone_(Invega)').
treatment('Fluphenazine_(Prolixin)').
treatment('Clozapine').
treatment('Clonazepam').
treatment('Cyproheptadine').
treatment('Bupropion_(Wellbutrin)').
treatment('Darunavir_(Prezista)').
treatment('Flurazepam').
treatment('Perphenazine').
treatment('Buspirone_(Buspar)').
treatment('Loxapine').
treatment('Lopinavir').
treatment('Lithium_(Li)').
treatment('Amantadine').
treatment('Fluvoxamine_(Luvox)').
treatment('Sertraline_(Zoloft)').
treatment('Doxepin').
treatment('Lisdexamfetamine_(Vyvanse)').
treatment('Meprobamate_(Miltown)').
treatment('Alprazolam_(Xanax)').
treatment('Acamprosate_(Campral)').
treatment('Clomipramine').
treatment('Benztropine').
treatment('Fluoxetine_(Prozac)').
treatment('Dextroamphetamine_(Adderall)').
treatment('Paroxetine_(Paxil)').
treatment('Divalproex_Sodium_(Depakote)').
treatment('Mirtazapine').
treatment('Trazodone').
treatment('Venlafaxine_(Effexor)').
treatment('Clonidine').


/* Usage: number_of_symptoms(List_of_symptoms, Condition, Number, Probability).
 number_of_symptoms(List_of_symptoms, Condition, List_of_Syptoms_for_said_condition, Number_of_truths, Probability_Sum) */


number_of_symptoms(L, Con, ProbOut, Num, DecList):- condition(Con, Rlist), number_of_symptoms(L, Con, Rlist, Num, Prob, DecList), Num > 0, ProbOut is  Prob / Num.
number_of_symptoms([], Cond, List, 0, 0, []).
number_of_symptoms([S|R], Cond, List, Num, Prob, [S|PreviousDec]):- member(S,List), number_of_symptoms(R, Cond, List, Number, PreviousProb, PreviousDec), Num is Number + 1, symptom_relation(Cond, S, OutProb), Prob is OutProb + PreviousProb. 
number_of_symptoms([S|R], Cond, List, Num, Prob, ExDec):- \+ member(S, List), number_of_symptoms(R, Cond, List, Num, Prob,ExDec). 

/* Usage: best_by_number(List_of_Symptoms, Condition, Number, DecisionList)*/


best_by_number(LS, Con, NumC, DecList):- number_of_symptoms(LS,Con,_,NumC,DecList),
forall(number_of_symptoms(LS,_,NumC1,_,_), NumC >= NumC1), !.

/* Usage: best_by_percentage(List_of_Symptoms, Condition, Percetage, DecisionList)*/

best_by_percentage(LS, Con, Perc, DecList):- number_of_symptoms(LS,Con,Perc,_, DecList),
forall(number_of_symptoms(LS,_,Perc1,_,_), Perc>= Perc1), !.

/* Usage: diagnose_number(List_of_Conditions, List_of_Symptoms, Condition, Number,DecisionList)*/

diagnose_number([],LS,Con, Num, DecList):- best_by_number(LS, Con, Num, DecList).
diagnose_number([LLC|LC],LS, Con, Num, DecList):- condition(LLC, [A,B,C|Rest]),diagnose_number(LC,[A,B,C|LS],Con,Num,DecList). 
diagnose_number([LLC|LC],LS, Con, Num, DecList):- \+ condition(LLC, [A,B,C|Rest]),diagnose_number(LC,LS,Con,Num,DecList). 

/* Usage: diagnose_perc(List_of_Conditions, List_of_Symptoms, Condition, Percetage, DecisionList)*/

diagnose_perc([],LS,Con,Per, DecList):- best_by_percentage(LS,Con, Per, DecList).
diagnose_perc([LLC|LC],LSS, Con, Per, DecList):- condition(LLC, [A,B,C|R]), diagnose_perc(LC,[A,B,C|LSS], Con, Per, DecList).  
diagnose_perc([LLC|LC],LSS, Con, Per, DecList):- \+ condition(LLC, [A,B,C|R]), diagnose_perc(LC,LSS, Con, Per, DecList).  


/* Example
diagnose_perc(['Panic_disorder'], ['Temper_problems','Drug_abuse'], Con, Perc, DecList).
*/