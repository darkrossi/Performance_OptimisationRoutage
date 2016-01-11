---
title:  'DM 2 : optimisation de routage'
author: Boëdec Hoël, Mickaël Fournier
date: 11 Janvier 2016
---

# Routage Bernoulli

## 1.
!!TO DO!!

## 2.
Il faut que $\lambda \cdot p<\mu_1$ et $\lambda \cdot (1-p)<\mu_2$.

## 3.
On sait que la quantité moyenne de paquets en régime stationnaire dans le système
vaut $\bar N=\frac{\lambda \cdot p}{\mu_1 \times (1-\frac{\lambda \cdot p}{\mu_1})}+\frac{\lambda \cdot (1-p)}{\mu_2 \times (1-\frac{\lambda \cdot (1-p)}{\mu_2})}$.  

Si on considère ce résultat comme une fonction en fonction de p. C'est un polynôme du second degré dont le coefficient du monôme de plus haut degré est positif. Ainsi, il existe un p qu'on note $p^*$ tel que $\bar N$ est minimum.  
Après calcul on trouve $p^* = \frac{1}{\lambda} \times (\mu_1 - \frac{\mu_2 + \mu_1 - \lambda}{1+\sqrt{\mu_2\mu_1}})$.

## 4.
Pour $\mu_1=\mu_2=\lambda=1$ on trouve $p^*=0.5$. Ce résultat est intuitif car le temps de service dans les deux serveurs sont égaux. Ainsi, autant partager les tâches équitablement entre les deux serveurs.  

Pour $\mu_2=\lambda=1$ et $\mu_1=2$ on trouve $p^*=0.82$ environ. Le fait que le résultat soit supérieur à 0.5 paraît intuitif car le serveur 1 a un temps de service doublement supérieur à celui du serveur 2. Ainsi, autant donné plus de paquets par seconde au serveur 1 afin de minimiser le nombre moyen total de paquets dans le système.

# Routage périodique

## 1.
!!TO DO!!

## 2.
Il faut que $\lambda*n<\mu_1$ et $\lambda<\mu_2$.

## 3.
!!Expliquer simu!!  
!!Calculer des intervalles de confiance!!

## 4.

1. Cas où $\lambda=\mu1=\mu2=1$  
  Par simulation on trouve $n^*=1$.  
  !!Résultat avec intervalle de confiance!!
2. Cas où $\lambda=\mu2=1$ et $\mu1=2$  
    Par simulation on trouve $n^*=2$.  
    !!Résultat avec intervalle de confiance!!

## 5.
!!ça dépend!!

# Routage optimal

## 1.
!!TO DO!!



pandoc -s -S --toc --toc-depth=1 -V geometry:margin=1in rapport.md -o rapport.pdf



# Notes sur DM2
Essayer de faire une rédaction comme la correction du DM1 (la forme)

## Question 1.1
**Processus de poisson** :
(axe horizontal avec des points $T_i$)

- 1ère définition : $P(T_{i+1}-T_i > t) = \exp{(-\lambda*t)}$
- 2ème définition : avec le processus de comptage N([a,b]) = nb de points dans [a,b] de $T_i$ pour i entier naturel. On dit que $T_i$ pour i entier natuel est PP($\lambda$) si N a les 2 propriétés :
  - N[a,b] et N[c,d] sont indépendants si \[a,b]&cap;[c,d] = &empty;
  - N[a,b] suit une loi de poisson de taux $\lambda$\*(b-a)
    - Définition : N suit une loi de poisson de taux $\alpha$ alors P(N=i) = $\frac{\alpha^i}{i!} \times \exp{-\alpha}$

### PP($\alpha$)  
Je tire au hasard avec proba p pour colorier en rouge (les autres sont en verts)  
Je choisis [0,a]  
$P(N1[0,a]=i_1, N2[0,a]=i_2)=P(N1=i_1, N2=i_2 | N=i_1+i_2) \times P(N=i_1+i_2)$

Le premier terme vaut : $p^{i_1} \times (1-p)^{i_2} \times \frac{(i_1+i_2)!}{i_1! \cdot i_2!}$  
Le deuxième terme vaut $\frac{(\alpha*a)^{i_1+i_2}}{(i_1!+i_2!)*exp(-\alpha*a)}$

On a au final = $(p^{i_1} \times (\alpha*a)^{i_1}/i_1!*\exp{-\alpha*p*a}) \times ((1-p)^{i_2}*(\alpha*a)^{i_2}*/i_2!*\exp{\alpha*(1-p)*a})$  
Et le premier terme de ce résultat est un PP($\alpha*p$) et le deuxième est un PP($\alpha*(1-p)$)  

## Question 1.3
Il faut donner un sens à chacun des termes du résultat


## Question 2.5
Ce n'est pas n'importe quel routage périodique. Du coup, pour certains mu et lmabda ça va mal se passer ...

## Question 3.0  
Les paquets qui sont envoyés en haut et en bas sont indépendants de ce qu'il se passe dans les files.
