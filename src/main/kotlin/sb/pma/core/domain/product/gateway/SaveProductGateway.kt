package sb.pma.core.domain.product.gateway

import sb.pma.core.domain.product.model.Product

interface SaveProductGateway {

    fun execute(product: Product): Product
}