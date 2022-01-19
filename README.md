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

Tanım:

```sh
BORÇ ÖDEME SERVİSİ
Yeni bir spring boot uygulaması oluşturunuz.
Uygulama database olarak postgresql kullanmalı. Swagger ile dökümante edilmeli.
İşlemler sırasında hata alınması durumunda, hata anına kadar olan tüm işlemler geri alınmalıdır.
Tüm tutar alanları virgülden sonra 2 basamak hassasiyetli olmalıdır. (10.99 TL gibi)
Aşağıda İstenen özellikler ışığında bir uygulama tasarlayınız.

```

Senaryo:

```sh
A.	Kullanıcı
a.	Sisteme kullanıcı kaydedebilmeli, kullanıcı bilgileri güncellenebilmeli ve silinebilmelidir.

```


```sh
B.	Borç
a.	Kullanıcıların borçları kaydedilebilmeli, güncellenebilmeli ve silinebilmeli. Dikkat edilmesi gereken hususlar:
i.	Ana Borç Tutarı kaydedildikten sonra güncellenemez.
ii.	Tahsilat durumlarına göre borç tutarı güncellenir.
iii.	Borca ait bir “vade tarihi” alanı olmalıdır.
iv.	Vade tarihi geçen borçlar için gecikme zamı hesaplatılır. (Borç sorgulama servisi sonucunda gecikme zammı hesaplanmalı fakat databasede “gecikme zammı” alanı tutulmamalıdır )
v.	Gecikme zamları günlük olarak hesaplanmalıdır. İlgili güne ait gecikme zammı oranı kadar gecikme işletilmelidir.
vi.	Vade tarihi geçen bir borca minimum 1TL gecikme zammı işletilmelidir. (0.75 vs
gibi değerler 1TL ye yuvarlanmalıdır. )
vii.	Tek başına gecikme zammı türünde bir borç kaydedilemez. Servisten sadece NORMAL borçlar kaydedilebilmelidir.
viii.	Gecikme zammı borçları sadece tahsilat anında oluşturulur.
ix.	Gecikme zammı borcu hangi borca bağlı oluştuğu bilgisi database de tutulmalıdır.
x.	Gecikme zamlarının borç türü GECIKME_ZAMMI, ana borcun borç türü ise
NORMAL olmalıdır.
```

```sh
C.	Gecikme Zammı Oranı
a.	Tabloya gerek yok. Statik bir değişken üzerinden oranları tutabilirsiniz. 01.01.2018 
öncesi 1.5, sonrası ise 2.0 olacak şekilde Kabul edilebilir. 
```


```sh
D.	TAHSİLAT
a.	Bir borç tahsilatı yapıldığında, eğer vade tarihi geçmiş ise, gecikme zammı tutarı kadar
bir borç kaydı atılır.
b.	Kayıt tarihi tahsilat yapılan tarih olur.
c.	Bağlı olduğu borç bilgisi muhakkak tutulmalıdır ki hangi borca istinaden bu gecikme zammı oluşmuş, görünebilsin.
d.	Asıl borç ve buna bağlı olan, tahsilat anında oluşturulan gecikme zammı borcunun borç tutarları 0(sıfır) yapılır. Ana borç tutarına dokunulmaz.
e.	Parçalı tahsilat yapılamaz. Bir borç tahsil edilmek istenirse borcun tamamı ödenmelidir.
(Varsa gecikme zammı dahil toplam tutar ödenmelidir. )
```

Ödev:

```sh
1.	Kullanıcı
a.	Kullanıcı kaydeden,
b.	silen,
d.	kullanıcıları dönen
servisler

3.	Borç
a.	Borç kaydeden, (sadece normal borçlar)
d.	Belirtilen tarihler arasında oluşturulan borçlar listelenebilmelidir.
e.	Bir kullanıcının tüm borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
f.	Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
g.	Bir kullanıcının toplam borç tutarını dönen bir servis olmaldıır.
h.	Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmaldıır.
i.	Bir kullanıcının anlık gecikme zammı tutarını dönen bir servis olmalıdır. (Vadesi geçen borçlara hesaplanan gecikme zamı tutarları toplamı. (Sadece gecikme zammı))

4.	Tahsilat
a.	Tahsilat yapan,
b.	Belirtilen tarihler arasında yapılan tahsilatlar listelenebilmelidir
c.	Kullanıcının tüm tahsilatları listelenebilmelidir.
d.	Kullanıcının ödediği toplam gecikme zammı listelenebilmelidir

```


```sh
localhost:2633
```

## License

MIT

**Burak YILDIZ**