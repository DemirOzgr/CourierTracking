# CourierTracking
 Courier Tracking Application For Migros
 
Junit testleri test kısmında yazılmıştır.

Projeyi çalıştırmak için gitHub üzerinden clone edin.

Projeyi Maven clean-install yapın.

Target klasörü altında oluşan dosyayı 'Java -jar courierTrackingApplication-0.0.1-SNAPSHOT.jar' scripti ile çalıştırın.

Db erişimi için http://localhost:8080/h2-console linkine gidin.

Kullanıcı adı ve şifre bilgisi application.properties dosyasında mevcuttur.

url = jdbc:h2:mem:testdb

username = sa

password = password

Migros mağazalarını eklemek için Postman kullanarak

{
"name": "Ataşehir MMM Migros",
"lat": 40.9923307,
"lng": 29.1244229
}

örnekteki gibi bir json oluşturup http://localhost:8080/stores linkine bir post isteği gönderin

Kurye eklemek ve takip etmek için Postman kullanarak

{
    "courier": 1,
    "lat": 40.9923307,
    "lng": 29.1244229,
    "time":"2020-07-17T12:00:00+02:00"
}

örnekteki gibi bir json oluşturup http://localhost:8080/couriers linkine bir post isteği gönderin

Bir kuryenin gittiği toplam mesafeyi görmek için 

http://localhost:8080/couriers/{id}/totalTravelDistance linkine istediğiniz kuryenin id'sini girerek GET isteği atın.
