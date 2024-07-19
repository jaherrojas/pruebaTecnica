Feature: Realizar una compra en Product Store

    @Caso2
    Scenario Outline: Anadir un producto al carrito y realizar la compra
        Given que el usuario esta en la pagina principal de Product Store
        When el usuario selecciona la categoria "<categoria>"
        And el usuario elige el producto "<producto>"
        And el usuario añade el producto al carrito

        Examples:

        #categorias: Phones, Laptops, Monitors
        #productos samsung: Samsung galaxy s7, Samsung galaxy s6
            | categoria | producto |
            | Phones    | Samsung galaxy s6  |