/* Usage: number_of_symptoms(List_of_symptoms, Condition, Number, Probability).
 number_of_symptoms(List_of_symptoms, Condition, List_of_Syptoms_for_said_condition, Number_of_truths, Probability_Sum) */


number_of_symptoms(L, Con, ProbOut, Num, DecList):- condition(Con, Rlist), number_of_symptoms(L, Con, Rlist, Num, Prob, DecList), Num > 0, ProbOut is  Prob / Num.
number_of_symptoms(L, Con, ProbOut, Num, DecList):- condition(Con, Rlist), number_of_symptoms(L, Con, Rlist, Num, Prob, DecList), Num = 0, ProbOut is  0.

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
diagnose_perc(["Panic_disorder"], ["Temper_problems","Drug_abuse"], Con, Perc, DecList).
*/