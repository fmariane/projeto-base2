## Desafio de automação | Base2 Tecnologia

### Para executar o projeto:
* Baixar o .zip e descompactar
* Importar no Eclipse como "Maven > Existing Maven Projects" e opção "Next"
* Selecionar a pasta que contém o projeto descompactado e opção "Finish"
* Dentro do pacote "com.base2.selenium.tests", executar a classe RunTest.java como JUnit Test;

### Classes:
* GoToPage: acessa a pagina https://mantis-prova.base2.com.br/ e maximiza a tela
* LoginScreen: valida página de login
    * Método loginFieldsValidation: valida texto dos campos;
    * Método loginValidation: tenta realizar login. 
* RunTest: executa 2 casos de teste, utilizando os métodos da classe LoginScreen

*Template adaptado de https://github.com/sridharbandi/Selenium-Junit-Template *. As classes DriverFactory e DriverType foram adaptadas para executar o navegador Google Chrome.