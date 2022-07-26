# Kajon työkkärin hallintamoduuli

Kajo 2022 työkkärin hallintamoduuli. Tarjoaa hallintamahdollisuuden muokata, luoda ja poistaa pestejä. Mahdollistaa myös ilmoittautuneiden tietojen tarkastelun.
Pestit ilmoitetaan pääsääntöisesti Kajo Lux sovelluksen kautta ja niihin voi ilmoittautua samaa kautta.  

## Tietokanta

Cosmos DB-dokumenttitietokanta, jossa containerit ilmoittautumisille ja luoduille pesteille.

### Task
>  Kenttä | Tyyppi | Kuvaus 
>  ------ | ------ | -----  
> id | string | generated id 
> taskName | string | pestin nimi
> location | string | pestin paikka
> date | string | pestin pvm
> time | string | pestin aika
> isActive| bool | näkyykö avoimena pestinä
> level | int | pestin taso 1-3
> skills | string | pestin taidot
> description | string | pestin kuvaus
> taskerName | string | ilmoittajan nimi
> taskerTask | string | ilmoittajan pesti
> taskerPhone | string | ilmoittajan puhelin


### Signup
>  Kenttä | Tyyppi | Kuvaus 
>  ------ | ------ | -----  
> id | string | generated id 
> taskId | string | ilmoituksen id
> taskName | string | ilmoituksen pestin nimi
> firstName | string | etunimi
> lastName | string | sukunimi
> lpk | int | ilmoittautujan leirilpk
> phone | string | ilmoittautujan puhelin
> info | string | lisätiedot

## Huomioitavaa
Forkatessa ja uudelleenkäytössä vaaditaan oman UserDetailsServicen luomista tai muuta vastaavaa ratkaisua.