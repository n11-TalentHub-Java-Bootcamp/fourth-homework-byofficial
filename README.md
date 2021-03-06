# n11 TalentHub Java Bootcamp
## _fourth-homework_
Quick Start Detail
- Swagger UI url:  http://localhost:2633/swagger-ui/index.html
- Project Api url : http://localhost:2633/api/{controller_name}


## Technologies

- Spring Boot
- Spring Data JPA / Hibernate
- Maven
- Java 17
- JDK 1.8+
- Swagger UI
- Mapstruct


## Installation

Can be installed and run as:

1. Clone the application

```cli
git clone https://github.com/n11-TalentHub-Java-Bootcamp/fourth-homework-byofficial
```
2. Install maven for running project

```sh
mvn clean install
```
3. Go to the project directory
```sh
cd fourth-homework-byofficial
```
4. Run Project
```sh
mvnw spring-boot:run
```

## Init
1. Creating a new user
```
[POST] localhost:2633/api/auth/sign-up
```
2. Login user
```
[POST] localhost:2633/api/auth/sign-in
```
3. Use the following Endpoints

## Endpoints
#### Authentication-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/auth/sign-up | POST | No params|
````
POST /api/auth/sign-up HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Content-Length: 74

{
    "username":"test6",
    "password":"test",
    "name":"test-6"
}
````
| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/auth/sign-in | POST | No params|
````
POST /api/auth/sign-in HTTP/1.1
Host: localhost:2633
Content-Type: application/json

{
    "username":"test6",
    "password":"test"
}
````


#### User-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/users | GET | No params|
````
GET /api/users/ HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "id": 3,
        "name": "test",
        "username": "test",
        "password": "$2a$10$RgMLYpSPfBKfLiVgjQENCOuGECkipTqtP/NIeVhRzXgKimSd1VXBS",
        "createTime": "2022-01-12T20:39:19.255807"
    },
    {
        "id": 4,
        "name": "test-4",
        "username": "test4",
        "password": "$2a$10$w.Ro.Rawlhc6j/cpqn7FsOWl6wuz60Z/no92jizV7dZHgmVNKb7nm",
        "createTime": "2022-01-12T20:53:41.656256"
    },

]
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/users/{id} | GET | @id|
````
GET /api/users/3 HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:

{
    "id": 3,
    "name": "test",
    "username": "test",
    "password": "$2a$10$RgMLYpSPfBKfLiVgjQENCOuGECkipTqtP/NIeVhRzXgKimSd1VXBS",
    "createTime": "2022-01-12T20:39:19.255807"
}
````
| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/users/{id} | DELETE | @id|
````
DELETE /api/users/6 HTTP/1.1
Host: localhost:2633
Content-Type: application/json
````

#### Debt-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts | GET | No params|
````
GET /api/debts/ HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "id": 1,
        "mainDebt": 10.00,
        "totalDebt": 10.00,
        "status": "NORMAL",
        "username": "test",
        "name": "test",
        "expiryDate": "2022-01-18T22:39:12.239",
        "createdDate": "2022-01-19T01:39:17.536132"
    },
    {
        "id": 2,
        "mainDebt": 20.00,
        "totalDebt": 20.00,
        "status": "NORMAL",
        "username": "test",
        "name": "test",
        "expiryDate": "2022-01-10T22:39:12.239",
        "createdDate": "2022-01-19T01:39:23.328341"
    }
]
````
| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts/user/{id} | GET | @id|
````
GET /api/debts/user/4 HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "id": 8,
        "mainDebt": 100.00,
        "totalDebt": 100.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-17T22:39:12.239",
        "createdDate": "2022-01-19T01:40:04.778962"
    }
]
````
| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts | POST | No params|
````
POST /api/debts/ HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Content-Length: 83

