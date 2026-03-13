# 🌱 TP 3 — Spring IoC & POC
 
---
 
## 🎯 Variante A — `@Primary` — Résultat via `Presentation2`
 
> Profil `dev` actif → `DaoImpl2` injecté → `150.0 × 2` = **300.0**
 
![Variante A](https://raw.githubusercontent.com/khadija-bouraiss/TP3_JakartaEE/master/Screenshot%202026-03-11%20154855.png)
 
---
 
## 🔗 Variante B — Alias `@Bean` — Résultat via `MainApp`
 
> Alias `"dao"` pointe vers `DaoApi` → `220.0 × 2` = **440.0**
 
![Variante B](https://raw.githubusercontent.com/khadija-bouraiss/TP3_JakartaEE/master/Screenshot%202026-03-11%20155608.png)
 
---
 
## 🗂️ Variante C — Propriété Externe — Résultat via `MainApp`
 
> `app.properties` → `dao.target=dao2` → `DaoImpl2` → `150.0 × 2` = **300.0**
 
![Variante C](https://raw.githubusercontent.com/khadija-bouraiss/TP3_JakartaEE/master/Screenshot%202026-03-12%20223143.png)
 
---
 
## ✅ Tests de Non-Régression — JUnit 4 — 3/3 Passés
 
> `OcpSelectionTest` — Validation OCP : `MetierImpl` jamais modifié
 
![Tests JUnit](https://raw.githubusercontent.com/khadija-bouraiss/TP3_JakartaEE/master/Screenshot%202026-03-13%20105732.png)
