**Aihe:** osakesalkku 

Toteutetaan järjestelmä, johon syötetään osakeostoja ja osakkeiden tietoja oston hetkellä, sekä lasketaan koko salkun arvo ja riskipitoisuus. Järjestelmässä on ainakin aluksi yksi osakesalkku, johon lisätään (käsin) osakkeita yksi kerrallaan. Lisäyksen aikana kerrotaan osakkeen arvo, osakkeiden määrä, volatiliteetti (esim. vuosittainen), beta-arvo (joka kertoo korrelaatiosta markkinan kanssa) ja valitaan osakkeen edustama toimiala. Järjestelmässä siis on valmis lista toimialoista, joista käyttäjä valitsee osakkeen toimialan.

Oletuksena on, että ainakin alussa kaikki osakkeet ovat Helsingin pörssistä (lähinnä markkinakorrelaation vuoksi) ja koska yksittäisten osakkeiden välistä korrelaatiota ei ilman suurta dataa saa selville, käytän toimialoja suuntaa-antavana informaationa. Järjestelmä siis käytännössä laskee ja näyttää salkun sisällön, arvon ja sen muutoksen, sekä riskipitoisuuden. Salkku osaa myös tottakai huomioida, jos jo omistettua osaketta ostetaan lisää.

**Käyttäjät:** Salkunhoitaja

**Salkunhoitajan toiminnot:**
* salkun tarkastelu
* osakkeiden lisäys/poisto
* osakkeiden riskin lisääminen/muokkaaminen
* salkun riskin tarkastelu

