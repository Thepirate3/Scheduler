# Scheduler
Mocanu Alexandru George 325CB
	
	TEMA 1

	Proiectul propus doreste sa implementeze functionalitatile unui scheduler, fiind alcatuit din 3 tipuri de scheduler(Random, RoundRobin, Weighted).
	Pentru a putea testa acest scheduler am implementat diferite procese,functii matematice ce trebuie apelate in functie de o anumita regula. 
	Astfel pentru a putea generaliza aceste functii am declarat o interfata numita "Proces" ce descrie functionalitatile pe care le vor avea toate procesele, si anume "Actiune" ce returneaza un int in functie de procesul apelat si "toName" ce returneaza numele procesului curent. Ierarhia este urmatoarea

		         	     PROCES
	/	    /       /	       |	\      \       \   
    CheckPrime NextPrime Fibonacci    Sqrt    Square  Cube  Factorial 

	Pentru a defini scheduler am declarat o clasa abstracta "Scheduler", ce are un constructor ce instantiaza un vector de procese fiecare celula al vectorului fiind instantiata cu un anumit tip de proces matematic. De asemenea aceasta clasa doreste ca fiecare clasa ce o mosteneste sa implementeze o metoda "Run" ce sa ruleze un anumit proces si o clasa "NumeProc" ce returneaza numele procesului rulat.

				
				     Scheduler
			/		 | 		\
		RandomScheduler RoundRobinScheduler WeightedScheduler

1. RandomScheduler

	Implementeaza in plus fata de scheduler o metoda "Select" ce modifica parametrul specific acestui scheduler numit "index" ce codifica pozitia procesului,din vectorul de procese, ce urmeaza a fi executat, acest index fiind stabilit aleator in limita pozitiilor din vectorul de procese. De asemenea metoda NumeProc apeleaza metoda din fiecare proces numita toName pentru a returna numele procesului.

2. RoundRobinScheduler
	
	Si in cazul acestui scheduler folosim un index pentru a indica urmatorul proces ce urmeaza a fi executat,regula la acest scheduler este de a rula pe rand fiecare proces incrementand de fiecare data indexul, iar in cazul in care am rulat toate procesele cel putin o data se reseteaza indexul si se incepe rularea din a fiecarui proces din vectorul de procese.

3. WeightedScheduler

	Acest scheduler se bazeaza pe anumite cote de rulare a fiecarui proces. Pentru a stabil aceste cote am implementat metoda "cote" ce copiaza in vectorii cote_procese si cote_prelucrate cota de executia intr-un interval de timp a fiecarui proces.Mentionam ca un timp= suma(cote_procese)/cmmdc(cote). Astfel in cei doi vectori vom avea cotele de executie, si anume de cate ori trebuie executat fiecare proces intr-un moment de timp.De mentionat ca mentinem timpul schedulerului in doua variabile una ce ramane drept etalon si una ce se modifica la executarea fiecarui proces,la fel se intampla si in cazul vectorilor de procese,unul se modifica iar altul ramane etalon.

 		Bonus!

	Pentru implementarea bonusului am implementat o clasa "Cache" ce simuleaza o celula al cache-ului ce contine numarul pentru care trebuie executat procesul,numele procesului, rezultatul rularii procesului si TIU, un indicativ pentru codificarea timpului pentru cazul cache-ului LRU si a numarului de utilizari pentru cazul cache-ului LFU. Astfel am descris o interfata CacheType ce ofera doua metode si anume "Check" si "Add" ,care verifica daca componenta curenta(numarul si procesul) se afla in cache. In cazul in care gasim elementele deja procesate vom returna rezultatul procesarii pentru a usura executia programului. Metoda "Add" va adauga componenta curenta in cache astfel:daca cache-ul mai are pozitii disponibile atunci se va adauga la urmatoare pozitie disponibila daca nu in functie de tipul de cache se va adauga pe pozitia cu ultimul timp modificat(LRU cache) sau cu cea mai putin utilizata componenta (LFU cache).

		       	    CacheType
			    /       \
		     LruCache        LfuCache


	In main am verificat daca inputul testeaza optiunea cache, daca da am initializat cache-ul corespunzator celui prezent in fisierul de input, iar apoi am verificat pentru fiecare numarul procesele in functie de tipul de scheduler primit ca paramatru.





