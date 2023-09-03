package sb.pma.core.domain.product.gateway

import sb.pma.core.domain.product.model.Product
import java.util.Optional

interface FindProductByNameAndActiveGateway {

    fun execute(name: String): Optional<Product>
}
