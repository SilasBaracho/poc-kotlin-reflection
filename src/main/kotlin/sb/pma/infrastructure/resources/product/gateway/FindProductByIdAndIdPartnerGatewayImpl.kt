package sb.pma.infrastructure.resources.product.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.product.gateway.FindProductByIdAndIdPartnerGateway
import sb.pma.core.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ProductRepository
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter
import java.util.Optional
import java.util.UUID

@Component
class FindProductByIdAndIdPartnerGatewayImpl(
    private val productAdapter: ProductAdapter,
    private val productRepository: ProductRepository
): FindProductByIdAndIdPartnerGateway {

    override fun execute(idProduct: UUID, idPartner: UUID): Optional<Product> {
        val product = productRepository.findByIdProductAndIdPartner(idProduct, idPartner).orElse(null)
        return if (product != null) {
            Optional.of(
                productAdapter.toDomain(product)
            )
        } else {
            Optional.empty()
        }
    }

}