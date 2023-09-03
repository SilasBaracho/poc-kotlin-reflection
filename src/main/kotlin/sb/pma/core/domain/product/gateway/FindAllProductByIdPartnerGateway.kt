package sb.pma.core.domain.product.gateway

import sb.pma.core.domain.product.model.Product
import java.util.UUID

interface FindAllProductByIdPartnerGateway {

    fun execute(idPartner: UUID): MutableList<Product>
}