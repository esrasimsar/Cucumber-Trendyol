Feature: Trendyol sitesine Login olma ve ürün aratma
  işlem adımlarının yürütüldüğü otomasyonudur.

  Scenario: Login ve ürün aratma işlemi
    Given trendyol yüklenir
    When giriş yap ikonuna tıklanır
    Then eposta adresi girilir
    And şifre girilir
    And giriş yap butonuna tıklanır
    And ürün araması yapılır
    And ürüne tıklanır
    And ürün numarası seçilir
    And ürün listeleme ekranına geri dönülür




