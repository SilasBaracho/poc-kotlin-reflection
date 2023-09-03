package sb.pma.core.domain.product.gateway

import sb.pma.core.domain.product.model.Product

interface DeleteProductGateway {

    fun execute(product: Product)
}