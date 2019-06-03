# Socibby

Kişinin ilgi alanlarına ve lokasyonuna göre *Organizasyonlara* ulaşabileceği bu proje; insanların yaşadıkları, seyahat ettikleri bölgelerde kendi ilgi alanlarına ait *kulüp*, *organizasyon*, *topluluk* veya *dernekleri* bulmalarında kolaylık sağlaması amacıyla gerçekleştirilmiştir. 

Projenin gerçekleştirilmesi hem organizasyonlar hem de kişiler için büyük oranda kolaylık sağlayacaktır. Proje tasarlanırken dünyanın her yerinde kullanılabilmesi amaçlanmıştır. Gerçekleştirdiğimiz proje sayesinde insanlar aradıkları organizasyonlara çok basit bir şekilde ulaşabilecek ve iletişime geçebileceklerdir. Aynı zamanda organizasyonlar, dernekler, topluluklar veya kulüpler sisteme kayıt olabilecek ve kendilerine ulaşabilirliğini kolaylaştıracaklardır. Bu platform, organizasyon sahiplerinin reklam vb. gibi maliyet gerektirecek durumlarının en aza indirgemeyi sağlayacaktır.

##  Sistemdeki Modeller Arasındaki İlişki (Entity Relationship)

![desc](https://farukgenc.com/Socibby/er.png)

Projemiz; 5 adet modele  sahiptir. Bunlar User(Kullanıcı), Organization(Organizasyon), Photo(Fotoğraf), Category(Kategori, İlgi Alanı, Hobi) ve Contact(İletişim). Bu varlıkların birbirleri ile ilişkisi bulunmaktadır. Kullanıcı(User) modelinin Photo(Fotoğraf) modeli ile OneToOne(Bire Bir) ilişkisi bulunmakta. Yani bir fotoğraf yalnızca bir kullanıcıya ait olabilir, bir kullanıcının yanlızca bir fotoğrafı bulunabilir.

Kullanıcı(User) modelinin Category(Kategori, İlgi Alanı, Hobi) modeli ile ManyToMany(Çoktan Çoka) ilişkisi bulunmaktadır. Kullanıcı(User) modeli birden fazla hobiye, kategoriye, ilgi alanına sahip olabilir. Sahip olduğu bu alan kullanıcı modeli içerisinde "HashSet" veri tipinde tutulmaktadır. Bunun avantajı elemanların sıralı olmasının bir şartı olmadığından ve tekrarlı veri tutulmadığından(aynı kategori eklenemez) ve hashleme yöntemi ile veriler tutulduğundan performanslı olmaktadır. Aynı zamanda Kategori(Category) modeli içerisinde kullanıcılarda "HashSet" veri tipinde tutulur. Böylelikle belirli bir kategoriyi seçmiş olan sisteme kayıt olan tüm kullanıcıları bulabilmekteyiz.

Organizasyon/Topluluk(Organization) modelinin Photo(Fotoğraf) modeli ile OneToMany(Birden çoka) bir ilişkisi bulunmaktadır. Bunun anlamı; bir topluluğun birden fazla fotoğrafı olabilir.
Organizasyon/Topluluk(Organization) modelinin Contact(İletişim) modeli ile arasında OneToOne(Bire bir) ilişki bulunmaktadır. Her bir organizasyonun yanlızca bir adet Contact(İletişim) modeline sahip olabileceğini, her bir Contact(İletişim) modelininde yalnızca bir adet Organization(Organizasyon)'a sahip olabileceğini belirtmiş oluruz.

Organizasyon/Topluluk(Organization) modelinin Category(Kategori, İlgi Alanı, Hobi) modeli ile ManyToOne(Çoktan bire) bir ilişkisi bulunmaktadır. Bunun anlamı, bir organizasyonun yalnızca bir kategoriye ait olabileceğini, ancak bir kategoride birden fazla organizasyonun bulunabileceğini belirtiriz.

## Nasıl kullanabilirim ?

ORM tekniği olan JPA/Hibernate ile geliştirilmiş Spring MVC projemizde herhangi bir tablo oluşturmanıza gerek yok. Yanlızca schema oluşturup veritabanınızın ismini belirledikten sonra [db.properties](https://github.com/Genc/Socibby/blob/master/src/main/resources/db.properties "db.properties") dosyasında url adresini belirlemiş olduğunuz schema ismine göre düzenlemeli ve username password alanlarını kendinize bilgilerinize göre düzeltmelisiniz.

Projede kullanıcının resimleri ve organizasyonların resimleri sistemde Tomcat'in bulunduğu dizinde kullanıcılar için "images" klasörü, organizasyonlar içinde "organizations" klasöründe bulunur. Bunu değiştirmek isterseniz [UserController](https://github.com/Genc/Socibby/blob/master/src/main/java/com/socibby/controller/UserController.java "UserController") ve [OrganizationController](https://github.com/Genc/Socibby/blob/master/src/main/java/com/socibby/controller/OrganizationController.java "OrganizationController") sınıflarında bulunan imageUploadOperations metodunu düzenlemeli ve [SpringWebConfig](https://github.com/Genc/Socibby/blob/master/src/main/java/com/socibby/configuration/SpringWebConfig.java "SpringWebConfig") sınıfında bulunan addResourceHandlers metodunu güncellemelidir. Ayrıca ilgili jsp sayfalarındaki path alanınıda güncellemelidir.

Ayrıca projede bulunan ülke, il, ilçe bilgileri JSON veri tipinde [*/web/assets/json*](https://github.com/Genc/Socibby/tree/master/web/assets/json "/web/assets/json") klasörü içinde bulunmakta. Bu alanıda güncelleyebilirsiniz.

Ek olarak projede validation işlemini sağlamak amacıyla Hibernate Validator kullanılmıştır. Kullanıcı ya da organizasyon sisteme kayıt olurken boş bırakılmaması gereken yerleri boş bıraktığında uyarı verilip tekrar aynı sayfa gösterilir. Bu mesajları değiştirmek için [burayı](https://github.com/Genc/Socibby/tree/master/src/main/resources/messages/validation "burayı") güncelleyebilirsiniz.

## i18n / Internationalization

Sistemin dilini değiştirmek için; adres çubuğunda bulunan adresin son kısmına "?language=tr" gibi bir parametre eklememiz gerekmektedir. Sistem şuanda Türkçe ve İngilizce olmak üzere iki adet dili desteklemektedir. Projeyi ingilizce görüntülemek içinde paramtereyi "?language=en" şeklinde düzenlenmemiz gerekmektedir. Bu işlemi otomatize etmek amacıyla sayfaların en alt kısmında(Footer) alanında Türk bayrağı ve İngiliz bayrağı eklenmiştir. Bu bayraklara tıklayarak sistemin dilini kolay bir şekilde değiştirebilmekteyiz.

İlgili mesajları [buradan](https://github.com/Genc/Socibby/tree/master/src/main/resources/messages/view "buradan") güncelleyebilir/değiştirebilirsiniz.

## Kullanılan Teknolojiler

 - HTML, CSS, Bootstrap ([Argon design system](https://github.com/creativetimofficial/argon-design-system "Argon design system"))
 - Javascript & JQuery
 - JSP & JSTL
 - JPA/Hibernate
 - Spring MVC
 - AspectJ
 - Log4J
 - Hibernate Validator
 - Apache Commons IO
 - MySQL

## Ekran Görüntüleri

![desc](https://farukgenc.com/Socibby/1.1landing.png)

------------


![desc](https://farukgenc.com/Socibby/1.2user-register.png)


------------


![desc](https://farukgenc.com/Socibby/1.3user-register2.png)


------------


![desc](https://farukgenc.com/Socibby/1.4user-profile.png)


------------


![desc](https://farukgenc.com/Socibby/1.5user-editprofile.png)


------------


![desc](https://farukgenc.com/Socibby/1.6user-dashboard.png)


------------


![desc](https://farukgenc.com/Socibby/1.7user-login.png)


------------


![desc](https://farukgenc.com/Socibby/2.1organization-register.png)


------------


![desc](https://farukgenc.com/Socibby/2.2organization-dashboard.png)


------------


![desc](https://farukgenc.com/Socibby/2.3organization-profile.png)


------------


![desc](https://farukgenc.com/Socibby/2.4organization-profilepage.png)


------------


![desc](https://farukgenc.com/Socibby/2.5organization-editprofile.png)


------------


![desc](https://farukgenc.com/Socibby/2.6organization-tag-dashboard.png)


------------


![desc](https://farukgenc.com/Socibby/2.7organization-login.png)


------------


![desc](https://farukgenc.com/Socibby/3.1.search-organization.png)


------------


![desc](https://farukgenc.com/Socibby/3.2multiAccountError.png)


------------


![desc](https://farukgenc.com/Socibby/3.3error-user.png)


------------


![desc](https://farukgenc.com/Socibby/3.4org-error.png)


------------

*Sevgiler* :heart: