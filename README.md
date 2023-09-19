# MITyCLib

Fonte template redazione documento:  https://www.makeareadme.com/.


# Descrizione

Fork del progetto [MITyCLib](https://github.com/gdiazs/MITyCLib) è utilizzato come **dipendenza** dal modulo **Cryptolibrary** in cui sono implementate le logiche di verifica di firme digitali dei formati più noti (vedi ETSI https://www.etsi.org/).

# Installazione

Come già specificato nel paragrafo precedente [Descrizione](# Descrizione) si tratta di un progetto di tipo "libreria", quindi un modulo applicativo utilizzato attraverso la definzione della dipendenza Maven secondo lo standard previsto (https://maven.apache.org/): 

```xml
<dependency>
    <groupId>it.eng.parer</groupId>
    <artifactId>eng-mityclib-xades</artifactId>
    <version>$VERSIONE</version>
</dependency>
```

# Utilizzo

Il modulo definisce le implementazioni di logiche di verifica del formato di firma digitale **Xades** (https://www.etsi.org/deliver/etsi_en/319100_319199/31913201/01.02.01_60/en_31913201v010201p.pdf)

# Supporto

Progetto a cura di [Engineering Ingegneria Informatica S.p.A.](https://www.eng.it/).

# Contributi

Se interessati a crontribuire alla crescita del progetto potete scrivere all'indirizzo email <a href="mailto:areasviluppoparer@regione.emilia-romagna.it">areasviluppoparer@regione.emilia-romagna.it</a>.

# Autori

Proprietà intellettuale del progetto di [Regione Emilia-Romagna](https://www.regione.emilia-romagna.it/) e [Polo Archivisitico](https://poloarchivistico.regione.emilia-romagna.it/).

# Licenza

Questo progetto è rilasciato sotto licenza GNU Affero General Public License v3.0 or later ([LICENSE.txt](LICENSE.txt)).
