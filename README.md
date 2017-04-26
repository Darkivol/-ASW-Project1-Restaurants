# ASW Progetto 1 - Ristoranti

- Fabrizio Cicala (450977)
- Luigi D’Onofrio (462576)
- Carlo Petracca Ciavarella	(436787)
- Mariano Scazzariello (475151)

## Descrizione del dominio applicativo

### Informazioni su ristoranti

Abbiamo un servizio principale S il quale fornisce informazioni sui ristoranti di una determinata città.

S offre due operazioni:

-	`/S/<città>` - Restituisce la lista di tutti i ristoranti della `<città>` unitamente alle valutazioni dei singoli ristoranti espresse in una scala di valori da 0 a 5.
- `/S/<città>/<ristorante>` - Restituisce le specialità del `<ristorante>` con annessa valutazione (sempre del `<ristorante>`) espressa nella scala di cui sopra. 

Ad esempio, la richiesta `/S/Affi/Le-pizze-di-Pizzo` potrebbe restituire:


> Il ristorante Le pizze di Pizzo sito ad Affi (con valutazione 4.5/5) propone le seguenti specialità:
> - Margherita - 3.50€
> - Focaccia di Pizzo - 6.00€
> - Bomba Pugliese - 6.50€
> - Shrek - 7.00€

Se effettuiamo la richiesta `/S/Matera`, potrebbe restituire:

> I ristoranti che puoi trovare a Matera sono:
> - Le tagliatelle di nonna Pina - 4.8/5
> - Abbondanza Lucana - 4.3/5 
> - Casa del Kebab - 3.7/5

Il servizio S si appoggia a due servizi secondari S1 e S2, con le caratteristiche descritte nel seguito.

### Servizio S1

Il servizio S1 offre due operazioni che forniscono i ristoranti e le relative specialità di una determinata città. In particolare:
- `/S1/<città>` - Restituisce la lista dei nomi dei ristoranti presenti nella `<città>`;
- `/S1/<città>/<ristorante>` - Restituisce la specialità del particolare `<ristorante>` nella specifica `<città>` (si considera la possibilità che esistano due o più ristoranti con lo stesso nome in città diverse).

Ad esempio, `/S1/Matera` potrebbe restituire:

> - Le tagliatelle di nonna Pina
> - Abbondanza Lucana
> - Casa del Kebab

Mentre `/S1/Affi/Le-pizze-di-Pizzo` potrebbe restituire:

> Le specialità della casa sono:
> - Margherita - 3.50€
> - Focaccia di Pizzo - 6.00€
> - Bomba Pugliese - 6.00€
> - Shrek - 7.00€

### Servizio S2

Il servizio S2, invece, offre informazioni esclusivamente sulla valutazione assegnata ad un determinato ristorante. In particolare fornisce la seguente operazione:

- `/S2/<città>/<ristorante>` - Restituisce la valutazione del `<ristorante>` sito nella `<città>` in una scala di valori da 0 a 5.

Ad esempio, `/S2/Matera/Abbondanza-Lucana` potrebbe restituire: 

> Abbondanza Lucana riporta una valutazione media di 4.3.

Il servizio S risponderà al client interagendo con entrambi i servizi S1 e S2 ed integrando le risposte ottenute per costruire quella di interesse per il client.