{
  "mainDebt": 60,
  "userId": 3,
  "expiryDate": "2022-01-19T12:04:44.387Z"
}
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts/user/{id}/total/latefee | GET | @id|
````
GET /api/debts/user/3/total/latefee HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
28
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts/user/{id}/total/expiry | GET | @id|
````
GET /api/debts/user/3/total/expiry HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
148.00
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts/user/{id}/total/debt | GET | @id|
````
GET /api/debts/user/3/total/debt HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
328.00
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts/user/{id}/expiry | GET | @id|
````
GET /api/debts/user/3/expiry HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "id": 1,
        "topDebtId": null,
        "mainDebt": 10.00,
        "totalDebt": 10.00,
        "status": "NORMAL",
        "username": "test",
        "name": "test",
        "expiryDate": "2022-01-18T22:39:12.239",
        "createdDate": "2022-01-19T01:39:17.536132"
    },
    {
        "id": 2,
        "topDebtId": null,
        "mainDebt": 20.00,
        "totalDebt": 20.00,
        "status": "NORMAL",
        "username": "test",
        "name": "test",
        "expiryDate": "2022-01-10T22:39:12.239",
        "createdDate": "2022-01-19T01:39:23.328341"
    }
]
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/debts/date/between?s={start_date}&e={end_date} | GET | @{start_date}, @{end_date}|
````
GET /api/debts/date/between?s=2022-01-17&e=2022-01-21 HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "id": 1,
        "topDebtId": null,
        "mainDebt": 10.00,
        "totalDebt": 10.00,
        "status": "NORMAL",
        "username": "test",
        "name": "test",
        "expiryDate": "2022-01-18T22:39:12.239",
        "createdDate": "2022-01-19T01:39:17.536132"
    },
    {
        "id": 9,
        "topDebtId": 4,
        "mainDebt": 14.00,
        "totalDebt": 0.00,
        "status": "LATE_FEE",
        "username": "test4",
        "name": "test-4",
        "expiryDate": null,
        "createdDate": "2022-01-19T01:55:28.10945"
    },
]
````



#### DebtCollection-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/collections | GET | No params|
````
GET /api/collections HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "mainDebt": 60.00,
        "totalDebt": 0.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-21T22:39:12.239",
        "createdDate": "2022-01-19T01:51:57.265464"
    },
    {
        "mainDebt": 20.00,
        "totalDebt": 0.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-12T22:39:12.239",
        "createdDate": "2022-01-19T01:55:28.10945"
    }
]
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/collections | POST | No params|
````
POST /api/collections HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Content-Length: 35

{
  "amount": 60,
  "debtId": 3
}
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/collections/user/{id} | GET | @{id}|
````
GET /api/collections/user/4 HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "mainDebt": 60.00,
        "totalDebt": 0.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-21T22:39:12.239",
        "createdDate": "2022-01-19T01:51:57.265464"
    },
    {
        "mainDebt": 20.00,
        "totalDebt": 0.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-12T22:39:12.239",
        "createdDate": "2022-01-19T01:55:28.10945"
    }
]
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/collections/user/{id}/latefee | GET | @{id}|
````
GET /api/collections/user/4/latefee HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "mainDebt": 14.00,
        "totalDebt": 0.00,
        "status": "LATE_FEE",
        "username": "test4",
        "name": "test-4",
        "createdDate": "2022-01-19T01:55:28.10945"
    }
]
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/collections/user/{id}/total/latefee | GET | @{id}|
````
GET /api/collections/user/4/total/latefee HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
14
````

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/collections/date/between?s={start_date}&e={end_date} | GET | @{start_date}, @{end_date}|
````
GET /api/collections/date/between?s=2022-01-18&e=2022-01-20 HTTP/1.1
Host: localhost:2633
Content-Type: application/json
Example Value:
[
    {
        "id": 1,
        "topDebtId": null,
        "mainDebt": 60.00,
        "totalDebt": 0.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-21T22:39:12.239",
        "createdDate": "2022-01-19T01:51:57.265464"
    },
    {
        "id": 2,
        "topDebtId": null,
        "mainDebt": 20.00,
        "totalDebt": 0.00,
        "status": "NORMAL",
        "username": "test4",
        "name": "test-4",
        "expiryDate": "2022-01-12T22:39:12.239",
        "createdDate": "2022-01-19T01:55:28.10945"
    }
]
````

## Homework Problems

Tan??m:

```sh
BOR?? ??DEME SERV??S??
Yeni bir spring boot uygulamas?? olu??turunuz.
Uygulama database olarak postgresql kullanmal??. Swagger ile d??k??mante edilmeli.
????lemler s??ras??nda hata al??nmas?? durumunda, hata an??na kadar olan t??m i??lemler geri al??nmal??d??r.
T??m tutar alanlar?? virg??lden sonra 2 basamak hassasiyetli olmal??d??r. (10.99 TL gibi)
A??a????da ??stenen ??zellikler ??????????nda bir uygulama tasarlay??n??z.

```

Senaryo:

```sh
A.	Kullan??c??
a.	Sisteme kullan??c?? kaydedebilmeli, kullan??c?? bilgileri g??ncellenebilmeli ve silinebilmelidir.

```


