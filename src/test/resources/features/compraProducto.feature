Feature: Realizar una compra en Product Store
    @caso2
    Scenario: Anadir un producto al carrito y realizar la compra
        Given que el usuario esta en la pagina principal de Product Store
        When el usuario selecciona una categoria aleatoria
        And el usuario elige un producto dependiendo la categoria y seleccion del cliente
        # And el usuario añade el producto al carrito
        # Then el sistema confirma que el producto está en el carrito
