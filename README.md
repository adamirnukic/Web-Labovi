# Lab-1

# 📺 Sports Streaming App

## 👥 Članovi tima
- **Abida Biogradlija**: Odgovoran za Model Team + rute + view lista timova
- **Adamir Nukić**: Odgovoran za Model Match + rute + view lista utakmica
- **Zajedničko**: Akcija pokretanja/zaustavljanja stream-a + stranica akcije

## 📋 Opis aplikacije
Mini MVC Spring Boot aplikacija za streaming sportskih prenosa. Aplikacija omogućava pregled timova i utakmica, kao i pokretanje/zaustavljanje live stream-a utakmica.

## 🏗️ Modeli i relacije

### Model: Team (Tim)
**Atributi:**
- `id` (Long) - Jedinstveni identifikator tima
- `name` (String) - Naziv tima
- `country` (String) - Država tima
- `coach` (String) - Ime trenera
- `foundedYear` (Integer) - Godina osnivanja

### Model: Match (Utakmica)
**Atributi:**
- `id` (Long) - Jedinstveni identifikator utakmice
- `homeTeam` (Team) - Domaći tim
- `awayTeam` (Team) - Gostujući tim
- `matchDate` (LocalDateTime) - Datum i vrijeme utakmice
- `stadium` (String) - Naziv stadiona
- `competition` (String) - Naziv takmičenja
- `isLive` (boolean) - Status stream-a (da li je uživo)

### 🔗 Relacija
**Team 1:N Match** - Jedan tim može učestvovati u više utakmica (kao domaćin ili gost)

## 🛣️ Rute

| Ruta | Metoda | Opis |
|------|--------|------|
| `/` | GET | Redirect na `/matches` |
| `/teams` | GET | Prikaz liste svih timova |
| `/matches` | GET | Prikaz liste svih utakmica |
| `/matches/start/{id}` | GET | Pokretanje stream-a za utakmicu |
| `/matches/stop/{id}` | GET | Zaustavljanje stream-a za utakmicu |

## ✨ Funkcionalnosti
- ✅ Pregled svih timova sa detaljnim informacijama
- ✅ Pregled svih utakmica sa statusom stream-a
- ✅ Pokretanje live stream-a za utakmicu
- ✅ Zaustavljanje live stream-a
- ✅ Responzivan dizajn
- ✅ In-memory podaci (bez potrebe za bazom)
