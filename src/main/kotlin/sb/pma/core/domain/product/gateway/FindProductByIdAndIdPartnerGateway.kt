package sb.pma.core.domain.product.gateway

import sb.pma.core.domain.product.model.Product
import java.util.Optional
import java.util.UUID

interface FindProductByIdAndIdPartnerGateway {

    fun execute(idProduct: UUID, idPartner: UUID): Optional<Product>
}
