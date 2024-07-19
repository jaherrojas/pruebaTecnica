Feature: Realizar una compra en Product Store

    @CompraProducto
    Scenario Outline: Anadir un producto al carrito y realizar la compra
        Given que el usuario esta en la pagina principal de Product Store
        When el usuario selecciona la categoria "<categoria>"
        And el usuario elige el producto "<producto>"
        Then el usuario agrega el producto al carrito
        And el usuario acepta la aletar y genera un click en el tab Cart
        Then hace click en place older
        And diligencia formulario
        Then genera la compra

        Examples:

        #categorias: Phones, Laptops, Monitors
        #productos de celulares samsung: Samsung galaxy s7, Samsung galaxy s6
        #productos de Laptops Sony: Sony vaio i5, Sony vaio i7
        #productos de Monitores: Apple monitor 24, ASUS Full HD

            | categoria | producto |
            | Phones  | Samsung galaxy s7  |