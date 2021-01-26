# Wünschenswerte Conventions

-> Presenter: Stellen die RestController dar

-> Gateways: Klassen welche mit externen Datenquellen kommunizieren (andere APIs, FileSystem ect.)

-> Plugins: Kleine und wiederverwendbare Klassen z.B lokalisierung von Strings, umwandeln von Daten ect.

-> Repository: Um auf die JPA Schicht zuzugreifen (Datenbankzugriff)

-> Interactors: Jeder "Interaktor" enthält Business Logik

-> Am besten immer gegen ein Interface implementieren, damit man es später gut durch Mocks zum testen austauschen kann