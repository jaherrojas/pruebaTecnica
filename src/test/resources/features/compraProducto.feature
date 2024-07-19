Feature: Realizar una compra en Product Store

    @Caso2
    Scenario Outline: Anadir un producto al carrito y realizar la compra
        Given que el usuario esta en la pagina principal de Product Store
        When el usuario selecciona la categoria "<categoria>"
        And el usuario elige el producto "<producto>"
        Then el usuario agrega el producto al carrito
        And el usuario acepta la aletar y genera un click en el tab Cart
        Then hace click en place older
        And diligencia formulario

        #And ingresa al apartado del Cart
        #Then el usuario genera click en place Order

        Examples:

        #categorias: Phones, Laptops, Monitors
        #productos samsung: Samsung galaxy s7, Samsung galaxy s6
            | categoria | producto |
            | Phones    | Samsung galaxy s6  |