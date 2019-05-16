/* Usage: number_of_symptoms(List_of_symptoms, Condition, Number, Probability).
 number_of_symptoms(List_of_symptoms, Condition, List_of_Syptoms_for_said_condition, Number_of_truths, Probability_Sum) */

number_of_symptoms(L, Con, Num, ProbOut):- condition(Con, Rlist), number_of_symptoms(L, Con, Rlist, Num, Prob), Num > 0, ProbOut is  Prob / Num.
number_of_symptoms([], Cond, List, 0, 0).
number_of_symptoms([S|R], Cond, List, Num, Prob):- member(S,List), number_of_symptoms(R, Cond, List, Number, PreviousProb), Num is Number + 1, symptom_relation(Cond, S, OutProb), Prob is OutProb + PreviousProb. 
number_of_symptoms([S|R], Cond, List, Num, Prob):- \+ member(S, List), number_of_symptoms(R, Cond, List, Num, Prob). 

