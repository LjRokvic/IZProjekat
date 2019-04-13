import requests
from bs4 import BeautifulSoup

global_symptoms = set([])
global_tests = set([])
global_treatments = set([])

out_file = open('out.pl','w+')

with open("source.txt", "r") as in_file: 
    for line in in_file:
        result = requests.get(line.strip())
        print(line.strip())
        src = result.content
        soup = BeautifulSoup(src, 'lxml')

        title = soup.find('h1')

        #print(title.string+':')

        sym_div = soup.find('div', id='concept-symptoms-div')

        sym_lis = sym_div.find_all('li')

        symptoms = []

        for sym_li in sym_lis:
            symptom = sym_li.find('span', attrs={'itemprop':'name'})
            symptoms.append(symptom.string)
            global_symptoms.add(symptom.string)
            #print('\t - ' + symptom.string)

        test_div = soup.find('div', id='proc_chart_div')
        test_trs = test_div.find_all('tr')

        #print('\n')
        tests = []

        for test_tr in test_trs:
            test = test_tr.find('a')
            tests.append(test.string)
            global_tests.add(test.string)
            #print('\t + ' + test.string)

        treat_div = soup.find('div', id='med_chart_div')
        treat_trs = treat_div.find_all('tr')

        #print('\n')
        treatments = []

        for treat_trs in treat_trs:
            treat = treat_trs.find('a')
            treatments.append(treat.string)
            global_treatments.add(treat.string)
            #print('\t * ' + treat.string)

        
        #SYMPTOMS
        #for st in symptoms:
            #out_file.write('symptom(\"' + st + '\").\n')

        out_file.write('condition(\"'+ title.string + '\", [')

        for st in symptoms[:-1]:
            out_file.write('\"'+ st +'\",')

        out_file.write('\"' + symptoms[-1]+'\"]).\n')

        out_file.write('\n')

        #TESTS
        for st in tests:
            #out_file.write('test(\"' + st + '\").\n')
            out_file.write('test_for_condition(\"' + title.string + '\", \"'+ st + '\").\n')

        out_file.write('\n')

        #TREATMENTS
        for st in treatments:
            #out_file.write('treatment(\"' + st + '\").\n')
            out_file.write('treatment_for_condition(\"' + title.string + '\", \"'+ st + '\").\n')
            
        out_file.write('\n')

for st in global_symptoms:
    out_file.write('symptom(\"' + st + '\").\n')

out_file.write('\n')

for st in global_tests:
    out_file.write('test(\"' + st + '\").\n')

out_file.write('\n')

for st in global_treatments:
    out_file.write('treatment(\"' + st + '\").\n')

out_file.close()