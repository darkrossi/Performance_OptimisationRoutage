# DM2 : optimisation de routage

## Routage Bernoulli

## 1.

Définition : Avec le processus de comptage N([a,b]) = nb de points dans [a,b] de $T_i$ pour i entier naturel, on dit que $T_i$ pour i entier natuel est un processus de Poisson de paramètre $\lambda$) si N a les 2 propriétés :
  - N[a,b] et N[c,d] sont indépendants si $[a, b] \cap [c, d] = \emptyset$
  - N[a,b] suit une loi de poisson de taux $\lambda \cdot (b-a)$

On note X la variable aléatoire qui définie le nombre de paquets qui arrivent au routeur dans un intervalle de temps [a, b] avec $a\not=b$ et $a>0$, $b>0$. Cette variable aléatoire suit une loi de Poisson de paramètre $\lambda$. On suppose qu'un paquet a une probabilité p d'être routé dans la file 1 et une probabilité p-1 d'être routé dans la file 2.  
Notons maintenant Y la variable aléatoire qui définie le nombre de paquets qui arrivent dans la file 1 dans l'intervalle de temps [a, b]. Si on suppose que n paquets arrivent au routeur dans [a, b] alors Y est la somme de n variable aléatoires indépendantes suivant une loi de Bernouilli de paramètre p. Ainsi, Y suit une loi Binomiale de paramètres n et p. Sa loi de probabilité est donc :

\begin{align}\label{}
      \nonumber P_Y(i)&=\sum_{n=0}^{\infty} P(Y=i|N=n) \cdot P_X(n)\\
      \nonumber &=\sum_{n=i}^{\infty} {n \choose i} \cdot p^i \cdot q^{n-i} \cdot e^{-\lambda} \cdot \frac{\lambda^n}{n!}\\
      \nonumber &=\sum_{n=i}^{\infty} \frac{p^i \cdot q^{n-i} \cdot e^{-\lambda} \cdot \lambda^n}{i! \cdot (n-i)!} \\
      \nonumber &=\frac{e^{-\lambda} \cdot (\lambda \cdot p)^i}{i!}  \sum_{n=i}^{\infty} \frac{(\lambda \cdot q)^{n-i}}{(n-i)!} \\
      \nonumber &=\frac{e^{-\lambda} \cdot (\lambda \cdot p)^i}{i!} e^{\lambda \cdot q} \\
      \nonumber &=\frac{e^{-\lambda \cdot p} \cdot (\lambda \cdot p)^i}{i!}
      \end{align}

Ainsi, on a prouvé que Y suit une loi de poisson de paramètre $\lambda \cdot p$. De plus, comme les paquets qui arrivent dans la file 1 ne dépendent que des paquets arrivant au routeur alors pour a, b, c et d tels que $[a, b] \cap [c, d] = \emptyset$ on a que le nombre de paquets arrivant dans [a, b] est indépendant du nombre de paquets arrivant dans [c ,d].  

D'après la définition notée au début de la question, nous pouvons alors affirmé que les paquets qui arrivent dans la file 1 forment un Processus de Poisson de taux $\lambda \cdot p$.

#### 2.
Il faut que &lambda;\*p<&mu;<sub>1</sub> et &lambda;\*(1-p)<&mu;<sub>2</sub>

#### 3.
Après calcul on trouve p<sup>\*</sup> = 1/&lambda;\*(&mu;<sub>1</sub> - (&mu;<sub>2</sub> + &mu;<sub>1</sub> - &lambda;)/(1+sqrt(&mu;<sub>2</sub>/&mu;<sub>1</sub>)))

Si on considère ce résultat comme une fonction en fonction de p. C'est un polynôme du second degré dont le coefficient du monôme de plus haut degré est positif. Ainsi, il existe un p qu'on note $p^*$ tel que $\bar N$ est minimum.  
Après calcul on trouve $p^* = \frac{1}{\lambda} \times (\mu_1 - \frac{\mu_2 + \mu_1 - \lambda}{1+\sqrt{\mu_2 \cdot \mu_1}})$.


#### 4.
Pour mu1 = mu2 = lambda = 1 on trouve p* = 0.5 ce qui est intuitif car le temps de service dans les deux serveurs sont égaux. Ainsi, autant partager les tâches équitablement entre les deux serveurs.  

Pour mu2 = lambda = 1 et mu1 = 2 on trouve p<sup>\*</sup> = 0.82 environ. Le fait que le résultat soit plus proche de 1 que de 0.5 paraît intuitif car le serveur 1 a un temps de service doublement supérieur à celui du serveur 2. Ainsi, autant donné plus de paquets par seconde au serveur 1 afin de minimuser le nombre moyen total de paquets dans le système.
## Routage périodique

#### 1.
Le routage est ici périodique :
- À partir d'une date t<sub>a</sub> le système envoie n paquets sur un serveur.
- Puis, à partir d'une date t<sub>b</sub> le système envoie un paquet sur l'autre serveur.
- À une date t<sub>c</sub> le système recommence à envoyer n paquets sur le premier serveur.

Pendant l'intervalle t<sub>c</sub> - t<sub>a</sub> le système doit donc envoyer exactement n paquets sur la file 1.    
Si le processus d'arrivée sur la file 1 était de Poisson, on aurait :  
Pour tout t<sub>0</sub>=0 < t1 < ... < t<sub>k</sub> , (N<sub>t<sub>k</sub></sub> - N<sub>t<sub>k-1</sub></sub>), ..., (N<sub>t<sub>1</sub></sub> - N<sub>t<sub>0</sub></sub>) indépendantes. (En notant (N<sub>t</sub>) le processus de poisson).

On aurait donc notamment (N<sub>t<sub>c</sub></sub> - N<sub>t<sub>b</sub></sub>) et (N<sub>t<sub>b</sub></sub> - N<sub>t<sub>a</sub></sub>) qui seraient indépendants. Or si (N<sub>t<sub>c</sub></sub> - N<sub>t<sub>b</sub></sub>) = n, alors (N<sub>t<sub>b</sub></sub> - N<sub>t<sub>a</sub></sub>) = 0 donc l'indépendance n'est pas vérifiée et le processus de la file 1 n'est pas de Poisson.

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
