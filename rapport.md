# DM2 : optimisation de routage

## Routage Bernoulli

#### 1.

#### 2.
Il faut que &lambda;\*p<&mu;<sub>1</sub> et &lambda;\*(1-p)<&mu;<sub>2</sub>

#### 3.
Après calcul on trouve p<sup>\*</sup> = 1/&lambda;\*(&mu;<sub>1</sub> - (&mu;<sub>2</sub> + &mu;<sub>1</sub> - &lambda;)/(1+sqrt(&mu;<sub>2</sub>/&mu;<sub>1</sub>)))

#### 4.
Pour mu1 = mu2 = lambda = 1 on trouve p* = 0.5 ce qui est intuitif car le temps de service dans les deux serveurs sont égaux. Ainsi, autant partager les tâches équitablement entre les deux serveurs.  

Pour mu2 = lambda = 1 et mu1 = 2 on trouve p<sup>\*</sup> = 0.82 environ. Le fait que le résultat soit plus proche de 1 que de 0.5 paraît intuitif car le serveur 1 a un temps de service doublement supérieur à celui du serveur 2. Ainsi, autant donné plus de paquets par seconde au serveur 1 afin de minimuser le nombre moyen total de paquets dans le système.
## Routage périodique

#### 1.

#### 2.
Il faut que &lambda;\*n<&mu;<sub>1</sub> et &lambda;<&mu;<sub>2</sub>

#### 3.

#### 4.

#### 5.

## Routage optimal

#### 1.



# Notes sur DM2
Essayer de faire une rédaction comme la correction du DM1 (la forme)

#### Question 1.1
**Processus de poisson** :
(axe horizontal avec des points T<sub>i</sub>)
- 1ère définition : P(T<sub>i+1</sub>-T<sub>i</sub> > t) = exp(-&lambda;\*t)
- 2ème définition : avec le processus de comptage N([a,b]) = nb de points dans [a,b] de T<sub>i</sub> pour i entier naturel. On dit que T<sub>i</sub> pour i entier natuel est PP(&lambda;) si N a les 2 propriétés :
  - N[a,b] et N[c,d] sont indépendants si \[a,b]&cap;[c,d] = &empty;
  - N[a,b] suit une loi de poisson de taux &lambda;\*(b-a)
    - Définition : N suit une loi de poisson de taux &alpha; alors P(N=i) = (&alpha;<sup>i</sup>/i!)\*exp(-&alpha;)

###### PP(&alpha;)  
Je tire au hasard avec proba p pour colorier en rouge (les autres sont en verts)  
Je choisis [0,a]  
P(N1[0,a]=i<sub>1</sub>, N2[0,a]=i<sub>2</sub>) = P(N1=i<sub>1</sub>, N2 = i<sub>2</sub> | N = i<sub>1</sub> + i<sub>2</sub>)\*P(N=i<sub>1</sub>+i<sub>2</sub>)

Le premier terme vaut : p<sup>i<sub>1</sub></sup>\*(1-p)<sup>i</sup><sub>2</sub> * (i<sub>1</sub>+i<sub>2</sub>)!/(i<sub>1</sub>!\*i<sub>2</sub>!)  
Le deuxième terme vaut (&alpha;\*a)^(i<sub>1</sub>+i<sub>2</sub>)/(i<sub>1</sub>!+i<sub>2</sub>!)\*exp(-&alpha;\*a)

On a au final = (p<sup>i<sub>1</sub></sup>\*(&alpha;\*a)<sup>i<sub>1</sub></sup>/i<sub>1</sub>!\*exp(-&alpha;\*p*a))\*((1-p)<sup>i<sub>2</sub></sup>\*(&alpha;\*a)<sup>i<sub>2</sub></sup>\*/i<sub>2</sub>!\*exp(&alpha;\*(1-p)\*a))  
Et le premier terme de ce résultat est un PP(&alpha;\*p) et le deuxième est un PP(&alpha;\*(1-p))  

#### Question 1.3
Il faut donner un sens à chacun des termes du résultat


#### Question 2.5
Ce n'est pas n'importe quel routage périodique. Du coup, pour certains mu et lmabda ça va mal se passer ...

#### Question 3.0  
Les paquets qui sont envoyés en haut et en bas sont indépendants de ce qu'il se passe dans les files.