```sh
B.	Bor??
a.	Kullan??c??lar??n bor??lar?? kaydedilebilmeli, g??ncellenebilmeli ve silinebilmeli. Dikkat edilmesi gereken hususlar:
i.	Ana Bor?? Tutar?? kaydedildikten sonra g??ncellenemez.
ii.	Tahsilat durumlar??na g??re bor?? tutar?? g??ncellenir.
iii.	Borca ait bir ???vade tarihi??? alan?? olmal??d??r.
iv.	Vade tarihi ge??en bor??lar i??in gecikme zam?? hesaplat??l??r. (Bor?? sorgulama servisi sonucunda gecikme zamm?? hesaplanmal?? fakat databasede ???gecikme zamm????? alan?? tutulmamal??d??r )
v.	Gecikme zamlar?? g??nl??k olarak hesaplanmal??d??r. ??lgili g??ne ait gecikme zamm?? oran?? kadar gecikme i??letilmelidir.
vi.	Vade tarihi ge??en bir borca minimum 1TL gecikme zamm?? i??letilmelidir. (0.75 vs
gibi de??erler 1TL ye yuvarlanmal??d??r. )
vii.	Tek ba????na gecikme zamm?? t??r??nde bir bor?? kaydedilemez. Servisten sadece NORMAL bor??lar kaydedilebilmelidir.
viii.	Gecikme zamm?? bor??lar?? sadece tahsilat an??nda olu??turulur.
ix.	Gecikme zamm?? borcu hangi borca ba??l?? olu??tu??u bilgisi database de tutulmal??d??r.
x.	Gecikme zamlar??n??n bor?? t??r?? GECIKME_ZAMMI, ana borcun bor?? t??r?? ise
NORMAL olmal??d??r.
```

```sh
C.	Gecikme Zamm?? Oran??
a.	Tabloya gerek yok. Statik bir de??i??ken ??zerinden oranlar?? tutabilirsiniz. 01.01.2018 
??ncesi 1.5, sonras?? ise 2.0 olacak ??ekilde Kabul edilebilir. 
```


```sh
D.	TAHS??LAT
a.	Bir bor?? tahsilat?? yap??ld??????nda, e??er vade tarihi ge??mi?? ise, gecikme zamm?? tutar?? kadar
bir bor?? kayd?? at??l??r.
b.	Kay??t tarihi tahsilat yap??lan tarih olur.
c.	Ba??l?? oldu??u bor?? bilgisi muhakkak tutulmal??d??r ki hangi borca istinaden bu gecikme zamm?? olu??mu??, g??r??nebilsin.
d.	As??l bor?? ve buna ba??l?? olan, tahsilat an??nda olu??turulan gecikme zamm?? borcunun bor?? tutarlar?? 0(s??f??r) yap??l??r. Ana bor?? tutar??na dokunulmaz.
e.	Par??al?? tahsilat yap??lamaz. Bir bor?? tahsil edilmek istenirse borcun tamam?? ??denmelidir.
(Varsa gecikme zamm?? dahil toplam tutar ??denmelidir. )
```

??dev:

```sh
1.	Kullan??c??
a.	Kullan??c?? kaydeden,
b.	silen,
d.	kullan??c??lar?? d??nen
servisler

3.	Bor??
a.	Bor?? kaydeden, (sadece normal bor??lar)
d.	Belirtilen tarihler aras??nda olu??turulan bor??lar listelenebilmelidir.
e.	Bir kullan??c??n??n t??m bor??lar?? listenelebilmelidir. (Bor?? tutar?? s??f??rdan b??y??k olanlar)
f.	Bir kullan??c??n??n vadesi ge??mi?? bor??lar?? listenelebilmelidir. (Bor?? tutar?? s??f??rdan b??y??k olanlar)
g.	Bir kullan??c??n??n toplam bor?? tutar??n?? d??nen bir servis olmald????r.
h.	Bir kullan??c??n??n vadesi ge??mi?? toplam bor?? tutar??n?? d??nen bir servis olmald????r.
i.	Bir kullan??c??n??n anl??k gecikme zamm?? tutar??n?? d??nen bir servis olmal??d??r. (Vadesi ge??en bor??lara hesaplanan gecikme zam?? tutarlar?? toplam??. (Sadece gecikme zamm??))

4.	Tahsilat
a.	Tahsilat yapan,
b.	Belirtilen tarihler aras??nda yap??lan tahsilatlar listelenebilmelidir
c.	Kullan??c??n??n t??m tahsilatlar?? listelenebilmelidir.
d.	Kullan??c??n??n ??dedi??i toplam gecikme zamm?? listelenebilmelidir

```


```sh
localhost:2633
```

## License

MIT

**Burak YILDIZ**