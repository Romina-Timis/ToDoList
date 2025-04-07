# Progetto To-Do List

## Panoramica del Progetto

Questo progetto è una semplice applicazione web per la gestione dei task, sviluppata utilizzando **Spring Boot** per il backend, **Thymeleaf** per il rendering dei template HTML e **MySQL** per la persistenza dei dati. L'applicazione permette agli utenti di creare, modificare ed eliminare task, suddividendoli in tre categorie: *Da Fare*, *In Corso* e *Completati*. Inoltre, offre una dashboard interattiva con grafici realizzati con **Chart.js** e supporta una modalità dark/light tramite un toggle.

## Tecnologia Utilizzata
  - SpringBoot
  - Thymeleaf
  - MySql
  - Hiberante
  - Librerie esterne (Chart.js)
    
## Funzionalità Principali

- **Gestione Task (CRUD):**  
  Gli utenti possono creare nuovi task, visualizzare quelli esistenti, modificarli e cancellarli.
- **Dashboard e Grafici:**  
  Visualizzazione dei task suddivisi per stato e grafici che mostrano le percentuali di task completati, in corso e da fare.
- **Autenticazione:**  
  All'avvio, l'utente viene reindirizzato alla pagina di login; solo gli utenti autenticati possono accedere alle funzionalità del sistema.
- **Profilo Utente:**  
  La pagina del profilo mostra i dettagli personali (nome, email, username) e consente di aggiornare le informazioni.
- **Modalità Dark/Light:**  
  Un toggle nella navbar permette di passare dalla modalità chiara a quella scura.

## Struttura del Sito

L'applicazione segue il pattern **MVC (Model-View-Controller)** e prevede il seguente flusso di navigazione:

- **Login:**  
  All'accesso, l'utente viene indirizzato alla pagina di login dove deve inserire le proprie credenziali. Solo dopo l'autenticazione, l'utente potrà accedere alle funzionalità dell'applicazione.

- **Home (Index):**  
  Dopo il login, l'utente viene indirizzato alla pagina principale (Index) che presenta:
  - **Grafici:**  Mostrano le percentuali di task "Completed", "In Progress" e "To Do", sono posizionati subito sotto il titolo della pagina. Sono centrati orizzontalmente e disposti sulla stessa riga.
  - **Task:** Visualizzati in tre colonne a destra, suddivisi per stato:
    - *Task da fare*
    - *Task in corso*
    - *Task completati*
  - **Pulsante "Aggiungi":** Disponibile in alto per permettere l'inserimento di un nuovo task.

- **Dashboard:**  
  Offre una visione completa e aggregata di tutti i task di tutti gli utenti. In questa pagina potrai visualizzare un grafico generale che illustra la distribuzione complessiva dei task, suddivisi per stato (Da Fare, In Corso, Completati). Questo grafico permette di avere un'istantanea immediata dell'andamento dei progetti.

- **Profilo:**  
  La pagina del profilo mostra i dati personali dell’utente e offre la possibilità di aggiornarli. Dopo il login, l'utente accede alla pagina home e può navigare facilmente tra le sezioni.

- **Logica del Progetto:**  
  - **Controller:** Gestiscono le richieste HTTP e coordinano la logica tra il frontend e il backend (es. LoginController, TaskController, UserController).
  - **Servizi:** Implementano la logica di business per le operazioni CRUD sui task e per la gestione degli utenti.
  - **Repository:** Si occupano della persistenza dei dati nel database MySQL.
  - **Sicurezza:** Spring Security protegge le pagine e le API, consentendo l'accesso solo agli utenti autenticati.

- **Risorse Statiche e Template:**  
  - **CSS e JavaScript:** Il sito utilizza Bootstrap per il layout e Chart.js per i grafici.
  - **Template Thymeleaf:** I file HTML, situati in `src/main/resources/templates`, definiscono l'interfaccia utente delle diverse pagine (login, index, dashboard, profilo).

### Esecuzione del Progetto

### Requisiti 
- **Java 8** o superiore
- **Maven 3.6+** (oppure utilizza il Maven Wrapper incluso nel progetto)
- **MySQL** per la persistenza dei dati


