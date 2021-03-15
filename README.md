# spring_thymeleaf_movieApp #

#Çalıştırma Adımlar
-Proje dosyasını kaydedin.
-Proje dosyanızı Maven Project olarak çalışma ortamınıza kaydedin.
- pom.xml dosyasında 
    <properties>
		<java.version>1.8</java.version>
		<maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>
	</properties>
  Sistemde yüklü olan JDK versiyonları eklenmelidir.
-Proje de MySQL veritabanı kullanılmıştır. MySQL veritabanı yüklenmesi gerekir.
-Veritabanında yeni bir şema oluştur.
-Proje kaynak kodunda Application.properties dosyasında 
***spring.datasource.url=jdbc:mysql://localhost:3306/{ŞEMA_ADI}?useSSL=false&serverTimezone=UTC*** {ŞEMA_ADI} oluşturduğumuz şemanın adı verilmelidir.
-Proje çalıştırılır ve ORM ile tüm tablolar yaratılır.
-Veritabanında aşağıdaki sql script çalıştırılmalıdır. User objesine bir role atanması için.
*/
INSERT INTO `role` (name)
VALUES 
('ROLE_USER'),('ROLE_ADMIN');
/*
-Proje http://localhost:8086 linkinde çalışır hale gelir.Proje kaynak kodunda Application.properties dosyasında 
***server.port:{PORT}*** {PORT} kullanılmayan bir port verilebilir.

#ÇALIŞTIRILAN ORTAM
-ECLIPSE IDE
-JDK 1.8
-MYSQL WORKBENCH 8.0
