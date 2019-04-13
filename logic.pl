/* Usage: number_of_symptoms(List_of_symptoms, Condition, Number).
 number_of_symptoms(List_of_symptoms, Condition, List_of_Syptoms_for_said_condition, Number_of_truths) */
number_of_symptoms(L, Con, Num):- condition(Con, Rlist), number_of_symptoms(L, Con, Rlist, Num), Num > 0.
number_of_symptoms([], Cond, List, 0).
number_of_symptoms([S|R], Cond, List, Num):- member(S,List), number_of_symptoms(R, Cond, List, Number), Num is Number + 1. 
number_of_symptoms([S|R], Cond, List, Num):- \+ member(S, List), number_of_symptoms(R, Cond, List, Num).