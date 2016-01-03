# DM2 : optimisation de routage

## Routage Bernoulli

#### 1.

#### 2.

#### 3.

#### 4.

## Routage périodique

#### 1.

#### 2.

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
  - N[a,b] et N[c,d] sont indépendants si \[a,b](intersection)[c,d] = vide
  - N[a,b] suit une loi de poisson de taux &lambda;\*(b-a)
    - Définition : N suit une loi de poisson de taux &alpha; alors P(N=i) = (&alpha;^i/i!)\*exp(-&alpha;)

###### PP(&alpha;)  
Je tire au hasard avec proba p pour colorier en rouge (les autres sont en verts)  
Je choisis [0,a]  
P(N1[0,a]=i<sub>1</sub>, N2[0,a]=i<sub>2</sub>) = P(N1=i<sub>1</sub>, N2 = i<sub>2</sub> | N = i<sub>1</sub> + i<sub>2</sub>)\*P(N=i<sub>1</sub>+i<sub>2</sub>)

Le premier terme vaut : p<sup>i<sub>1</sub></sup>\*(1-p)^i<sub>2</sub> * (i<sub>1</sub>+i<sub>2</sub>)!/(i<sub>1</sub>!\*i<sub>2</sub>!)  
Le deuxième terme vaut (&alpha;\*a)^(i<sub>1</sub>+i<sub>2</sub>)/(i<sub>1</sub>!+i<sub>2</sub>!)\*exp(-&alpha;\*a)

On a au final = (p<sup>i<sub>1</sub></sup>\*(&alpha;\*a)<sup>i<sub>1</sub></sup>/i<sub>1</sub>!\*exp(-&alpha;\*p*a))\*((1-p)<sup>i<sub>2</sub></sup>\*(&alpha;\*a)<sup>i<sub>2</sub></sup>\*/i<sub>2</sub>!\*exp(&alpha;\*(1-p)\*a))  
Et le premier terme de ce résultat est un PP(&alpha;\*p) et le deuxième est un PP(&alpha;\*(1-p))  

#### Question 1.3
Il faut donner un sens à chacun des termes du résultat


#### Question 2.5
Ce n'est pas n'importe quel routage périodique. Du coup, pour certains mu et lmabda ça va mal se passer ...

#### Question 3.0  
Les paquets qui sont envoyés en haut et en bas sont indépendants de ce qu'il se passe dans les files.
