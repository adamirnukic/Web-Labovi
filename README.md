## 📝 Lab 2 - Logika dodavanja novog modela

### Dodavanje Player modela
**Razlog dodavanja:** Model Player je logično proširenje aplikacije jer omogućava prikaz pojedinačnih igrača koji čine timove. Svaki sportski tim se sastoji od igrača, tako da je ova relacija prirodna i očekivana u ovoj domeni.

**Ostvarena relacija:** **N:1 (Many-to-One)** između Player i Team modela
- Više igrača pripada jednom timu
- Svaki igrač mora biti dio tačno jednog tima
- Implementirano kroz `@ManyToOne` anotaciju na strani Player modela
- Tim ima listu igrača kroz `@OneToMany` anotaciju sa `mappedBy = "team"`

**JPA anotacije:**
\`\`\`java
// U Player.java
@ManyToOne
@JoinColumn(name = "team_id")
private Team team;

// U Team.java
@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
private List<Player> players = new ArrayList<>();
\`\`\`

---

## 🎮 Funkcionalnosti Controller-a za Player model

### 1. PlayerController (Thymeleaf MVC Controller)
**Namjena:** Upravljanje HTML stranicama i formama za igrače

**Rute:**
- `GET /players` - Prikaz liste svih igrača
- `GET /players/new` - Forma za dodavanje novog igrača
- `GET /players/edit/{id}` - Forma za izmjenu postojećeg igrača
- `POST /players/save` - Čuvanje novog ili izmijenjenog igrača
- `GET /players/delete/{id}` - Brisanje igrača

**Ključne funkcionalnosti:**
- Prikaz svih igrača sa njihovim timovima u tabeli
- Forma za unos/izmjenu igrača sa padajućim menijem za izbor tima
- Validacija podataka
- Potvrda pri brisanju igrača
- Responzivan dizajn sa obojenim oznakama za pozicije

### 2. PlayerRestController (REST API Controller)
**Namjena:** JSON API za programatski pristup podacima o igračima

**REST Endpoint-i:**
- `GET /api/players` - Vraća sve igrače u JSON formatu
- `GET /api/players/{id}` - Vraća jednog igrača po ID-u
- `GET /api/players/team/{teamId}` - Vraća sve igrače određenog tima
- `POST /api/players` - Kreira novog igrača (prima JSON)
- `PUT /api/players/{id}` - Ažurira postojećeg igrača (prima JSON)
- `DELETE /api/players/{id}` - Briše igrača

**Primjer JSON odgovora:**
\`\`\`json
{
  "id": 1,
  "name": "Edin Džeko",
  "position": "Napadač",
  "jerseyNumber": 11,
  "dateOfBirth": "1986-03-17",
  "nationality": "Bosna i Hercegovina",
  "team": {
    "id": 1,
    "name": "FK Sarajevo",
    "country": "Bosna i Hercegovina",
    "coach": "Vinko Marinović",
    "foundedYear": 1946
  }
}
\`\`\`

---

## 💾 Konfiguracija baze podataka

### MySQL Database
**Preduslovi:**
1. Instaliran MySQL Server (verzija 8.0 ili novija)
2. Pokrenuti MySQL servis
3. Kreirana baza podataka `sports_streaming_db`

**Kreiranje baze podataka:**
\`\`\`sql
CREATE DATABASE sports_streaming_db;
\`\`\`

**Konfiguracija** (`application.properties`):
```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/sports_streaming_db?useSSL=false&serverTimezone=UTC
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
