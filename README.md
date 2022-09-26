# trainers

MAIN APP
1. Aplikacja WWW napisana w języku JAVA uruchamiana na serwerzeWildfy
2. Zestawienie połączenia z bazą danych, która przetrzymuje dane na temattrenerów
3. Osobna podstrona z listą trenerów w formie tabeli zawierająca:
  1. imię
  2. nazwisko
  3. adres e-mail
  4. telefon
  5. przycisk akcji usunięcia trenera
4. Osobna podstrona z formularzem dodawania trenera
5. Osobna podstrona z formularzem edytowania trenera
6. Osobna podstrona z listą ostatnich 20 logów pobranych z aplikacjiTracking
7. Wysyłanie event’ów na temat akcji jakich dokonywał użytkownik. Eventpowinien zawierać następujące informacje:
  1. IPużytkownika
  2. typ dokonanej akcji [odwiedzenie listy trenerów, dodanietrenera do bazy, edycja trenera, usunięcie trenera, 
     jeżeli tomożliwe id trenera, na którym była dokonywana akcja]
  3. link do podglądu informacji na temat trenera (możnawykorzystać widok edycji trenera)
  4. data wystąpienia akcji

TRACKING
1. Usługa REST-owa napisana w języku JAVA uruchamiana na serwerzeWildfy
2. Zestawienie połączenia z bazą danych, która przetrzymuje dane na tematakcji, 
   które dokonał użytkownik systemu w aplikacji MainApp
Dwa endpointy:
  1. tracking/event - przyjmujący event i zapisujący go do bazydanych
  2. tracking/logs - zwracający 20 ostatnich logów
  
WSPÓLNE
1. Napisz minimum 5 testów jednostkowych do głównych funkcji systemu.
2. Napisz minimum jeden test integracyjny.

Rozwiązanie należy przygotować w repozytorium git (np. na githubie).
Aplikacjapowinna być łatwa do uruchomienia.
